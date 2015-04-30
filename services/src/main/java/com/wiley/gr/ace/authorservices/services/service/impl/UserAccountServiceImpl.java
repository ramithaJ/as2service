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

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserAccountDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginServiceDAOImpl;
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
	UserLoginServiceDAO userLoginServiceDAO = (UserLoginServiceDAOImpl) context
			.getBean("UserLoginServiceDAO");

	@Override
	public UserMgmt[] getEmailDetails(String userId) {

		AuthorProfile userProfile = userAccountDAO.getEmailDetails(userId);
		ArrayList<UserMgmt> email = new ArrayList<UserMgmt>();
		UserMgmt userMgmt = new UserMgmt();
		//Commented for Hibernate changes
//		userMgmt.setPrimaryEmailAddress(userProfile.getPrimaryEmailAddr());
//		userMgmt.setSecondaryEmailAddress(userProfile.getSecondaryEmailAddr());
		email.add(userMgmt);
		return (UserMgmt[]) email.toArray(new UserMgmt[email.size()]);
	}

	@Override
	public boolean updateEmailDetails(String userId, UserMgmt emailDetails) {
		
		String primaryEmail = emailDetails.getPrimaryEmailAddress();
		String SecondaryEmail = emailDetails.getSecondaryEmailAddress();
		return userAccountDAO.updateEmailDetails(userId,primaryEmail,SecondaryEmail);
	}

	@Override
	public boolean updateSecurityDetails(String emailId, Security securityDetails) {

		Integer userId = userLoginServiceDAO.getUserId(emailId);
		String question1=securityDetails.getSecurityQuestion1();
		String answer1=securityDetails.getSecurityAnswer1();
		String question2=securityDetails.getSecurityQuestion2();
		String answer2=securityDetails.getSecurityAnswer2();
		userAccountDAO.updateSecurityDetails(question1,answer1,question2,answer2,userId);
		return false;
	}

}
