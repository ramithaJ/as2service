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

public class JournalDetails {

    private String journalId;

    private String journalTitle;

    /**
     * @return the journalId
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * @param journalId the journalId to set
     */
    public final void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    /**
     * @return the journalTitle
     */
    public final String getJournalTitle() {
        return journalTitle;
    }

    /**
     * @param journalTitle the journalTitle to set
     */
    public final void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }
    
    
}
