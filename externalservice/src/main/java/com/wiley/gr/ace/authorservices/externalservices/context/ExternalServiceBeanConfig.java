package com.wiley.gr.ace.authorservices.externalservices.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.BPMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ESBInterfaceServiceImpl;

@Configuration
public class ExternalServiceBeanConfig {


	

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

		


}
