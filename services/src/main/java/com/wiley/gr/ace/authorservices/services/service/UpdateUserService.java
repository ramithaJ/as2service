/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.User;

/**
 * @author vkumark
 *
 */
public interface UpdateUserService {
	
	User updateOrcidProfile(String orcidId, String userId) throws Exception;

}
