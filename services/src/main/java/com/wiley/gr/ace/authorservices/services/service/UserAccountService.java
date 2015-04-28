package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.Security;
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
	UserMgmt[] getEmailDetails(String userId);
	/**
	 * @return
	 */
	boolean updateEmailDetails(String userId, UserMgmt emailDetails);
	/**
	 * @return
	 */
	boolean updateSecurityDetails(String emailId, Security securityDetails);
}
