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
package com.wiley.gr.ace.authorservices.services.search.external.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.model.external.AutocompleteResponse;
import com.wiley.gr.ace.authorservices.model.external.AutocompleteSearch;
import com.wiley.gr.ace.authorservices.search.model.SearchRequest;
import com.wiley.gr.ace.authorservices.search.model.SearchResponse;
import com.wiley.gr.ace.authorservices.services.search.external.service.SearchExternalService;

/**
 * The Class SearchExternalServiceImpl.
 */
public class SearchExternalServiceImpl implements SearchExternalService {

    /**
     * This method is for Searching
     * 
     * @param searchRequest
     * @return searchresponse.
     * 
     * */

    @Value("${search.url}")
    private String searchUrl;

    @Value("${search.autocomplete}")
    private String autocompleteSearchUrl;

    /** This method is calling search api for getting search related data */
    @Override
    public final SearchResponse search(final SearchRequest searchRequest) {

        final HttpHeaders headers = new HttpHeaders();
        headers.add(AuthorServicesConstants.SEARCH_ROLE,
                AuthorServicesConstants.SEARCH_ROLE_REGISTERED);

        final HttpEntity<SearchRequest> httpEntity = new HttpEntity<SearchRequest>(
                searchRequest, headers);

        return new RestTemplate().exchange(searchUrl, HttpMethod.POST,
                httpEntity, SearchResponse.class).getBody();
    }

    /**
     * This method is calling search api for getting autocomplete suggest
     * related data related data
     */
    @Override
    public AutocompleteResponse autocompleteSearch(
            final AutocompleteSearch autocompleteSearch) {

        return (AutocompleteResponse) RestServiceInvokerUtil
                .restServiceInvoker(autocompleteSearchUrl, autocompleteSearch,
                        AutocompleteResponse.class);
    }

}
