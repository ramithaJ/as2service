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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ResearchFunders.
 *
 * @author yugandhark
 */
public class ResearchFunders {

    /** The research funder. */
    @JsonProperty("ResearchFunder")
    private List<ResearchFunder> researchFunder;

    /**
     * Gets the research funder.
     *
     * @return the research funder
     */
    public final List<ResearchFunder> getResearchFunder() {
        return researchFunder;
    }

    /**
     * Sets the research funder.
     *
     * @param researchFunder the new research funder
     */
    public final void setResearchFunder(final List<ResearchFunder> researchFunder) {
        this.researchFunder = researchFunder;
    }

}
