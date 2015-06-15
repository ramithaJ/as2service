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

import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrcidInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.UserManagementImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.BPMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.UserProfilesImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ESBInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.OrcidInterfaceServiceImpl;

@Configuration
public class ExternalServiceBeanConfig {

    @Bean(name = "UserManagement")
    public UserManagement aLMExternalService() {
        return new UserManagementImpl();
    }

    @Bean(name = "BPMExternalService")
    public BPMInterfaceService bpmExternalService() {
        return new BPMInterfaceServiceImpl();
    }

    @Bean(name = "ESBInterfaceService")
    public ESBInterfaceService eSBInterfaceService() {
        return new ESBInterfaceServiceImpl();
    }

    @Bean(name = "OricdInterfaceService")
    public OrcidInterfaceService orcidInterfaceService() {
        return new OrcidInterfaceServiceImpl();
    }

    @Bean(name = "UserProfiles")
    public UserProfiles cdmInterfaceService() {

        return new UserProfilesImpl();
    }

}
