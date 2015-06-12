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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.UserManagement;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserLoginController extends ASExceptionController {
    
    /**
     * Logger for UserLoginController class.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserLoginController.class);
    
    /**
     * injecting UserLoginService bean.
     */
    @Autowired(required = true)
    private UserLoginService userLoginService;
    
    /**
     * injecting AuthorProfileService bean.
     */
    @Autowired
    private AuthorProfileService authorProfileService;
    
    /**
     * injecting AdminLoginService bean.
     */
    @Autowired(required = true)
    private AdminLoginService adminLoginService;
    
    /**
     * Method to authenticate user.
     * 
     * @param login
     *            - it takes user name and password as input.
     * @return Service object
     */
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public final Service login(@Valid @RequestBody final Login login) {
        
        Service service = new Service();
        if(userLoginService.validateEmailAddress(login.getEmailId())){
            
            SharedServieRequest sharedServieRequest = new SharedServieRequest();
            sharedServieRequest.setUserId(login.getEmailId());
            sharedServieRequest.setPassword(login.getPassword());
            sharedServieRequest.setAuthenticationType("LDAP");
            sharedServieRequest.setAppKey("AS");
            service.setPayload(userLoginService.login(login, sharedServieRequest));
            return service;
        }else{
            throw new ASException("invalidEmailCode","invalidEmailMessage");
        }
    }
    
    /**
     * Method to reset the password through security questions and email.
     * 
     * @param securityDetailsHolder
     *            - it takes the email_id, security details and new password as
     *            inputs.
     * @return Service object.
     */
    @RequestMapping(value = "/password/reset", method = RequestMethod.POST)
    public final Service resetPassword(
            @RequestBody final SecurityDetailsHolder securityDetailsHolder) {
        LOGGER.info("Inside resetPassword method");
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
     * @return Service object.
     */
    @RequestMapping(value = "/password/update", method = RequestMethod.POST)
    public final Service updatePassword(
            @Valid @RequestBody final PasswordDetails passwordDetails) {
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
     * @return Service object.
     */
    @RequestMapping(value = "/securityQuestions/validate")
    public final Service validateSecurityQuestions(@Valid @RequestBody final SecurityDetailsHolder securityDetails) {
        LOGGER.info("inside validateSecurityQuestions method");
        Service service = new Service();
        service.setPayload(userLoginService.validateSecurityQuestions(securityDetails.getSecurityDetails()));
        
        return service;
    }
    
    /**
     * Method to get user security questions.
     * 
     * @param emailId
     * @return service object.
     */
    @RequestMapping(value = "/userSecurityQuestions/{emailId}")
    public final Service userSecurityQuestions(
            @PathVariable("emailId") final String emailId) {
        LOGGER.info("inside userSecurityQuestions method");
        Service service = new Service();
        service.setPayload(userLoginService.securityQuestions(emailId));
        return service;
        
    }
    
    /**
     * Method to resetPassword.
     * 
     * @param emailId
     * @return service
     */
    @RequestMapping(value = "resetPassword/{guid}", method = RequestMethod.GET)
    public final Service resetPassword(@PathVariable("guid") final String guid) {
        Service service = new Service();
        Login login = new Login();
        login.setEmailId(userLoginService.resetPassword(guid));
        service.setPayload(login);
        
        return service;
    }
    
    /**
     * @param emailId
     * @return service
     */
    @RequestMapping(value = "resetByEmail/{emailId}", method = RequestMethod.POST)
    public final Service resetByEmail(
            @PathVariable("emailId") final String emailId) {
        
        return new Service();
    }
    /**
     * @param guid
     * @return service.
     */
    @RequestMapping(value = "verifyAccount/{guid}", method = RequestMethod.POST)
    public final Service verifyAccount(
            @PathVariable("guid") final String guid) {
        userLoginService.verifyAccountUpdate(guid);
        return new Service();
    }
    
}