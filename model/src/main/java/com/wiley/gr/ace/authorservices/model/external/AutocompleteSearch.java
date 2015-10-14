/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version 1.0
 *
 */
public class AutocompleteSearch {

    /**
     * This field holds the value of appKey.
     */
    private String appKey;

    /**
     * This field holds the value of index.
     */
    private String index;

    /**
     * This field holds the value of autoCompleteQuery.
     */
    private AutoCompleteQuery autoCompleteQuery;

    /**
     * This field holds the value of size.
     */
    private String size;

    /**
     * @return the appKey
     */
    public final String getAppKey() {
        return appKey;
    }

    /**
     * @param appKey
     *            the appKey to set
     */
    public final void setAppKey(final String appKey) {
        this.appKey = appKey;
    }

    /**
     * @return the index
     */
    public final String getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
     */
    public final void setIndex(final String index) {
        this.index = index;
    }

    /**
     * @return the autoCompleteQuery
     */
    public final AutoCompleteQuery getAutoCompleteQuery() {
        return autoCompleteQuery;
    }

    /**
     * @param autoCompleteQuery
     *            the autoCompleteQuery to set
     */
    public final void setAutoCompleteQuery(
            final AutoCompleteQuery autoCompleteQuery) {
        this.autoCompleteQuery = autoCompleteQuery;
    }

    /**
     * @return the size
     */
    public final String getSize() {
        return size;
    }

    /**
     * @param size
     *            the size to set
     */
    public final void setSize(final String size) {
        this.size = size;
    }

}
