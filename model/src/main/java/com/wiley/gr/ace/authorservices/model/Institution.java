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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Institution.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Institution {

	@JsonProperty("responseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("response")
	private Response response;

	/**
	 * 
	 * @return The responseHeader
	 */
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	/**
	 * 
	 * @param responseHeader
	 *            The responseHeader
	 */
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	/**
	 * 
	 * @return The response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * 
	 * @param response
	 *            The response
	 */
	public void setResponse(Response response) {
		this.response = response;
	}

}