package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;

/**
 * @author kpshiva
 *
 */
public interface UserServiceDAO {

	public List<UserProfile> getUsersList();

	public boolean validateSecurityQuestions(String emailId);

	public boolean isUserLocked(String emailId);

	public int lockUser(String emailId);

	public List<UserSecurityDetails> getSecurityQuestions(Integer userId);

	public boolean checkSecuritySetup(String emailId);

	public boolean validateEmailAddress(String emailId);

	public boolean doLogin(String emailId, String password);
	
	public boolean resetPassword(String emailId, String password);
	
	public Integer getUserId(String emailId);
}
