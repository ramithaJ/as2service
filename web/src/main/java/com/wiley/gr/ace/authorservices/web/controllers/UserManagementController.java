package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserService;
import com.wiley.gr.ace.authorservices.services.service.UserServiceImpl;

@RestController
@RequestMapping("/userManagement")
public class UserManagementController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(ServiceBeanConfig.class);
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUserRecord() {

		UserService us = (UserServiceImpl) context.getBean("UserService");

		return us.getUsersList();
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello() {
		UserService us = (UserService) context.getBean("UserService");
		return us.greet("Vinay", "Konda");
	}
}