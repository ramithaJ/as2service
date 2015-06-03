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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 */
public class UserLoginServiceImpl implements UserLoginService {
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserLoginServiceImpl.class);
            
    @Autowired(required = true)
    UserLoginServiceDAO userLoginServiceDAO;
    @Autowired(required = true)
    UserManagement userManagement;
    
    @Override
    public SecurityResponse login(SharedServieRequest sharedServieRequest) {
        
        LOGGER.info("In login method");
        return userManagement.authenticateUser(sharedServieRequest);
    }
    
    @Override
    public boolean validateEmailAddress(String emailId) {
        
        LOGGER.info("In validateEmailAddress method");
        return userLoginServiceDAO.validateEmailAddress(emailId);
    }
    
    /**
     * @param userId
     * @return
     */
    @Override
    public boolean isUserLocked(int userId) {
        
        LOGGER.info("In isUserLocked method");
        return userLoginServiceDAO.isUserLocked(userId);
    }
    
    /**
     * @param userId
     * @param template_id
     */
    @Override
    public void sendEmail(String userId, String templateId) {
        // TODO: send email service
    }
    
    /**
     * this method will reset the password at the time of login.
     * 
     * @param emailId
     * @param newPassword
     * @return
     */
    @Override
    public boolean resetPassword(SecurityDetailsHolder securityDetailsHolder) {
        
        LOGGER.info("In resetPassword method");
        return userManagement.resetPassword(securityDetailsHolder);
    }
    
    @Override
    public SecurityDetailsHolder securityQuestions(String emailId) {
        
        LOGGER.info("In securityQuestions method");
        return userManagement.getSecurityQuestions(emailId);
    }
    
    @Override
    public boolean lockUser(String emailId) {
        
        LOGGER.info("In lockUser method");
        return userManagement.lockUser(emailId);
    }
    
    @Override
    public boolean unLockUser(String emailId) {
        
        LOGGER.info("In unLockUser method");
        return userManagement.unLockUser(emailId);
    }
    
    @Override
    public boolean validateSecurityQuestions(String emailId,
            List<SecurityDetails> securityDetails) {
        
        LOGGER.info("In validateSecurityQuestions method");
        return false;
    }
}
