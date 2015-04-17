package com.wiley.gr.ace.authorservices.persistence.services;

public interface UserLoginDao {

	/**
	 * Checks if emailId exists in USER_PROFILE in AS2.0 database
	 * 
	 * @param emailId
	 */
	public boolean validateEmail(String emailId);

	/**
	 * Updates the LAST_LOGIN_TIME, UPDATED_BY, UPDATED_DATE columns of
	 * USER_PROFILE table
	 * 
	 * @param emailId
	 * @return
	 */
	public boolean doLogin(String emailId);

}
