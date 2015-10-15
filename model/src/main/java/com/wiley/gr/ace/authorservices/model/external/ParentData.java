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
 * The Class ParentData.
 */
public class ParentData {
    
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
     * Gets the uri.
     *
     * @return the uri
     */
    public final String getUri() {
        return uri;
    }
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }
    
    /**
     * Gets the secondary ids.
     *
     * @return the secondary ids
     */
    public final SecondaryIds getSecondaryIds() {
        return secondaryIds;
    }
    
    /**
     * Sets the uri.
     *
     * @param uri the new uri
     */
    public final void setUri(final String uri) {
        this.uri = uri;
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
     * Sets the secondary ids.
     *
     * @param secondaryIds the new secondary ids
     */
    public final void setSecondaryIds(final SecondaryIds secondaryIds) {
        this.secondaryIds = secondaryIds;
    }

   
}



