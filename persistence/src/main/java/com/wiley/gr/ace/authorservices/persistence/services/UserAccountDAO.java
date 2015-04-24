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
	public UserProfile getEmailDetails(String userId);
	/**
	 * @return
	 */
	public boolean updateEmailDetails();
	/**
	 * @return
	 */
	public boolean updateSecurityDetails();
}
