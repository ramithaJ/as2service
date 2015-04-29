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

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;
import com.wiley.gr.ace.authorservices.services.service.impl.UserAccountServiceImpl;

/**
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	UserAccountService userAccountService = (UserAccountServiceImpl) context
			.getBean("UserAccountService");

	@RequestMapping(value = "/getUserDetails/{userId}", method = RequestMethod.GET)
	public Service getUserDetails(@PathVariable("userId") String userId) {

		return null;

	}

	@RequestMapping(value = "/getEmailDetails/{userId}", method = RequestMethod.GET)
	public Service getEmailDetails(@PathVariable("userId") String userId) {

		Service service = new Service();
		try{
			
			service.setStatus("Success");
			service.setPayload(userAccountService.getEmailDetails(userId));
			
		}catch (ASException asException) {

			service.setStatus("failed");
			service.setError(new com.wiley.gr.ace.authorservices.model.Error());
			service.getError().setCode(
					Integer.parseInt(asException.getErrorCode()));
			service.getError().setMessage(asException.getDescription());
			
		} catch(Exception exception) {
			service.setStatus("failed");
			service.setError(new com.wiley.gr.ace.authorservices.model.Error());
			service.getError().setCode(-1);
			service.getError().setMessage(exception.getMessage());
		}
		return service;
	}

	@RequestMapping(value = "/getUserAddresses/{userId}", method = RequestMethod.GET)
	public Service getUserAddresses(@PathVariable("userId") String userId) {

		return null;

	}

	@RequestMapping(value = "/updateUserDetails/{userId}", method = RequestMethod.POST)
	public Service updateUserDetails(@PathVariable("userId") String userId,
			@RequestBody String userDetails) {

		return null;

	}

	@RequestMapping(value = "/updateUserEmail/{userId}", method = RequestMethod.POST)
	public Service updateUserEmail(@PathVariable("userId") String userId,
			@RequestBody UserMgmt emailDetails) {

		Service service = new Service();
		try{
			service.setStatus("Success");
			service.setPayload(userAccountService.updateEmailDetails(userId,emailDetails));
			
		}catch (ASException asException) {

			service.setStatus("failed");
			service.setError(new com.wiley.gr.ace.authorservices.model.Error());
			service.getError().setCode(
					Integer.parseInt(asException.getErrorCode()));
			service.getError().setMessage(asException.getDescription());
			
		} catch(Exception exception) {
			service.setStatus("failed");
			service.setError(new com.wiley.gr.ace.authorservices.model.Error());
			service.getError().setCode(-1);
			service.getError().setMessage(exception.getMessage());
		}
		return service;
	}
	
	
	@RequestMapping(value = "/updateSecutiryDetails/{emailId}", method = RequestMethod.POST)
	public boolean updateSecurityDetails(
			@PathVariable("emailId") String emailId,
			@RequestBody Security securityDetails) {
				
		userAccountService.updateSecurityDetails(emailId,securityDetails);
		return true;
		
	}
	

}
