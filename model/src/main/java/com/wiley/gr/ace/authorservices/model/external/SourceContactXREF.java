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
 * The Class SourceContactXREF.
 */
public class SourceContactXREF {

    /** The source customer id. */
    @JsonProperty("SourceCustomerID")
    private String sourceCustomerID;

    /** The source system. */
    @JsonProperty("SourceSystem")
    private String sourceSystem;

    /**
     * Gets the source customer id.
     *
     * @return the source customer id
     */
    public final String getSourceCustomerID() {
        return sourceCustomerID;
    }

    /**
     * Sets the source customer id.
     *
     * @param sourceCustomerID
     *            the new source customer id
     */
    public final void setSourceCustomerID(final String sourceCustomerID) {
        this.sourceCustomerID = sourceCustomerID;
    }

    /**
     * Gets the source system.
     *
     * @return the source system
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * Sets the source system.
     *
     * @param sourceSystem
     *            the new source system
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }
}
