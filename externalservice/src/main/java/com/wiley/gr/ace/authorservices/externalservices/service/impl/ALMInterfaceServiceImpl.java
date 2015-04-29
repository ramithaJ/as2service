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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;

/**
 * @author RAVISINHA
 *
 */
public class ALMInterfaceServiceImpl  implements ALMInterfaceService {
	
	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.services.admin.external.ALMInterfaceService#authenticateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authenticateUser(String emailId) {
		
		// TODO: Authenticate with LDAP  
		return false;
	}

	@Override
	public boolean authenticateUserALM(String emailId, String password) {

		if(password.equals("Password")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updatePassword(String emailId, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean resetPassword(String emailId, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
