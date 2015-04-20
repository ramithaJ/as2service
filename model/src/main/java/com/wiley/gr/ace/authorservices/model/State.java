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
