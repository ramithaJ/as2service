/**
 * 
 */
package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * SubFunderDetails.
 *
 * @author virtusa
 * @version 1.0
 */
public class SubFunderDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, SubFunders> subFundersMap = new HashMap<String, SubFunders>();

	/**
	 * @return the subFundersMap
	 */
	public Map<String, SubFunders> getSubFundersMap() {
		return subFundersMap;
	}

	/**
	 * @param subFundersMap the subFundersMap to set
	 */
	public void setSubFundersMap(Map<String, SubFunders> subFundersMap) {
		this.subFundersMap = subFundersMap;
	}
	

}
