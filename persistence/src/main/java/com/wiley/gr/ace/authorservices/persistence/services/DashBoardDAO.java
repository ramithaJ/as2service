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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;

/**
 * @author Virtusa
 *
 */
public interface DashBoardDAO {
	/**
	 * @param userId
	 * @return List
	 */
	List<UserSecurityDetails> getSecurityDetailsList(int userId) throws Exception;
	/**
	 * @param userId
	 * @return UserFunderGrants
	 */
	UserFunderGrants getFundersDetails(int userId) throws Exception;
	/**
	 * @param userId
	 * @return AuthorProfile
	 */
	AuthorProfile getMissedUserProfile(int userId) throws Exception;
}
