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

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * The Class UserManagementImpl.
 *
 * @author virtusa version 1.0
 */
public class UserManagementImpl implements UserManagement {

    /** The lock user. */
    @Value("${lockUser.url}")
    private String lockUser;

    /** The status. */
    @Value("${STATUS}")
    private String STATUS;

    /** The shared service authenticate url. */
    @Value("${shared.service.authenticate.url}")
    private String sharedServiceAuthenticateUrl;

    /** The force ful reset. */
    @Value("${forceFulReset.url}")
    private String forceFulReset;

    /** The update user id. */
    @Value("${updateUserId.url}")
    private String updateUserId;

    /** The reset password. */
    @Value("${resetPassword.url}")
    private String resetPassword;

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
    private String updatePassword;

    /** The update security details. */
    @Value("${updateSecurityDetails.url}")
    private String updateSecurityDetails;

    /** The find user. */
    @Value("${findUser.url}")
    private String findUser;

    /** The security question details. */
    @Value("${securityQuestionDetails.url}")
    private String securityQuestionDetails;

    /**
     * This method is for authentacing by calling shared services.
     *
     * @param sharedServieRequest
     *            the shared servie request
     * @return the security response
     */
    @Override
    public SecurityResponse authenticateUser(
            SharedServieRequest sharedServieRequest) {
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
    public boolean authenticateAdminUser(String emailId) {

        Service service = (Service) StubInvokerUtil.invokeStub(
                authenticateAdminUser, HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
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
    public boolean authenticateUserALM(String emailId, String password) {

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
    public boolean resetPassword(SecurityDetailsHolder securityDetailsHolder) {
        Service service = (Service) StubInvokerUtil.invokeStub(resetPassword,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
            return true;
        }
        return false;
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
    public boolean updateUserId(String oldEmailId, String newEmailId) {

        Service service = (Service) StubInvokerUtil.invokeStub(updateUserId,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
            return true;
        }
        return false;
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
    public boolean forceFulReset(String emailId, String newPassword) {
        Service service = (Service) StubInvokerUtil.invokeStub(forceFulReset,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
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
    public boolean lockUser(String emailId) {

        Service service = (Service) StubInvokerUtil.invokeStub(lockUser,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
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
    public boolean unLockUser(String emailId) {

        Service service = (Service) StubInvokerUtil.invokeStub(unLockUser,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
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
    public SecurityDetailsHolder getSecurityDetails(String emailId) {

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
    public SecurityDetailsHolder getSecurityQuestions(String emailId) {

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
    public boolean updatePassword(PasswordDetails passwordDetails) {

        Service service = (Service) StubInvokerUtil.invokeStub(updatePassword,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
            return true;
        }
        return false;
    }

    /**
     * This method is for updateSecurityDetails based on emailId.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    @Override
    public boolean updateSecurityDetails(SecurityDetailsHolder securityDetails) {

        Service service = (Service) StubInvokerUtil.invokeStub(
                updateSecurityDetails, HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUS)) {
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
    public SecuirtyQuestionDetails getSecurityQuestionDetails(String emailId) {

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
    public AdminUser findUser(String emailId) {

        /*
         * return (AdminUser) StubInvokerUtil.invokeStub(findUser,
         * HttpMethod.GET, AdminUser.class);
         */
        SharedServieRequest sharedServieRequest = new SharedServieRequest();
        sharedServieRequest.setUserId(emailId);
        return (AdminUser) StubInvokerUtil.restServiceInvoker(findUser,
                sharedServieRequest, AdminUser.class);

    }
}
