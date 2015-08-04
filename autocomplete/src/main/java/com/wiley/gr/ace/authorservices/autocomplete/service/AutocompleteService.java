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
import java.util.List;

import com.wiley.gr.ace.authorservices.model.CacheData;

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
     *            - the request value
     * @param phrase
     *            - the request value
     * @param count
     *            - the request value
     * @return List of string values
     */
    List<String> getAutocompleteData(String key, String phrase, Integer count);

    /**
     * This service will set the auto complete data in redis cache.
     *
     * @param key
     *            - the request value
     * @param count
     *            - the request value
     * @return status
     * @throws IOException
     *             - exception
     */
    boolean setAutocompleteData(String key, Boolean count) throws IOException;

    /**
     * This service will delete the data related to the key from redis.
     *
     * @param key
     *            - the request value
     * @return status
     */
    boolean flush(String key);
    
    /**
     * This service will return the drop down data.
     * @param key
     * @param phrase
     * @param offset
     * @param parentName
     * @return cacheDataList
     */
	List<CacheData> getDropDownData(String key, String phrase, Integer offset, String parentId, String parentName);

}
