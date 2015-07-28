/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.object;

import java.io.Serializable;
import java.util.List;

/**
 * @author kalyancj
 *
 */
public class AutocompleteCacheData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The Cached Data List */
	private List<String> cachedDataList;

	/**
	 * @return the cachedDataList
	 */
	public List<String> getCachedDataList() {
		return cachedDataList;
	}

	/**
	 * @param cachedDataList the cachedDataList to set
	 */
	public void setCachedDataList(List<String> cachedDataList) {
		this.cachedDataList = cachedDataList;
	} 
	
	



	
	

}
