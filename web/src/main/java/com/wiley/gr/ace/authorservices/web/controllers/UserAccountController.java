package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;
import com.wiley.gr.ace.authorservices.services.service.impl.UserAccountServiceImpl;

/**
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	UserAccountService userAccountService = (UserAccountServiceImpl) context
			.getBean("UserAccountService");

	@RequestMapping(value = "/getUserDetails/{userId}", method = RequestMethod.GET)
	public Service getUserDetails(@PathVariable("userId") String userId) {

		return null;

	}

	@RequestMapping(value = "/getEmailDetails/{userId}", method = RequestMethod.GET)
	public Service getEmailDetails(@PathVariable("userId") String userId) {

		Service service = new Service();
		try{
			
			service.setStatus("Success");
			service.setServiceObject(userAccountService.getEmailDetails(userId));
			
		}catch (ASException asException) {

			service.setStatus("failed");
			service.setErrorVO(new com.wiley.gr.ace.authorservices.model.Error());
			service.getErrorVO().setErrorCode(
					Integer.parseInt(asException.getErrorCode()));
			service.getErrorVO().setErrorMessage(asException.getDescription());
			
		} catch(Exception exception) {
			service.setStatus("failed");
			service.setErrorVO(new com.wiley.gr.ace.authorservices.model.Error());
			service.getErrorVO().setErrorCode(-1);
			service.getErrorVO().setErrorMessage(exception.getMessage());
		}
		return service;
	}

	@RequestMapping(value = "/getUserAddresses/{userId}", method = RequestMethod.GET)
	public Service getUserAddresses(@PathVariable("userId") String userId) {

		return null;

	}

	@RequestMapping(value = "/updateUserDetails/{userId}", method = RequestMethod.POST)
	public Service updateUserDetails(@PathVariable("userId") String userId,
			@RequestBody String userDetails) {

		return null;

	}

	@RequestMapping(value = "/updateUserEmail/{userId}", method = RequestMethod.POST)
	public Service updateUserEmail(@PathVariable("userId") String userId,
			@RequestBody String emailDetails) {

		Service service = new Service();
		try{
			
			service.setStatus("Success");
			service.setServiceObject(userAccountService.getEmailDetails(userId));
			
		}catch (ASException asException) {

			service.setStatus("failed");
			service.setErrorVO(new com.wiley.gr.ace.authorservices.model.Error());
			service.getErrorVO().setErrorCode(
					Integer.parseInt(asException.getErrorCode()));
			service.getErrorVO().setErrorMessage(asException.getDescription());
			
		} catch(Exception exception) {
			service.setStatus("failed");
			service.setErrorVO(new com.wiley.gr.ace.authorservices.model.Error());
			service.getErrorVO().setErrorCode(-1);
			service.getErrorVO().setErrorMessage(exception.getMessage());
		}
		return service;
	}

}
