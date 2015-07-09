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
package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class User.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Autocomplete implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Key. */
    private String key;

    /** The phrase. */
    private String phrase;

    /** The count. */
    private int count;

    /** The dataPath. */
    private URL dataPath;

    /** The clear. */
    private Boolean clear;

    /**
     * Gets the key.
     *
     * @return the key
     */
    public final String getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the new key
     */
    public final void setKey(final String key) {
        this.key = key;
    }

    /**
     * Gets the phrase.
     *
     * @return the phrase
     */
    public final String getPhrase() {
        return phrase;
    }

    /**
     * Sets the phrase.
     *
     * @param phrase
     *            the new phrase
     */
    public final void setPhrase(final String phrase) {
        this.phrase = phrase;
    }

    /**
     * Gets the count.
     *
     * @return the count
     */
    public final Integer getCount() {
        return count;
    }

    /**
     * Sets the count.
     *
     * @param count
     *            the new count
     */
    public final void setCount(final Integer count) {
        this.count = count;
    }

    /**
     * Gets the data path.
     *
     * @return the data path
     */
    public final URL getDataPath() {
        return dataPath;
    }

    /**
     * Sets the data path.
     *
     * @param dataPath
     *            the new data path
     */
    public final void setDataPath(final URL dataPath) {
        this.dataPath = dataPath;
    }

    /**
     * Checks if is clear.
     *
     * @return the boolean
     */
    public final Boolean isClear() {
        return clear;
    }

    /**
     * Sets the clear.
     *
     * @param clear
     *            the new clear
     */
    public final void setClear(final Boolean clear) {
        this.clear = clear;
    }
}
