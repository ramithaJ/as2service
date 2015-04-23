package com.wiley.gr.ace.authorservices.externalservices.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;

public interface ESBInterfaceService {

	public ESBUser createCustomer(ESBUser esbUser);
	public User fetchOrcidDetails(String orcid) throws Exception;
	public ESBUser checkEmailIdExists(String emailId);
	public List<ESBUser> checkFirstNameLastNameExists(String firstName, String lastName);
	
}
