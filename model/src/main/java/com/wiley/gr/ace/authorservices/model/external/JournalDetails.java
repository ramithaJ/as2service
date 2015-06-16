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

    /** The journal name. */
    private String journalName;

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public Integer getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId
     *            the new journal id
     */
    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    /**
     * Gets the journal name.
     *
     * @return the journal name
     */
    public String getJournalName() {
        return journalName;
    }

    /**
     * Sets the journal name.
     *
     * @param journalName
     *            the new journal name
     */
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }
}
