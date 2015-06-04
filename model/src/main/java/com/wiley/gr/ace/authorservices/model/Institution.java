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
 * @author virtusa
 *	version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Institution {
    
    /** The institution id. */
    private String institutionId;
    
    /** The institution name. */
    private String institutionName;
    
    /**
     * Gets the institution id.
     *
     * @return the institution id
     */
    public String getInstitutionId() {
        return institutionId;
    }
    
    /**
     * Sets the institution id.
     *
     * @param institutionId
     *            the new institution id
     */
    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }
    
    /**
     * Gets the institution name.
     *
     * @return the institution name
     */
    public String getInstitutionName() {
        return institutionName;
    }
    
    /**
     * Sets the institution name.
     *
     * @param institutionName
     *            the new institution name
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    
}
