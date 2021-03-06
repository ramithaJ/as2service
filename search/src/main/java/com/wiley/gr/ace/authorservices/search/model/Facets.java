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
package com.wiley.gr.ace.authorservices.search.model;

import java.io.Serializable;

/**
 * The Class Facets.
 */
public class Facets implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** The tag. */
    private Tag tag;

    /**
     * Gets the tag.
     *
     * @return the tag
     */
    public final Tag getTag() {
        return tag;
    }

    /**
     * Sets the tag.
     *
     * @param tag
     *            the new tag
     */
    public final void setTag(final Tag tag) {
        this.tag = tag;
    }

}
