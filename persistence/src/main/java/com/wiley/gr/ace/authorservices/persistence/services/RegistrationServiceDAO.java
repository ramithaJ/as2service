package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

public interface RegistrationServiceDAO {
	public void createUser(UserProfile userProfile);
	public List<UserProfile> getUserFromFirstNameLastName(String firstName, String lastName);
	public List<UserProfile> checkPrimaryEmailAddres(String emailId);
	public List<UserProfile> checkSecondaryEmailAddress(String emailId);

}
