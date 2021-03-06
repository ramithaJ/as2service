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

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Affiliations.
 *
 * @author yugandhark
 */
public class AffiliationsData implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /** The affiliation. */
    @JsonProperty("Affiliation")
    private List<AffiliationData> affiliation;

    /**
     * Gets the affiliation.
     *
     * @return the affiliation
     */
    public final List<AffiliationData> getAffiliation() {
        return affiliation;
    }

    /**
     * Sets the affiliation.
     *
     * @param affiliation
     *            the new affiliation
     */
    public final void setAffiliation(final List<AffiliationData> affiliation) {
        this.affiliation = affiliation;
    }
}
