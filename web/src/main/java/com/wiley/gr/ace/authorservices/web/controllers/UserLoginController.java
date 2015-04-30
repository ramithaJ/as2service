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

import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;
import com.wiley.gr.ace.authorservices.services.service.impl.UserLoginServiceImpl;

/**
 * @author kpshiva
 *
 */
@RestController
@RequestMapping("/userLogin")
public class UserLoginController extends ASExceptionController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	UserLoginService userLoginService = (UserLoginServiceImpl) context
			.getBean("UserLoginService");

	/**
	 * This method takes email in encrypted format like --
	 * kondavinay4%40gmail.com
	 * 
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/checkSecuritySetup/", method = RequestMethod.GET)
	public Service checkSecuritySetUp(@RequestBody String emailId) {

		Service service = new Service();

		boolean status = userLoginService.checkSecuritySetUp(emailId);
		UserMgmt userMgmt = new UserMgmt();
		if (status) {
			userMgmt.setIsSecuritySetup("true");
		} else {
			userMgmt.setIsSecuritySetup("false");
		}
		service.setStatus("success");
		service.setPayload(userMgmt);
		
		return service;
	}

	/**
	 * this method takes the password from request body
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/doLogin/", method = RequestMethod.POST)
	public Service doLogin(@RequestBody Login login) {

		Service service = new Service();
		service.setStatus("success");
		service.setPayload(userLoginService.doLogin(login.getEmailId(), login.getPassword()));
		
		return service;
	}

	@RequestMapping(value = "/orcid", method = RequestMethod.POST, produces = "application/json")
	public Service doOrcidLogin(@RequestBody String email,
			@RequestBody String password) {

		Service service = new Service();
		User user = new User();
		user.setUserId(1234);
		user.setOrcidID("123");
		/**
		 * Service impl TODO
		 */
		service.setStatus("success");
		service.setPayload(user);
		
		return service;
	}

	/**
	 * this method takes the password from request body
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updatePassword/{emailId}", method = RequestMethod.POST)
	public Service updatePassword(@PathVariable("emailId") String emailId,
			@RequestBody PasswordDetails passwordDetails) {

		Service service = new Service();
		userLoginService.updatePassword(emailId, passwordDetails);
		service.setStatus("success");
		
		return service;
	}

	@RequestMapping(value = "/resetPassword/{emailId}", method = RequestMethod.POST)
	public Service resetPassword(@PathVariable("emailId") String emailId,
			@RequestBody String newPassword) {

		Service service = new Service();
		userLoginService.resetPassword(emailId, newPassword);
		service.setStatus("success");
	
		return service;
	}

	/**
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/getSecurityQuestions/{emailId}", method = RequestMethod.GET)
	public Service getSecurityQuestions(@PathVariable("emailId") String emailId) {

		Service service = new Service();
		service.setStatus("success");
		service.setPayload(userLoginService.getSecurityQuestions(emailId));
		
		return service;
	}

	/**
	 * this method requires json string like { "id1": "SEQ5", "id2": "SEQ4",
	 * "securityQuestion1": "what's ur pet name", "securityQuestion2":
	 * "What is your birthday?","securityAnswer1": "cat","securityAnswer2":
	 * "i will not tell"} This method takes reads Security from POST
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/valdiateSecurityQuestions/{emailId}", method = RequestMethod.POST)
	public Service validateSecurityQuestions(
			@PathVariable("emailId") String emailId,
			@RequestBody Security securityDetails) {

		Service service = new Service();
		userLoginService
				.validateSecurityQuestions(emailId, securityDetails);
		service.setStatus("success");
	
		return service;
	}

}
