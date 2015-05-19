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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * @author kpshiva
 *
 */
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

	@Autowired
	UserAccountService userAccountService;

	@Autowired
	AuthorProfileService authorProfileService;
	
	/**
	 * @param userId
	 * @param userDetails
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userDetails/{userId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public Service getUserDetails(@PathVariable("userId") String userId,
			@RequestBody String userDetails, HttpServletRequest request) {

		return null;

	}

	/**
	 * @param userId
	 * @param emailDetails
	 * @return
	 */
	@RequestMapping(value = "/emailDetails/update/{userId}", method = RequestMethod.POST)
	public Service updateEmail(@PathVariable("userId") String userId,
			@RequestBody UserMgmt emailDetails) {

		Service service = new Service();
		service.setPayload(userAccountService.updateEmailDetails(userId,
				emailDetails));
		return service;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/emailDetails/{userId}", method = RequestMethod.GET)
	public Service getEmailDetails(@PathVariable("userId") String userId) {

		Service service = new Service();
		service.setPayload(userAccountService.getEmailDetails(userId));
		return service;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getUserAddresses/{userId}", method = RequestMethod.GET)
	public Service getUserAddresses(@PathVariable("userId") String userId) {

		return null;

	}

	/**
	 * This service will update the security questions and answers at user
	 * profile level.
	 * 
	 * @param userId
	 * @param securityDetails
	 *            - it is a JSON array having security questions and answers.
	 * @return
	 */
	@RequestMapping(value = "/secutiryDetails/update/{userId}", method = RequestMethod.POST)
	public Service updateSecurityDetails(@PathVariable("userId") String userId,
			@Valid @RequestBody SecurityDetailsHolder securityDetails) {

		Service service = new Service();
		service.setStatus("Success");
		service.setPayload(userAccountService.updateSecurityDetails(userId,
				securityDetails.getSecurityDetails()));
		return service;

	}

}
