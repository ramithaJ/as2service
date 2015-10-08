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

public class Source {
	private String journal_type;

	private String journal_ownership_type;

	private String journal_status;

	private String journal_title;

	private String journal_acronym;

	private String journal_setup_state;

	public final String getJournal_type() {
		return journal_type;
	}

	public final void setJournal_type(final String journal_type) {
		this.journal_type = journal_type;
	}

	public final String getJournal_ownership_type() {
		return journal_ownership_type;
	}

	public final void setJournal_ownership_type(
			final String journal_ownership_type) {
		this.journal_ownership_type = journal_ownership_type;
	}

	public final String getJournal_status() {
		return journal_status;
	}

	public final void setJournal_status(final String journal_status) {
		this.journal_status = journal_status;
	}

	public final String getJournal_title() {
		return journal_title;
	}

	public final void setJournal_title(final String journal_title) {
		this.journal_title = journal_title;
	}

	public final String getJournal_acronym() {
		return journal_acronym;
	}

	public final void setJournal_acronym(final String journal_acronym) {
		this.journal_acronym = journal_acronym;
	}

	public final String getJournal_setup_state() {
		return journal_setup_state;
	}

	public final void setJournal_setup_state(final String journal_setup_state) {
		this.journal_setup_state = journal_setup_state;
	}

}
