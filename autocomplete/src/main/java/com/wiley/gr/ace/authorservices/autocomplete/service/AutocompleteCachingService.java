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
	
	List<String> getCachedData(String dropDownKey, String parentId);

	SubFunderDetails getCachedSubFunders(String key);

}
