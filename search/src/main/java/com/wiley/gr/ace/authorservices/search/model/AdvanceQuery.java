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
 * The Class AdvanceQuery.
 */
public class AdvanceQuery {

	/** The field. */
	private String field;

	/** The value. */
	private String value;

	/** The from. */
	private String from;

	/** The to. */
	private String to;

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
	 * @param field
	 *            the new field
	 */
	public final void setField(final String field) {
		this.field = field;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public final String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public final void setValue(final String value) {
		this.value = value;
	}

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public final String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from
	 *            the new from
	 */
	public final void setFrom(final String from) {
		this.from = from;
	}

	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public final String getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 *
	 * @param to
	 *            the new to
	 */
	public final void setTo(final String to) {
		this.to = to;
	}

}
