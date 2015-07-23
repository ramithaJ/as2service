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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.ErrorPayLoad;
import com.wiley.gr.ace.authorservices.model.external.ForcefulReset;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordResetRequest;
import com.wiley.gr.ace.authorservices.model.external.ResponseStatus;
import com.wiley.gr.ace.authorservices.model.external.RetrieveSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsUpdateRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsValidateRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.model.external.UserEmailDetails;

/**
 * The Class UserManagementImpl.
 *
 * @author virtusa version 1.0
 */
public class UserManagementImpl implements UserManagement {

    /** The lock user. */
    @Value("${lockUser.url}")
    private String lockUser;

    /** The shared service authenticate url. */
    @Value("${shared.service.authenticate.url}")
    private String sharedServiceAuthenticateUrl;

    /** The force ful reset. */
    @Value("${forceFulReset.url}")
    private String forceFulReseturl;

    /** The update user id. */
    @Value("${updateUserId.url}")
    private String updateUserIdurl;

    /** The reset password. */
    @Value("${resetPassword.url}")
    private String resetPasswordurl;

    /** The authenticate admin user. */
    @Value("${authenticateAdminUser.url}")
    private String authenticateAdminUser;

    /** The un lock user. */
    @Value("${unLockUser.url}")
    private String unLockUser;

    /** The security details. */
    @Value("${securityDetails.url}")
    private String securityDetails;

    /** The security questions. */
    @Value("${securityQuestions.url}")
    private String securityQuestions;

    /** The update password. */
    @Value("${updatePassword.url}")
    private String updatePasswordurl;

    /** The update security details. */
    @Value("${updateSecurityDetails.url}")
    private String updateSecurityDetailsurl;

    /** The find user. */
    @Value("${findUser.url}")
    private String findUser;

    /** The security question details. */
    @Value("${securityQuestionDetails.url}")
    private String securityQuestionDetails;

    /** The Retrieve security questions. */
    @Value("${RetrieveSecurityQuestions.url}")
    private String retrieveSecurityQuestions;

    /** The Retrieve security questions. */
    @Value("${lookupSecurityQuestions.url}")
    private String lookupSecurityQuestionsurl;

    /** The Retrieve security questions. */
    @Value("${validateSecurityQuestions.url}")
    private String validateSecurityQuestionsurl;

    /**
     * This field holds the value of success.
     */
    @Value("${STATUS}")
    private String success;

    @Value("${FAILURE}")
    private String failure;

    /**
     * This method is for authentacing by calling shared services.
     *
     * @param sharedServieRequest
     *            the shared servie request
     * @return the security response
     */
    @Override
    public final SecurityResponse authenticateUser(
            final SharedServieRequest sharedServieRequest) {
        return (SecurityResponse) StubInvokerUtil.restServiceInvoker(
                sharedServiceAuthenticateUrl, sharedServieRequest,
                SecurityResponse.class);
    }

    /**
     * This method is for resetting the password.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    @Override
    public final boolean resetPassword(
            final PasswordResetRequest passwordResetRequest) {

        final ResponseStatus responseStatus = (ResponseStatus) StubInvokerUtil
                .restServiceInvoker(resetPasswordurl, passwordResetRequest,
                        ResponseStatus.class);
        boolean status = false;
        if (success.equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        }
        if (failure.equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        return status;
    }

    /**
     * This method is for updateUserId.
     *
     * @param oldEmailId
     *            the old email id
     * @param newEmailId
     *            the new email id
     * @return true, if successful
     */
    @Override
    public final boolean updateUserId(final UserEmailDetails userEmailDetails) {

        final ResponseStatus responseStatus = (ResponseStatus) StubInvokerUtil
                .restServiceInvoker(updateUserIdurl, userEmailDetails,
                        ResponseStatus.class);
        boolean status = false;
        if (success.equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        }
        if (failure.equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        return status;
    }

    /**
     * This method is for forceFulReset based on emailId.
     *
     * @param emailId
     *            the email id
     * @param newPassword
     *            the new password
     * @return true, if successful
     */
    @Override
    public final boolean forceFulReset(final ForcefulReset forcefulReset) {

        final ResponseStatus responseStatus = (ResponseStatus) StubInvokerUtil
                .restServiceInvoker(forceFulReseturl, forcefulReset,
                        ResponseStatus.class);
        boolean status = false;
        if (success.equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        }
        if (failure.equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        System.err.println(status);
        return status;
    }

    /**
     * This method is for updatePassword based on emailId.
     *
     * @param passwordDetails
     *            the password details
     * @return true, if successful
     */
    @Override
    public final boolean updatePassword(final PasswordRequest passwordRequest) {

        final ResponseStatus responseStatus = (ResponseStatus) StubInvokerUtil
                .restServiceInvoker(updatePasswordurl, passwordRequest,
                        ResponseStatus.class);
        boolean status = false;
        if (success.equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        }
        if (failure.equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        return status;
    }

    /**
     * This method is for updateSecurityDetails based on emailId.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    @Override
    public final boolean updateSecurityDetails(
            final SecurityQuestionsUpdateRequest securityQuestionsUpdateRequest) {

        final ResponseStatus responseStatus = (ResponseStatus) StubInvokerUtil
                .restServiceInvoker(updateSecurityDetailsurl,
                        securityQuestionsUpdateRequest, ResponseStatus.class);
        boolean status = false;
        if (success.equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        }
        if (failure.equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        return status;
    }

    /**
     * This method is for finding admin user based on emailId.
     *
     * @param emailId
     *            the email id
     * @return the admin user
     */
    @Override
    public final AdminUser findUser(final String emailId) {

        final SharedServieRequest sharedServieRequest = new SharedServieRequest();
        sharedServieRequest.setUserId(emailId);
        return (AdminUser) StubInvokerUtil.restServiceInvoker(findUser,
                sharedServieRequest, AdminUser.class);

    }

    /**
     * Gets the security questions list.
     *
     * @param emailId
     *            the email id
     * @return the security questions list
     */
    @Override
    public RetrieveSecurityQuestions userSecurityQuestions(final String emailId) {
        return (RetrieveSecurityQuestions) StubInvokerUtil.invokeStub(
                retrieveSecurityQuestions + emailId, HttpMethod.GET,
                RetrieveSecurityQuestions.class);
    }

    @Override
    public RetrieveSecurityQuestions lookupSecutityQuestions() {

        return (RetrieveSecurityQuestions) StubInvokerUtil.getServiceData(
                lookupSecurityQuestionsurl, RetrieveSecurityQuestions.class);
    }

    @Override
    public boolean validateSecurityQuestions(
            final SecurityQuestionsValidateRequest securityQuestionsValidateRequest) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("c:\\Shiva\\user.json"),
                    securityQuestionsValidateRequest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        final ResponseStatus responseStatus = (ResponseStatus) StubInvokerUtil
                .restServiceInvoker(validateSecurityQuestionsurl,
                        securityQuestionsValidateRequest, ResponseStatus.class);
        boolean status = false;
        if (success.equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        }
        if (failure.equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        return status;
    }
}
