package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SearchUserResult.
 */
public class SearchUserResult {

    /** The search user response. */
    @JsonProperty("SearchUserResponse")
    private SearchUserResponse searchUserResponse;

    /**
     * Gets the search user response.
     *
     * @return the search user response
     */
    public SearchUserResponse getSearchUserResponse() {
        return searchUserResponse;
    }

    /**
     * Sets the search user response.
     *
     * @param searchUserResponse
     *            the new search user response
     */
    public void setSearchUserResponse(SearchUserResponse searchUserResponse) {
        this.searchUserResponse = searchUserResponse;
    }
}
