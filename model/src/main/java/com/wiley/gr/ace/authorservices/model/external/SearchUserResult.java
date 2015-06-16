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
     * @return the searchUserResponse
     */
    public final SearchUserResponse getSearchUserResponse() {
        return searchUserResponse;
    }

    /**
     * @param searchUserResponse
     *            the searchUserResponse to set
     */
    public final void setSearchUserResponse(
            final SearchUserResponse searchUserResponse) {
        this.searchUserResponse = searchUserResponse;
    }

}
