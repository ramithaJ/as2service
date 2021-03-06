/*******************************************************************************
a * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.UserLogin;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;
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
     * Injecting SendNotification bean.
     */
    @Autowired(required = true)
    private SendNotification sendNotification;

    /**
     * This field holds the value of SUCCESS.
     */
    @Value("${SUCCESS}")
    private String success;

    /**
     * This field holds the value of FAILURE.
     */
    @Value("${FAILURE}")
    private String failure;

    /**
     * This field holds the value of LOCKED.
     */
    @Value("${LOCKED}")
    private String locked;

    /**
     * This field holds the value of AuthorServices.
     */
    @Value("${AuthorServices}")
    private String authorServices;

    /**
     * This field holds the value of AuthenticationType.
     */
    @Value("${AuthenticationType}")
    private String authenticationType;

    /**
     * This field holds the value of templateId.
     */
    @Value("${templateId.password.reset}")
    private String templateId;

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

        SharedServieRequest sharedServieRequest = new SharedServieRequest();
        sharedServieRequest.setUserId(login.getEmailId());
        sharedServieRequest.setPassword(login.getPassword());
        sharedServieRequest.setAuthenticationType(authenticationType);
        sharedServieRequest.setAppKey(authorServices);

        SecurityResponse securityResponse = userLoginService.login(login,
                sharedServieRequest);
        final String status = securityResponse.getStatus();
        if (locked.equalsIgnoreCase(status) || failure.equalsIgnoreCase(status)) {
            service.setStatus(failure);
            ErrorPOJO errorPOJO = new ErrorPOJO();
            errorPOJO.setCode(securityResponse.getCode());
            errorPOJO.setMessage(securityResponse.getMessage());
            service.setError(errorPOJO);
        } else if (success.equals(securityResponse.getStatus())) {
            UserLogin user = new UserLogin();
            service.setPayload(user);
        }
        return service;
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
        userLoginService.resetPassword(securityDetailsHolder);
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
        authorProfileService.updatePassword(passwordDetails);
        return service;

    }

    /**
     * this method will validate the security questions and answers to reset the
     * password at the time of login.
     * 
     * @param securityDetails
     *            - it takes security questions and answers as inputs in JSON
     *            array format.
     * @return Service object.
     */
    @RequestMapping(value = "/securityQuestions/validate", method = RequestMethod.POST)
    public final Service validateSecurityQuestions(
            @Valid @RequestBody final SecurityDetailsHolder securityDetails) {
        LOGGER.info("inside validateSecurityQuestions method");
        Service service = new Service();
        service.setPayload(userLoginService
                .validateSecurityQuestions(securityDetails));

        return service;
    }

    /**
     * Method to get user security questions.
     * 
     * @param emailId
     *            - The request value
     * @return service object.
     */
    @RequestMapping(value = "/userSecurityQuestions/{emailId}", method = RequestMethod.GET)
    public final Service userSecurityQuestions(
            @PathVariable("emailId") final String emailId) {
        LOGGER.info("inside userSecurityQuestions method");
        Service service = new Service();
        service.setPayload(userLoginService.userSecurityQuestions(emailId));
        return service;

    }

    /**
     * Method to resetPassword.
     * 
     * @param guid
     *            - The request value
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
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "resetByEmail/{emailId}/", method = RequestMethod.POST)
    public final Service resetByEmail(
            @PathVariable("emailId") final String emailId) {
        Service service = new Service();
        userLoginService.resetByEmail(emailId);

        sendNotification.notifyByEmail(emailId, templateId);
        return service;
    }

    /**
     * @param guid
     *            - The request value
     * @return service.
     */
    @RequestMapping(value = "verifyAccount/{guid}", method = RequestMethod.GET)
    public final Service verifyAccount(@PathVariable("guid") final String guid) {
        userLoginService.verifyAccountUpdate(guid);
        return new Service();
    }

    /**
     * @param firstName
     *            - The request value
     * @param lastName
     *            - The request value
     * @param emailAddress
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "create/{fn}/{ln}/{email}/", method = RequestMethod.GET)
    public final Service createGuid(@PathVariable("fn") final String firstName,
            @PathVariable("ln") final String lastName,
            @PathVariable("email") final String emailAddress) {
        Service service = new Service();
        service.setPayload(userLoginService.insertGuid(firstName, lastName,
                emailAddress));
        return service;
    }

}
