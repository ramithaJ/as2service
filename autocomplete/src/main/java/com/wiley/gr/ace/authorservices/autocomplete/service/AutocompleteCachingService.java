/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.service;

import java.util.List;

/**
 * AutocompleteCachingService.
 *
 * @author virtusa
 * @version 1.0
 */
public interface AutocompleteCachingService {
	
	List<String> getCachedData(String dropDownKey);

}
