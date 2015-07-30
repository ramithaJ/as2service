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

import java.util.ArrayList;

/**
 * The Class LicenseFunderDetails.
 * 
 * @author virtusa version 1.0
 */
public class LicenseFunderDetails {

    /** The funder info. */
    private FunderInfo funderInfo;

    /** The grants. */
    private ArrayList<Grant> grants;

    /**
     * Gets the funder info.
     *
     * @return the funder info
     */
    public final FunderInfo getFunderInfo() {
        return funderInfo;
    }

    /**
     * Sets the funder info.
     *
     * @param funderInfo the new funder info
     */
    public final void setFunderInfo(final FunderInfo funderInfo) {
        this.funderInfo = funderInfo;
    }

    /**
     * Gets the grants.
     *
     * @return the grants
     */
    public final ArrayList<Grant> getGrants() {
        return grants;
    }

    /**
     * Sets the grants.
     *
     * @param grants the new grants
     */
    public final void setGrants(final ArrayList<Grant> grants) {
        this.grants = grants;
    }
}
