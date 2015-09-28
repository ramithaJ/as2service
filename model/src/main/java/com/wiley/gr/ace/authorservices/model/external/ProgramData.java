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



/**
 * The Class ProgramData.
 */
public class ProgramData {
   
    /** The funder. */
    private Funder funder;
    
    /** The authors. */
    private AuthorsData authors;

    /** The grants. */
    private GrantsData grants;

    /**
     * Gets the funder.
     *
     * @return the funder
     */
    public final Funder getFunder() {
        return funder;
    }

    /**
     * Gets the authors.
     *
     * @return the authors
     */
    public final AuthorsData getAuthors() {
        return authors;
    }

    /**
     * Gets the grants.
     *
     * @return the grants
     */
    public final GrantsData getGrants() {
        return grants;
    }

    /**
     * Sets the funder.
     *
     * @param funder the new funder
     */
    public final void setFunder(final Funder funder) {
        this.funder = funder;
    }

    /**
     * Sets the authors.
     *
     * @param authors the new authors
     */
    public final void setAuthors(final AuthorsData authors) {
        this.authors = authors;
    }

    /**
     * Sets the grants.
     *
     * @param grants the new grants
     */
    public final void setGrants(final GrantsData grants) {
        this.grants = grants;
    }

 
}



