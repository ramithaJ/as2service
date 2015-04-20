package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;

/**
 * @author kpshiva
 *
 */
public interface UserLoginServiceDAO {

	/**
	 * @param emailId
	 * @return
	 */
	public boolean validateSecurityQuestions(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	public boolean isUserLocked(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	public int lockUser(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	public List<UserSecurityDetails> getSecurityQuestions(Integer userId);

	/**
	 * @param emailId
	 * @return
	 */
	public boolean checkSecuritySetup(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	public boolean validateEmailAddress(String emailId);

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	public boolean doLogin(String emailId, String password);
	
	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	public boolean resetPassword(String emailId, String password);
	
	/**
	 * @param emailId
	 * @return
	 */
	public Integer getUserId(String emailId);

	/**
	 * @return
	 */
	public List<UserProfile> getUsersList();
}
