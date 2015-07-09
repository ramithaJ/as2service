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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class DisambiguatedOrganization.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class DisambiguatedOrganization {

    /** The disambiguatedOrganizationIdentifier. */
    private String disambiguatedOrganizationIdentifier;

    /** The disambiguationSource. */
    private String disambiguationSource;

    /**
     * Gets the disambiguated organization identifier.
     *
     * @return the disambiguatedOrganizationIdentifier
     */
    public final String getDisambiguatedOrganizationIdentifier() {
        return disambiguatedOrganizationIdentifier;
    }

    /**
     * Sets the disambiguated organization identifier.
     *
     * @param disambiguatedOrganizationIdentifier
     *            the disambiguatedOrganizationIdentifier to set
     */
    public final void setDisambiguatedOrganizationIdentifier(
            final String disambiguatedOrganizationIdentifier) {
        this.disambiguatedOrganizationIdentifier = disambiguatedOrganizationIdentifier;
    }

    /**
     * Gets the disambiguation source.
     *
     * @return the disambiguationSource
     */
    public final String getDisambiguationSource() {
        return disambiguationSource;
    }

    /**
     * Sets the disambiguation source.
     *
     * @param disambiguationSource
     *            the disambiguationSource to set
     */
    public final void setDisambiguationSource(final String disambiguationSource) {
        this.disambiguationSource = disambiguationSource;
    }

}
