package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchUserResult {

	@JsonProperty("SearchUserResponse")
	private SearchUserResponse searchUserResponse;

	public SearchUserResponse getSearchUserResponse() {
		return searchUserResponse;
	}

	public void setSearchUserResponse(SearchUserResponse searchUserResponse) {
		this.searchUserResponse = searchUserResponse;
	}
}
