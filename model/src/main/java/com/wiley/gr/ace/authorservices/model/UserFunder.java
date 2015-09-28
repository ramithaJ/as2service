/**
 * 
 */
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class UserFunder.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class UserFunder {

    /** The user Id . */
    private String userId;

    /** The funder Id . */
    private String rfunderId;

    /**
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the rfunderId
     */
    public final String getRfunderId() {
        return rfunderId;
    }

    /**
     * @param rfunderId
     *            the rfunderId to set
     */
    public final void setRfunderId(final String rfunderId) {
        this.rfunderId = rfunderId;
    }

}
