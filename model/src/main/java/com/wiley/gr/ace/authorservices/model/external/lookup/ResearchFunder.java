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
package com.wiley.gr.ace.authorservices.model.external.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author yugandhark
 *
 */
public class ResearchFunder {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("FunderID")
    private String funderID;

    @JsonProperty("FunderName")
    private String funderName;

    @JsonProperty("Status")
    private String status;

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getFunderID() {
        return funderID;
    }

    public final void setFunderID(final String funderID) {
        this.funderID = funderID;
    }

    public final String getFunderName() {
        return funderName;
    }

    public final void setFunderName(final String funderName) {
        this.funderName = funderName;
    }

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

}
