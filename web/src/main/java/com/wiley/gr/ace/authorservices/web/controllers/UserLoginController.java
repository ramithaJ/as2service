package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UISecurityDetails;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;
import com.wiley.gr.ace.authorservices.services.service.impl.UserLoginServiceImpl;

//import com.wiley.gr.ace.authorservices.usermanagement.model.UISecurityDetails;

/**
 * @author kpshiva
 *
 */
@RestController
@RequestMapping("/user")
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
	public boolean checkecuritySetUp(@PathVariable("emailId") String emailId) {

		return userLoginService.checkSecuritySetUp(emailId);
	}

	/**
	 * this method takes the password from request body
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/doLogin/{emailId}", method = RequestMethod.POST)
	public Service login(@PathVariable("emailId") String emailId,
			@RequestBody String password) {

		Service service = new Service();
		if (userLoginService.validateEmailAddress(emailId))
			return userLoginService.doLogin(emailId, password);
		return service;
	}

	/**
	 * this method takes the password from request body
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/resetPwd/{emailId}", method = RequestMethod.POST)
	public boolean resetPassword(@PathVariable("emailId") String emailId,
			@RequestBody String password) {

		return userLoginService.resetPassword(emailId, password);
	}

	/**
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/getSecurityQuestions/{emailId}", method = RequestMethod.GET)
	public Security getSecurityQuestions(@PathVariable("emailId") String emailId) {

		Security securityVO = userLoginService.getSecurityQuestions(emailId);
		return securityVO;
	}

	/**
	 * This method takes reads SecurityVO from POST
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/valdiateSecurityQuestions/{emailId}", method = RequestMethod.POST)
	public boolean validateSecurityQuestions(
			@PathVariable("emailId") String emailId) {

		UISecurityDetails uiSecurityDetails = new UISecurityDetails();
		uiSecurityDetails.setId1(3);
		uiSecurityDetails.setAnswer1("cat");
		uiSecurityDetails.setId2(4);
		uiSecurityDetails.setAnswer2("i will not tell");
		return userLoginService.validateSecurityQuestions(emailId,
				uiSecurityDetails);
	}

}
