package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

public interface UserServiceDAO {
	public List<UserProfile> getUsersList();

	boolean validateSecurityQuestions(String emailId);

	boolean doLogin(String emailId);

	boolean isUserLocked(String emailId);

	int lockUser(String emailId);

	List<Object[]> getSecurityQuestions(String userId);

	boolean checkSecuritySetup(String emailId);

	boolean validateEmailAddress(String emailId);
}
