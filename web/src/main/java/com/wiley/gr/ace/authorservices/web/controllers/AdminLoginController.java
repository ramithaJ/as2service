package com.wiley.gr.ace.authorservices.web.controllers.admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.ServiceVO;
import com.wiley.gr.ace.authorservices.services.admin.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.admin.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;

/**
 * @author ravisinha
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);

	@RequestMapping(value = "/login/{emailId}", method = RequestMethod.POST, produces = "application/json")
	public ServiceVO login(@PathVariable("emailId") String emailId) {

		boolean status = false;
		ServiceVO serviceVO = new ServiceVO();
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
