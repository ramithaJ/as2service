package com.wiley.gr.ace.authorservices.externalservices.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;

public interface ESBInterfaceService {

	ESBUser createCustomer(ESBUser esbUser);
	User fetchOrcidDetails(String orcid) throws Exception;
	ESBUser checkEmailIdExists(String emailId);
	List<ESBUser> checkFirstNameLastNameExists(String firstName, String lastName);
	
}
