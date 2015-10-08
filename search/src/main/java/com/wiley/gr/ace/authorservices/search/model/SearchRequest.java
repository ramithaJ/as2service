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

public class SearchRequest {
	private String enableFacets;

	private String index;

	private AdvanceQuery[] advanceQuery;

	private String simpleQuery;

	private Sort[] sort;

	private String offset;

	private String[] types;

	private Filters filters;

	private String rows;

	private String appKey;

	public final String getEnableFacets() {
		return enableFacets;
	}

	public final void setEnableFacets(final String enableFacets) {
		this.enableFacets = enableFacets;
	}

	public final String getIndex() {
		return index;
	}

	public final void setIndex(final String index) {
		this.index = index;
	}

	public final AdvanceQuery[] getAdvanceQuery() {
		return advanceQuery;
	}

	public final void setAdvanceQuery(final AdvanceQuery[] advanceQuery) {
		this.advanceQuery = advanceQuery;
	}

	public final String getSimpleQuery() {
		return simpleQuery;
	}

	public final void setSimpleQuery(final String simpleQuery) {
		this.simpleQuery = simpleQuery;
	}

	public final Sort[] getSort() {
		return sort;
	}

	public final void setSort(final Sort[] sort) {
		this.sort = sort;
	}

	public final String getOffset() {
		return offset;
	}

	public final void setOffset(final String offset) {
		this.offset = offset;
	}

	public final String[] getTypes() {
		return types;
	}

	public final void setTypes(final String[] types) {
		this.types = types;
	}

	public final Filters getFilters() {
		return filters;
	}

	public final void setFilters(final Filters filters) {
		this.filters = filters;
	}

	public final String getRows() {
		return rows;
	}

	public final void setRows(final String rows) {
		this.rows = rows;
	}

	public final String getAppKey() {
		return appKey;
	}

	public final void setAppKey(final String appKey) {
		this.appKey = appKey;
	}

}
