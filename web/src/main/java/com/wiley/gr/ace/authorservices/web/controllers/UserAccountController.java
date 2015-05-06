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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

	// public static ApplicationContext context = new
	// AnnotationConfigApplicationContext(
	// ServiceBeanConfig.class);
	// UserAccountService userAccountService = (UserAccountServiceImpl) context
	// .getBean("UserAccountService");

	@Autowired
	UserAccountService userAccountService;

	@RequestMapping(value = "/userDetails/{userId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public Service getUserDetails(@PathVariable("userId") String userId,
			@RequestBody String userDetails, HttpServletRequest request) {

		return null;

	}

	@RequestMapping(value = "/emailDetails/{userId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public Service getEmailDetails(@PathVariable("userId") String userId,
			@RequestBody(required = false) UserMgmt emailDetails,
			HttpServletRequest request) {

		Service service = null;

		if (request.getMethod().equals(RequestMethod.GET)) {

			service = new Service();
			service.setPayload(userAccountService.getEmailDetails(userId));

		} else if (request.getMethod().equals(RequestMethod.POST)
				&& emailDetails != null) {

			service = new Service();
			service.setPayload(userAccountService.updateEmailDetails(userId,
					emailDetails));

		} else if (request.getMethod().equals(RequestMethod.POST)
				&& emailDetails == null) {

			throw new ASException("400", "Invalid Request Body");

		}

		return service;
	}

	@RequestMapping(value = "/getUserAddresses/{userId}", method = RequestMethod.GET)
	public Service getUserAddresses(@PathVariable("userId") String userId) {

		return null;

	}

	@RequestMapping(value = "/updateSecutiryDetails/{emailId}", method = RequestMethod.POST)
	public boolean updateSecurityDetails(
			@PathVariable("emailId") String emailId,
			@RequestBody Security securityDetails) {

		userAccountService.updateSecurityDetails(emailId, securityDetails);
		return true;

	}

}
