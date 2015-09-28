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
    private String dhId;

    /** The aid ecore. */
    @JsonProperty("aidECORE")
    private String aidECORE;

    /** The article title. */
    @JsonProperty("articleTitle")
    private String articleTitle;

    /** The article details. */
    private ArticleDetails articleDetails;

    /** The license status. */
    private String licenseStatus;

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

    public final String getAidECORE() {
        return aidECORE;
    }

    public final void setAidEcore(final String aidECORE) {
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
    public final void setTitle(final String articleTitle) {
        this.articleTitle = articleTitle;
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

}
