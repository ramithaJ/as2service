package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.external.ESBUser;

public interface RegistrationService {

	void createUser(String contactId, ESBUser esbUser);

	List<ESBUser> getUserFromFirstNameLastName(String firstName,
			String lastName);

	ESBUser checkEmailIdExists(String emailId);

}
