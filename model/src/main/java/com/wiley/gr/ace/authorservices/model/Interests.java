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
public class Interests {
	
	private String interestId;
	
	private String interestCategory;
	
	private String interestName;

	/**
	 * @return
	 */
	public String getInterestId() {
		return interestId;
	}

	/**
	 * @param interestId
	 */
	public void setInterestId(String interestId) {
		this.interestId = interestId;
	}

	/**
	 * @return
	 */
	public String getInterestCategory() {
		return interestCategory;
	}

	/**
	 * @param interestCategory
	 */
	public void setInterestCategory(String interestCategory) {
		this.interestCategory = interestCategory;
	}

	/**
	 * @return
	 */
	public String getInterestName() {
		return interestName;
	}

	/**
	 * @param interestName
	 */
	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}
	
	

}
