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

public class AdvanceQuery {
	private String field;

	private String value;
	private String from;
	private String to;

	public final String getField() {
		return field;
	}

	public final void setField(final String field) {
		this.field = field;
	}

	public final String getValue() {
		return value;
	}

	public final void setValue(final String value) {
		this.value = value;
	}

	public final String getFrom() {
		return from;
	}

	public final void setFrom(final String from) {
		this.from = from;
	}

	public final String getTo() {
		return to;
	}

	public final void setTo(final String to) {
		this.to = to;
	}

}
