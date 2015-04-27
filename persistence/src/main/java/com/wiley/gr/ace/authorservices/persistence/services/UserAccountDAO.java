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
	boolean updateEmailDetails();
	/**
	 * @return
	 */
	boolean updateSecurityDetails();
}
