/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ALMSearchUserResponse.
 */
public class ALMSearchUserResponse extends ALMResponse {

    /** The user payload. */
    @JsonProperty("UserPayload")
    private ArrayList<ALMUser> userPayload;

    /**
     * Gets the user payload.
     *
     * @return the user payload
     */
    public final ArrayList<ALMUser> getUserPayload() {
        return userPayload;
    }

    /**
     * Sets the user payload.
     *
     * @param userPayload the new user payload
     */
    public final void setUserPayload(final ArrayList<ALMUser> userPayload) {
        this.userPayload = userPayload;
    }
}