package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

public interface RegistrationServiceDAO {
	void createUser(UserProfile userProfile);
	List<UserProfile> getUserFromFirstNameLastName(String firstName, String lastName);
	List<UserProfile> getFromPrimaryEmailAddres(String emailId);
	List<UserProfile> getFromSecondaryEmailAddress(String emailId);

}
