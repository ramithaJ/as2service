package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.external.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	private static ApplicationContext serviceContext = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	RegistrationServiceDAO regDao = (RegistrationServiceDAO) context
			.getBean("RegistrationServiceDAO");

	@Override
	public void createUser(User user) {

		UserProfile userProfile = new UserProfile();
		userProfile.setFirstName(user.getFirstName());
		userProfile.setLastName(user.getLastName());
		// userProfile.setPrimaryEmailAddr(user.getPrimaryEmailAddr());

		ESBInterfaceService esbInterfaceService = (ESBInterfaceService) serviceContext
				.getBean("ESBInterfaceService");
		boolean esbCreationStatus = esbInterfaceService.createCustomer(user);
		if (esbCreationStatus) {
			regDao.createUser(userProfile);
		}

	}

	@Override
	public List<User> getUserFromFirstNameLastName(String firstName,
			String lastName) {
		// TODO Auto-generated method stub
		List<UserProfile> userProfileList = regDao.getUserFromFirstNameLastName(firstName, lastName);
		List<User> userList = new ArrayList<User>();
		for (UserProfile userProfile : userProfileList) {
			User user = new User();
			user.setTitle(userProfile.getTitle());
			user.setFirstName(userProfile.getFirstName());
		}
		return null;
	}

	@Override
	public List<User> checkPrimaryEmailAddres(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> checkSecondaryEmailAddress(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
