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

import java.io.Serializable;
import java.util.List;

/**
 * The Class SearchResponse.
 */
public class SearchResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** The total. */
    private String total;

    /** The hits. */
    private List<Hits> hits;

    /** The timed_out. */
    private String timed_out;

    /** The facets. */
    private Facets facets;

    /** The took. */
    private String took;

    /** The max_score. */
    private String max_score;

    /**
     * Gets the total.
     *
     * @return the total
     */
    public final String getTotal() {
        return total;
    }

    /**
     * Sets the total.
     *
     * @param total
     *            the new total
     */
    public final void setTotal(final String total) {
        this.total = total;
    }

    /**
     * Gets the hits.
     *
     * @return the hits
     */
    public final List<Hits> getHits() {
        return hits;
    }

    /**
     * Sets the hits.
     *
     * @param hits
     *            the new hits
     */
    public final void setHits(final List<Hits> hits) {
        this.hits = hits;
    }

    /**
     * Gets the timed_out.
     *
     * @return the timed_out
     */
    public final String getTimed_out() {
        return timed_out;
    }

    /**
     * Sets the timed_out.
     *
     * @param timed_out
     *            the new timed_out
     */
    public final void setTimed_out(final String timed_out) {
        this.timed_out = timed_out;
    }

    /**
     * Gets the facets.
     *
     * @return the facets
     */
    public final Facets getFacets() {
        return facets;
    }

    /**
     * Sets the facets.
     *
     * @param facets
     *            the new facets
     */
    public final void setFacets(final Facets facets) {
        this.facets = facets;
    }

    /**
     * Gets the took.
     *
     * @return the took
     */
    public final String getTook() {
        return took;
    }

    /**
     * Sets the took.
     *
     * @param took
     *            the new took
     */
    public final void setTook(final String took) {
        this.took = took;
    }

    /**
     * Gets the max_score.
     *
     * @return the max_score
     */
    public final String getMax_score() {
        return max_score;
    }

    /**
     * Sets the max_score.
     *
     * @param max_score
     *            the new max_score
     */
    public final void setMax_score(final String max_score) {
        this.max_score = max_score;
    }

}
