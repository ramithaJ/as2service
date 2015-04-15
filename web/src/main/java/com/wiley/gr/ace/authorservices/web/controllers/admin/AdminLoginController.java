package com.wiley.gr.ace.authorservices.web.controllers.admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.services.admin.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.admin.external.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.services.admin.external.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.admin.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;

/**
 * @author ravisinha
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(ServiceBeanConfig.class);
	

	@RequestMapping(value = "/login/{emailId}/{password}", method = RequestMethod.GET, produces = "application/json")
	public String login(@PathVariable("emailId") String emailId,@PathVariable("password") String password) {
		
		boolean status = false;
		AdminLoginService adminlogin= (AdminLoginServiceImpl)context.getBean("AdminLoginService");
      	status = adminlogin.validateEmail(emailId);
      	
      	if(status) {
      		
      		adminlogin.doLogin(emailId, password);
      	}
      	
      	if(status) {
      		return "true ";
      	} else {
      		return "false";
      	}
		
	}
}
