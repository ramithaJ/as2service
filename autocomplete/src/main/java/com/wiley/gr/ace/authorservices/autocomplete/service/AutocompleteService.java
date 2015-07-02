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
package com.wiley.gr.ace.authorservices.autocomplete.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * The Interface AutocompleteService.
 *
 * @author virtusa version 1.0
 */
public interface AutocompleteService {

	/**
	 * This service will fetch the auto complete data related to the phrase from
	 * redis cache.
	 *
	 * @param key
	 * @param phrase
	 * @return List of string values
	 */
	List<String> getAutocompleteData(String key, String phrase, Integer count);

	/**
	 * This service will set the auto complete data in redis cache.
	 *
	 * @param key
	 * @param dataPath
	 * @param clear
	 * @param populate
	 * @return status
	 */
	boolean setAutocompleteData(String key, URL dataPath, Boolean count)
	        throws IOException;

	/**
	 * This service will delete the data related to the key from redis.
	 *
	 * @param key
	 * @return status
	 */
	boolean flush(String key);

}
