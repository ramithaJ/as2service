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
package com.wiley.gr.ace.authorservices.services.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.services.service.ASDataService;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;
import com.wiley.gr.ace.authorservices.services.service.impl.ASDataServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.ArticleAssignmentServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.AuthorProfileServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.DashboardServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.OrcidServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.RegistrationServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UpdateUserServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserAccountServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserLoginServiceImpl;

@Configuration
public class ServiceBeanConfig {

    @Bean(name = "AdminLoginService")
    public AdminLoginService adminloginservice() {
        return new AdminLoginServiceImpl();
    }

    @Bean(name = "UserLoginService")
    public UserLoginService userLoginService() {
        return new UserLoginServiceImpl();
    }

    @Bean(name = "RegistrationService")
    public RegistrationService registrationService() {

        return new RegistrationServiceImpl();
    }

    @Bean(name = "DashboardService")
    public DashboardService dashboardService() {
        return new DashboardServiceImpl();
    }

    @Bean(name = "UpdateUserService")
    public UpdateUserService updateUserService() {
        return new UpdateUserServiceImpl();
    }

    @Bean(name = "OrcidService")
    public OrcidService orcidService() {
        return new OrcidServiceImpl();
    }


    @Bean(name = "UserAccountService")
    public UserAccountService userAccountService() {
        return new UserAccountServiceImpl();
    }

    @Bean(name = "ASDataService")
    public ASDataService aSDataService() {
        return new ASDataServiceImpl();
    }

    @Bean(name = "AuthorProfileService")
    public AuthorProfileService authorProfileService() {

        return new AuthorProfileServiceImpl();
    }

    @Bean(name = "ArticleAssignmentService")
    public ArticleAssignmentService articleAssignmentService() {
        return new ArticleAssignmentServiceImpl();
    }

}
