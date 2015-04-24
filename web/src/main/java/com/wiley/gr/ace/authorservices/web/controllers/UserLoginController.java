package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;
import com.wiley.gr.ace.authorservices.services.service.impl.UserLoginServiceImpl;

/**
 * @author kpshiva
 *
 */
@RestController
@RequestMapping("/userLogin")
public class UserLoginController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	UserLoginService userLoginService = (UserLoginServiceImpl) context
			.getBean("UserLoginService");

	/**
	 * This method takes email in encrypted format like --
	 * kondavinay%40gmail.com
	 * 
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/checkSecuritySetup/{emailId}", method = RequestMethod.GET)
	public Service checkSecuritySetUp(@PathVariable("emailId") String emailId) {

		boolean status = userLoginService.checkSecuritySetUp(emailId);
		Service service = new Service();
		service.setStatus("success");
		UserMgmt userMgmt = new UserMgmt();
		if (status) {
			userMgmt.setIsSecuritySetup("true");
		} else {
			userMgmt.setIsSecuritySetup("false");
		}
		service.setServiceObject(userMgmt);
		return service;
	}

	/**
	 * this method takes the password from request body
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/doLogin/{emailId}", method = RequestMethod.POST)
	public Service doLogin(@PathVariable("emailId") String emailId,
			@RequestBody String password) {

		Service service = new Service();
		try {
			System.out.println("try");
			UserMgmt userMgmt = userLoginService.doLogin(emailId, password);
			System.out.println("try1");
			service.setStatus("success");
			service.setServiceObject(userMgmt);

		} catch (ASException asException) {

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

	/**
	 * this method takes the password from request body
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/resetPassword/{emailId}", method = RequestMethod.POST)
	public boolean resetPassword(@PathVariable("emailId") String emailId,
			@RequestBody String oldPassword, @RequestBody String newPassword) {

		return userLoginService
				.resetPassword(emailId, oldPassword, newPassword);
	}

	/**
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/getSecurityQuestions/{emailId}", method = RequestMethod.GET)
	public Service getSecurityQuestions(@PathVariable("emailId") String emailId) {

		Service service = new Service();
		Security securityVO = userLoginService.getSecurityQuestions(emailId);
		service.setStatus("success");
		service.setServiceObject(securityVO);
		return service;
	}

	/**
	 * This method takes reads SecurityVO from POST
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/valdiateSecurityQuestions/{emailId}", method = RequestMethod.POST)
	public boolean validateSecurityQuestions(
			@PathVariable("emailId") String emailId,
			@RequestBody Security securityDetails) {

		userLoginService.validateSecurityQuestions(emailId, securityDetails);
		return false;
	}

	/**
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/lockUser/{emailId}", method = RequestMethod.GET)
	public boolean lockUser(@PathVariable("emailId") String emailId) {

		return userLoginService.lockUser(emailId);
	}
}
