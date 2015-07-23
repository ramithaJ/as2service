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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.ErrorPayLoad;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordResetRequest;
import com.wiley.gr.ace.authorservices.model.external.ResponseStatus;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.model.external.UserEmailDetails;
import com.wiley.gr.ace.authorservices.model.external.lookup.RetrieveSecurityQuestions;

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
    private String forceFulReset;

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
    private String updateSecurityDetails;

    /** The find user. */
    @Value("${findUser.url}")
    private String findUser;

    /** The security question details. */
    @Value("${securityQuestionDetails.url}")
    private String securityQuestionDetails;

    /** The Retrieve security questions. */
    @Value("${RetrieveSecurityQuestions.url}")
    private String retrieveSecurityQuestions;
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
     * This method is for authentacing admin user by calling shared services
     * using emailId.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    @Override
    public final boolean authenticateAdminUser(final String emailId) {

        final Service service = (Service) StubInvokerUtil.invokeStub(
                authenticateAdminUser, HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && success.equalsIgnoreCase(status)) {
            return true;
        }
        return false;
    }

    /**
     * This method is for authentaciting user based on emailId and password.
     *
     * @param emailId
     *            the email id
     * @param password
     *            the password
     * @return true, if successful
     */
    @Override
    public final boolean authenticateUserALM(final String emailId,
            final String password) {

        return "Password".equalsIgnoreCase(password);
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
    public final boolean forceFulReset(final String emailId,
            final String newPassword) {
        final Service service = (Service) StubInvokerUtil.invokeStub(
                forceFulReset, HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && success.equalsIgnoreCase(status)) {
            return true;
        }
        return false;
    }

    /**
     * This method is for lockuser based on emailId.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    @Override
    public final boolean lockUser(final String emailId) {

        final Service service = (Service) StubInvokerUtil.invokeStub(lockUser,
                HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && success.equalsIgnoreCase(status)) {
            return true;
        }
        return false;
    }

    /**
     * This method is for unlocking user based on emailId.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    @Override
    public final boolean unLockUser(final String emailId) {

        final Service service = (Service) StubInvokerUtil.invokeStub(
                unLockUser, HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && success.equalsIgnoreCase(status)) {
            return true;
        }
        return false;
    }

    /**
     * This method is for getting security details based on emailId.
     *
     * @param emailId
     *            the email id
     * @return the security details
     */
    @Override
    public final SecurityDetailsHolder getSecurityDetails(final String emailId) {

        return (SecurityDetailsHolder) StubInvokerUtil.invokeStub(
                securityDetails, HttpMethod.GET, SecurityDetailsHolder.class);
    }

    /**
     * This method is for getting SecurityQuestions based on emailId.
     *
     * @param emailId
     *            the email id
     * @return the security questions
     */
    @Override
    public final SecurityDetailsHolder getSecurityQuestions(final String emailId) {

        return (SecurityDetailsHolder) StubInvokerUtil.invokeStub(
                securityQuestions, HttpMethod.GET, SecurityDetailsHolder.class);
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
            final SecurityDetailsHolder securityDetails) {

        final Service service = (Service) StubInvokerUtil.invokeStub(
                updateSecurityDetails, HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && success.equalsIgnoreCase(status)) {
            return true;
        }
        return false;
    }

    /**
     * This method is for getSecurityQuestionDetails based on emailId.
     *
     * @param emailId
     *            the email id
     * @return the security question details
     */
    @Override
    public final SecuirtyQuestionDetails getSecurityQuestionDetails(
            final String emailId) {

        return (SecuirtyQuestionDetails) StubInvokerUtil.invokeStub(
                securityQuestionDetails, HttpMethod.GET,
                SecuirtyQuestionDetails.class);
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

        /*
         * return (AdminUser) StubInvokerUtil.invokeStub(findUser,
         * HttpMethod.GET, AdminUser.class);
         */
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
    public RetrieveSecurityQuestions getSecurityQuestionsList(final String emailId) {
        return (RetrieveSecurityQuestions) StubInvokerUtil.invokeStub(
                retrieveSecurityQuestions + emailId, HttpMethod.GET,
                RetrieveSecurityQuestions.class);
    }
}
