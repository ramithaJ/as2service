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
 * The Class JobCategory.
 *
 * @author virtusa version 1.0
 */
public class JobCategory {

    /** The job category id. */
    private String jobCategoryId;

    /** The job category name. */
    private String jobCategoryName;

    /**
     * @return the jobCategoryId
     */
    public final String getJobCategoryId() {
        return jobCategoryId;
    }

    /**
     * @param jobCategoryId
     *            the jobCategoryId to set
     */
    public final void setJobCategoryId(final String jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    /**
     * @return the jobCategoryName
     */
    public final String getJobCategoryName() {
        return jobCategoryName;
    }

    /**
     * @param jobCategoryName
     *            the jobCategoryName to set
     */
    public final void setJobCategoryName(final String jobCategoryName) {
        this.jobCategoryName = jobCategoryName;
    }

}
