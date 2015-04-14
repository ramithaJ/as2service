package com.wiley.gr.ace.authorservices.services.admin;

public interface AdminLoginService {
	
	/**
	 * This method validates if emailId exists in the AS 2.0 database
	 * 
	 * @param emailId
	 * @return
	 */
	public boolean validateEmail(String emailId);
	
	/**
	 * This method updates the lastLoginTime in the AS 2.0 database
	 * 
	 * @param emailId
	 * @return
	 */
	public boolean doLogin(String emailId);

}
