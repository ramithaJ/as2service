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

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class PersonDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CollectArticle {

    /** The ownerships. */
    private Set<Ownerships> ownerships;

    /**
     * Gets the ownerships.
     *
     * @return the ownerships
     */
    public final Set<Ownerships> getOwnerships() {
        return ownerships;
    }

    /**
     * Sets the ownerships.
     *
     * @param ownerships
     *            the new ownerships
     */
    public final void setOwnerships(final Set<Ownerships> ownerships) {
        this.ownerships = ownerships;
    }

}
