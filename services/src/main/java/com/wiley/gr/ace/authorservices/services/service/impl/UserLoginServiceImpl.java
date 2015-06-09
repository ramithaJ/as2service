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
 * @author virtusa
 *	version 1.0
 */
public class UserLoginServiceImpl implements UserLoginService {
    
    /**
     * Logger for UserLoginServiceImpl class.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserLoginServiceImpl.class);
    /**
     * Injecting UserLoginServiceDAO bean.
     */
    @Autowired(required = true)
    UserLoginServiceDAO userLoginServiceDAO;
    /**
     * Injecting UserMangement bean.
     */
    @Autowired(required = true)
    UserManagement userManagement;
    
    /**
     * Method to authenticate user. calling external system to authenticate user.
     * 
     * @param sharedServieRequest - having user information .
     * @return status - true/false
     */
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
     * Method to reset the password at the time of login.
     * 
     * @param securityDetailsHolder - having emailId, secutiryDetails and password.
     * @return status - true/false
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
    public boolean validateSecurityQuestions(String emailId,
            List<SecurityDetails> securityDetails) {
        
        LOGGER.info("In validateSecurityQuestions method");
        return false;
    }
}