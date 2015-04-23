package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
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

	@RequestMapping(value = "/checkByName/{firstName}/{lastName}", method = RequestMethod.GET)
	public @ResponseBody Service getUserFromFirstNameLastName(
			@PathVariable String firstName, @PathVariable String lastName) {

		Service service = new Service();
		List<User> userList = rs.getUserFromFirstNameLastName(firstName, lastName);
		service.setStatus("User first name and last names already Exists");
		service.setServiceObject(userList);
		return service;
	}

	@RequestMapping(value = "/checkByEmail/{emailId}", method = RequestMethod.GET)
	public @ResponseBody Service getUserFromEmailEntered(
			@PathVariable String emailId) {
		List<User> userList = new ArrayList<User>();
		Service service = new Service();
		userList = rs.getFromPrimaryEmailAddres(emailId);
		if (userList.isEmpty()) {
			userList = rs.getFromSecondaryEmailAddress(emailId);
			service.setStatus("User email id already exists as Secondary Email Id");
		}
		else {
			service.setStatus("User email id already exists as Primary Email Id");
		}
		
		service.setServiceObject(userList);
		return service;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = { "application/json" })
	public void registerUser(@RequestBody User user) {
		try {

			rs.createUser(user);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

}
