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
 * This is the generic service VO object which is returned by every service.
 * Data from the service is wrapped into this and returned.
 * 
 * @author SarmaKumarap
 *
 */
@JsonInclude(Include.NON_NULL)
public class Service {
	
	private String status;
	
	private Object serviceObject;
	
	private Error errorVO;

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public Object getServiceObject() {
		return serviceObject;
	}

	/**
	 * @param serviceObject
	 */
	public void setServiceObject(Object serviceObject) {
		this.serviceObject = serviceObject;
	}

	/**
	 * @return
	 */
	public Error getErrorVO() {
		return errorVO;
	}

	/**
	 * @param errorVO
	 */
	public void setErrorVO(Error errorVO) {
		this.errorVO = errorVO;
	}
	
	

}
