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

public class SearchResponse {
	private String total;

	private Hits[] hits;

	private String timed_out;

	private Facets facets;

	private String took;

	private String max_score;

	public final String getTotal() {
		return total;
	}

	public final void setTotal(final String total) {
		this.total = total;
	}

	public final Hits[] getHits() {
		return hits;
	}

	public final void setHits(final Hits[] hits) {
		this.hits = hits;
	}

	public final String getTimed_out() {
		return timed_out;
	}

	public final void setTimed_out(final String timed_out) {
		this.timed_out = timed_out;
	}

	public final Facets getFacets() {
		return facets;
	}

	public final void setFacets(final Facets facets) {
		this.facets = facets;
	}

	public final String getTook() {
		return took;
	}

	public final void setTook(final String took) {
		this.took = took;
	}

	public final String getMax_score() {
		return max_score;
	}

	public final void setMax_score(final String max_score) {
		this.max_score = max_score;
	}

}
