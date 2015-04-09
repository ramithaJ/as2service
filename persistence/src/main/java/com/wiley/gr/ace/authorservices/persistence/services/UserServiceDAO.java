package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

public interface UserServiceDAO {
	public List<UserProfile> getUsersList();
}
