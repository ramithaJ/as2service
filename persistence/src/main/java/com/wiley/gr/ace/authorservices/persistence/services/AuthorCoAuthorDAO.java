package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.AuthCoauthDetails;

public interface AuthorCoAuthorDAO {
	
	List<AuthCoauthDetails> getCoAuthorsList(String userId);

}
