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

    /**
     * Gets the article details.
     *
     * @return the article details
     */
    public ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the article details.
     *
     * @param articleDetails
     *            the new article details
     */
    public void setArticleDetails(ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * Gets the journal details.
     *
     * @return the journal details
     */
    public JournalDetails getJournalDetails() {
        return journalDetails;
    }

    /**
     * Sets the journal details.
     *
     * @param journalDetails
     *            the new journal details
     */
    public void setJournalDetails(JournalDetails journalDetails) {
        this.journalDetails = journalDetails;
    }

    /**
     * Gets the article user role.
     *
     * @return the article user role
     */
    public String getArticleUserRole() {
        return articleUserRole;
    }

    /**
     * Sets the article user role.
     *
     * @param articleUserRole
     *            the new article user role
     */
    public void setArticleUserRole(String articleUserRole) {
        this.articleUserRole = articleUserRole;
    }

    /**
     * Gets the license status.
     *
     * @return the license status
     */
    public String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the new license status
     */
    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * Gets the order payment status.
     *
     * @return the order payment status
     */
    public OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    /**
     * Sets the order payment status.
     *
     * @param orderPaymentStatus
     *            the new order payment status
     */
    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    /**
     * Gets the production status.
     *
     * @return the production status
     */
    public String getProductionStatus() {
        return productionStatus;
    }

    /**
     * Sets the production status.
     *
     * @param productionStatus
     *            the new production status
     */
    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }
}
