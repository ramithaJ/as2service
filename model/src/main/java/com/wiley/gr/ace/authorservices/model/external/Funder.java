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

/**
 * The Class Funder.
 * 
 * @author virtusa version 1.0
 */
public class Funder {

    /** The id. */
    private String id;

    /** The fund ref id. */
    private String fundRefId;

    /** The name. */
    private String name;

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
     * Gets the fund ref id.
     *
     * @return the fund ref id
     */
    public final String getFundRefId() {
        return fundRefId;
    }

    /**
     * Sets the fund ref id.
     *
     * @param fundRefId the new fund ref id
     */
    public final void setFundRefId(final String fundRefId) {
        this.fundRefId = fundRefId;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public final void setName(final String name) {
        this.name = name;
    }
}
