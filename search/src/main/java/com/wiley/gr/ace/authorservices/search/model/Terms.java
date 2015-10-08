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
 * The Class Terms.
 */
public class Terms {
	
	/** The field. */
	private String field;

	/** The count. */
	private String count;

	/** The term. */
	private String term;

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public final String getField() {
		return field;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public final void setField(final String field) {
		this.field = field;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public final String getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public final void setCount(final String count) {
		this.count = count;
	}

	/**
	 * Gets the term.
	 *
	 * @return the term
	 */
	public final String getTerm() {
		return term;
	}

	/**
	 * Sets the term.
	 *
	 * @param term the new term
	 */
	public final void setTerm(final String term) {
		this.term = term;
	}

}
