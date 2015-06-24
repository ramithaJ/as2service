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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ArticleData.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleData {

    /** The article user role. */
    private String articleUserRole;

    /** The journal. */
    private Journal journal;

    /** The dhid. */
    @JsonProperty("DH_ID")
    private String DHID;

    /** The aid ecore. */
    private String aidECORE;

    /** The article title. */
    private String articleTitle;

    /** The authors. */
    private String authors;

    /** The article details. */
    private ArticleDetails articleDetails;

    /** The license status. */
    private String licenseStatus;

    /** The order payment status. */
    private OrderPaymentStatus orderPaymentStatus;

    /** The production status. */
    private String productionStatus;

    /** The publication. */
    private Publication publication;

    /**
     * Gets the publication.
     *
     * @return the publication
     */
    public final Publication getPublication() {
        return publication;
    }

    /**
     * Sets the publication.
     *
     * @param publication
     *            the new publication
     */
    public final void setPublication(final Publication publication) {
        this.publication = publication;
    }

    /** The order. */
    private OrderData order;

    /**
     * Gets the order.
     *
     * @return the order
     */
    public final OrderData getOrder() {
        return order;
    }

    /**
     * Sets the order.
     *
     * @param order
     *            the new order
     */
    public final void setOrder(final OrderData order) {
        this.order = order;
    }

    /**
     * Gets the article user role.
     *
     * @return the article user role
     */
    public final String getArticleUserRole() {
        return articleUserRole;
    }

    /**
     * Sets the article user role.
     *
     * @param articleUserRole
     *            the new article user role
     */
    public final void setArticleUserRole(final String articleUserRole) {
        this.articleUserRole = articleUserRole;
    }

    /**
     * Gets the journal.
     *
     * @return The journal
     */
    public final Journal getJournal() {
        return journal;
    }

    /**
     * Sets the journal.
     *
     * @param journal
     *            The journal
     */
    public final void setJournal(final Journal journal) {
        this.journal = journal;
    }

    /**
     * Gets the dhid.
     *
     * @return The DHID
     */
    public final String getDHID() {
        return DHID;
    }

    /**
     * Sets the dhid.
     *
     * @param DHID
     *            The DH_ID
     */
    public final void setDHID(final String DHID) {
        this.DHID = DHID;
    }

    /**
     * Gets the aid ecore.
     *
     * @return The aidECORE
     */
    public final String getAidECORE() {
        return aidECORE;
    }

    /**
     * Sets the aid ecore.
     *
     * @param aidECORE
     *            The aidECORE
     */
    public final void setAidECORE(final String aidECORE) {
        this.aidECORE = aidECORE;
    }

    /**
     * Gets the article title.
     *
     * @return The articleTitle
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            The articleTitle
     */
    public final void setArticleTitle(final String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets the authors.
     *
     * @return The authors
     */
    public final String getAuthors() {
        return authors;
    }

    /**
     * Sets the authors.
     *
     * @param authors
     *            The authors
     */
    public final void setAuthors(final String authors) {
        this.authors = authors;
    }

    /**
     * Gets the article details.
     *
     * @return the articleDetails
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the article details.
     *
     * @param articleDetails
     *            the articleDetails to set
     */
    public final void setArticleDetails(final ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * Gets the license status.
     *
     * @return the licenseStatus
     */
    public final String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the licenseStatus to set
     */
    public final void setLicenseStatus(final String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * Gets the order payment status.
     *
     * @return the orderPaymentStatus
     */
    public final OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    /**
     * Sets the order payment status.
     *
     * @param orderPaymentStatus
     *            the orderPaymentStatus to set
     */
    public final void setOrderPaymentStatus(
            final OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    /**
     * Gets the production status.
     *
     * @return the productionStatus
     */
    public final String getProductionStatus() {
        return productionStatus;
    }

    /**
     * Sets the production status.
     *
     * @param productionStatus
     *            the productionStatus to set
     */
    public final void setProductionStatus(final String productionStatus) {
        this.productionStatus = productionStatus;
    }
}
