package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.Date;
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
	boolean validateSecurityQuestions(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean isUserLocked(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean lockUser(String emailId);

	/**
	 * @param userId
	 * @return
	 */
	List<UserSecurityDetails> getSecurityQuestions(Integer userId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean checkSecuritySetup(String emailId);

	/**
	 * @param emailId
	 * @return
	 */
	boolean validateEmailAddress(String emailId);

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	boolean doLogin(String emailId, String password);
	
	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	boolean resetPassword(String emailId, String password);
	
	/**
	 * @param emailId
	 * @return
	 */
	Integer getUserId(String emailId);

	/**
	 * @return
	 */
	List<UserProfile> getUsersList();
	
	/**
	 * @param emailId
	 * @return
	 */
	int getCount(String emailId);
	
	/**
	 * @param count
	 * @param emailId
	 * @return
	 */
	boolean updateCount(int count, String emailId); 
	
	/**
	 * @param emailId
	 * @return
	 */
	Date getLockedTime(String emailId);
	
	/**
	 * @param emailId
	 * @return
	 */
	boolean unLockUser(String emailId);
}
