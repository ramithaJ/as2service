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

import java.util.List;

/**
 * The Class LicenceOO.
 */
public class LicenceOO {
    
    /** The license id. */
    private String licenseId;

    /** The journal id. */
    private String journalId;

    /** The ownership details. */
    private OwnershipDetailsOO ownershipDetails;

    /** The license details. */
    private LicenseDetails licenseDetails;

    /** The funder details. */
    private List<FunderDetails> funderDetails;

    /** The online open. */
    private String onlineOpen;

    /** The article id. */
    private String articleId;

    /**
     * Gets the license id.
     *
     * @return the license id
     */
    public final String getLicenseId() {
        return licenseId;
    }

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * Gets the ownership details.
     *
     * @return the ownership details
     */
    public final OwnershipDetailsOO getOwnershipDetails() {
        return ownershipDetails;
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
     * Gets the funder details.
     *
     * @return the funder details
     */
    public final List<FunderDetails> getFunderDetails() {
        return funderDetails;
    }

    /**
     * Gets the online open.
     *
     * @return the online open
     */
    public final String getOnlineOpen() {
        return onlineOpen;
    }

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * Sets the license id.
     *
     * @param licenseId the new license id
     */
    public final void setLicenseId(final String licenseId) {
        this.licenseId = licenseId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId the new journal id
     */
    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
    }

    /**
     * Sets the ownership details.
     *
     * @param ownershipDetails the new ownership details
     */
    public final void setOwnershipDetails(final OwnershipDetailsOO ownershipDetails) {
        this.ownershipDetails = ownershipDetails;
    }

    /**
     * Sets the license details.
     *
     * @param licenseDetails the new license details
     */
    public final void setLicenseDetails(final LicenseDetails licenseDetails) {
        this.licenseDetails = licenseDetails;
    }

    /**
     * Sets the funder details.
     *
     * @param funderDetails the new funder details
     */
    public final void setFunderDetails(final List<FunderDetails> funderDetails) {
        this.funderDetails = funderDetails;
    }

    /**
     * Sets the online open.
     *
     * @param onlineOpen the new online open
     */
    public final void setOnlineOpen(final String onlineOpen) {
        this.onlineOpen = onlineOpen;
    }

    /**
     * Sets the article id.
     *
     * @param articleId the new article id
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    
}



