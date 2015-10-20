package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPayload {

    /** The user payload. */
    @JsonProperty("UserPayload")
    private List<ALMUser> userPayload;

    /**
     * @return the userPayload
     */
    public final List<ALMUser> getUserPayload() {
        return userPayload;
    }

    /**
     * @param userPayload
     *            the userPayload to set
     */
    public final void setUserPayload(final List<ALMUser> userPayload) {
        this.userPayload = userPayload;
    }

}
