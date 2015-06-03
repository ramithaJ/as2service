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
package com.wiley.gr.ace.authorservices.web.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 */
@RestController
@RequestMapping("/user")
public class UserLoginController extends ASExceptionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	
    @Autowired(required = true)
    UserLoginService userLoginService;
    
    @Autowired(required = true)
    LocalValidatorFactoryBean validator;
    
    @Autowired
    AuthorProfileService authorProfileService;
    
    
    /**
     * @param sharedServieRequest
     * @return Service
     */
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public Service login(@Valid @RequestBody SharedServieRequest sharedServieRequest) {
        
        Service service = new Service();
        service.setPayload(userLoginService.login(sharedServieRequest));
        return service;
    }
    
    /**
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/orcid", method = RequestMethod.POST)
    public Service doOrcidLogin(@RequestBody String email,
            @RequestBody String password) {
        Service service = new Service();
        User user = new User();
        user.setUserId(1234);
        user.setOrcidID("123");
        service.setPayload(user);
        return service;
    }
    
    /**
     * this method will reset the password at the time of login.
     * 
     * @param login
     *            - it takes the email id and new password as inputs.
     * @return
     */
    @RequestMapping(value = "/password/reset", method = RequestMethod.POST)
    public Service resetPassword(
            @RequestBody SecurityDetailsHolder securityDetailsHolder) {
    	 LOGGER.info("inside resetPassword method");
        Service service = new Service();
        service.setPayload(userLoginService
                .resetPassword(securityDetailsHolder));
        return service;
        
    }
    
    /**
     * this method will update the password at user profile level.
     * 
     * @param passwordDetails
     *            - it takes userId, old password and new password as inputs.
     * @return
     */
    @RequestMapping(value = "/password/update", method = RequestMethod.POST)
    public Service updatePassword(
            @Valid @RequestBody PasswordDetails passwordDetails) {
    	LOGGER.info("inside updatePassword method");
        Service service = new Service();
        service.setPayload(authorProfileService.updatePassword(passwordDetails));
        return service;
        
    }
    
    /**
     * this method will validate the security questions and answers to reset the
     * password at the time of login.
     * 
     * @param emailId
     * @param securityDetails
     *            - it takes security questions and answers as inputs in JSON
     *            array format.
     * @return
     */
    @RequestMapping(value = "/securityQuestions/validate/{emailId}", method = RequestMethod.POST)
    public Service validateSecurityQuestions(
            @PathVariable("emailId") String emailId,
            @Valid @RequestBody SecurityDetailsHolder securityDetails) {
    	LOGGER.info("inside validateSecurityQuestions method");
        Service service = new Service();
        service.setPayload(userLoginService.validateSecurityQuestions(emailId,
                securityDetails.getSecurityDetails()));
        
        return service;
    }
    
    @RequestMapping(value = "/userSecurityQuestions/{emailId}", method = RequestMethod.GET)
    public Service userSecurityQuestions(@PathVariable("emailId") String emailId) {
    	LOGGER.info("inside userSecurityQuestions method");
        Service service = new Service();
        service.setPayload(userLoginService.securityQuestions(emailId));
        return service;
        
    }
    
    @RequestMapping(value = "/lockUser", method = RequestMethod.POST)
    public Service lockUser(@RequestBody String emailId) {
    	LOGGER.info("inside lockUser method");
        Service service = new Service();
        service.setPayload(userLoginService.lockUser(emailId));
        return service;
        
    }
    
    @RequestMapping(value = "/unLockUser", method = RequestMethod.POST)
    public Service unLockUser(@RequestBody String emailId) {
    	LOGGER.info("inside unLockUser method");
        Service service = new Service();
        service.setPayload(userLoginService.unLockUser(emailId));
        return service;
        
    }
    
    @RequestMapping(value = "resetByEmail/{emailId}", method = RequestMethod.POST)
    public Service resetByEmail(@PathVariable("emailId") String emailId) {
    	LOGGER.info("inside resetByEmail method");
        return new Service();
    }
}
