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
     * @return the industryId
     */
    public final String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId
     *            the industryId to set
     */
    public final void setIndustryId(final String industryId) {
        this.industryId = industryId;
    }

    /**
     * @return the industryName
     */
    public final String getIndustryName() {
        return industryName;
    }

    /**
     * @param industryName
     *            the industryName to set
     */
    public final void setIndustryName(final String industryName) {
        this.industryName = industryName;
    }

}
