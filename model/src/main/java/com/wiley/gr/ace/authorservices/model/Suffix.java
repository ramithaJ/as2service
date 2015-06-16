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
 * The Class Suffix.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Suffix {

    /** The suffix id. */
    private String suffixId;

    /** The suffix name. */
    private String suffixName;

    /**
     * Gets the suffix id.
     *
     * @return the suffix id
     */
    public String getSuffixId() {
        return suffixId;
    }

    /**
     * Sets the suffix id.
     *
     * @param suffixId
     *            the new suffix id
     */
    public void setSuffixId(String suffixId) {
        this.suffixId = suffixId;
    }

    /**
     * Gets the suffix name.
     *
     * @return the suffix name
     */
    public String getSuffixName() {
        return suffixName;
    }

    /**
     * Sets the suffix name.
     *
     * @param suffixName
     *            the new suffix name
     */
    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

}
