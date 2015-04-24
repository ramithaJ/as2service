package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {
	
	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	UpdateUserService updateUserService = (UpdateUserService) context
			.getBean("UpdateUserService");
	
	
	@RequestMapping(value = "/getUserDetails/{userId}", method = RequestMethod.GET)
	public Service getUserDetails(@PathVariable("userId") String userId) {
		
		return null;
		
	}
	
	
	@RequestMapping(value = "/getEmailDetails/{userId}", method = RequestMethod.GET)
	public Service getEmailDetails(@PathVariable("userId") String userId) {
		
		return null;
		
	}
	
	@RequestMapping(value = "/getUserAddresses/{userId}", method = RequestMethod.GET)
	public Service getUserAddresses(@PathVariable("userId") String userId) {
		
		return null;
		
	}
	
	
	@RequestMapping(value = "/updateUserDetails/{userId}", method = RequestMethod.POST)
	public Service updateUserDetails(@PathVariable("userId") String userId, @RequestBody String userDetails) {
		
		return null;
		
	}
	
	
	@RequestMapping(value = "/updateUserEmail/{userId}", method = RequestMethod.POST)
	public Service updateUserEmail(@PathVariable("userId") String userId, @RequestBody String emailDetails) {
		
		return null;
		
	}

}
