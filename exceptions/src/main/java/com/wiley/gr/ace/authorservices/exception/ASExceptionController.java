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
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ResponseBody
	public Service handleASException(ASException asException) {
		
		System.out.println("Inside ASException Controller");
		
		Service response = new Service();
		
		response.setStatus("failed2");
		response.setErrorVO(new com.wiley.gr.ace.authorservices.model.Error());
		response.getErrorVO().setErrorCode(
				Integer.parseInt(asException.getErrorCode()));
		response.getErrorVO().setErrorMessage(asException.getDescription());
		
		return response;
		
	}
	

}
