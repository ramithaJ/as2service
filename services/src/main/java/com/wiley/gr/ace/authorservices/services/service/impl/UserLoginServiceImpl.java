/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.AuthenticationObject;
import com.wiley.gr.ace.authorservices.model.external.PasswordReset;
import com.wiley.gr.ace.authorservices.model.external.PasswordResetRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsEntry;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsMap;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * The Class UserLoginServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class UserLoginServiceImpl implements UserLoginService {

    /**
     * Logger for UserLoginServiceImpl class.
     */
    @Value("${UserLoginServiceImpl.resetPassword.statusclosedcode}")
    private String statusclosedcode;

    /** The statusclosedmessage. */
    @Value("${UserLoginServiceImpl.resetPassword.statusclosedmessage}")
    private String statusclosedmessage;

    /** The recordnotexistcode. */
    @Value("${UserLoginServiceImpl.resetPassword.doesntexist.code}")
    private String recordnotexistcode;

    /** The recordnotexistmessage. */
    @Value("${UserLoginServiceImpl.resetPassword.doesntexist.message}")
    private String recordnotexistmessage;

    /** The securityquestioncode. */
    @Value("${UserLoginServiceImpl.resetPassword.securityquestion.code}")
    private String securityquestioncode;

    /** The securityquestionmessage. */
    @Value("${UserLoginServiceImpl.resetPassword.securityquestion.message}")
    private String securityquestionmessage;

    /** The account verified code. */
    @Value("${accountVerifiedCode}")
    private String accountVerifiedCode;

    /** The account verified message. */
    @Value("${accountVerifiedMessage}")
    private String accountVerifiedMessage;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserLoginServiceImpl.class);
    /**
     * Injecting UserLoginServiceDAO bean.
     */
    @Autowired(required = true)
    private UserLoginServiceDAO userLoginServiceDAO;
    /**
     * Injecting UserMangement bean.
     */
    @Autowired(required = true)
    private UserManagement userManagement;

    /**
     * Method to authenticate user. calling external system to authenticate
     * user.
     *
     * @param login
     *            the login
     * @param sharedServieRequest
     *            - having user information .
     * @return status - true/false
     */
    @Override
    public final SecurityResponse login(final Login login,
            final SharedServieRequest sharedServieRequest) {

        LOGGER.info("In login method");
        return userManagement.authenticateUser(sharedServieRequest);
    }

    /**
     * Validate email address.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    @Override
    public final boolean validateEmailAddress(final String emailId) {

        LOGGER.info("In validateEmailAddress method");
        return userLoginServiceDAO.validateEmailAddress(emailId);
    }

    /**
     * Method to reset the password at the time of login.
     * 
     * @param securityDetailsHolder
     *            - having emailId, secutiryDetails and password.
     * @return status - true/false
     */
    @Override
    public final boolean resetPassword(
            final SecurityDetailsHolder securityDetailsHolder) {

        boolean status = false;

        LOGGER.info("In resetPassword method");

        if (securityDetailsHolder.isForceReset()) {
            status = userManagement.forceFulReset(
                    securityDetailsHolder.getEmailId(),
                    securityDetailsHolder.getPassword());

        } else {
            if (securityDetailsHolder.getSecurityDetails().isEmpty()) {
                throw new ASException(securityquestioncode,
                        securityquestionmessage);
            } else {

                PasswordResetRequest passwordResetRequest = new PasswordResetRequest();

                PasswordReset passwordReset = new PasswordReset();
                passwordReset.setExistingEmail(securityDetailsHolder
                        .getEmailId());
                passwordReset.setNewPassword(securityDetailsHolder
                        .getPassword());
                passwordReset
                        .setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);

                UserSecurityQuestions userSecurityQuestions = new UserSecurityQuestions();
                UserSecurityQuestionsMap userSecurityQuestionsMap = new UserSecurityQuestionsMap();
                List<UserSecurityQuestionsEntry> userSecurityQuestionsEntriesList = new ArrayList<UserSecurityQuestionsEntry>();
                UserSecurityQuestionsEntry userSecurityQuestionsEntry = null;

                List<SecurityDetails> securityDetailsList = securityDetailsHolder
                        .getSecurityDetails();
                for (SecurityDetails securityDetails : securityDetailsList) {

                    userSecurityQuestionsEntry = new UserSecurityQuestionsEntry();
                    userSecurityQuestionsEntry.setKey(securityDetails
                            .getSecurityQuestion());
                    userSecurityQuestionsEntry.setText(securityDetails
                            .getSecurityAnswer());
                    userSecurityQuestionsEntriesList
                            .add(userSecurityQuestionsEntry);
                }
                userSecurityQuestionsMap
                        .setEntry(userSecurityQuestionsEntriesList);
                userSecurityQuestions
                        .setUserSecurityQuestionsMap(userSecurityQuestionsMap);

                passwordReset.setUserSecurityQuestions(userSecurityQuestions);

                AuthenticationObject authenticationObject = new AuthenticationObject();
                authenticationObject
                        .setAuthusername(AuthorServicesConstants.AUTHUSERNAME);
                authenticationObject
                        .setAuthpassword(AuthorServicesConstants.AUTHPASSWORD);

                passwordReset.setAuthenticationObject(authenticationObject);
                passwordResetRequest
                        .setUpdateUserSecurityAttributes(passwordReset);
                status = userManagement.resetPassword(passwordResetRequest);
            }

        }
        return status;
    }

    /**
     * Security questions.
     *
     * @param emailId
     *            the email id
     * @return the security details holder
     */
    @Override
    public final SecurityDetailsHolder securityQuestions(final String emailId) {

        LOGGER.info("In securityQuestions method");
        return userManagement.getSecurityQuestions(emailId);
    }

    /**
     * Validate security questions.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    @Override
    public final boolean validateSecurityQuestions(
            final List<SecurityDetails> securityDetails) {

        LOGGER.info("In validateSecurityQuestions method");
        return true;
    }

    /**
     * Reset password.
     *
     * @param guid
     *            the guid
     * @return the string
     */
    @Override
    public final String resetPassword(final String guid) {
        InviteResetpwdLog daoinviteResetpwdLog = userLoginServiceDAO
                .getinviteResetpwdLog(guid);
        String emailId = null;

        if (null == daoinviteResetpwdLog) {
            throw new ASException(recordnotexistcode, recordnotexistmessage);
        } else if (AuthorServicesConstants.INVITE_RESET_PASSWORD_STATUS_CLOSED
                .equalsIgnoreCase(daoinviteResetpwdLog.getStatus())) {
            throw new ASException(statusclosedcode, statusclosedmessage);
        } else if (AuthorServicesConstants.INVITE_RESET_PASSWORD_STATUS
                .equalsIgnoreCase(daoinviteResetpwdLog.getStatus())) {
            emailId = daoinviteResetpwdLog.getEmailAddress();
        }
        return emailId;

    }

    /**
     * Verify account update.
     *
     * @param guid
     *            the guid
     */
    @Override
    public final void verifyAccountUpdate(final String guid) {

        InviteResetpwdLog inviteResetpwdLog = userLoginServiceDAO
                .getinviteResetpwdLog(guid);

        if (null == inviteResetpwdLog) {
            throw new ASException(recordnotexistcode, recordnotexistmessage);
        } else if (AuthorServicesConstants.INVITE_RESET_PASSWORD_STATUS_CLOSED
                .equalsIgnoreCase(inviteResetpwdLog.getStatus())) {
            throw new ASException(statusclosedcode, statusclosedmessage);
        } else if (AuthorServicesConstants.INVITE_RESET_PASSWORD_STATUS
                .equalsIgnoreCase(inviteResetpwdLog.getStatus())
                && inviteResetpwdLog
                        .getType()
                        .equalsIgnoreCase(
                                AuthorServicesConstants.INVITE_RESET_PASSWORD_STATUS_TYPE)) {
            userLoginServiceDAO.getUserId(inviteResetpwdLog.getEmailAddress());
        } else {
            throw new ASException(accountVerifiedCode, accountVerifiedMessage);
        }

    }
/** This method will call userlogin dao to create a record in db */
    @Override
    public void insertGuid(String firstName, String lastName,
            String emailAddress) {
        userLoginServiceDAO.insertGuid(firstName, lastName, emailAddress);

    }
}
