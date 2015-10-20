package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPayload {
	
	/** The user payload. */
    @JsonProperty("UserPayload")
    private ArrayList<ALMUser> userPayload;

	public ArrayList<ALMUser> getUserPayload() {
		return userPayload;
	}

	public void setUserPayload(ArrayList<ALMUser> userPayload) {
		this.userPayload = userPayload;
	}

}
