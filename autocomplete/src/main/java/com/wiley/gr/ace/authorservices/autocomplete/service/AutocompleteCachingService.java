/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.SubFunderDetails;

/**
 * AutocompleteCachingService.
 *
 * @author virtusa
 * @version 1.0
 */
public interface AutocompleteCachingService {

    /**
     * 
     * @param dropDownKey
     *            the dropDownKey
     * @param parentId
     *            the parentId
     * @return caheDataList
     */
    List<String> getCachedData(String dropDownKey, String parentId);

    /**
     * 
     * @param key
     *            the key
     * @return SubFunderDetails
     */
    SubFunderDetails getCachedSubFunders(String key);

}
