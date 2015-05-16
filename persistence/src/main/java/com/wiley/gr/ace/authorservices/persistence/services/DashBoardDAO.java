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
import com.wiley.gr.ace.authorservices.persistence.entity.UserAffiliations;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAreaOfInterest;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;

/**
 * @author Virtusa
 *
 */
public interface DashBoardDAO {
	
	/**
	 * @param userId
	 * @return UserFunderGrants
	 */
	List<UserFunderGrants> getFundersDetailsList(int userId) throws Exception;
	/**
	 * @param userId
	 * @return AuthorProfile
	 */
	List<AuthorProfile> getMissedUserProfileList(int userId) throws Exception;
	/**
	 * @param userId
	 * @return UserSocietyDetails
	 */
	List<UserSocietyDetails> getSocietyDetailsList(int userId) throws Exception;
	/**
	 * @param userId
	 * @return UserAffiliations
	 */
	List<UserAffiliations> getUserAffiliationsList(int userId) throws Exception;
	/**
	 * @param userId
	 * @return UserAreaOfInterest
	 */
	List<UserAreaOfInterest> getUserAreaOfInterestsList(int userId) throws Exception;
}
