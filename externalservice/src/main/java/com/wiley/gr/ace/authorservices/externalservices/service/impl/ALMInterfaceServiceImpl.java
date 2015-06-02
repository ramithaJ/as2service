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
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;

/**
 * @author RAVISINHA
 */
public class ALMInterfaceServiceImpl implements ALMInterfaceService {
    
    @Value("${lockUser.url}")
    private String lockUser;
    
    @Value("${forceFulReset.url}")
    private String forceFulReset;
    
    @Value("${updateUserId.url}")
    private String updateUserId;
    
    @Value("${resetPassword.url}")
    private String resetPassword;
    
    @Value("${authenticateAdminUser.url}")
    private String authenticateAdminUser;
    
    @Value("${unLockUser.url}")
    private String unLockUser;
    
    @Value("${securityDetails.url}")
    private String securityDetails;
    
    @Value("${securityQuestions.url}")
    private String securityQuestions;
    
    @Value("${updatePassword.url}")
    private String updatePassword;
    
    @Value("${updateSecurityDetails.url}")
    private String updateSecurityDetails;
    
    @Value("${findUser.url}")
    private String findUser;
    
    @Value("${securityQuestionDetails.url}")
    private String securityQuestionDetails;
    
    private static final String STATUSS = "success";
    
    @Override
    public boolean authenticateAdminUser(String emailId) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(
                authenticateAdminUser, HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean authenticateUserALM(String emailId, String password) {
        
        return "Password".equalsIgnoreCase(password);
    }
    
    @Override
    public boolean resetPassword(SecurityDetailsHolder securityDetailsHolder) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(resetPassword,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean updateUserId(String oldEmailId, String newEmailId) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(updateUserId,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean forceFulReset(String emailId, String newPassword) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(forceFulReset,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean lockUser(String emailId) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(lockUser,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean unLockUser(String emailId) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(unLockUser,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public SecurityDetailsHolder getSecurityDetails(String emailId) {
        
        return (SecurityDetailsHolder) StubInvokerUtil
                .invokeStub(securityDetails, HttpMethod.GET,
                        SecurityDetailsHolder.class);
    }
    
    @Override
    public SecurityDetailsHolder getSecurityQuestions(String emailId) {
        
        return (SecurityDetailsHolder) StubInvokerUtil
                .invokeStub(securityQuestions, HttpMethod.GET,
                        SecurityDetailsHolder.class);
    }
    
    @Override
    public boolean updatePassword(PasswordDetails passwordDetails) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(updatePassword,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean updateSecurityDetails(SecurityDetailsHolder securityDetails) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(
                updateSecurityDetails, HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public SecuirtyQuestionDetails getSecurityQuestionDetails(String emailId) {
        
        return (SecuirtyQuestionDetails) StubInvokerUtil
                .invokeStub(securityQuestionDetails, HttpMethod.GET,
                        SecuirtyQuestionDetails.class);
    }
    
    @Override
    public AdminUser findUser(String emailId) {
        
        return (AdminUser) StubInvokerUtil.invokeStub(findUser,
                HttpMethod.GET, AdminUser.class);
        
    }
}