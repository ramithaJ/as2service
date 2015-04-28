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
 * This is the generic errorVO returned by the service.
 * 
 * @author SarmaKumarap
 *
 */
@JsonInclude(Include.NON_NULL)
public class Error {
	
	private int errorCode;
	
	private String errorMessage;
	
	/**
	 * @return
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	

}
