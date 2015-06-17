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

import java.util.List;

/**
 * The Class ArticleData.
 *
 * @author yugandhark
 */
public class ArticleData {

    /** The article details. */
    private ArticleDetails articleDetails;

    /** The journal details. */
    private JournalDetails journalDetails;

    /** The article user role. */
    private String articleUserRole;

    /** The license status. */
    private String licenseStatus;

    /** The order payment status. */
    private OrderPaymentStatus orderPaymentStatus;

    /** The production status. */
    private String productionStatus;
    
    private List<PriceObject> quote;
    
    private String societyDiscount;
    
    private String tax;
    
    private List<PriceObject> finalPrice;

    /**
     * @return the articleDetails
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * @param articleDetails
     *            the articleDetails to set
     */
    public final void setArticleDetails(final ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * @return the journalDetails
     */
    public final JournalDetails getJournalDetails() {
        return journalDetails;
    }

    /**
     * @param journalDetails
     *            the journalDetails to set
     */
    public final void setJournalDetails(final JournalDetails journalDetails) {
        this.journalDetails = journalDetails;
    }

    /**
     * @return the articleUserRole
     */
    public final String getArticleUserRole() {
        return articleUserRole;
    }

    /**
     * @param articleUserRole
     *            the articleUserRole to set
     */
    public final void setArticleUserRole(final String articleUserRole) {
        this.articleUserRole = articleUserRole;
    }

    /**
     * @return the licenseStatus
     */
    public final String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * @param licenseStatus
     *            the licenseStatus to set
     */
    public final void setLicenseStatus(final String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * @return the orderPaymentStatus
     */
    public final OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    /**
     * @param orderPaymentStatus
     *            the orderPaymentStatus to set
     */
    public final void setOrderPaymentStatus(
            final OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    /**
     * @return the productionStatus
     */
    public final String getProductionStatus() {
        return productionStatus;
    }

    /**
     * @param productionStatus
     *            the productionStatus to set
     */
    public final void setProductionStatus(final String productionStatus) {
        this.productionStatus = productionStatus;
    }

	public final List<PriceObject> getQuote() {
		return quote;
	}

	public final void setQuote(List<PriceObject> quote) {
		this.quote = quote;
	}

	public final String getSocietyDiscount() {
		return societyDiscount;
	}

	public final void setSocietyDiscount(String societyDiscount) {
		this.societyDiscount = societyDiscount;
	}

	public final String getTax() {
		return tax;
	}

	public final void setTax(String tax) {
		this.tax = tax;
	}

	public final List<PriceObject> getFinalPrice() {
		return finalPrice;
	}

	public final void setFinalPrice(List<PriceObject> finalPrice) {
		this.finalPrice = finalPrice;
	}
}
