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

import java.util.List;

import com.wiley.gr.ace.authorservices.model.CacheData;

/**
 * The Interface AutocompleteService.
 *
 * @author virtusa version 1.0
 */
public interface AutocompleteService {

    /**
     * This service will return the drop down data.
     * 
     * @param key
     *            - Input parameter
     * @param phrase
     *            - Input parameter
     * @param offset
     *            - Input parameter
     * @param parentId
     *            - Input parameter
     * @return cacheDataList - Return Type
     */
    List<CacheData> getDropDownData(String key, String phrase, Integer offset,
            String parentId);

    /**
     * This service will return the name based on the code.
     * 
     * @param key
     *            - Input parameter
     * @param code
     *            - Input parameter
     * @param parentId
     *            - Input parameter
     * @return name.
     */
    String getNameByCode(String key, String code, String parentId);

}
