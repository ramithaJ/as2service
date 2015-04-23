package com.wiley.gr.ace.authorservices.externalservices.service;

/**
 * @author RAVISINHA
 *
 */
public interface ALMInterfaceService {

	/**
	 * This method authenticates the user by calling the ALM LDAP Service
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 */
	public boolean authenticateUser(String emailId);

}
