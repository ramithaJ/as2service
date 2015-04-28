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

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserAccountDAOImpl;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * @author kpshiva
 *
 */
public class UserAccountServiceImpl implements UserAccountService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	UserAccountDAO userAccountDAO = (UserAccountDAOImpl) context
			.getBean("UserAccountDAO");

	@Override
	public UserMgmt[] getEmailDetails(String userId) {

		UserProfile userProfile = userAccountDAO.getEmailDetails(userId);
		ArrayList<UserMgmt> email = new ArrayList<UserMgmt>();
		UserMgmt userMgmt = new UserMgmt();
		userMgmt.setPrimaryEmailAddress(userProfile.getPrimaryEmailAddr());
		userMgmt.setSecondaryEmailAddress(userProfile.getSecondaryEmailAddr());
		email.add(userMgmt);
		return (UserMgmt[]) email.toArray(new UserMgmt[email.size()]);
	}

	@Override
	public boolean updateEmailDetails() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSecurityDetails() {
		// TODO Auto-generated method stub
		return false;
	}

}
