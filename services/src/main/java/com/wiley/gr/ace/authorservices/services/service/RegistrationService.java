package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;

public interface RegistrationService {

	public void createUser(String contactId, ESBUser esbUser);

	public List<ESBUser> getUserFromFirstNameLastName(String firstName,
			String lastName);

	public ESBUser checkEmailIdExists(String emailId);

}
