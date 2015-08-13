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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.Autocomplete;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.Service;

/**
 * AutocompleteController.
 * 
 * @author virtusa version 1.0
 */
@Controller
@RequestMapping("/autocomplete")
public class AutocompleteController extends ASExceptionController {

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AutocompleteController.class);

    /**
     * injecting autoCompleteService bean.
     */
    @Autowired(required = true)
    private AutocompleteService autoCompleteService;

    /**
     * Controller method that returns dropDownData.
     * 
     * @param autocomplete
     *            - The request value
     * @return List
     */
    @RequestMapping(value = "/dropdown/", method = RequestMethod.POST)
    @ResponseBody
    public final Service getDropDownData(
            @RequestBody final Autocomplete autocomplete) {
        AutocompleteController.LOGGER.info("Inside get data Method");

        Service service = null;

        if (autocomplete.getKey() != null) {
            final List<CacheData> autocompleteData = autoCompleteService
                    .getDropDownData(autocomplete.getKey(),
                            autocomplete.getPhrase(), autocomplete.getOffset(),
                            autocomplete.getParentId());
            service = new Service();
            service.setPayload(autocompleteData);
        }
        return service;

    }

}
