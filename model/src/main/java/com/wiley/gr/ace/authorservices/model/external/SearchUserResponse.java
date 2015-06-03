package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchUserResponse {

	@JsonProperty("UserList")
	private List<ESBUser> userList;

	public List<ESBUser> getUserList() {
		return userList;
	}

	public void setUserList(List<ESBUser> userList) {
		this.userList = userList;
	}
}
