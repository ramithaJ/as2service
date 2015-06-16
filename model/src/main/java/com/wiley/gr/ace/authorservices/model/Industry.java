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

/**
 * The Class Industry.
 *
 * @author virtusa version 1.0
 */
public class Industry {

    /** The industry id. */
    private String industryId;

    /** The industry name. */
    private String industryName;

    /**
     * Gets the industry id.
     *
     * @return the industry id
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * Sets the industry id.
     *
     * @param industryId
     *            the new industry id
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    /**
     * Gets the industry name.
     *
     * @return the industry name
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * Sets the industry name.
     *
     * @param industryName
     *            the new industry name
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

}
