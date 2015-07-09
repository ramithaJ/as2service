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

package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class JournalElement.
 * 
 * @author virtusa version 1.0
 */
public class JournalElement {

    /** The journaltitle. */
    private String journaltitle;

    /** The journalid. */
    private String journalid;

    /**
     * Gets the journaltitle.
     *
     * @return the journaltitle
     */
    public final String getJournaltitle() {
        return journaltitle;
    }

    /**
     * Sets the journaltitle.
     *
     * @param journaltitle
     *            the journaltitle to set
     */
    public final void setJournaltitle(final String journaltitle) {
        this.journaltitle = journaltitle;
    }

    /**
     * Gets the journalid.
     *
     * @return the journalid
     */
    public final String getJournalid() {
        return journalid;
    }

    /**
     * Sets the journalid.
     *
     * @param journalid
     *            the journalid to set
     */
    public final void setJournalid(final String journalid) {
        this.journalid = journalid;
    }

}
