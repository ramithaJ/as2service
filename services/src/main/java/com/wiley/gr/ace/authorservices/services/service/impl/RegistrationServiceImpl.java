package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.externalservices.context.ExternalServiceBeanConfig;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	private static ApplicationContext serviceContext = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	private static ApplicationContext externalServiceContext = new AnnotationConfigApplicationContext(
			ExternalServiceBeanConfig.class);
	RegistrationServiceDAO regDao = (RegistrationServiceDAO) context
			.getBean("RegistrationServiceDAO");

	@Override
	public void createUser(User user) {

		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName(user.getFirstName());
		userProfile.setLastName(user.getLastName());
		userProfile.setPrimaryEmailAddr(user.getPrimaryEmailAddr());
		//userProfile.setTermsOfUseFlg();

		ESBInterfaceService esbInterfaceService = (ESBInterfaceService) externalServiceContext
				.getBean("ESBInterfaceService");
		boolean esbCreationStatus = esbInterfaceService.createCustomer(user);
		if (esbCreationStatus) {
			regDao.createUser(userProfile);
		}

	}

	@Override
	public List<User> getUserFromFirstNameLastName(String firstName,
			String lastName) {
		List<UserProfile> userProfileList = regDao
				.getUserFromFirstNameLastName(firstName, lastName);
		List<User> userList = new ArrayList<User>();
		for (UserProfile userProfile : userProfileList) {
			User user = new User();
			user.setTitle(userProfile.getTitle());
			user.setFirstName(userProfile.getFirstName()); //suffix, Journal Title, ORCID Id, Security Question - AS2.0
														   //institution, Middle Name - CDM
			userList.add(user);
		}
		return userList;
	}

	@Override
	public List<User> getFromPrimaryEmailAddres(String emailId) {
		// TODO Auto-generated method stub
		List<UserProfile> userProfileList = regDao.getFromPrimaryEmailAddres(emailId);
		List<User> userList = new ArrayList<User>();
		for (UserProfile userProfile : userProfileList) {
			User user = new User();
			user.setPrimaryEmailAddr(userProfile.getPrimaryEmailAddr());
			user.setFirstName(userProfile.getFirstName());
			user.setLastName(userProfile.getLastName());//country - CDM
			userList.add(user);
		}
		return userList;
	}

	@Override
	public List<User> getFromSecondaryEmailAddress(String emailId) {
		List<UserProfile> userProfileList = regDao.getFromSecondaryEmailAddress(emailId);
		List<User> userList = new ArrayList<User>();
		for (UserProfile userProfile : userProfileList) {
			User user = new User();
			user.setPrimaryEmailAddr(userProfile.getPrimaryEmailAddr());
			user.setFirstName(userProfile.getFirstName());
			user.setLastName(userProfile.getLastName());//Country - CDM
			userList.add(user);
		}
		return userList;
	}

}
