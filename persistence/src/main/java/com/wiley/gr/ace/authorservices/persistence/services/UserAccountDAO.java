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

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

/**
 * @author kpshiva
 *
 */
public interface UserAccountDAO {

	/**
	 * @param userId
	 * @return
	 */
	UserProfile getEmailDetails(String userId);
	/**
	 * @return
	 */
	boolean updateEmailDetails(String userId,String primaryEmail, String secondaryEmail);
	/**
	 * @return
	 */
	boolean updateSecurityDetails(String question1,String answer1,String question2,String answer2, Integer userId);
}
