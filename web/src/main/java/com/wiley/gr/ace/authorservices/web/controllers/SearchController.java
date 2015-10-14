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
package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.AutocompleteSearch;
import com.wiley.gr.ace.authorservices.search.model.SearchRequest;
import com.wiley.gr.ace.authorservices.services.search.service.SearchService;

/**
 * The Class SearchController.
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    /** The search service. */
    @Autowired(required = true)
    private SearchService searchService;

    /**
     * Search.
     *
     * @param searchRequest
     *            the search request
     * @param role
     *            the role
     * @return the service
     */
    @RequestMapping(value = "/api", method = RequestMethod.POST)
    public Service search(@RequestBody final SearchRequest searchRequest) {
        final Service service = new Service();

        service.setPayload(searchService.search(searchRequest));
        return service;

    }

    /**
     * Auto complete search.
     * 
     * @param autocompleteSearch
     *            the request object.
     * @return service
     */
    @RequestMapping(value = "/autocomplete", method = RequestMethod.POST)
    public Service autoCompleteSearch(
            @RequestBody final AutocompleteSearch autocompleteSearch) {
        Service service = new Service();
        service.setPayload(searchService.autocompleteSearch(autocompleteSearch));
        return service;
    }
}