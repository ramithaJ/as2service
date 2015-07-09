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
 * The Class ResearchFunders.
 * 
 * @author virtusa version 1.0
 */
public class ResearchFunders {

    /** The researchfunder. */
    private ResearchFunderElement[] researchfunder;

    /**
     * Gets the researchfunder.
     *
     * @return the researchfunder
     */
    public final ResearchFunderElement[] getResearchfunder() {
        return researchfunder;
    }

    /**
     * Sets the researchfunder.
     *
     * @param researchfunder
     *            the researchfunder to set
     */
    public final void setResearchfunder(
            final ResearchFunderElement[] researchfunder) {
        this.researchfunder = researchfunder;
    }
}
