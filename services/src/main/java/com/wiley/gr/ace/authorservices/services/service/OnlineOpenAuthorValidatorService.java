/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
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
    void validateTaxDetails(TaxDetails taxDetails);

    /**
     * @param userId
     * @param funderDetails
     */
    void validateFunderDetails(List<FunderDetails> funderDetailsList);

    /**
     * @param onlineOpenOrder
     * @param userId
     * @return onlineOpenOrder
     */
    OnlineOpenOrder processAndValidateNext(OnlineOpenOrder onlineOpenOrder,
            String userId);

}
