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

import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;

// TODO: Auto-generated Javadoc
/**
 * The Interface SaveArticleDAO.
 */
public interface SaveArticleDAO {

	/**
	 * Save article invitation.
	 *
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param email
	 *            the email
	 * @param role
	 *            the role
	 * @return true, if successful
	 * @throws Exception
	 *             the exception
	 */
	boolean saveArticleInvitation(InviteResetpwdLog invite) throws Exception;
}
