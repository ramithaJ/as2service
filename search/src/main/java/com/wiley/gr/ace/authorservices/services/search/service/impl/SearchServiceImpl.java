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
package com.wiley.gr.ace.authorservices.services.search.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.external.AutocompleteResponse;
import com.wiley.gr.ace.authorservices.model.external.AutocompleteSearch;
import com.wiley.gr.ace.authorservices.search.model.SearchRequest;
import com.wiley.gr.ace.authorservices.search.model.SearchResponse;
import com.wiley.gr.ace.authorservices.services.search.external.service.SearchExternalService;
import com.wiley.gr.ace.authorservices.services.search.service.SearchService;

/**
 * The Class SearchServiceImpl.
 */
public class SearchServiceImpl implements SearchService {

    /** The search external service. */
    @Autowired(required = true)
    private SearchExternalService searchExternalService;

    /**
     * This method is for search
     * 
     * @param searchRequest
     * 
     * @return search response..
     * */
    @Override
    public final SearchResponse search(final SearchRequest searchRequest) {

        return searchExternalService.search(searchRequest);
    }

    @Override
    public AutocompleteResponse autocompleteSearch(
            final AutocompleteSearch autocompleteSearch) {
        return searchExternalService.autocompleteSearch(autocompleteSearch);
    }

}
