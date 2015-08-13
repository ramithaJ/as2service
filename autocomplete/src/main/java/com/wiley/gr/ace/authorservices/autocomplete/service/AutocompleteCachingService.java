/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.service;

import java.util.Map;

import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.SubFunderDetails;

/**
 * AutocompleteCachingService.
 *
 * @author virtusa
 * @version 1.0
 */
public interface AutocompleteCachingService {

    /**
     * Interface method getCacheData.
     * 
     * @param dropDownKey
     *            - the input value
     * @param parentId
     *            - the input value
     * @return dropDowmMap
     */
    Map<String, CacheData> getCachedData(String dropDownKey, String parentId);

    /**
     * Interface method getCachedSubFunders.
     * 
     * @param key
     *            the key
     * @return SubFunderDetails
     */
    SubFunderDetails getCachedSubFunders(String key);

}
