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

import java.util.ArrayList;

import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;

/**
 * @author kpshiva
 *
 */
public interface UserAccountDAO {

	/**
	 * @param userId
	 * @return
	 */
	AuthorProfile getEmailDetails(String userId);

	/**
	 * @param userId
	 * @param primaryEmail
	 * @param secondaryEmail
	 * @return
	 */
	boolean updateEmailDetails(String userId, String primaryEmail,
			String secondaryEmail);

	/**
	 * @param userId
	 * @param securityDetails
	 * @return
	 */
	boolean updateSecurityDetails(Integer userId,
			ArrayList<SecurityDetails> securityDetails);

}
