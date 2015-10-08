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

public class Tag {
	private String total;

	private Terms[] terms;

	public final String getTotal() {
		return total;
	}

	public final void setTotal(final String total) {
		this.total = total;
	}

	public final Terms[] getTerms() {
		return terms;
	}

	public final void setTerms(final Terms[] terms) {
		this.terms = terms;
	}

}
