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
package com.wiley.gr.ace.authorservices.search.model;

/**
 * The Class Term.
 */
public class Term {
	
	/** The journal title. */
	private String[] journalTitle;

	/**
	 * Gets the journalTitle.
	 *
	 * @return the journalTitle
	 */
	public final String[] getJournalTitle() {
		return journalTitle;
	}

	/**
	 * Sets the journal title.
	 *
	 * @param journal title the new journal_title
	 */
	public final void setJournalTitle(final String[] journalTitle) {
		this.journalTitle = journalTitle;
	}

}
