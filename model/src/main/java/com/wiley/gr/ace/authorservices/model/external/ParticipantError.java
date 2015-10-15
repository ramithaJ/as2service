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
/**
* 
 */
package com.wiley.gr.ace.authorservices.model.external;


/**
 * The Class ParticipantError.
 * 
 * @author virtusa version 1.0
 */
public class ParticipantError {
	
	/** The code. */
	private Integer code;
	
	/** The message. */
	private String message;
	
	/** The fields. */
	private String fields;
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public final Integer getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public final void setCode(final Integer code) {
		this.code = code;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public final void setMessage(final String message) {
		this.message = message;
	}
	
	/**
	 * Gets the fields.
	 *
	 * @return the fields
	 */
	public final String getFields() {
		return fields;
	}
	
	/**
	 * Sets the fields.
	 *
	 * @param fields the new fields
	 */
	public final void setFields(final String fields) {
		this.fields = fields;
	}
}
