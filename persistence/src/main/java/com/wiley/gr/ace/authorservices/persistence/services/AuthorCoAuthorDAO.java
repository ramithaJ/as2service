package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthCoauthDetails;

/**
 * @author kpshiva
 *
 */
public interface AuthorCoAuthorDAO {

	/**
	 * @param userId
	 * @return
	 */
	List<AuthCoauthDetails> getCoAuthorsList(String userId);

	/**
	 * @param userId
	 * @param coAuthorJson
	 * @return
	 */
	boolean editCoAuthor(String userId, CoAuthor coAuthorJson);

	/**
	 * @param userId
	 * @param coAuthorId
	 * @return
	 */
	boolean deleteCoAuthor(String userId, String coAuthorId);

}
