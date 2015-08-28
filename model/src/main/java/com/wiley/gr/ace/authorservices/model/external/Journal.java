/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Journal.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Journal {

    /** The dh id. */
    @JsonProperty("DH_ID")
    private String dhId;

    /** The journal title. */
    private String journalTitle;

    /** The journal code abbreviation. */
    private String journalCodeAbbreviation;

    /** The issn. */
    private String issn;

    /** The electronic issn. */
    private String electronicIssn;

    /** The journal doi. */
    private String journalDoi;

    /** The journal image link. */
    private String journalImageLink;

    /**
     * Gets the journal image link.
     *
     * @return the journal image link
     */
    public final String getJournalImageLink() {
        return journalImageLink;
    }

    /**
     * Sets the journal image link.
     *
     * @param journalImageLink
     *            the new journal image link
     */
    public final void setJournalImageLink(final String journalImageLink) {
        this.journalImageLink = journalImageLink;
    }

    /**
     * Gets the journal doi.
     *
     * @return the journal doi
     */
    public final String getJournalDoi() {
        return journalDoi;
    }

    /**
     * Sets the journal doi.
     *
     * @param journalDoi
     *            the new journal doi
     */
    public final void setJournalDoi(final String journalDoi) {
        this.journalDoi = journalDoi;
    }

    /**
     * Gets the journal title.
     *
     * @return the journalTitle
     */
    public final String getJournalTitle() {
        return journalTitle;
    }

    /**
     * Sets the journal title.
     *
     * @param journalTitle
     *            the journalTitle to set
     */
    public final void setJournalTitle(final String journalTitle) {
        this.journalTitle = journalTitle;
    }

    /**
     * Gets the article titile.
     *
     * @return the articleTitile
     */
    public final String getArticleTitile() {
        return articleTitile;
    }

    /**
     * Sets the article titile.
     *
     * @param articleTitile
     *            the articleTitile to set
     */
    public final void setArticleTitile(final String articleTitile) {
        this.articleTitile = articleTitile;
    }

    /**
     * Gets the base price.
     *
     * @return the basePrice
     */
    public final String getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price.
     *
     * @param basePrice
     *            the basePrice to set
     */
    public final void setBasePrice(final String basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public final String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     *
     * @param author
     *            the author to set
     */
    public final void setAuthor(final String author) {
        this.author = author;
    }

    /** The article titile. */
    private String articleTitile;

    /** The base price. */
    private String basePrice;

    /** The author. */
    private String author;

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
     * Gets the journal code abbreviation.
     *
     * @return the journal code abbreviation
     */
    public final String getJournalCodeAbbreviation() {
        return journalCodeAbbreviation;
    }

    /**
     * Gets the issn.
     *
     * @return the issn
     */
    public final String getIssn() {
        return issn;
    }

    /**
     * Gets the electronic issn.
     *
     * @return the electronic issn
     */
    public final String getElectronicIssn() {
        return electronicIssn;
    }

    /**
     * Sets the journal code abbreviation.
     *
     * @param journalCodeAbbreviation
     *            the new journal code abbreviation
     */
    public final void setJournalCodeAbbreviation(
            final String journalCodeAbbreviation) {
        this.journalCodeAbbreviation = journalCodeAbbreviation;
    }

    /**
     * Sets the issn.
     *
     * @param issn
     *            the new issn
     */
    public final void setIssn(final String issn) {
        this.issn = issn;
    }

    /**
     * Sets the electronic issn.
     *
     * @param electronicIssn
     *            the new electronic issn
     */
    public final void setElectronicIssn(final String electronicIssn) {
        this.electronicIssn = electronicIssn;
    }

}
