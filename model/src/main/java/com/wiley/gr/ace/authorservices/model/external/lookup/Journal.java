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
package com.wiley.gr.ace.authorservices.model.external.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author yugandhark
 *
 */
public class Journal {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("JournalID")
    private String journalID;

    @JsonProperty("JournalTitle")
    private String journalTitle;

    @JsonProperty("Status")
    private String status;

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getJournalID() {
        return journalID;
    }

    public final void setJournalID(final String journalID) {
        this.journalID = journalID;
    }

    public final String getJournalTitle() {
        return journalTitle;
    }

    public final void setJournalTitle(final String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

}
