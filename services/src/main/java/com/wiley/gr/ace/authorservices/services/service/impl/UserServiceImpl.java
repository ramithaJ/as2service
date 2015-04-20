package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.UserService;

public class UserServiceImpl implements UserService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	@Override
	public String greet(String firstName, String lastName) {
		return "Hello !!" + firstName + lastName;
	}

	@Override
	public List<User> getUsersList() {
		UserLoginServiceDAO userDAO = (UserLoginServiceDAO) context
				.getBean("UserServiceDAO");
		List<UserProfile> userProfileList = userDAO.getUsersList();
		User user;
		List<User> userList = new LinkedList<User>();
				
		for (UserProfile userProfile : userProfileList) {
			user = new User();
			user.setFirstName(userProfile.getFirstName());
			user.setLastName(userProfile.getLastName());
			userList.add(user);
		}
		return userList;
	}

}
