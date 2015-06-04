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
public class Title {
    
    /** The title id. */
    private String titleId;
    
    /** The title name. */
    private String titleName;
    
    /**
     * Gets the title id.
     *
     * @return the title id
     */
    public String getTitleId() {
        return titleId;
    }
    
    /**
     * Sets the title id.
     *
     * @param titleId
     *            the new title id
     */
    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
    
    /**
     * Gets the title name.
     *
     * @return the title name
     */
    public String getTitleName() {
        return titleName;
    }
    
    /**
     * Sets the title name.
     *
     * @param titleName
     *            the new title name
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
