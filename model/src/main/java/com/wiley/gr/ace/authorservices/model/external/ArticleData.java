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
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleData.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleData {
	private Journal journal;
	private String DHID;
	private String aidECORE;
	private String articleTitle;
	private String authors;
	private ArticleDetails articleDetails;
	private String licenseStatus;
	private OrderPaymentStatus orderPaymentStatus;
	private String productionStatus;

	/**
	 * 
	 * @return The journal
	 */
	public Journal getJournal() {
		return journal;
	}

	/**
	 * 
	 * @param journal
	 *            The journal
	 */
	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	/**
	 * 
	 * @return The DHID
	 */
	public String getDHID() {
		return DHID;
	}

	/**
	 * 
	 * @param DHID
	 *            The DH_ID
	 */
	public void setDHID(String DHID) {
		this.DHID = DHID;
	}

	/**
	 * 
	 * @return The aidECORE
	 */
	public String getAidECORE() {
		return aidECORE;
	}

	/**
	 * 
	 * @param aidECORE
	 *            The aidECORE
	 */
	public void setAidECORE(String aidECORE) {
		this.aidECORE = aidECORE;
	}

	/**
	 * 
	 * @return The articleTitle
	 */
	public String getArticleTitle() {
		return articleTitle;
	}

	/**
	 * 
	 * @param articleTitle
	 *            The articleTitle
	 */
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	/**
	 * 
	 * @return The authors
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * 
	 * @param authors
	 *            The authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * @return the articleDetails
	 */
	public ArticleDetails getArticleDetails() {
		return articleDetails;
	}

	/**
	 * @param articleDetails the articleDetails to set
	 */
	public void setArticleDetails(ArticleDetails articleDetails) {
		this.articleDetails = articleDetails;
	}

	/**
	 * @return the licenseStatus
	 */
	public String getLicenseStatus() {
		return licenseStatus;
	}

	/**
	 * @param licenseStatus the licenseStatus to set
	 */
	public void setLicenseStatus(String licenseStatus) {
		this.licenseStatus = licenseStatus;
	}

	/**
	 * @return the orderPaymentStatus
	 */
	public OrderPaymentStatus getOrderPaymentStatus() {
		return orderPaymentStatus;
	}

	/**
	 * @param orderPaymentStatus the orderPaymentStatus to set
	 */
	public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
		this.orderPaymentStatus = orderPaymentStatus;
	}

	/**
	 * @return the productionStatus
	 */
	public String getProductionStatus() {
		return productionStatus;
	}

	/**
	 * @param productionStatus the productionStatus to set
	 */
	public void setProductionStatus(String productionStatus) {
		this.productionStatus = productionStatus;
	}
}
