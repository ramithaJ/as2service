package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

public interface RegistrationService {

	public void createUser(User user);

	public List<User> getUserFromFirstNameLastName(String firstName,
			String lastName);

	public List<User> getFromPrimaryEmailAddres(String emailId);

	public List<User> getFromSecondaryEmailAddress(String emailId);
}
