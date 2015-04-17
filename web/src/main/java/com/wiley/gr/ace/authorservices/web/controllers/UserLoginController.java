package com.wiley.gr.ace.authorservices.web.controllers.usermanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.usermanagement.UserLoginService;
import com.wiley.gr.ace.authorservices.services.usermanagement.impl.UserLoginServiceImpl;
import com.wiley.gr.ace.authorservices.usermanagement.model.SecurityVO;
import com.wiley.gr.ace.authorservices.usermanagement.model.UISecurityDetails;

/**
 * @author kpshiva
 *
 */
@RestController
@RequestMapping("/user")
public class UserLoginController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);

	/**
	 * This method takes email in encrypted format like --
	 * kondavinay%40gmail.com
	 * 
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/checkSecuritySetup/{emailId}", method = RequestMethod.GET)
	public boolean checkecuritySetUp(@PathVariable("emailId") String emailId) {

		UserLoginService userLoginService = (UserLoginServiceImpl) context
				.getBean("UserLoginService");
		return userLoginService.checkSecuritySetUp(emailId);
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/login/{emailId}", method = RequestMethod.GET)
	public String login(@PathVariable("emailId") String userId) {

		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/resetPwd/{emailId}", method = RequestMethod.GET)
	public String resetPassword(@PathVariable("emailId") String userId) {

		return null;
	}

	/**
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/getSecurityQuestions/{userId}", method = RequestMethod.GET)
	public SecurityVO getSecurityQuestions(@PathVariable("userId") String userId) {
		UserLoginService userLoginService = (UserLoginServiceImpl) context
				.getBean("UserLoginService");
		SecurityVO securityVO = userLoginService.getSecurityQuestions(userId);
		return securityVO;
	}

	/**
	 * This method takes reads SecurityVO from POST
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/valdiateSecurityQuestions", method = RequestMethod.POST)
	/* @ModelAttribute("userSecurityModel") UserSecurityModel userSecurityModel */
	public boolean validateSecurityQuestions() {
		UserLoginService userLoginService = (UserLoginServiceImpl) context
				.getBean("UserLoginService");
		UISecurityDetails uiSecurityDetails = new UISecurityDetails();
		uiSecurityDetails.setId1(3);
		uiSecurityDetails.setAnswer1("cat");
		uiSecurityDetails.setId2(4);
		uiSecurityDetails.setAnswer2("i will not tell");
		return userLoginService.validateSecurityQuestions(uiSecurityDetails);
	}

}
