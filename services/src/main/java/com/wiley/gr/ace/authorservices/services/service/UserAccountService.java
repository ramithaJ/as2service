package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.UserMgmt;

/**
 * @author kpshiva
 *
 */
public interface UserAccountService {

	/**
	 * @param userId
	 * @return
	 */
	public UserMgmt[] getEmailDetails(String userId);
	/**
	 * @return
	 */
	public boolean updateEmailDetails();
	/**
	 * @return
	 */
	public boolean updateSecurityDetails();
}
