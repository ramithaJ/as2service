/**
 * 
 */
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Virtusa
 *
 */
@JsonInclude(Include.NON_NULL)
public class UserFunder {
	
	/** The user Id . */
	private String userId;
	
	/** The funder Id . */
	private String rfunderId;

	/**
	 * Gets the user Id.
	 *
	 * @return the user Id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user Id.
	 *
	 * @return the user Id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the funder Id.
	 *
	 * @return the funder Id
	 */
	public String getRfunderId() {
		return rfunderId;
	}

	/**
	 * Sets the funder Id.
	 *
	 * @return the funder Id
	 */
	public void setRfunderId(String rfunderId) {
		this.rfunderId = rfunderId;
	}
}
