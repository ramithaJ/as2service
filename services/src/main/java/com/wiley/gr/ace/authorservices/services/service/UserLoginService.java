package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.UISecurityDetails;

/**
 * @author kpshiva
 *
 */
public interface UserLoginService {

	/**
	 * This method authenticates the user and does login 
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 */
	public boolean doLogin(String emailId, String password);
	//Forgot Password // see
	/**
	 * @param password
	 * @return
	 */
	public boolean resetPassword(String password);
	/**
	 * @param userId
	 * @param securityVO
	 * @return
	 */
	public boolean validateSecurityQuestions(String userId, Security securityVO);
	/**
	 * @param userId
	 * @return
	 */
	public Security getSecurityQuestions(String userId);
	/**
	 * @param userId
	 * @return
	 */
	public boolean lockUser(String emailId);
	/**
	 * @param userId
	 * @return
	 */
	public boolean checkSecuritySetUp(String emailId);
	/**
	 * @param emailId
	 * @return
	 */
	public boolean validateEmailAddress(String emailId);
	//public boolean update_count(); // see 
	/**
	 * @param userId
	 * @return
	 */
	public boolean isUserLocked(String emailId);
	/**
	 * @param userId
	 * @param template_id
	 */
	public void sendEmail(String userId, String template_id);
	
	public boolean validateSecurityQuestions(UISecurityDetails uiSecurityDetails);
}
