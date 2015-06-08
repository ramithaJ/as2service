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
public class Interests {
    
    /** The user Id . */
    private String userId;
    
    private String aoeId;
    
    private String aoeCategory;
    
    private String aoeName;
    
    /**
     * Gets the user Id.
     *
     * @return the user Id
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Sets the user Id.
     *
     * @return the user Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getAoeId() {
        return aoeId;
    }
    
    public void setAoeId(String aoeId) {
        this.aoeId = aoeId;
    }
    
    public String getAoeCategory() {
        return aoeCategory;
    }
    
    public void setAoeCategory(String aoeCategory) {
        this.aoeCategory = aoeCategory;
    }
    
    public String getAoeName() {
        return aoeName;
    }
    
    public void setAoeName(String aoeName) {
        this.aoeName = aoeName;
    }
    
}
