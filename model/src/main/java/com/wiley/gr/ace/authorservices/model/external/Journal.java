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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Journal.
 *
 * @author virtusa version 1.0
 */
public class Journal implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The id. */
    @JsonProperty("Id")
    private String id;

    /** The journal id. */
    @JsonProperty("JournalID")
    private String journalID;

    /** The journal title. */
    @JsonProperty("JournalTitle")
    private String journalTitle;

    /** The status. */
    @JsonProperty("Status")
    private String status;

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
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public final String getJournalID() {
        return journalID;
    }

    /**
     * Sets the journal id.
     *
     * @param journalID
     *            the new journal id
     */
    public final void setJournalID(final String journalID) {
        this.journalID = journalID;
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

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

}
