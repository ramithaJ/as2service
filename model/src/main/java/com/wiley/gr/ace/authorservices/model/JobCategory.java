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
 * @author SarmaKumarap
 *
 */
public class JobCategory {
	
	private String jobCategoryId;
	
	private String jobCategoryName;

	/**
	 * @return
	 */
	public String getJobCategoryId() {
		return jobCategoryId;
	}

	/**
	 * @param jobCategoryId
	 */
	public void setJobCategoryId(String jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}

	/**
	 * @return
	 */
	public String getJobCategoryName() {
		return jobCategoryName;
	}

	/**
	 * @param jobCategoryName
	 */
	public void setJobCategoryName(String jobCategoryName) {
		this.jobCategoryName = jobCategoryName;
	}

}
