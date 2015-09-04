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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class JournalData.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class JournalData {

    /** The dh id. */
    private String dhId;

    /** The journal id. */
    private String journalId;

    /** The journal title. */
    private String journalTitle;

    /** The journal doi. */
    private String journalDoi;

    /** The issn. */
    private String issn;

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId
     *            the new journal id
     */
    public final void setJournalId(String journalId) {
        this.journalId = journalId;
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
    public final void setJournalDoi(String journalDoi) {
        this.journalDoi = journalDoi;
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
     * Sets the issn.
     *
     * @param issn
     *            the new issn
     */
    public final void setIssn(String issn) {
        this.issn = issn;
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
     * Gets the journal title.
     *
     * @return the journal title
     */
    public final String getJournalTitle() {
        return journalTitle;
    }

    /**
     * Sets the journal title.
     *
     * @param journalTitle
     *            the new journal title
     */
    public final void setJournalTitle(final String journalTitle) {
        this.journalTitle = journalTitle;
    }

}
