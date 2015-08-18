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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.AuditInformation;
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
import com.wiley.gr.ace.authorservices.persistence.audit.AuditResultServiceImpl;

/**
 * The Class UserManagementImpl.
 *
 * @author virtusa version 1.0
 */
public class UserManagementImpl implements UserManagement {

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

    /** The update password. */
    @Value("${updatePassword.url}")
    private String updatePasswordurl;

    /** The update security details. */
    @Value("${updateSecurityDetails.url}")
    private String updateSecurityDetailsurl;

    /** The find user. */
    @Value("${findUser.url}")
    private String findUser;

    /** The Retrieve security questions. */
    @Value("${RetrieveSecurityQuestions.url}")
    private String retrieveSecurityQuestionsurl;

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

    /** The failure. */
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
        return (SecurityResponse) RestServiceInvokerUtil.restServiceInvoker(
                sharedServiceAuthenticateUrl, sharedServieRequest,
                SecurityResponse.class);
    }

    /**
     * This method is for resetting the password.
     *
     * @param passwordResetRequest
     *            the password reset request
     * @return true, if successful
     */
    @Override
    public final boolean resetPassword(
            final PasswordResetRequest passwordResetRequest) {

        final boolean status = this.externalPostServiceInvoker(
                resetPasswordurl, passwordResetRequest);
        if (status) {
            final Integer userId = 8011047;
            AuditInformation auditInformation = new AuditInformation();
            auditInformation.setActionID("PWDRES");
            auditInformation.setTableName("TABLE");
            auditInformation.setColumnName("COLUMN");
            auditInformation.setNewValue(passwordResetRequest
                    .getUpdateUserSecurityAttributes().getNewPassword());
            auditInformation.setOldValue("45624");
            auditInformation.setUserId(userId);
            AuditResultServiceImpl.auditUserActions(auditInformation);
        }
        return status;
    }

    /**
     * This method is for updateUserId.
     *
     * @param userEmailDetails
     *            the user email details
     * @return true, if successful
     */
    @Override
    public final boolean updateUserId(final UserEmailDetails userEmailDetails) {

        return this.externalPostServiceInvoker(updateUserIdurl,
                userEmailDetails);
    }

    /**
     * This method is for forceFulReset based on emailId.
     *
     * @param forcefulReset
     *            the forceful reset
     * @return true, if successful
     */
    @Override
    public final boolean forceFulReset(final ForcefulReset forcefulReset) {

        boolean status = this.externalPostServiceInvoker(forceFulReseturl,
                forcefulReset);
        if (status) {
            final Integer userId = 8011047;
            AuditInformation auditInformation = new AuditInformation();
            auditInformation.setActionID("PWDRES");
            auditInformation.setTableName("TABLE");
            auditInformation.setColumnName("COLUMN");
            auditInformation.setNewValue(forcefulReset.getNewPassword());
            auditInformation.setOldValue("45624");
            auditInformation.setUserId(userId);
            AuditResultServiceImpl.auditUserActions(auditInformation);
        }
        return status;
    }

    /**
     * This method is for updatePassword based on emailId.
     *
     * @param passwordRequest
     *            the password request
     * @return true, if successful
     */
    @Override
    public final boolean updatePassword(final PasswordRequest passwordRequest) {

        return this.externalPostServiceInvoker(updatePasswordurl,
                passwordRequest);
    }

    /**
     * This method is for updateSecurityDetails based on emailId.
     *
     * @param securityQuestionsUpdateRequest
     *            the security questions update request
     * @return true, if successful
     */
    @Override
    public final boolean updateSecurityDetails(
            final SecurityQuestionsUpdateRequest securityQuestionsUpdateRequest) {

        return this.externalPostServiceInvoker(updateSecurityDetailsurl,
                securityQuestionsUpdateRequest);
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
        return (AdminUser) RestServiceInvokerUtil.restServiceInvoker(findUser,
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
    public final RetrieveSecurityQuestions userSecurityQuestions(
            final String emailId) {
        RetrieveSecurityQuestions retrieveSecurityQuestions = (RetrieveSecurityQuestions) RestServiceInvokerUtil
                .getServiceData(retrieveSecurityQuestionsurl + emailId,
                        RetrieveSecurityQuestions.class);
        if (success.equalsIgnoreCase(retrieveSecurityQuestions.getStatus())) {
            return retrieveSecurityQuestions;
        }
        final ErrorPayLoad errorPayLoad = retrieveSecurityQuestions.getError();
        throw new UserException(errorPayLoad.getErrorCode(),
                errorPayLoad.getErrorMessage());
    }

    /**
     * For retriving security questions.
     * 
     * @return retrived security questions.
     */
    @Override
    public final RetrieveSecurityQuestions lookupSecutityQuestions() {

        RetrieveSecurityQuestions retrieveSecurityQuestions = (RetrieveSecurityQuestions) RestServiceInvokerUtil
                .getServiceData(lookupSecurityQuestionsurl,
                        RetrieveSecurityQuestions.class);
        if (success.equalsIgnoreCase(retrieveSecurityQuestions.getStatus())) {
            return retrieveSecurityQuestions;
        }
        final ErrorPayLoad errorPayLoad = retrieveSecurityQuestions.getError();
        throw new UserException(errorPayLoad.getErrorCode(),
                errorPayLoad.getErrorMessage());
    }

    /**
     * For validating security questions.
     *
     * @param securityQuestionsValidateRequest
     *            the security questions validate request
     * @return true, if successful
     */
    @Override
    public final boolean validateSecurityQuestions(
            final SecurityQuestionsValidateRequest securityQuestionsValidateRequest) {

        return this.externalPostServiceInvoker(validateSecurityQuestionsurl,
                securityQuestionsValidateRequest);
    }

    /**
     * For External service invoker.
     *
     * @param url
     *            the url
     * @param requestEntityClass
     *            the request entity class
     * @return true, if successful
     */

    private boolean externalPostServiceInvoker(final String url,
            final Object requestEntityClass) {

        final ResponseStatus responseStatus = (ResponseStatus) RestServiceInvokerUtil
                .restServiceInvoker(url, requestEntityClass,
                        ResponseStatus.class);
        boolean status = false;
        if (StringUtils.isEmpty(responseStatus)) {
            return status;
        }
        if (success.equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        } else if (failure.equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        return status;
    }

}
