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
 * The Class FavoriteJournals.
 * 
 * @author virtusa version 1.0
 */
public class FavoriteJournals {

    /** The journal. */
    private JournalElement[] journal;

    /**
     * Gets the journal.
     *
     * @return the journal
     */
    public final JournalElement[] getJournal() {
        return journal;
    }

    /**
     * Sets the journal.
     *
     * @param journal
     *            the journal to set
     */
    public final void setJournal(final JournalElement[] journal) {
        this.journal = journal;
    }
}
