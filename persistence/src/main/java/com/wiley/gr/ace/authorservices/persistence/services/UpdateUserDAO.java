/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.model.User;

/**
 * @author vkumark
 *
 */
public interface UpdateUserDAO {
	
	public User updateUserWithOrcid(User user) throws Exception;

}
