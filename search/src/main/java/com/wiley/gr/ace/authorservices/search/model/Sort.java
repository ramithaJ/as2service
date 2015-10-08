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
 * The Class Sort.
 */
public class Sort {
	
	/** The sort by. */
	private String sortBy;

	/** The sort order. */
	private String sortOrder;

	/**
	 * Gets the sort by.
	 *
	 * @return the sort by
	 */
	public final String getSortBy() {
		return sortBy;
	}

	/**
	 * Sets the sort by.
	 *
	 * @param sortBy the new sort by
	 */
	public final void setSortBy(final String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * Gets the sort order.
	 *
	 * @return the sort order
	 */
	public final String getSortOrder() {
		return sortOrder;
	}

	/**
	 * Sets the sort order.
	 *
	 * @param sortOrder the new sort order
	 */
	public final void setSortOrder(final String sortOrder) {
		this.sortOrder = sortOrder;
	}

}
