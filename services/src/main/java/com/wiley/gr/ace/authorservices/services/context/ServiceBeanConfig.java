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
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;
import com.wiley.gr.ace.authorservices.services.service.impl.ASDataServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.DashBoardServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.RegistrationServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UpdateUserServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserAccountServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.UserProfileServiceImpl;

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

	@Bean(name = "DashBoardService")
	public DashBoardService dashBoardService() {
		return new DashBoardServiceImpl();
	}

	@Bean(name = "UpdateUserService")
	public UpdateUserService updateUserService() {
		return new UpdateUserServiceImpl();
	}

	@Bean(name = "UserProfileService")
	public UserProfileService userProfileService() {

		return new UserProfileServiceImpl();

	}
	
	@Bean(name="UserAccountService")
	public UserAccountService userAccountService(){
		return new UserAccountServiceImpl();
	}
	
	@Bean(name="ASDataService")
	public ASDataService aSDataService(){
		return new ASDataServiceImpl();
	}
}
