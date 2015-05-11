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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired(required = true)
	RegistrationServiceDAO regDao;
	@Autowired(required = true)
	ESBInterfaceService esbInterFaceService;

	@Override
	public String createUser(User user) throws Exception {

		String status = "failure";
		if (null != user) {
			status = esbInterFaceService.creatUser(user);
		}
		return status;
	}

	@Override
	public List<User> getUserFromFirstNameLastName(String firstName,
			String lastName) {

		List<AuthorProfile> authorProfileList = new ArrayList<AuthorProfile>();
		if (null != firstName && !firstName.isEmpty() && null != lastName
				&& !lastName.isEmpty()) {
			authorProfileList = regDao.getUserFromFirstNameLastName(firstName,
					lastName);
		}
		List<User> userList = new ArrayList<User>();

		for (AuthorProfile authorProfile : authorProfileList) {
			User user = new User();
			user.setPrimaryEmailAddr(authorProfile.getAlertPrefEmailid()); // should
																			// be
																			// modified
		}

		return userList;
	}

	@Override
	public User checkEmailIdExists(String emailId) throws Exception {
		User user = null;
		if (null != emailId && !emailId.isEmpty()) {
			user = esbInterFaceService.checkEmailIdExists(emailId);
		}

		return user;
	}
}
