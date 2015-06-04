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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * @author Virtusa
 */
public class UserAccountServiceImpl implements UserAccountService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserAccountServiceImpl.class);

	@Autowired(required = true)
	UserAccountDAO userAccountDAO;
	@Autowired(required = true)
	UserLoginServiceDAO userLoginServiceDAO;
	@Autowired
	UserProfiles userProfile;

	@Override
	public User getEmailDetails(String userId) {

		LOGGER.info("inside getEmailDetails Method");

		UserProfileResponse lookupProfile = userProfile.userProfileResponse(userId);
		User user = new User();
		user.setPrimaryEmailAddr(lookupProfile.getCustomerProfile()
				.getCustomerDetails().getPrimaryEmailAddr());
		user.setRecoveryEmailAddress(lookupProfile.getCustomerProfile()
				.getCustomerDetails().getRecoveryEmailAddress());
		return user;

	}

	/**
	 * this method will call the DAO to update security details which are
	 * updated by user at userProfile level.
	 */
	@Override
	public boolean updateSecurityDetails(String userId,
			List<SecurityDetails> securityDetails) {

		LOGGER.info("inside updateSecurityDetails Method");
		return userAccountDAO.updateSecurityDetails(Integer.parseInt(userId),
				securityDetails);
	}

	@Override
	public User getProfileInformation(String userId) {

		LOGGER.info("inside getProfileInformation Method");
		UserProfileResponse lookupProfile = userProfile.userProfileResponse(userId);
		return lookupProfile.getCustomerProfile().getCustomerDetails();
	}

	@Override
	public List<Addresses> getUserAddress(String userId) {

		LOGGER.info("inside getUserAddress Method");
		UserProfileResponse lookupProfile = userProfile.userProfileResponse(userId);
		return lookupProfile.getCustomerProfile().getAddressDetails();
	}

}
