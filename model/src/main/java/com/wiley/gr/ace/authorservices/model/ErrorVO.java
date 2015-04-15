package com.wiley.gr.ace.authorservices.model;

/**
 * This is the generic errorVO returned by the service.
 * 
 * @author SarmaKumarap
 *
 */
public class ErrorVO {
	
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
