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

/**
 * The Class Tag.
 */
public class Tag {

    /** The total. */
    private String total;

    /** The terms. */
    private Terms[] terms;

    /**
     * Gets the total.
     *
     * @return the total
     */
    public final String getTotal() {
        return total;
    }

    /**
     * Sets the total.
     *
     * @param total
     *            the new total
     */
    public final void setTotal(final String total) {
        this.total = total;
    }

    /**
     * Gets the terms.
     *
     * @return the terms
     */
    public final Terms[] getTerms() {
        return terms;
    }

    /**
     * Sets the terms.
     *
     * @param terms
     *            the new terms
     */
    public final void setTerms(final Terms[] terms) {
        this.terms = terms;
    }

}
