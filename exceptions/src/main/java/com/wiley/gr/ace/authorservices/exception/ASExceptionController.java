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

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;

/**
 * This class serves as a global exception handler for all controller classes
 * 
 * @author SarmaKumarap
 *
 */
@ControllerAdvice
public class ASExceptionController {
	
	
	/**
	 * @param asException
	 * @return
	 */
	@ExceptionHandler(ASException.class)
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public Service handleASException(ASException asException) {
		
		System.out.println("Inside ASException Controller");
		
		Service response = new Service();
		
		response.setStatus("failed");
		ErrorPOJO errorPojo = new com.wiley.gr.ace.authorservices.model.ErrorPOJO();
		errorPojo.setCode(
				Integer.parseInt(asException.getErrorCode()));
		errorPojo.setMessage(asException.getDescription());
		response.setError(errorPojo);
		
		return response;
		
	}
	
	
	/**
	 * @param asException
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody	public Service handleException(Exception exception) {
		
		System.out.println("Inside ASException Controller");
		
		Service response = new Service();
		
		response.setStatus("failed");
		ErrorPOJO errorPojo = new com.wiley.gr.ace.authorservices.model.ErrorPOJO();
		errorPojo.setCode(-1);
		errorPojo.setMessage(exception.getMessage());
		response.setError(errorPojo);
		
		return response;
		
	}
	

}
