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

public class Sort {
	private String sortBy;

	private String sortOrder;

	public final String getSortBy() {
		return sortBy;
	}

	public final void setSortBy(final String sortBy) {
		this.sortBy = sortBy;
	}

	public final String getSortOrder() {
		return sortOrder;
	}

	public final void setSortOrder(final String sortOrder) {
		this.sortOrder = sortOrder;
	}

}
