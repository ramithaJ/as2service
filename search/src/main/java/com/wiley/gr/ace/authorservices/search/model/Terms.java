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

public class Terms {
	private String field;

	private String count;

	private String term;

	public final String getField() {
		return field;
	}

	public final void setField(final String field) {
		this.field = field;
	}

	public final String getCount() {
		return count;
	}

	public final void setCount(final String count) {
		this.count = count;
	}

	public final String getTerm() {
		return term;
	}

	public final void setTerm(final String term) {
		this.term = term;
	}

}
