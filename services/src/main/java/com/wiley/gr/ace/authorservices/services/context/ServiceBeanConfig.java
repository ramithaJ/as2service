package com.wiley.gr.ace.authorservices.services.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.services.admin.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.admin.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.UserService;
import com.wiley.gr.ace.authorservices.services.service.UserServiceImpl;
import com.wiley.gr.ace.authorservices.services.usermanagement.UserLoginService;
import com.wiley.gr.ace.authorservices.services.usermanagement.impl.UserLoginServiceImpl;

@Configuration
public class ServiceBeanConfig {

	@Bean(name = "UserService")
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean(name = "AdminLoginService")
	public AdminLoginService adminloginservice() {
		return new AdminLoginServiceImpl();
	}
	
	@Bean(name = "UserLoginService")
	public UserLoginService userLoginService() {
		return new UserLoginServiceImpl();
	}

}
