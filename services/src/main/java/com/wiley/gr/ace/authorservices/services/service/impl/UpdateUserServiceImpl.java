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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.externalservices.context.ExternalServiceBeanConfig;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author vkumark
 *
 */
public class UpdateUserServiceImpl implements UpdateUserService {
	
	private ApplicationContext contextDao = new AnnotationConfigApplicationContext(PersistenceBeanConfig.class);
	private ApplicationContext context = new AnnotationConfigApplicationContext(ExternalServiceBeanConfig.class);
	private ESBInterfaceService esbInterfaceService = (ESBInterfaceService) context.getBean("ESBInterfaceService");
	private UpdateUserDAO userDao = (UpdateUserDAO)contextDao.getBean("UpdateUserDAO");
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UpdateUserService#
	 * updateOrcidProfile(java.lang.String)
	 */
	@Override
	public User updateOrcidProfile(String orcidId, String userId) throws Exception {

		/**
		 * Fetch Account details and Profile details from external service
		 * (ESB->ORCID)
		 */
		User user = esbInterfaceService.fetchOrcidDetails(orcidId);
		User updatedUser = null;
		if(user!=null){
			/**
			 * Code to update ALM user attributes through ESB
			 */
			String status = esbInterfaceService.updateALMUser(user);
System.out.println("ALM user update status :: "+status);	

			if(status.equalsIgnoreCase("success")){
				/**
				 * Update the user account details with ORCID account details
				 */
				user.setUserId(Integer.parseInt(userId));
				updatedUser = userDao.updateUserWithOrcid(user);				
			}
		}
		return updatedUser;
	}

}
