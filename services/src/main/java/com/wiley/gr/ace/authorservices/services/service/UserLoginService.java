package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
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
	UserMgmt doLogin(String emailId, String password);

	/**
	 * @param password
	 * @return
	 */
	boolean resetPassword(String emailId, String oldPassword, String newPassword);

	/**
	 * @param userId
	 * @param securityVO
	 * @return
	 */
	boolean validateSecurityQuestions(String emailId, Security security);

	/**
	 * @param userId
	 * @return
	 */
	Security getSecurityQuestions(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	boolean lockUser(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	boolean checkSecuritySetUp(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean validateEmailAddress(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	boolean isUserLocked(String emailId);

	/**
	 * @param userId
	 * @param template_id
	 */
	void sendEmail(String userId, String template_id);
	
	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	Service authentication(String emailId, String password);
	
}
