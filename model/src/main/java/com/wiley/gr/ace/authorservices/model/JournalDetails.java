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
 * The Class JournalDetails.
 * 
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class JournalDetails {

    /** The journal id. */
    private String journalId;

    /** The journal title. */
    private String journalTitle;

    /** The printIssn. */
    private String journalPrintIssn;

    /** The electronic issn. */
    private String journalElectronicIssn;

    /** The journal doi. */
    private String journalDoi;

    /**
     * Gets the journal id.
     *
     * @return the journalId
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId
     *            the journalId to set
     */
    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
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
     * Gets the journal print issn.
     *
     * @return the journal print issn
     */
    public final String getJournalPrintIssn() {
        return journalPrintIssn;
    }

    /**
     * Sets the journal print issn.
     *
     * @param journalPrintIssn
     *            the new journal print issn
     */
    public final void setJournalPrintIssn(final String journalPrintIssn) {
        this.journalPrintIssn = journalPrintIssn;
    }

    /**
     * Gets the journal electronic issn.
     *
     * @return the journal electronic issn
     */
    public final String getJournalElectronicIssn() {
        return journalElectronicIssn;
    }

    /**
     * Sets the journal electronic issn.
     *
     * @param journalElectronicIssn
     *            the new journal electronic issn
     */
    public final void setJournalElectronicIssn(
            final String journalElectronicIssn) {
        this.journalElectronicIssn = journalElectronicIssn;
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

}
