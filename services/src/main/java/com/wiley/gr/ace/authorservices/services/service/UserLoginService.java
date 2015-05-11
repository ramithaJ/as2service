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
package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
/**
 * @author kpshiva
 *
 */
public interface UserLoginService {

	/**
	 * This method authenticates the user and does login
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 */
	UserMgmt doLogin(String emailId, String password);

	/**
	 * @param password
	 * @return
	 */
	boolean updatePassword(PasswordDetails passwordDetails);
	
	/**
	 * @param emailId
	 * @param newPassword
	 * @return
	 */
	boolean resetPassword(String emailId, String newPassword);

	/**
	 * @param userId
	 * @param securityVO
	 * @return
	 */
	boolean validateSecurityQuestions(String emailId, Security securityDetails);

	/**
	 * @param userId
	 * @return
	 */
	Security[] getSecurityQuestions(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	boolean lockUser(int userId);

	/**
	 * @param userId
	 * @return
	 */
	boolean checkSecuritySetUp(int userId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean validateEmailAddress(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	boolean isUserLocked(int userId);

	/**
	 * @param userId
	 * @param template_id
	 */
	void sendEmail(String userId, String template_id);
		
}
