/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.externalservices.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.BPMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.CDMInterfaceServiceImpl;
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
	@Bean(name="CDMInterfaceService")
	public CDMInterfaceService cdmInterfaceService()
	{
		
		return new CDMInterfaceServiceImpl();
	}

}
