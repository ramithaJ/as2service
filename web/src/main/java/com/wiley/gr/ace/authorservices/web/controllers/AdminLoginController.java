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
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.service.impl.AdminLoginServiceImpl;

/**
 * This method takes email in encrypted format like -- kondavinay%40gmail.com/
 * Hit the link as
 * http://localhost:8080/author-services/admin/login/kondavinay%40gmail.com/
 * 
 * @author ravisinha
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);

	@RequestMapping(value = "/login/{emailId}", method = RequestMethod.POST, produces = "application/json")
	public Service login(@PathVariable("emailId") String emailId,
			@RequestBody String password) {

		boolean status = false;
		Service serviceVO = new Service();
		AdminLoginService adminlogin = (AdminLoginServiceImpl) context
				.getBean("AdminLoginService");
		status = adminlogin.validateEmail(emailId);

		if (status) {

			adminlogin.doLogin(emailId);
			serviceVO.setStatus("success");
		}

		return serviceVO;

	}
}
