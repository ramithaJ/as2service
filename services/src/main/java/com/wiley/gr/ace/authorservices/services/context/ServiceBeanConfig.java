package com.wiley.gr.ace.authorservices.services.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.services.admin.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.admin.external.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.services.admin.external.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.services.admin.external.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.admin.external.impl.BPMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.admin.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.UserService;
import com.wiley.gr.ace.authorservices.services.service.UserServiceImpl;

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

	@Bean(name = "ALMExternalService")
	public ALMInterfaceService aLMExternalService() {
		return new ALMInterfaceServiceImpl();
	}

	@Bean(name = "BPMExternalService")
	public BPMInterfaceService bpmExternalService() {
		return new BPMInterfaceServiceImpl();
	}

}
