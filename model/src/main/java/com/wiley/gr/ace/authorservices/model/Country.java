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
 * @author Virtusa
 */
@JsonInclude(Include.NON_NULL)
public class Country {
    
    /** The country code. */
    private String countryCode;
    
    /** The country name. */
    private String countryName;
    
    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }
    
    /**
     * Sets the country code.
     *
     * @param countryCode
     *            the new country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    /**
     * Gets the country name.
     *
     * @return the country name
     */
    public String getCountryName() {
        return countryName;
    }
    
    /**
     * Sets the country name.
     *
     * @param countryName
     *            the new country name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
}
