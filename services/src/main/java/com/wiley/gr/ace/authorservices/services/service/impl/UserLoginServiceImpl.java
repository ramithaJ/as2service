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
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.SecurityQuestionsList;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ALMSearchUserResponse;
import com.wiley.gr.ace.authorservices.model.external.ForcefulReset;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.PasswordReset;
import com.wiley.gr.ace.authorservices.model.external.PasswordResetRequest;
import com.wiley.gr.ace.authorservices.model.external.RetrieveSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsValidateRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsEntry;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsMap;
import com.wiley.gr.ace.authorservices.model.external.ValidateUserSecurityQA;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * The Class UserLoginServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class UserLoginServiceImpl implements UserLoginService {

    /** The securityquestioncode. */
    @Value("${UserLoginServiceImpl.resetPassword.securityquestion.code}")
    private String securityquestioncode;

    /** The securityquestionmessage. */
    @Value("${UserLoginServiceImpl.resetPassword.securityquestion.message}")
    private String securityquestionmessage;

    /** The template id. */
    @Value("${templateId.security.validation.failed}")
    private String templateId;

    /**
     * This field holds the value of passwordResetTemplateId.
     */
    @Value("${templateId.password.reset}")
    private String passwordResetTemplateId;

    /** The alm service. */
    @Autowired(required = true)
    private ALMInterfaceService almService;

    /** The participants interface service. */
    @Autowired(required = true)
    ParticipantsInterfaceService participantsInterfaceService;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserLoginServiceImpl.class);
    /**
     * Injecting UserMangement bean.
     */
    @Autowired(required = true)
    private UserManagement userManagement;

    /** This field holds the value of sendNotification. */
    @Autowired(required = true)
    private SendNotification sendNotification;

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
            ForcefulReset forcefulReset = new ForcefulReset();
            forcefulReset.setExistingEmail(securityDetailsHolder.getEmailId());
            forcefulReset.setNewPassword(securityDetailsHolder.getPassword());
            forcefulReset.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);

            status = userManagement.forceFulReset(forcefulReset);
            if (status) {
                sendNotification.notifyByEmail(
                        securityDetailsHolder.getEmailId(),
                        passwordResetTemplateId);
            }

        } else {
            if (securityDetailsHolder.getSecurityDetails().isEmpty()) {
                throw new ASException(securityquestioncode,
                        securityquestionmessage);
            } else {
                List<UserSecurityQuestionsEntry> userSecurityQuestionsEntriesList = null;
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
                userSecurityQuestionsEntriesList = new ArrayList<UserSecurityQuestionsEntry>();
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

                passwordReset.setUserSQuestions(userSecurityQuestions);

                passwordResetRequest
                        .setUpdateUserSecurityAttributes(passwordReset);
                status = userManagement.resetPassword(passwordResetRequest);
                if (status) {
                    sendNotification.notifyByEmail(
                            securityDetailsHolder.getEmailId(),
                            passwordResetTemplateId);
                }
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
    public final SecurityQuestionsList userSecurityQuestions(
            final String emailId) {

        LOGGER.info("In securityQuestions method");
        SecurityQuestionsList securityQuestionsList = new SecurityQuestionsList();
        List<SecurityDetails> securityDetailsList = new ArrayList<SecurityDetails>();
        List<String> retrieveSecurityQuestionsList = new ArrayList<String>();
        SecurityDetails securityDetails = null;
        int i = 0;
        RetrieveSecurityQuestions retrieveSecurityQuestions = userManagement
                .userSecurityQuestions(emailId);
        retrieveSecurityQuestionsList = retrieveSecurityQuestions
                .getSystemSecurityQuestions().getSecurityQuestionList();

        for (String list : retrieveSecurityQuestionsList) {

            securityDetails = new SecurityDetails();
            securityDetails.setSecurityQuestionId("SecurityQuestion" + (++i));
            securityDetails.setSecurityQuestion(list);
            securityDetailsList.add(securityDetails);
        }
        securityQuestionsList.setSecurityDetails(securityDetailsList);

        return securityQuestionsList;
    }

    /**
     * Validate security questions.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    @Override
    public final boolean validateSecurityQuestions(
            final SecurityDetailsHolder securityDetailsHolder) {

        LOGGER.info("In validateSecurityQuestions method");
        SecurityQuestionsValidateRequest securityQuestionsValidateRequest = new SecurityQuestionsValidateRequest();
        ValidateUserSecurityQA validateUserSecurityQA = new ValidateUserSecurityQA();
        UserSecurityQuestions userSecurityQuestions = new UserSecurityQuestions();
        UserSecurityQuestionsMap userSecurityQuestionsMap = new UserSecurityQuestionsMap();
        List<UserSecurityQuestionsEntry> userSecurityQuestionsEntryList = new ArrayList<UserSecurityQuestionsEntry>();
        UserSecurityQuestionsEntry userSecurityQuestionsEntry = null;
        List<SecurityDetails> securityDetailsList = securityDetailsHolder
                .getSecurityDetails();
        for (SecurityDetails securityDetails : securityDetailsList) {

            userSecurityQuestionsEntry = new UserSecurityQuestionsEntry();
            userSecurityQuestionsEntry.setKey(securityDetails
                    .getSecurityQuestion());
            userSecurityQuestionsEntry.setText(securityDetails
                    .getSecurityAnswer());
            userSecurityQuestionsEntryList.add(userSecurityQuestionsEntry);
        }
        userSecurityQuestionsMap.setEntry(userSecurityQuestionsEntryList);
        userSecurityQuestions
                .setUserSecurityQuestionsMap(userSecurityQuestionsMap);
        final String emailId = securityDetailsHolder.getEmailId();
        validateUserSecurityQA.setLogin(emailId);
        validateUserSecurityQA.setUserSecurityQuestions(userSecurityQuestions);
        securityQuestionsValidateRequest
                .setValidateUserSecurityQA(validateUserSecurityQA);
        try {
            return userManagement
                    .validateSecurityQuestions(securityQuestionsValidateRequest);
        } catch (UserException userException) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, userException);
            // need to put correct templteId here
            sendNotification.notifyByEmail(emailId, templateId);
            throw new UserException(userException.getErrorCode(),
                    userException.getDescription());
        }
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
        return guid;
    }

    /**
     * Verify account update.
     *
     * @param guid
     *            the guid
     */
    @Override
    public final void verifyAccountUpdate(final String guid) {
        LOGGER.info("verify account information");
    }

    /**
     * This method will call user login dao to create a record in db.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @param emailAddress
     *            the email address
     * @return the string
     */
    @Override
    public final String insertGuid(final String firstName,
            final String lastName, final String emailAddress) {
        return emailAddress;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.services.service.UserLoginService#
     * searchUserInALM(java.lang.String)
     */
    @Override
    public User searchUserInALM(final String emailId) {

        ALMSearchUserResponse response = almService.searchUser(emailId);
        User user = new User();
        user.setTermsOfUseFlg(response.getUserPayload().getUserPayload().get(0)
                .getTcFlag());
        user.setStatus(response.getUserPayload().getUserPayload().get(0)
                .getUserStatus());
        user.setAlmUserId(response.getUserPayload().getUserPayload().get(0)
                .getAlmUserId());
        return user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.services.service.UserLoginService#
     * searchUserInParticipantByALMId(java.lang.String)
     */
    @Override
    public boolean searchUserInParticipantByALMId(final String almUserId) {
        boolean userFound = true;
        Participant participant = participantsInterfaceService
                .searchParticipantByUserId(almUserId);
        if (participant == null) {
            userFound = false;
        }
        return userFound;
    }

    @Override
    public boolean resetByEmail(final String emailId) {

        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.services.service.UserLoginService#
     * getUserDetailsFromParticipantService(java.lang.String)
     */
    @Override
    public User getUserDetailsFromParticipantService(final String emailId) {
        User userDetails = null;

        Participant participantDetails = participantsInterfaceService
                .searchParticipantByEmailId(emailId);

        if (participantDetails != null) {
            userDetails = new User();
            userDetails.setUserId(participantDetails.getParticipantId());
            userDetails.setFirstName(participantDetails.getGivenName());
            userDetails.setLastName(participantDetails.getFamilyName());
            userDetails.setOrcidId(participantDetails.getOrcidId());
        }

        return userDetails;
    }
}
