/*******************************************************************************
` * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
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

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jndi.JndiTemplate;

import com.wiley.gr.ace.authorservices.services.service.ASDataService;
import com.wiley.gr.ace.authorservices.services.service.AdditionalPermissionService;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;
import com.wiley.gr.ace.authorservices.services.service.OnlineOpenAuthorValidatorService;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;
import com.wiley.gr.ace.authorservices.services.service.SaveArticleData;
import com.wiley.gr.ace.authorservices.services.service.SaveInvitationCeaseEventService;
import com.wiley.gr.ace.authorservices.services.service.SaveInvitationStartEventService;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;
import com.wiley.gr.ace.authorservices.services.service.impl.ASDataServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.AdditionalPermissionServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.AdminLoginServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.ArticleAssignmentServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.AuthorProfileServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.DashboardServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.OnlineOpenAuthorValidatorServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.OpenAccessServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.OrcidServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.OrderOnlineOpenServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.RegistrationServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveArticleDataImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveInvitationCeaseEventServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveInvitationStartServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.impl.SendNotificationImpl;
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

	@Bean(name = "OpenAccessService")
	public OpenAccessService openAccessService() {
		return new OpenAccessServiceImpl();
	}

	/**
	 * Online Open Author Validator Service
	 * 
	 * @return OnlineOpenAuthorValidatorService
	 */
	@Bean(name = "OnlineOpenAuthorValidatorService")
	public OnlineOpenAuthorValidatorService onlineOpenAuthorValidatorService() {
		return new OnlineOpenAuthorValidatorServiceImpl();
	}

	/**
	 * SaveArticleData
	 * 
	 * @return
	 */
	@Bean(name = "SaveArticleData")
	public SaveArticleData saveArticleData() {
		return new SaveArticleDataImpl();
	}
	
	/**
	 * @return
	 */
	@Bean(name = "AdditionalPermissionService")
	public AdditionalPermissionService additionalPermissionService() {
		return new AdditionalPermissionServiceImpl();
	}
	@Bean(name="SaveInvitationStartEventService")
	public SaveInvitationStartEventService saveInvitationStartEventService() {
        return new SaveInvitationStartServiceImpl();
    }

	@Bean(name="SaveInvitationCeaseEventService")
    public SaveInvitationCeaseEventService saveInvitationCeaseEventService() {
        return new SaveInvitationCeaseEventServiceImpl();
    }

	@Bean(name="SendNotification")
	public SendNotification sendNotification(){
	    return new SendNotificationImpl();
	}
	@Bean(name="JndiTemplate")
	public JndiTemplate jndiTemplate() {
        Properties env = new Properties();
        
        env.put("java.naming.factory.initial","com.tibco.tibjms.naming.TibjmsInitialContextFactory");
        env.put("java.naming.provider.url", "tcp://vmesbdev.wiley.com:7222");
        env.put("java.naming.security.principal", "as2team");
        env.put("java.naming.security.credentials", "as2team");
        return new JndiTemplate(env);
    }





	@Bean(name="UserCredentialsConnectionFactoryAdapter")
	@Lazy(true)
    public UserCredentialsConnectionFactoryAdapter authenticationConnectionFactory() throws NamingException {
        UserCredentialsConnectionFactoryAdapter authenticationConnectionFactory = new UserCredentialsConnectionFactoryAdapter();
        authenticationConnectionFactory
                .setTargetConnectionFactory((ConnectionFactory) jndiTemplate().lookup("QueueConnectionFactory"));
        authenticationConnectionFactory.setUsername("as2team");
        authenticationConnectionFactory.setPassword("as2team");
        return authenticationConnectionFactory();
    }

	@Bean(name="JmsTemplate")
	@Lazy(true)
    public JmsTemplate jmsTemplate() throws NamingException {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(authenticationConnectionFactory());
        jmsTemplate.setDefaultDestination((Destination) jndiTemplate().lookup("wiley.global.as2app.inbound.events.queue"));
        return jmsTemplate;
    }

}
