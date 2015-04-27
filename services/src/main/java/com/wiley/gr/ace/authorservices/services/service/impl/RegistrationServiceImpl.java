package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.externalservices.context.ExternalServiceBeanConfig;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
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

		UserProfile userProfile = new UserProfile();
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
