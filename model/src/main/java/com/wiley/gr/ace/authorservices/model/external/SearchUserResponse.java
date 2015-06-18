package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SearchUserResponse.
 */
public class SearchUserResponse {

    /** The user list. */
    @JsonProperty("UserList")
    private List<ESBUser> userList;

    /**
     * @return the userList
     */
    public final List<ESBUser> getUserList() {
        return userList;
    }

    /**
     * @param userList
     *            the userList to set
     */
    public final void setUserList(final List<ESBUser> userList) {
        this.userList = userList;
    }

}
