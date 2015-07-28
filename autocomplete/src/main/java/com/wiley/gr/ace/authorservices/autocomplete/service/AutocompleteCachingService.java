/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.service;

import java.util.List;

/**
 * @author kalyancj
 *
 */
public interface AutocompleteCachingService {
	
	public List<String> getCachedData(String dropDownKey);

}
