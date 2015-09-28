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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Country.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Country {

    /** The country code. */
    private String countryCode = "";

    /** The country name. */
    private String countryName;

    /**
     * @return the countryCode
     */
    public final String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode
     *            the countryCode to set
     */
    public final void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the countryName
     */
    public final String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName
     *            the countryName to set
     */
    public final void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

}
