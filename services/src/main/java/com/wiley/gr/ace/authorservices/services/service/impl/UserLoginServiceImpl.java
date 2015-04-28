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

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.context.ExternalServiceBeanConfig;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginServiceDAOImpl;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 */
public class UserLoginServiceImpl implements UserLoginService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	private static ApplicationContext externalServiceContext = new AnnotationConfigApplicationContext(
			ExternalServiceBeanConfig.class);
	UserLoginServiceDAO userLoginServiceDAO = (UserLoginServiceDAOImpl) context
			.getBean("UserLoginServiceDAO");
	
	@Override
	public UserMgmt doLogin(String emailId, String password) {

		UserMgmt userMgmt = null;
		if (userLoginServiceDAO.validateEmailAddress(emailId)) {

			if (userLoginServiceDAO.isUserLocked(emailId)) {
				
				Date currentDate = new Date();
				Date date = userLoginServiceDAO.getLockedTime(emailId);
				Date lockedDate = new Date(date.getTime());
				if((currentDate.getTime() - lockedDate.getTime()) > 1800000) {
					
					if(authenticateUser(emailId, password)) {

						userMgmt = new UserMgmt();
						userMgmt.setUserId(userLoginServiceDAO.getUserId(emailId)+"");
					}else{
						throw new ASException("1005", "Your account is locked. Please try after sometime.");
					}
				}else{
					
					throw new ASException("1007", "Your account is locked. Please try after sometime.");
				}
			} else {
				if(authenticateUser(emailId, password)) {
					userMgmt = new UserMgmt();
					userMgmt.setUserId(userLoginServiceDAO.getUserId(emailId)+"");
				}
			}
		} else {
			
			throw new ASException("1001", "Invalid email address. Please Re-Enter");
		}
		return userMgmt;
	}

	@Override
	public boolean checkSecuritySetUp(String emailId) {

		return userLoginServiceDAO.checkSecuritySetup(emailId);
	}

	@Override
	public Security getSecurityQuestions(String emailId) {

		Security security = new Security();
		Integer userId = userLoginServiceDAO.getUserId(emailId);
		List<UserSecurityDetails> securityQuestionslist = userLoginServiceDAO
				.getSecurityQuestions(userId);
		security.setSecurityQuestion1(securityQuestionslist.get(0)
				.getSecurityQuestion());
		security.setSecurityQuestion2(securityQuestionslist.get(1)
				.getSecurityQuestion());
		return security;
	}

	@Override
	public boolean resetPassword(String emailId, String oldPassword,
			String newPassword) {

		return userLoginServiceDAO.resetPassword(emailId, newPassword);
	}

	@Override
	public boolean validateSecurityQuestions(String emailId,
			Security securityDetails) {

		Integer userId = userLoginServiceDAO.getUserId(emailId);
		List<UserSecurityDetails> securityQuestionslist = userLoginServiceDAO
				.getSecurityQuestions(userId);
		if (securityDetails.getSecurityQuestion1().equalsIgnoreCase(
				securityQuestionslist.get(0).getSecurityQuestion())
				&& securityDetails.getSecurityAnswer1().equalsIgnoreCase(
						securityQuestionslist.get(0).getSecurityAnswer())
				&& securityDetails.getSecurityQuestion2().equalsIgnoreCase(
						securityQuestionslist.get(1).getSecurityQuestion())
				&& securityDetails.getSecurityAnswer2().equalsIgnoreCase(
						securityQuestionslist.get(1).getSecurityAnswer()))
			return true;
		return false;
	}

	@Override
	public boolean lockUser(String emailId) {

		return userLoginServiceDAO.lockUser(emailId);
		
	}

	@Override
	public boolean validateEmailAddress(String emailId) {

		return userLoginServiceDAO.validateEmailAddress(emailId);
	}

	@Override
	public boolean isUserLocked(String emailId) {

		return userLoginServiceDAO.isUserLocked(emailId);
	}

	@Override
	public void sendEmail(String userId, String template_id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Service authentication(String emailId, String password) {

		return null;
	}
	
	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	private boolean authenticateUser(String emailId, String password) {
		
		ALMInterfaceService almService = (ALMInterfaceServiceImpl) externalServiceContext
				.getBean("ALMExternalService");
		
		boolean loginStatus = false;

		if (almService.authenticateUserALM(emailId,password)) {
			System.out.println("nani"+emailId+"  "+password);
			
			userLoginServiceDAO.doLogin(emailId, password);
			userLoginServiceDAO.unLockUser(emailId);
			userLoginServiceDAO.updateCount(0, emailId);
			loginStatus = true;
			
		} else {

			int count = userLoginServiceDAO.getCount(emailId);
			if (count >= 2) {
				
				if (userLoginServiceDAO.lockUser(emailId))
					throw new ASException("1002", "Your account is locked. Please try after sometime.");
			} else {
				
				count++;
				userLoginServiceDAO.updateCount(count, emailId);
				throw new ASException("1003", "Please enter valid EmailId and Password.");
			}
		}
		
		return loginStatus;
	}
}
