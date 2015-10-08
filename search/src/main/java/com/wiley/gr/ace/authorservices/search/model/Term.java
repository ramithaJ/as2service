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
	
	/** The journal_title. */
	private String[] journal_title;

	/**
	 * Gets the journal_title.
	 *
	 * @return the journal_title
	 */
	public final String[] getJournal_title() {
		return journal_title;
	}

	/**
	 * Sets the journal_title.
	 *
	 * @param journal_title the new journal_title
	 */
	public final void setJournal_title(final String[] journal_title) {
		this.journal_title = journal_title;
	}

}
