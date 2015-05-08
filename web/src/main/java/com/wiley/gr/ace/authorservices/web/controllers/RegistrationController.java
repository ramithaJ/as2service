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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired(required = true)
	RegistrationService rs;


	@RequestMapping(value = "/checkIfExists/{email}", method = RequestMethod.GET)
	public @ResponseBody Service checkUserExists(
			@PathVariable("email") String email) {

		Service service = new Service();
		User user = new User();
		try {
			user = rs.checkEmailIdExists(email);
		} catch (Exception e) {
			ErrorPOJO err = new ErrorPOJO();
			err.setCode(202);
			err.setMessage("searching user encountered exception");
			service.setStatus("ERROR");
			service.setError(err);
		}

		if (user != null) {
			service.setStatus("FAILURE");
			service.setPayload(user);
		} else {
			service.setStatus("SUCCESS");
		}

		return service;
	}

	@RequestMapping(value = "/checkFirstNameLastName/{firstName}/{lastName}", method = RequestMethod.GET)
	public @ResponseBody Service checkFirstNameLastName(
			@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {

		Service service = new Service();
		List<User> userList = rs.getUserFromFirstNameLastName(firstName,
				lastName);

		if (userList != null) {
			service.setStatus("FAILURE");
			service.setPayload(userList);
		} else {
			service.setStatus("SUCCESS");
		}

		return service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = { "application/json" })
	public @ResponseBody Service registerUser(@RequestBody User user) {
		String status = null;
		Service service = new Service();
		try {
			status = rs.createUser(user);
		} catch (Exception e) {
		
			ErrorPOJO err = new ErrorPOJO();
			err.setCode(201);
			err.setMessage("Creating user encountered exception");
			service.setStatus("ERROR");
			service.setError(err);
		}
		
		if(status == "success") {
			service.setStatus("SUCCESS");
		} else {
			service.setStatus("FAILURE");
		}
		return service;
	}

}
