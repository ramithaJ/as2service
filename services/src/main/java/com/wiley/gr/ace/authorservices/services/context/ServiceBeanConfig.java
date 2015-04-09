package com.wiley.gr.ace.authorservices.services.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.services.service.UserService;
import com.wiley.gr.ace.authorservices.services.service.UserServiceImpl;

@Configuration
public class ServiceBeanConfig {

	@Bean(name = "UserService")
	public UserService userService() {
		return new UserServiceImpl();
	}

}
