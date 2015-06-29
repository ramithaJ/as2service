/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.Grants;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.services.service.OnlineOpenAuthorValidatorService;

/**
 * 
 * @author virtusa version 1.0
 */
public class OnlineOpenAuthorValidatorServiceImpl implements
        OnlineOpenAuthorValidatorService {

    /** Getting Bean Of Order Service */
    @Autowired(required = true)
    private OrderService orderservice;

    /**
     * This method validates the tax details
     * 
     * @param userId
     * @param taxDetails
     * 
     */
    @Override
    public void validateTaxDetails(final String userId,
            final TaxDetails taxDetails) {

        if (userId != null && taxDetails != null) {

            // TODO: Error codes and messages must be changed accordingly
            if (!"USA".equalsIgnoreCase(taxDetails.getTaxCountryCode())
                    || !"CANADA".equalsIgnoreCase(taxDetails
                            .getTaxCountryCode())) {
                throw new ASException("900",
                        "User must belong to USA or CANADA only to enter Tax Exemption Number");
            }

            if (taxDetails.getTaxCodeExpiryDate() == null
                    || "".equals(taxDetails.getTaxCodeExpiryDate().trim())) {
                throw new ASException("901",
                        "Tax Exemption Number cannot be entered without Tax Code Expiry Date");
            }

            if (taxDetails.getTaxExemptionNumber() == null
                    || "".equals(taxDetails.getTaxExemptionNumber().trim())) {
                throw new ASException("902",
                        "Tax Code Expiry Date cannot be entered without Tax Exemption Number");
            }

            orderservice.validateTaxDetails(userId, taxDetails);

        } else {
            throw new ASException("903", "No Tax details available");
        }

    }

    /**
     * This method validates the funder details
     * 
     * @param userId
     * @param taxDetails
     * 
     */
    @Override
    public void validateFunderDetails(final String userId,
            final List<FunderDetails> funderDetailsList) {

        if (userId != null && funderDetailsList != null
                && !funderDetailsList.isEmpty()) {
            // TODO: Error codes and messages must be changed accordingly

            for (Iterator<FunderDetails> iterator = funderDetailsList
                    .iterator(); iterator.hasNext();) {
                FunderDetails funderDetails = iterator.next();

                List<Grants> grantList = funderDetails.getGrants();

                if (grantList == null || grantList.isEmpty()) {

                    throw new ASException("904",
                            "Atleaset One Grant Number is mandatory for the selected Research Funder");

                }
            }

            orderservice.validateFunderDetails(userId, funderDetailsList);

        } else {
            throw new ASException("905", "No Funder Details available");
        }

    }
    

}
