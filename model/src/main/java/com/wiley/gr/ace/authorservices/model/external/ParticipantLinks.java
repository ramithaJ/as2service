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
 * The Class ParticipantLinks.
 */
public class ParticipantLinks {

    /** The rel. */
    private String rel;

    /** The href. */
    private String href;

    /**
     * Gets the rel.
     *
     * @return the rel
     */
    public final String getRel() {
        return rel;
    }

    /**
     * Sets the rel.
     *
     * @param rel
     *            the new rel
     */
    public final void setRel(final String rel) {
        this.rel = rel;
    }

    /**
     * Gets the href.
     *
     * @return the href
     */
    public final String getHref() {
        return href;
    }

    /**
     * Sets the href.
     *
     * @param href
     *            the new href
     */
    public final void setHref(final String href) {
        this.href = href;
    }
}
