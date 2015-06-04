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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * @author Virtusa
 */
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserAccountController.class);
    @Autowired
    UserAccountService userAccountService;
    
    @Autowired
    AuthorProfileService authorProfileService;
    
    @RequestMapping(value = "/profileInfo/{userId}", method = RequestMethod.GET)
    public Service getProfileInformation(@PathVariable("userId") String userId) {
        LOGGER.info("inside getProfileInformation method");
        Service service = new Service();
        service.setPayload(userAccountService.getProfileInformation(userId));
        return service;
        
    }
    
    @RequestMapping(value = "/profileInfo/{userId}", method = RequestMethod.POST)
    public Service updateProfileInformation(
            @PathVariable("userId") String userId, @RequestBody User user) {
    	 LOGGER.info("inside updateProfileInformation method");
        Service service = new Service();
        service.setPayload(authorProfileService.updateUserProfileInfo(user));
        return service;
        
    }
    
    @RequestMapping(value = "/emailDetails/{userId}", method = RequestMethod.GET)
    public Service getEmailDetails(@PathVariable("userId") String userId) {
    	 LOGGER.info("inside getEmailDetails method");
        Service service = new Service();
        service.setPayload(userAccountService.getEmailDetails(userId));
        return service;
    }
    
    @RequestMapping(value = "/emailDetails/{userId}", method = RequestMethod.POST)
    public Service updateEmail(@PathVariable("userId") String userId,
            @RequestBody User emailDetails) {
    	 LOGGER.info("inside updateEmail method");
        Service service = new Service();
        emailDetails.setUserId(Integer.parseInt(userId));
        service.setPayload(authorProfileService
                .updateEmailDetails(emailDetails));
        return service;
    }
    
    @RequestMapping(value = "/userAddresses/{userId}", method = RequestMethod.GET)
    public Service getUserAddresses(@PathVariable("userId") String userId) {
    	 LOGGER.info("inside getUserAddresses method");
        Service service = new Service();
        service.setPayload(userAccountService.getUserAddress(userId));
        return service;
    }
    
    @RequestMapping(value = "/userAddresses/{userId}", method = RequestMethod.POST)
    public Service updateUserAddresses(@PathVariable("userId") String userId,
            @RequestBody UserProfile addresses) {
    	 LOGGER.info("inside updateUserAddresses method");
        Service service = new Service();
        service.setPayload(authorProfileService.updateUserAddress(addresses));
        return service;
    }
    
    @RequestMapping(value = "/secutiryDetails/update", method = RequestMethod.POST)
    public Service updateSecurityDetails(
            @RequestBody SecurityDetailsHolder securityDetails) {
    	 LOGGER.info("inside updateSecurityDetails method");
        Service service = new Service();
        service.setPayload(authorProfileService
                .updateSecurityDetails(securityDetails));
        return service;
        
    }
    
    @RequestMapping(value = "/updateUserId/{oldEmailId}/{newEmailId}", method = RequestMethod.POST)
    public Service updateUserId(@PathVariable("oldEmailId") String oldEmailId,
            @PathVariable("newEmailId") String newEmailId) {
    	 LOGGER.info("inside updateUserId method");
        Service service = new Service();
        service.setPayload(authorProfileService.updateUserId(oldEmailId,
                newEmailId));
        return service;
    }
    
}
