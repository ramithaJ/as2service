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
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;
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
import com.wiley.gr.ace.authorservices.services.service.impl.OrderOnlineOpenServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.RegistrationServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UpdateUserServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserAccountServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserLoginServiceImpl;

/**
 * The Class ServiceBeanConfig.
 */
@Configuration
public class ServiceBeanConfig {

    /**
     * Adminloginservice.
     *
     * @return the admin login service
     */
    @Bean(name = "AdminLoginService")
    public AdminLoginService adminloginservice() {
        return new AdminLoginServiceImpl();
    }

    /**
     * User login service.
     *
     * @return the user login service
     */
    @Bean(name = "UserLoginService")
    public UserLoginService userLoginService() {
        return new UserLoginServiceImpl();
    }

    /**
     * Registration service.
     *
     * @return the registration service
     */
    @Bean(name = "RegistrationService")
    public RegistrationService registrationService() {

        return new RegistrationServiceImpl();
    }

    /**
     * Dashboard service.
     *
     * @return the dashboard service
     */
    @Bean(name = "DashboardService")
    public DashboardService dashboardService() {
        return new DashboardServiceImpl();
    }

    /**
     * Update user service.
     *
     * @return the update user service
     */
    @Bean(name = "UpdateUserService")
    public UpdateUserService updateUserService() {
        return new UpdateUserServiceImpl();
    }

    /**
     * Orcid service.
     *
     * @return the orcid service
     */
    @Bean(name = "OrcidService")
    public OrcidService orcidService() {
        return new OrcidServiceImpl();
    }

    /**
     * User account service.
     *
     * @return the user account service
     */
    @Bean(name = "UserAccountService")
    public UserAccountService userAccountService() {
        return new UserAccountServiceImpl();
    }

    /**
     * A s data service.
     *
     * @return the AS data service
     */
    @Bean(name = "ASDataService")
    public ASDataService aSDataService() {
        return new ASDataServiceImpl();
    }

    /**
     * Author profile service.
     *
     * @return the author profile service
     */
    @Bean(name = "AuthorProfileService")
    public AuthorProfileService authorProfileService() {

        return new AuthorProfileServiceImpl();
    }

    /**
     * Article assignment service.
     *
     * @return the article assignment service
     */
    @Bean(name = "ArticleAssignmentService")
    public ArticleAssignmentService articleAssignmentService() {
        return new ArticleAssignmentServiceImpl();
    }
    /**
     * Order online open service.
     *
     * @return the order online open service
     */
    @Bean(name = "OrderOnlineOpenService")
    public OrderOnlineOpenService orderOnlineOpenService() {
        return new OrderOnlineOpenServiceImpl();
    }
}
