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
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
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
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 *
 */
@RestController
@RequestMapping("/user")
public class UserLoginController extends ASExceptionController {

	@Autowired(required = true)
	UserLoginService userLoginService;

	@Autowired(required = true)
	LocalValidatorFactoryBean validator;
	
	/** This method will authenticate the user based on email id and password 
	 * @param login - it is a JSON object having email id and password 
	 * @return
	 */
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public Service login(@Valid @RequestBody Login login) {

		Service service = new Service();
		service.setStatus("success");
		service.setPayload(userLoginService.doLogin(login.getEmailId(),
				login.getPassword()));

		return service;
	}

	/**
	 * @param email
	 * @param password
	 * @return
	 */
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
	 * @param emailId
	 * @param passwordDetails
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/password/{emailId}", method = {
			RequestMethod.POST, RequestMethod.PUT })
	public Service updatePassword(@PathVariable("emailId") String emailId,
			@RequestBody PasswordDetails passwordDetails,
			HttpServletRequest request) {

		Service service = new Service();

		if (request.getMethod().equals(RequestMethod.POST)) {

			service = new Service();
			userLoginService.updatePassword(emailId, passwordDetails);

		} else if (request.getMethod().equals(RequestMethod.PUT)) {

			service = new Service();
			userLoginService.resetPassword(emailId,
					passwordDetails.getNewPassword());
		}

		return service;
	}

	/**
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/securityQuestions/{emailId}", method = RequestMethod.GET)
	public Service securityQuestions(@PathVariable("emailId") String emailId) {

		Service service = new Service();
		service.setPayload(userLoginService.getSecurityQuestions(emailId));
		service.setStatus("success");

		return service;
	}

	/**
	 * @param emailId
	 * @param securityDetails
	 * @return
	 */
	@RequestMapping(value = "/securityQuestions/validate/{emailId}", method = RequestMethod.POST)
	public Service validateSecurityQuestions(
			@PathVariable("emailId") String emailId,
			@Valid @RequestBody Security securityDetails) {

		Service service = new Service();
		service.setPayload(userLoginService.validateSecurityQuestions(emailId,
				securityDetails));
		service.setStatus("success");

		return service;
	}

}
