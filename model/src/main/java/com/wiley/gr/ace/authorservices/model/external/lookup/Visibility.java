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
package com.wiley.gr.ace.authorservices.model.external.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author yugandhark
 *
 */
public class Visibility {

    @JsonProperty("AttributeCode")
    private String attributeCode;

    @JsonProperty("Visibility")
    private String visibility;

    public final String getAttributeCode() {
        return attributeCode;
    }

    public final void setAttributeCode(final String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public final String getVisibility() {
        return visibility;
    }

    public final void setVisibility(final String visibility) {
        this.visibility = visibility;
    }
}
