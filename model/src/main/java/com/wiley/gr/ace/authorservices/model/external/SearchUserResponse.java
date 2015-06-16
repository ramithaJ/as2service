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
     * Gets the user list.
     *
     * @return the user list
     */
    public List<ESBUser> getUserList() {
        return userList;
    }

    /**
     * Sets the user list.
     *
     * @param userList
     *            the new user list
     */
    public void setUserList(List<ESBUser> userList) {
        this.userList = userList;
    }
}
