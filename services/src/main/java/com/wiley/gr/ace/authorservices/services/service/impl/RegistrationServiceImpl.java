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

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired(required = true)
	RegistrationServiceDAO regDao;
	@Autowired(required = true)
	ESBInterfaceService esbInterFaceService;

	@Override
	public void createUser(String contactID, ESBUser esbUser) {

		AuthorProfile userProfile = new AuthorProfile();
	
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
