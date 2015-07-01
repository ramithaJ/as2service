/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.Grants;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.DiscountRequest;
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
    
    @Value("${OnlineOpenProperties.userId}")
    private String userId;

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
            if (!AuthorServicesConstants.COUNTRY_USA.equalsIgnoreCase(taxDetails.getTaxCountryCode())
                    || !AuthorServicesConstants.COUNTRY_CANADA.equalsIgnoreCase(taxDetails
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

    /**
     * This method executes all the validations on click of Next
     * @parama onlineOpenOrder
     * 
     */
	@Override
	public void processAndValidateNext(OnlineOpenOrder onlineOpenOrder) {
		
		/*
		 *  Validate Funder Details
		 */
		validateFunderDetails(userId, onlineOpenOrder.getFunderDetails());
		
		/*
		 * Validate validateTaxDetails
		 */
		validateTaxDetails(userId, onlineOpenOrder.getTaxDetails());
		
//		List<Prices> pricesList = onlineOpenOrder.getQuoteDetail().getPrices();
		
		// TODO : Need to be iterated and retrieve correct price 
		/*for (Iterator<Prices> iterator = pricesList.iterator(); iterator.hasNext();) {
			Prices prices = (Prices) iterator.next();
			
		}*/
		
//		Double apcPrice = Double.parseDouble(pricesList.get(0).getPrice());
		
		DiscountRequest discountRequest = new DiscountRequest();
		discountRequest.setCountry(onlineOpenOrder.getAddressDetails().getBillingAddress().getCountry().getCountryName());
		discountRequest.setInstitution(onlineOpenOrder.getAddressDetails().getBillingAddress().getInstitution());
		// TODO: Need to set the actual values
		discountRequest.setJrnlArcn("jrnlArcn");
		discountRequest.setOtherPromoCode("otherPromoCode");
		discountRequest.setSociety("SocietyName");
		discountRequest.setSocietyPromocode("societyPromocode");
		
	}
    

}
