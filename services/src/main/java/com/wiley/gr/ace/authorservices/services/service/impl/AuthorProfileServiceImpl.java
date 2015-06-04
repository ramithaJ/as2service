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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.UserProfileAlerts;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;

/**
 * @author virtusa
 *	version 1.0
 */
public class AuthorProfileServiceImpl implements AuthorProfileService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuthorProfileServiceImpl.class);

	@Autowired
	UserProfiles cdmservices;
	@Autowired
	UserManagement almService;

	UserProfile userProfile = new UserProfile();
	UserProfileResponse lookUpProfile = new UserProfileResponse();

	@Override
	public boolean updateSocietyDetails(Society society) {
		LOGGER.info("inside updateSocietyDetails Method ");

		List<Society> list = new ArrayList<Society>();
		list.add(society);
		userProfile.setSocieties(list);
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);
	}

	@Override
	public boolean updateAffiliation(Affiliation affiliation) {
		LOGGER.info("inside updateAffiliation Method ");

		List<Affiliation> list = new ArrayList<Affiliation>();
		list.add(affiliation);

		userProfile.setAffiliations(list);
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);
	}

	@Override
	public boolean updateResearchFunder(String userId,
			ResearchFunder researchFunder) {

		LOGGER.info("inside updateResearchFunder Method ");

		List<ResearchFunder> list = new ArrayList<ResearchFunder>();
		list.add(researchFunder);
		userProfile.setResearchFunders(list);
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);
	}

	@Override
	public boolean updateAlerts(String userId,
			UserProfileAlerts userProfileAlerts) {

		LOGGER.info("inside updateAlerts Method ");

		userProfile.setAlerts(userProfileAlerts.getAlertslist());
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);
	}

	@Override
	public boolean updatecoAuthor(CoAuthor coAuthor) {

		LOGGER.info("inside updatecoAuthor Method ");

		List<CoAuthor> list = new ArrayList<CoAuthor>();
		list.add(coAuthor);
		userProfile.setCoAuthors(list);
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);

	}

	@Override
	public boolean updateEmailDetails(User emailDetails) {

		LOGGER.info("inside updateEmailDetails Method ");
		userProfile.setCustomerDetails(emailDetails);
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);
	}

	@Override
	public boolean updateUserAddress(UserProfile addresses) {

		LOGGER.info("inside updateUserAddress Method ");
		userProfile.setAddressDetails(addresses.getAddressDetails());
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);
	}

	@Override
	public boolean updateUserProfileInfo(User user) {

		LOGGER.info("inside updateUserProfileInfo Method ");
		userProfile.setCustomerDetails(user);
		lookUpProfile.setCustomerProfile(userProfile);
		return cdmservices.updateProfile(lookUpProfile);
	}

	@Override
	public boolean updateUserId(String oldEmailId, String newEmailId) {

		LOGGER.info("inside updateUserId Method ");
		return almService.updateUserId(oldEmailId, newEmailId);
	}

	@Override
	public boolean updatePassword(PasswordDetails passwordDetails) {

		LOGGER.info("inside updatePassword Method ");
		return almService.updatePassword(passwordDetails);
	}

	@Override
	public boolean updateSecurityDetails(SecurityDetailsHolder securityDetails) {

		LOGGER.info("inside updateSecurityDetails Method ");
		return almService.updateSecurityDetails(securityDetails);
	}

}
