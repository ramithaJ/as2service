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
package com.wiley.gr.ace.authorservices.model;

/**
 * The Class FunderInfo.
 * 
 * @author virtusa version 1.0
 */
public class FunderInfo {

    /** The funder. */
    private FunderObject funder;

    /** The associate funder. */
    private FunderObject associateFunder;

    /**
     * Gets the funder.
     *
     * @return the funder
     */
    public final FunderObject getFunder() {
        return funder;
    }

    /**
     * Sets the funder.
     *
     * @param funder the new funder
     */
    public final void setFunder(final FunderObject funder) {
        this.funder = funder;
    }

    /**
     * Gets the associate funder.
     *
     * @return the associate funder
     */
    public final FunderObject getAssociateFunder() {
        return associateFunder;
    }

    /**
     * Sets the associate funder.
     *
     * @param associateFunder the new associate funder
     */
    public final void setAssociateFunder(final FunderObject associateFunder) {
        this.associateFunder = associateFunder;
    }

}
