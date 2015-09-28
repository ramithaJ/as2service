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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class FavoriteJournals.
 *
 * @author virtusa version 1.0
 */
public class FavoriteJournals implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /** The journal. */
    @JsonProperty("Journal")
    private List<Journal> journal;

    /**
     * Gets the journal.
     *
     * @return the journal
     */
    public final List<Journal> getJournal() {
        return journal;
    }

    /**
     * Sets the journal.
     *
     * @param journal
     *            the new journal
     */
    public final void setJournal(final List<Journal> journal) {
        this.journal = journal;
    }

}
