/*** ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * ******************************************************************************/
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SearchUserResult.
 * 
 * @author virtusa version 1.0
 */
public class SearchUserResult {

    /** The search user response. */
    @JsonProperty("SearchUserResponse")
    private SearchUserResponse searchUserResponse;

    /**
     * Gets the search user response.
     *
     * @return the searchUserResponse
     */
    public final SearchUserResponse getSearchUserResponse() {
        return searchUserResponse;
    }

    /**
     * Sets the search user response.
     *
     * @param searchUserResponse
     *            the searchUserResponse to set
     */
    public final void setSearchUserResponse(
            final SearchUserResponse searchUserResponse) {
        this.searchUserResponse = searchUserResponse;
    }

}
