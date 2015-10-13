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

import java.io.File;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Override
    public final SearchResponse search(final SearchRequest searchRequest) {

        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("c:\\ravi\\user.json"), searchRequest);

        } catch (final Exception e) {

            e.printStackTrace();
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.add("role", "REGISTERED");

        final HttpEntity<SearchResponse> httpEntity = new HttpEntity<SearchResponse>(
                headers);
        final SearchResponse response = new RestTemplate().exchange(
                "http://10.201.64.81:8090/searchservice/v1/api/_search",
                HttpMethod.POST, httpEntity, SearchResponse.class).getBody();

        return response;
    }

    @Override
    public AutocompleteResponse autocompleteSearch(
            final AutocompleteSearch autocompleteSearch) {

        return (AutocompleteResponse) RestServiceInvokerUtil
                .restServiceInvoker(
                        "http://10.201.64.81:8090/searchservice/v1/api/_suggest",
                        autocompleteSearch, AutocompleteResponse.class);
    }

}
