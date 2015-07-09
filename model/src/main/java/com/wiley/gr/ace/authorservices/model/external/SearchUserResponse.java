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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SearchUserResponse.
 * 
 * @author virtusa version 1.0
 */
public class SearchUserResponse {

    /** The user list. */
    @JsonProperty("UserList")
    private List<ESBUser> userList;

    /**
     * Gets the user list.
     *
     * @return the userList
     */
    public final List<ESBUser> getUserList() {
        return userList;
    }

    /**
     * Sets the user list.
     *
     * @param userList
     *            the userList to set
     */
    public final void setUserList(final List<ESBUser> userList) {
        this.userList = userList;
    }

}
