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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@RequestMapping(value = "/verify/email", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Service checkUserExists(@RequestHeader String email) {

		Service service = new Service();
		User user = null;
		try {
			if (null != email && !email.isEmpty())
				user = rs.checkEmailIdExists(email);
			else {
				ErrorPOJO err = new ErrorPOJO();
				err.setCode(201);
				err.setMessage("Email is null or empty");
				service.setStatus("ERROR");
				service.setError(err);
			}
			if (user != null) {
				service.setStatus("FAILURE");
				ErrorPOJO err = new ErrorPOJO();
				err.setCode(202);
				err.setMessage("Email address already exists");
				service.setError(err);
				service.setPayload(user);
			} else {
				service.setStatus("SUCCESS");
			}
		} catch (Exception e) {
			ErrorPOJO err = new ErrorPOJO();
			err.setCode(202);
			err.setMessage("searching user encountered exception");
			service.setStatus("ERROR");
			service.setError(err);
		}
		return service;
	}

	@RequestMapping(value = "/verify/fullname", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Service checkFirstNameLastName(
			@RequestHeader String firstName, @RequestHeader String lastName) {

		Service service = new Service();
		List<User> userList = null;
		try {
			if (null != firstName && !firstName.isEmpty() && null != lastName
					&& !lastName.isEmpty())
				userList = rs.getUserFromFirstNameLastName(firstName, lastName);
			else {
				ErrorPOJO err = new ErrorPOJO();
				err.setCode(205);
				err.setMessage("First Name or Last Name is empty");
				service.setStatus("ERROR");
				service.setError(err);
			}
			if (userList != null) {
				service.setStatus("FAILURE");
				ErrorPOJO err = new ErrorPOJO();
				err.setCode(205);
				err.setMessage("First Name and Last Name already exists");
				service.setError(err);
				service.setPayload(userList);
			} else {
				service.setStatus("SUCCESS");
			}
		} catch (Exception e) {
			ErrorPOJO err = new ErrorPOJO();
			err.setCode(206);
			err.setMessage("Searching user by full name encountered exception");
			service.setStatus("ERROR");
			service.setError(err);
		}

		return service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Service registerUser(@RequestBody User user) {
		String status = null;
		Service service = new Service();
		try {
			if (null != user)
				status = rs.createUser(user);
			else {
				ErrorPOJO err = new ErrorPOJO();
				err.setCode(207);
				err.setMessage("User object is empty");
				service.setStatus("ERROR");
				service.setError(err);
			}

			if (status.equalsIgnoreCase("success")) {
				service.setStatus("SUCCESS");
			} else {
				service.setStatus("FAILURE");
				ErrorPOJO err = new ErrorPOJO();
				err.setCode(208);
				err.setMessage("Creating user failed");
				service.setError(err);
			}
		} catch (Exception e) {

			ErrorPOJO err = new ErrorPOJO();
			err.setCode(201);
			err.setMessage("Creating user encountered exception");
			service.setStatus("ERROR");
			service.setError(err);
		}

		return service;
	}

}
