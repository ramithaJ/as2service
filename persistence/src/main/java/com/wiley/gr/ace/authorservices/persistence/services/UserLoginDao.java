package com.wiley.gr.ace.authorservices.persistence.services;

/**
 * @author RAVISINHA
 *
 */
public interface UserLoginDao {

	/**
	 * Checks if emailId exists in USER_PROFILE in AS2.0 database
	 * 
	 * @param emailId
	 */
	boolean validateEmail(String emailId);

	/**
	 * Updates the LAST_LOGIN_TIME, UPDATED_BY, UPDATED_DATE columns of
	 * USER_PROFILE table
	 * 
	 * @param emailId
	 * @return
	 */
	boolean doLogin(String emailId);

}
