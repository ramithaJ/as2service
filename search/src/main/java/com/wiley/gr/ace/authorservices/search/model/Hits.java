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

/**
 * The Class Hits.
 */
public class Hits implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private String id;

    /** The source. */
    private Source source;

    /** The score. */
    private String score;

    /** The type. */
    private String type;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the source.
     *
     * @return the source
     */
    public final Source getSource() {
        return source;
    }

    /**
     * Sets the source.
     *
     * @param source
     *            the new source
     */
    public final void setSource(final Source source) {
        this.source = source;
    }

    /**
     * Gets the score.
     *
     * @return the score
     */
    public final String getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score
     *            the new score
     */
    public final void setScore(final String score) {
        this.score = score;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type
     *            the new type
     */
    public final void setType(final String type) {
        this.type = type;
    }

}
