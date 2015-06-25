/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.TaxDetails;

/**
 * The Interface OnlineOpenAuthorValidatorService.
 * 
 * @author virtusa version 1.0
 *
 */
public interface OnlineOpenAuthorValidatorService {
	
	
	 /**
	  * 
	  * @param userId
	  * @param taxDetails
	  */
	 void validateTaxDetails(String userId, TaxDetails taxDetails);
	
	

}
