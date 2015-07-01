/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.Grants;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.Prices;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiReq;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.DiscountRequest;
import com.wiley.gr.ace.authorservices.model.external.Item;
import com.wiley.gr.ace.authorservices.model.external.TaxRequest;
import com.wiley.gr.ace.authorservices.services.service.OnlineOpenAuthorValidatorService;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * 
 * @author virtusa version 1.0
 */
public class OnlineOpenAuthorValidatorServiceImpl implements
        OnlineOpenAuthorValidatorService {

    /** Getting Bean Of Order Service */
    @Autowired(required = true)
    private OrderService orderService;
    
    /** Getting Bean Of Order Service */
    @Autowired(required = true)
    private OrderOnlineOpenService orderOnlineOpenService;
    
    /** Getting Bean Of Order Service */
    @Autowired(required = true)
    private ValidationService validationService;
    
    /**
     * This method validates the tax details
     * 
     * @param userId
     * @param taxDetails
     * 
     */
    @Override
    public void validateTaxDetails(final TaxDetails taxDetails) {

        if (taxDetails != null) {

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
    public void validateFunderDetails(final List<FunderDetails> funderDetailsList) {

        if (funderDetailsList != null
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
	public OnlineOpenOrder processAndValidateNext(OnlineOpenOrder onlineOpenOrder, String userId) {
		
		/*
		 *  Validate Funder Details
		 */
		validateFunderDetails(onlineOpenOrder.getFunderDetails());
		
		/*
		 * Validate validateTaxDetails
		 */
		validateTaxDetails(onlineOpenOrder.getTaxDetails());
		
		/*
		 * Validate Address Details
		 */
		AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
		
		AddressValidationMultiReq addressValidationMultiReq = new AddressValidationMultiReq();
		
		addressValidationMultiReq.setStreet1(onlineOpenOrder.getAddressDetails().getBillingAddress().getAddressLine1());
		addressValidationMultiReq.setStreet2(onlineOpenOrder.getAddressDetails().getBillingAddress().getAddressLine2());
		addressValidationMultiReq.setCountryName(onlineOpenOrder.getAddressDetails().getBillingAddress().getCountry().getCountryName());
		addressValidationMultiReq.setLocality1(onlineOpenOrder.getAddressDetails().getBillingAddress().getCity());
		addressValidationMultiReq.setPostCode(onlineOpenOrder.getAddressDetails().getBillingAddress().getPostCode());
		addressValidationMultiReq.setProvince1(onlineOpenOrder.getAddressDetails().getBillingAddress().getState());
		addressValidationMultiReq.setOrganization1(onlineOpenOrder.getAddressDetails().getBillingAddress().getInstitution());
		addressValidationMultiReq.setOrganizationDepartment1(onlineOpenOrder.getAddressDetails().getBillingAddress().getDepartment());
		
		addressValidationRequest.setAddressValidationMultiReq(addressValidationMultiReq);
		
		boolean isValidAddress = validationService.validateAddress(addressValidationRequest);
		
		 // TODO: Error codes and messages must be changed accordingly
		if(!isValidAddress){
			throw new ASException("906", "Invalid Address");
		}
		
		List<Prices> pricesList = onlineOpenOrder.getQuoteDetail().getPrices();
		
		// TODO : Need to check if multiple prices are received and iterate if multiple   
		Double apcPrice = Double.parseDouble(pricesList.get(0).getPrice());
		
		DiscountRequest discountRequest = new DiscountRequest();
		discountRequest.setCountry(onlineOpenOrder.getAddressDetails().getBillingAddress().getCountry().getCountryName());
		discountRequest.setInstitution(onlineOpenOrder.getAddressDetails().getBillingAddress().getInstitution());
		// TODO: Need to check whether values need to be populated
		discountRequest.setJrnlArcn("");
		discountRequest.setOtherPromoCode("");
		discountRequest.setSociety(onlineOpenOrder.getDiscountDetails().get(0).getSocietyId());
		discountRequest.setSocietyPromocode(onlineOpenOrder.getDiscountDetails().get(0).getPromoCode());
		
		Double discountPrice = Double.parseDouble(orderService.getDiscounts(discountRequest));
		
		TaxRequest taxRequest = new TaxRequest();
		List<Item> itemList = new ArrayList<Item>();
		taxRequest.setTaxExemptionExpiryDate(onlineOpenOrder.getTaxDetails().getTaxCodeExpiryDate());
		taxRequest.setTaxExemption(onlineOpenOrder.getTaxDetails().getTaxExemptionNumber());
		taxRequest.setVatId(onlineOpenOrder.getTaxDetails().getVatExemptionNumber());
		taxRequest.setCityName(onlineOpenOrder.getAddressDetails().getBillingAddress().getCity());
		taxRequest.setCountry(onlineOpenOrder.getAddressDetails().getBillingAddress().getCountry().getCountryName());
		taxRequest.setStateProv(onlineOpenOrder.getAddressDetails().getBillingAddress().getState());
		taxRequest.setZipPostalCode(onlineOpenOrder.getAddressDetails().getBillingAddress().getPostCode());
		taxRequest.setItem(itemList);
		
		Double taxAmount = Double.parseDouble(orderService.getTaxAmount(taxRequest));
		
		Double discountedAPC = apcPrice - discountPrice;
		
		Double finalAmount = discountedAPC + taxAmount;
		
		Double taxPercentage = (taxAmount/discountedAPC) * 100;
		
		Amount finAmount = new Amount();
		finAmount.setAmount(finalAmount.toString());
		
		onlineOpenOrder.setFinalAmount(finAmount);
		onlineOpenOrder.setTaxPercentage(taxPercentage.toString());
		
		Integer orderId = orderOnlineOpenService.saveLaterOrder(onlineOpenOrder, userId);
		
		onlineOpenOrder.setOrderId(orderId.toString());
		
		return onlineOpenOrder;
		
	}
    

}
