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

	@RequestMapping(value = "/fetch/{firstName}/{lastName}", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserFromFirstNameLastName(
			@PathVariable String firstName, @PathVariable String lastName) {

		return rs.getUserFromFirstNameLastName(firstName, lastName);
	}

	@RequestMapping(value = "/fetchbyemail/{emailId}")
	public @ResponseBody List<User> getUserFromEmailEntered(
			@PathVariable String emailId) {
		List<User> userList = new ArrayList<User>();
		userList = rs.getFromPrimaryEmailAddres(emailId);
		if (userList.isEmpty()) {
			userList = rs.getFromSecondaryEmailAddress(emailId);
		}
		return userList;
	}

	@RequestMapping(value = "/resgister", method = RequestMethod.POST, consumes = { "application/json" })
	public void registerUser(@RequestBody User user) {
		try {

			rs.createUser(user);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

}
