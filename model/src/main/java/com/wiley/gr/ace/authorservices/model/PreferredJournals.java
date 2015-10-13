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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class PreferredJournals.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class PreferredJournals {

    /** The journal id. */
    private String journalId;

    /** The journal title. */
    private String journalTitle;

    /** The journal image. */
    private String journalImage = "";

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
     * Gets the journal image.
     *
     * @return the journal image
     */
    public final String getJournalImage() {
        return journalImage;
    }

    /**
     * Sets the journal image.
     *
     * @param journalImage
     *            the new journal image
     */
    public final void setJournalImage(final String journalImage) {
        this.journalImage = journalImage;
    }

}
