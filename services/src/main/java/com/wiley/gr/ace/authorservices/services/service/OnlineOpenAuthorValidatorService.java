/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.FunderDetails;
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

	/**
	 * @param userId
	 * @param funderDetails
	 */
	void validateFunderDetails(String userId, List<FunderDetails> funderDetailsList);
	
	/**
	 * Method to validate for restricted Account
	 * 
	 * @param woaAccount
	 */
	
	
	
	

}
