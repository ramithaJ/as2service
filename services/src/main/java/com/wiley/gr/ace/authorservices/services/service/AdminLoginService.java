package com.wiley.gr.ace.authorservices.services.service;

/**
 * @author RAVISINHA
 *
 */
public interface AdminLoginService {

	/**
	 * This method validates if emailId exists in the AS 2.0 database
	 * 
	 * @param emailId
	 * @return
	 */
	boolean validateEmail(String emailId);

	/**
	 * This method updates the lastLoginTime in the AS 2.0 database
	 * 
	 * @param emailId
	 * @return
	 */
	boolean doLogin(String emailId);

	/**
	 * This method requests for a wiley user to get Admin Access.
	 * 
	 * @param emailId
	 * @return
	 */
	boolean requestAdminAccess(String emailId);

}
