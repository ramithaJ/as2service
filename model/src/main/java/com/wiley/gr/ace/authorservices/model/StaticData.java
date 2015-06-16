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
package com.wiley.gr.ace.authorservices.model;

/**
 * This is the generic model for all dropdowns in AS2.0
 * 
 * @author virtusa version 1.0
 */
public class StaticData {

    /** The id. */
    private String id;

    /** The description. */
    private String description;

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
     * @param id
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description
     *            the description to set
     */
    public final void setDescription(final String description) {
        this.description = description;
    }

}
