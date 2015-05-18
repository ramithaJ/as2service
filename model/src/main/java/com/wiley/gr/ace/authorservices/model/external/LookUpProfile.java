package com.wiley.gr.ace.authorservices.model.external;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wiley.gr.ace.authorservices.model.UserProfile;

@JsonInclude(Include.NON_NULL)
public class LookUpProfile implements Serializable {
	
	private UserProfile userProfile;

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	

}
