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
	public @ResponseBody Service checkUserExists(@PathVariable String email,
			@PathVariable String firstName, @PathVariable String lastName) {

		Service service = null;
		ESBUser esbUser = rs.checkEmailIdExists(email);

		if (esbUser != null) {
			service.setStatus("User email exists as primary email in the system");
			service.setServiceObject(esbUser);
		} else {
			List<ESBUser> esbUserList = rs.getUserFromFirstNameLastName(
					firstName, lastName);
			if (!esbUserList.isEmpty()) {
				service.setStatus("Number of user with email as secondary email in the system is: "
						+ esbUserList.size());
				service.setServiceObject(esbUserList);
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
