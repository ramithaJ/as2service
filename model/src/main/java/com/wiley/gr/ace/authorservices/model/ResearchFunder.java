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
public class ResearchFunder {
	
	private String researchFunderId;
	
	private String researchFunderName;
	
	private String articleAID;
	
	private String articleName;
	
	private String[] grantNumber;

	/**
	 * @return
	 */
	public String getResearchFunderId() {
		return researchFunderId;
	}

	/**
	 * @param researchFunderId
	 */
	public void setResearchFunderId(String researchFunderId) {
		this.researchFunderId = researchFunderId;
	}

	/**
	 * @return
	 */
	public String getResearchFunderName() {
		return researchFunderName;
	}

	/**
	 * @param researchFunderName
	 */
	public void setResearchFunderName(String researchFunderName) {
		this.researchFunderName = researchFunderName;
	}

	/**
	 * @return
	 */
	public String getArticleAID() {
		return articleAID;
	}

	/**
	 * @param articleAID
	 */
	public void setArticleAID(String articleAID) {
		this.articleAID = articleAID;
	}

	/**
	 * @return
	 */
	public String getArticleName() {
		return articleName;
	}

	/**
	 * @param articleName
	 */
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	/**
	 * @return
	 */
	public String[] getGrantNumber() {
		return grantNumber;
	}

	/**
	 * @param grantNumber
	 */
	public void setGrantNumber(String[] grantNumber) {
		this.grantNumber = grantNumber;
	}

}
