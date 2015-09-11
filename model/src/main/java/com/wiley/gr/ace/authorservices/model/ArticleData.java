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

    /** The journal data. */
    private JournalDetails journal;

    /** The dhid. */
    @JsonProperty("DH_ID")
    private String dhId;

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

    /** The payments status. */
    private OrderPaymentStatus orderPaymentStatus;

    /** The production status. */
    private Production production;

    /** The publication details. */
    private PublicationDetails publication;

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
     * @return the journal
     */
    public final JournalDetails getJournal() {
        return journal;
    }

    /**
     * Sets the journal.
     *
     * @param journal
     *            the new journal
     */
    public final void setJournal(final JournalDetails journal) {
        this.journal = journal;
    }

    /**
     * Gets the dh id.
     *
     * @return the dh id
     */
    public final String getDhId() {
        return dhId;
    }

    /**
     * Sets the dh id.
     *
     * @param dhId
     *            the new dh id
     */
    public final void setDhId(final String dhId) {
        this.dhId = dhId;
    }

    /**
     * Gets the aid ecore.
     *
     * @return the aid ecore
     */
    public final String getAidECORE() {
        return aidECORE;
    }

    /**
     * Sets the aid ecore.
     *
     * @param aidECORE
     *            the new aid ecore
     */
    public final void setAidECORE(final String aidECORE) {
        this.aidECORE = aidECORE;
    }

    /**
     * Gets the article title.
     *
     * @return the article title
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            the new article title
     */
    public final void setArticleTitle(final String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets the authors.
     *
     * @return the authors
     */
    public final String getAuthors() {
        return authors;
    }

    /**
     * Sets the authors.
     *
     * @param authors
     *            the new authors
     */
    public final void setAuthors(final String authors) {
        this.authors = authors;
    }

    /**
     * Gets the article details.
     *
     * @return the article details
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the article details.
     *
     * @param articleDetails
     *            the new article details
     */
    public final void setArticleDetails(final ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * Gets the license status.
     *
     * @return the license status
     */
    public final String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the new license status
     */
    public final void setLicenseStatus(final String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * Gets the order payment status.
     *
     * @return the order payment status
     */
    public final OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    /**
     * Sets the order payment status.
     *
     * @param orderPaymentStatus
     *            the new order payment status
     */
    public final void setOrderPaymentStatus(
            final OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    /**
     * Gets the production.
     *
     * @return the production
     */
    public final Production getProduction() {
        return production;
    }

    /**
     * Sets the production.
     *
     * @param production
     *            the new production
     */
    public final void setProduction(final Production production) {
        this.production = production;
    }

    /**
     * Gets the publication.
     *
     * @return the publication
     */
    public final PublicationDetails getPublication() {
        return publication;
    }

    /**
     * Sets the publication.
     *
     * @param publication
     *            the new publication
     */
    public final void setPublication(final PublicationDetails publication) {
        this.publication = publication;
    }

}
