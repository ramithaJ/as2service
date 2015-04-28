package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

/**
 * @author kpshiva
 *
 */
public interface UserAccountDAO {

	/**
	 * @param userId
	 * @return
	 */
	UserProfile getEmailDetails(String userId);
	/**
	 * @return
	 */
	boolean updateEmailDetails(String userId,String primaryEmail, String secondaryEmail);
	/**
	 * @return
	 */
	boolean updateSecurityDetails(String question1,String answer1,String question2,String answer2, Integer userId);
}
