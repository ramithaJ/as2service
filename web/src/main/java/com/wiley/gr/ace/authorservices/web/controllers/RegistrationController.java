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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	RegistrationService rs = (RegistrationService) context
			.getBean("RegistrationService");
	private Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);

	@RequestMapping(value = "/checkIfExists/{email}/{firstName}/{lastName}", method = RequestMethod.GET)
	public @ResponseBody Service checkUserExists(@PathVariable("email") String email,
			@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {

		Service service = new Service();
		ESBUser esbUser = rs.checkEmailIdExists(email);

		if (esbUser != null) {
			service.setStatus("User email exists as primary email in the system");
			service.setPayload(esbUser);
		} else {
			List<ESBUser> esbUserList = rs.getUserFromFirstNameLastName(
					firstName, lastName);
			if (!esbUserList.isEmpty()) {
				service.setStatus("Number of user with email as secondary email in the system is: "
						+ esbUserList.size());
				service.setPayload(esbUserList);
			}
		}

		return service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = { "application/json" })
	public void registerUser(@RequestParam String contactId,
			@RequestBody ESBUser esbUser) {
		try {
			rs.createUser(contactId, esbUser);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

}
