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

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public String getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId
     *            the new journal id
     */
    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    /**
     * Gets the journal title.
     *
     * @return the journal title
     */
    public String getJournalTitle() {
        return journalTitle;
    }

    /**
     * Sets the journal title.
     *
     * @param journalTitle
     *            the new journal title
     */
    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

}
