package com.wiley.gr.ace.authorservices.services.external.impl;

import com.wiley.gr.ace.authorservices.services.external.ALMInterfaceService;

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
		return true;
	}

	
}
