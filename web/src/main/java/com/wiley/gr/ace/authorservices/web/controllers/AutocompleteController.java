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

import java.io.IOException;
import java.net.URL;
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
import com.wiley.gr.ace.authorservices.model.Service;

/**
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

	@Autowired(required = true)
	private AutocompleteService autoCompleteService;

	/**
	 * @param autocomplete
	 * @return status
	 * @throws IOException
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	public final Service setAutocompleteData(
	        @RequestBody Autocomplete autocomplete) throws IOException {
		AutocompleteController.LOGGER.info("Inside set data Method");

		final String key = autocomplete.getKey();
		final URL dataPath = autocomplete.getDataPath();
		final Boolean clear = autocomplete.isClear();

		if (null != key && null != dataPath && null != clear) {
			autoCompleteService.setAutocompleteData(key, dataPath, clear);
			return new Service();
		}
		return null;

	}

	/**
	 * @param autocomplete
	 * @return List
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public final Service getAutocompleteData(
	        @RequestBody Autocomplete autocomplete) {
		AutocompleteController.LOGGER.info("Inside get data Method");

		final String key = autocomplete.getKey();
		final String phrase = autocomplete.getPhrase();
		Service service;
		final Integer count = autocomplete.getCount();
		if (null != key && null != phrase && null != count) {
			final List<String> autocompleteData = autoCompleteService
			        .getAutocompleteData(autocomplete.getKey(), phrase, count);
			service = new Service();
			service.setPayload(autocompleteData);
			return service;
		}
		return null;

	}

	/**
	 * @param autocomplete
	 * @return status
	 */
	@RequestMapping(value = "/clear", method = RequestMethod.POST)
	@ResponseBody
	public final Service flushData(@RequestBody Autocomplete autocomplete)
	        throws IOException {
		AutocompleteController.LOGGER.info("Inside flush data Method");

		final String key = autocomplete.getKey();
		if (null != key) {
			autoCompleteService.flush(autocomplete.getKey());
			return new Service();
		}
		return null;

	}

}
