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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Visibility.
 *
 * @author yugandhark
 */
public class Visibility implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The attribute code. */
    @JsonProperty("AttributeCode")
    private String attributeCode;

    /** The visibility. */
    @JsonProperty("Visibility")
    private String visibility;

    /**
     * Gets the attribute code.
     *
     * @return the attribute code
     */
    public final String getAttributeCode() {
        return attributeCode;
    }

    /**
     * Sets the attribute code.
     *
     * @param attributeCode
     *            the new attribute code
     */
    public final void setAttributeCode(final String attributeCode) {
        this.attributeCode = attributeCode;
    }

    /**
     * Gets the visibility.
     *
     * @return the visibility
     */
    public final String getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility.
     *
     * @param visibility
     *            the new visibility
     */
    public final void setVisibility(final String visibility) {
        this.visibility = visibility;
    }
}
