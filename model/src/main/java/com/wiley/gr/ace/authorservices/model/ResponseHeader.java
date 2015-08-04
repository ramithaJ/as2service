package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHeader {

	@JsonProperty("status")
	private Integer status;
	
	@JsonProperty("QTime")
	private Integer QTime;
	
	@JsonProperty("params")
	private ResponseHeaderParams params;

	/**
	 * 
	 * @return The status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The QTime
	 */
	public Integer getQTime() {
		return QTime;
	}

	/**
	 * 
	 * @param QTime
	 *            The QTime
	 */
	public void setQTime(Integer QTime) {
		this.QTime = QTime;
	}

	/**
	 * @return the params
	 */
	public ResponseHeaderParams getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(ResponseHeaderParams params) {
		this.params = params;
	}


}
