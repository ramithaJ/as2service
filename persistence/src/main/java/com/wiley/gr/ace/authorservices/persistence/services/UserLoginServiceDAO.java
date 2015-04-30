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
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.Date;
import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;

/**
 * @author kpshiva
 *
 */
public interface UserLoginServiceDAO {

	/**
	 * @param emailId
	 * @return
	 */
	boolean isUserLocked(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean lockUser(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	List<UserSecurityDetails> getSecurityQuestions(Integer userId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean checkSecuritySetup(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean validateEmailAddress(String emailId);

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	boolean doLogin(String emailId, String password);
		
	/**
	 * @param emailId
	 * @return
	 */
	Integer getUserId(String emailId);

	/**
	 * @return
	 */
	List<AuthorProfile> getUsersList();
	
	/**
	 * @param emailId
	 * @return
	 */
	int getCount(String emailId);
	
	/**
	 * @param count
	 * @param emailId
	 * @return
	 */
	boolean updateCount(int count, String emailId); 
	
	/**
	 * @param emailId
	 * @return
	 */
	Date getLockedTime(String emailId);
	
	/**
	 * @param emailId
	 * @return
	 */
	boolean unLockUser(String emailId);
}
