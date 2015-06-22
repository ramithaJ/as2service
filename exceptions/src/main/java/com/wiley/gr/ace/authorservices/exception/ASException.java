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
package com.wiley.gr.ace.authorservices.exception;

/**
 * @author virtusa 
 * version 1.0
 */
public class ASException extends RuntimeException {

	/**
     * This field holds the value of serialVersionUID.
     */
	private static final long serialVersionUID = 1L;
	/**
     * This field holds the value of errorCode.
     */
	private String errorCode;
	/**
     * This field holds the value of t.
     */
	private Throwable t;
	/**
	 * This field holds the value of description.
	 */
	private String description;
	/**
	 * This field holds the value of msgPart.
	 */
	private Object[] msgPart;

	/**
	 * @param errorCode
	 * @param t
	 */
	public ASException(final String errorCode, final Throwable t) {
		this.errorCode = errorCode;
		this.t = t;
	}

	/**
	 * @param errorCode
	 * @param desc
	 * @param t
	 */
	public ASException(final String errorCode,final String desc, final Throwable t) {
		this.errorCode = errorCode;
		this.description = desc;
		this.t = t;
	}

	/**
	 * @param errorCode
	 * @param desc
	 */
	public ASException(final String errorCode, final String desc) {
		this.errorCode = errorCode;
		this.description = desc;
	}

	/**
	 * @param errorCode
	 */
	public ASException(final String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param errorCode
	 * @param msgPart
	 */
	public ASException(final String errorCode, final Object[] msgPart) {
		this.errorCode = errorCode;
		this.msgPart = msgPart;
	}

	/**
	 * @param t
	 */
	public ASException(final Throwable t) {
		this.t = t;
	}

	/**
	 * TODO Auto-generated constructor stub
	 */
	public ASException() {
		
	}

	/**
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 */
	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return msgPart
	 */
	public Object[] getMsgPart() {
		return msgPart;
	}

	/**
	 * @param msgPart
	 */
	public void setMsgPart(final Object[] msgPart) {
		this.msgPart = msgPart;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription( final String description) {
		this.description = description;
	}

	/**
	 * This method is used to getWrappedException.
	 * @return
	 */
	public Throwable getWrappedException() {
		// Not all ASException will have Wrapped Exception, Inorder to make
		// Generic if Wrapped
		// Exception is not found, send current ASException Object itself
		if (t != null)
			return t;
		else
			return this;
	}

}
