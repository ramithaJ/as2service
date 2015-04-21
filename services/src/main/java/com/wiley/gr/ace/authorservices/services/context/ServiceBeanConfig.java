package com.wiley.gr.ace.authorservices.services.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.services.external.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.services.external.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.services.external.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.services.external.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.external.impl.BPMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.external.impl.ESBInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;
import com.wiley.gr.ace.authorservices.services.service.UserService;
import com.wiley.gr.ace.authorservices.services.service.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.RegistrationServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserServiceImpl;

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

	@Bean(name = "ALMExternalService")
	public ALMInterfaceService aLMExternalService() {
		return new ALMInterfaceServiceImpl();
	}

	@Bean(name = "BPMExternalService")
	public BPMInterfaceService bpmExternalService() {
		return new BPMInterfaceServiceImpl();
	}

	@Bean(name = "ESBInterfaceService")
	public ESBInterfaceService eSBInterfaceService() {
		return new ESBInterfaceServiceImpl();
	}
	@Bean (name="RegistrationService")
	public RegistrationService registrationService()
	{
		
		return new RegistrationServiceImpl();
	}

}
