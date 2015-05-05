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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.externalservices.context.ExternalServiceBeanConfig;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	//private static ApplicationContext serviceContext = new AnnotationConfigApplicationContext(
	//		ServiceBeanConfig.class);
	private static ApplicationContext externalServiceContext = new AnnotationConfigApplicationContext(
			ExternalServiceBeanConfig.class);
	RegistrationServiceDAO regDao = (RegistrationServiceDAO) context
			.getBean("RegistrationServiceDAO");
	ESBInterfaceService esbInterFaceService = (ESBInterfaceService) externalServiceContext
			.getBean("ESBInterfaceService");

	@Override
	public void createUser(String contactID, ESBUser esbUser) {

		AuthorProfile userProfile = new AuthorProfile();
		/*if (contactID.isEmpty()) {
			ESBUser esbUserAfterCreate = esbInterFaceService
					.createCustomer(esbUser);
			// userProfile.setContactId(esbUserAfterCreate.getContactId()); TODO: data model/entity change
		} else {
			// userProfile.setContactId(contactID); TODO: data model/entity change
		}*/
		
		regDao.createUser(userProfile);
	}

	@Override
	public List<ESBUser> getUserFromFirstNameLastName(String firstName,
			String lastName) {
		List<ESBUser> esbUserList = esbInterFaceService
				.checkFirstNameLastNameExists(firstName, lastName);

		return esbUserList;
	}

	@Override
	public ESBUser checkEmailIdExists(String emailId) {
		ESBUser esbUser = esbInterFaceService.checkEmailIdExists(emailId);
		return esbUser;
	}
}
