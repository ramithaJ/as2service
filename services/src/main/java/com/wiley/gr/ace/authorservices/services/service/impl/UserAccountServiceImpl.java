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

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * @author kpshiva
 *
 */
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired(required = true)
	UserAccountDAO userAccountDAO;
	@Autowired(required = true)
	UserLoginServiceDAO userLoginServiceDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserAccountService#
	 * getEmailDetails(java.lang.String)
	 */
	@Override
	public UserMgmt[] getEmailDetails(String userId) {

		// AuthorProfile userProfile = userAccountDAO.getEmailDetails(userId);
		ArrayList<UserMgmt> email = new ArrayList<UserMgmt>();
		UserMgmt userMgmt = new UserMgmt();
		// Commented for Hibernate changes
		// userMgmt.setPrimaryEmailAddress(userProfile.getPrimaryEmailAddr());
		// userMgmt.setSecondaryEmailAddress(userProfile.getSecondaryEmailAddr());
		email.add(userMgmt);
		return (UserMgmt[]) email.toArray(new UserMgmt[email.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserAccountService#
	 * updateEmailDetails(java.lang.String,
	 * com.wiley.gr.ace.authorservices.model.UserMgmt)
	 */
	@Override
	public boolean updateEmailDetails(String userId, UserMgmt emailDetails) {

		String primaryEmail = emailDetails.getPrimaryEmailAddress();
		String SecondaryEmail = emailDetails.getSecondaryEmailAddress();
		return userAccountDAO.updateEmailDetails(userId, primaryEmail,
				SecondaryEmail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserAccountService#
	 * updateSecurityDetails(java.lang.String,
	 * com.wiley.gr.ace.authorservices.model.Security)
	 */
	@Override
	public boolean updateSecurityDetails(String emailId,
			Security securityDetails) {

		Integer userId = userLoginServiceDAO.getUserId(emailId);
		userAccountDAO.updateSecurityDetails(userId, securityDetails);
		return true;
	}

}
