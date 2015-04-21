package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

public interface RegistrationServiceDAO {
	public void createUser(UserProfile userProfile);
	public List<UserProfile> getUserFromFirstNameLastName(String firstName, String lastName);
	public List<UserProfile> getFromPrimaryEmailAddres(String emailId);
	public List<UserProfile> getFromSecondaryEmailAddress(String emailId);

}
