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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author kpshiva
 */
@JsonInclude(Include.NON_NULL)
public class State {

	/** The state code. */
	private String stateCode;

	/** The state name. */
	private String stateName;

	/**
	 * Gets the state code.
	 *
	 * @return the state code
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * Sets the state code.
	 *
	 * @param stateCode
	 *            the new state code
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * Gets the state name.
	 *
	 * @return the state name
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Sets the state name.
	 *
	 * @param stateName
	 *            the new state name
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
