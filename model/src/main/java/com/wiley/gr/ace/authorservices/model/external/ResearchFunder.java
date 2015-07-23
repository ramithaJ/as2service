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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ResearchFunder.
 *
 * @author yugandhark
 */
public class ResearchFunder {

    /** The id. */
    @JsonProperty("Id")
    private String id;

    /** The funder id. */
    @JsonProperty("FunderID")
    private String funderID;

    /** The funder name. */
    @JsonProperty("FunderName")
    private String funderName;

    /** The status. */
    @JsonProperty("Status")
    private String status;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the funder id.
     *
     * @return the funder id
     */
    public final String getFunderID() {
        return funderID;
    }

    /**
     * Sets the funder id.
     *
     * @param funderID the new funder id
     */
    public final void setFunderID(final String funderID) {
        this.funderID = funderID;
    }

    /**
     * Gets the funder name.
     *
     * @return the funder name
     */
    public final String getFunderName() {
        return funderName;
    }

    /**
     * Sets the funder name.
     *
     * @param funderName the new funder name
     */
    public final void setFunderName(final String funderName) {
        this.funderName = funderName;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

}
