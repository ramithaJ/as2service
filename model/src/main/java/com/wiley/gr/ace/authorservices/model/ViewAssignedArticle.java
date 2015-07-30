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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ViewAssignedArticle.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ViewAssignedArticle {

    /** The article data. */
    private ArticleDetails articleData;

    /** The journal data. */
    private JournalDetails journalData;

    /** The order data. */
    private OrderDetails orderData;

    /** The publication data. */
    private PublicationDetails publicationData;

    /** The license data. */
    private LicenseDetails licenseData;

    /**
     * Gets the article data.
     *
     * @return the article data
     */
    public final ArticleDetails getArticleData() {
        return articleData;
    }

    /**
     * Sets the article data.
     *
     * @param articleData
     *            the new article data
     */
    public final void setArticleData(final ArticleDetails articleData) {
        this.articleData = articleData;
    }

    /**
     * Gets the journal data.
     *
     * @return the journal data
     */
    public final JournalDetails getJournalData() {
        return journalData;
    }

    /**
     * Sets the journal data.
     *
     * @param journalData
     *            the new journal data
     */
    public final void setJournalData(final JournalDetails journalData) {
        this.journalData = journalData;
    }

    /**
     * Gets the order data.
     *
     * @return the order data
     */
    public final OrderDetails getOrderData() {
        return orderData;
    }

    /**
     * Sets the order data.
     *
     * @param orderData
     *            the new order data
     */
    public final void setOrderData(final OrderDetails orderData) {
        this.orderData = orderData;
    }

    /**
     * Gets the publication data.
     *
     * @return the publication data
     */
    public final PublicationDetails getPublicationData() {
        return publicationData;
    }

    /**
     * Sets the publication data.
     *
     * @param publicationData
     *            the new publication data
     */
    public final void setPublicationData(
            final PublicationDetails publicationData) {
        this.publicationData = publicationData;
    }

    /**
     * Gets the license data.
     *
     * @return the license data
     */
    public final LicenseDetails getLicenseData() {
        return licenseData;
    }

    /**
     * Sets the license data.
     *
     * @param licenseData
     *            the new license data
     */
    public final void setLicenseData(final LicenseDetails licenseData) {
        this.licenseData = licenseData;
    }

}
