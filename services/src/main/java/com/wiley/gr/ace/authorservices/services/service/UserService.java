/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.User;


/**
 * @author vkumark
 *
 */
public interface UserService {
	public String greet(String firstName, String lastName);
	public List<User> getUsersList();

}
