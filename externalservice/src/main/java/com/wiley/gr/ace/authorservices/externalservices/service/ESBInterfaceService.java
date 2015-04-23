package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.User;

public interface ESBInterfaceService {

	public boolean createCustomer(User user);
	public User fetchOrcidDetails(String orcid) throws Exception;
	
}
