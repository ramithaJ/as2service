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
 * The Search Request Class.
 * 
 * @author virtusa version 1.0
 */
public class SearchRequest {

    /** The enable facets. */
    private String enableFacets;

    /** The index. */
    private String index;

    /** The advance query. */
    private AdvanceQuery[] advanceQuery;

    /** The simnple query. */
    private String simpleQuery;

    /** The sort. */
    private Sort[] sort;

    /** The offset. */
    private String offset;

    /** The types. */
    private String[] types;

    /** The filters. */
    private Filters filters;

    /** The rows. */
    private String rows;

    /** The appKey. */
    private String appKey;

    /**
     * @return the enableFacets
     */
    public String getEnableFacets() {
        return enableFacets;
    }

    /**
     * @param enableFacets
     *            the enableFacets to set
     */
    public void setEnableFacets(String enableFacets) {
        this.enableFacets = enableFacets;
    }

    /**
     * @return the index
     */
    public String getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * @return the advanceQuery
     */
    public AdvanceQuery[] getAdvanceQuery() {
        return advanceQuery;
    }

    /**
     * @param advanceQuery
     *            the advanceQuery to set
     */
    public void setAdvanceQuery(AdvanceQuery[] advanceQuery) {
        this.advanceQuery = advanceQuery;
    }

    /**
     * @return the simpleQuery
     */
    public String getSimpleQuery() {
        return simpleQuery;
    }

    /**
     * @param simpleQuery
     *            the simpleQuery to set
     */
    public void setSimpleQuery(String simpleQuery) {
        this.simpleQuery = simpleQuery;
    }

    /**
     * @return the sort
     */
    public Sort[] getSort() {
        return sort;
    }

    /**
     * @param sort
     *            the sort to set
     */
    public void setSort(Sort[] sort) {
        this.sort = sort;
    }

    /**
     * @return the offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * @param offset
     *            the offset to set
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    /**
     * @return the types
     */
    public String[] getTypes() {
        return types;
    }

    /**
     * @param types
     *            the types to set
     */
    public void setTypes(String[] types) {
        this.types = types;
    }

    /**
     * @return the filters
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * @param filters
     *            the filters to set
     */
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    /**
     * @return the rows
     */
    public String getRows() {
        return rows;
    }

    /**
     * @param rows
     *            the rows to set
     */
    public void setRows(String rows) {
        this.rows = rows;
    }

    /**
     * @return the appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * @param appKey
     *            the appKey to set
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

}
