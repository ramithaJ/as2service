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

/**
 * The Class JournalDetails.
 *
 * @author yugandhark
 */
public class JournalDetails {

    /** The journal id. */
    private Integer journalId;

    /**
     * @return the journalId
     */
    public final Integer getJournalId() {
        return journalId;
    }

    /**
     * @param journalId
     *            the journalId to set
     */
    public final void setJournalId(final Integer journalId) {
        this.journalId = journalId;
    }

    /**
     * @return the journalName
     */
    public final String getJournalName() {
        return journalName;
    }

    /**
     * @param journalName
     *            the journalName to set
     */
    public final void setJournalName(final String journalName) {
        this.journalName = journalName;
    }

    /** The journal name. */
    private String journalName;
}
