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



public class ProgramData {
   
    private AuthorsData authors;

    private Funder funder;
    private GrantsData grants;

    public final AuthorsData getAuthors() {
        return authors;
    }

    public final Funder getFunder() {
        return funder;
    }

    public final GrantsData getGrants() {
        return grants;
    }

    public final void setAuthors(final AuthorsData authors) {
        this.authors = authors;
    }

    public final void setFunder(final Funder funder) {
        this.funder = funder;
    }

    public final void setGrants(final GrantsData grants) {
        this.grants = grants;
    }
    
}



