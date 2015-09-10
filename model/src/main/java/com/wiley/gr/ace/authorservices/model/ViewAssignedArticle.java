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
    private JournalData journalData;

    /** The article links. */
    private ArticleLinks articleLinks;

    /** The publication data. */
    private PublicationDetails publicationData;

    /** The license details. */
    private LicenseDetails licenseDetails;

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
    public final JournalData getJournalData() {
        return journalData;
    }

    /**
     * Sets the journal data.
     *
     * @param journalData
     *            the new journal data
     */
    public final void setJournalData(final JournalData journalData) {
        this.journalData = journalData;
    }

    /**
     * Gets the article links.
     *
     * @return the article links
     */
    public final ArticleLinks getArticleLinks() {
        return articleLinks;
    }

    /**
     * Sets the article links.
     *
     * @param articleLinks
     *            the new article links
     */
    public final void setArticleLinks(ArticleLinks articleLinks) {
        this.articleLinks = articleLinks;
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
     * Gets the license details.
     *
     * @return the license details
     */
    public final LicenseDetails getLicenseDetails() {
        return licenseDetails;
    }

    /**
     * Sets the license details.
     *
     * @param licenseDetails
     *            the new license details
     */
    public final void setLicenseDetails(LicenseDetails licenseDetails) {
        this.licenseDetails = licenseDetails;
    }

}
