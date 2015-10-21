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

package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ultimate parent Data
 *
 * @author virtusa
 * @version 1.0
 */
public class UltimateParentData {
    /** The uri. */
    @JsonProperty("uri")
    private String uri;

    /** The id. */
    @JsonProperty("id")
    private String id;

    /** The secondary ids. */
    @JsonProperty("secondaryIds")
    private SecondaryIds secondaryIds;

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri
     *            the uri to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the secondaryIds
     */
    public SecondaryIds getSecondaryIds() {
        return secondaryIds;
    }

    /**
     * @param secondaryIds
     *            the secondaryIds to set
     */
    public void setSecondaryIds(SecondaryIds secondaryIds) {
        this.secondaryIds = secondaryIds;
    }

}
