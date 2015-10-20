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

    /** The timed out. */
    private String timedOut;

    /** The facets. */
    private Facets facets;

    /** The took. */
    private String took;

    /** The max_score. */
    private String maxScore;

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
     * Gets the timedOut.
     *
     * @return the timedOut
     */
    public final String getTimedOut() {
        return timedOut;
    }

    /**
     * Sets the timedOut.
     *
     * @param timedOut
     *            the new timedOut
     */
    public final void setTimedOut(final String timedOut) {
        this.timedOut = timedOut;
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
     * Gets the maxScore.
     *
     * @return the maxScore
     */
    public final String getMaxScore() {
        return maxScore;
    }

    /**
     * Sets the maxScore.
     *
     * @param maxScore
     *            the new maxScore
     */
    public final void setMaxScore(final String maxScore) {
        this.maxScore = maxScore;
    }

}
