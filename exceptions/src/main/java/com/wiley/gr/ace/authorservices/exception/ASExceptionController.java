package com.wiley.gr.ace.authorservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
		response.setErrorVO(new com.wiley.gr.ace.authorservices.model.Error());
		response.getErrorVO().setErrorCode(
				Integer.parseInt(asException.getErrorCode()));
		response.getErrorVO().setErrorMessage(asException.getDescription());
		
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
		response.setErrorVO(new com.wiley.gr.ace.authorservices.model.Error());
		response.getErrorVO().setErrorCode(-1);
		response.getErrorVO().setErrorMessage(exception.getMessage());
		
		return response;
		
	}
	

}
