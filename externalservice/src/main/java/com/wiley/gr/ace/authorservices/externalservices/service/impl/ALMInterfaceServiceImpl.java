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

	
}
