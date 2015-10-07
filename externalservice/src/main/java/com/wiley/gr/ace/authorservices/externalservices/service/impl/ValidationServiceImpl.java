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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiRes;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationResponse;
import com.wiley.gr.ace.authorservices.model.external.VatIdValidationResponse;

/**
 * The Class ValidationServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class ValidationServiceImpl implements ValidationService {

    /** The address doctor url. */
    @Value("$addressdoctor.url")
    private String addressDoctorUrl;

    /** The vat validation url. */
    @Value("$vatidvalidation.url")
    private String vatValidationUrl;

    /**
     * Validate address.
     *
     * @param addressValidationRequest
     *            the address validation request
     * @return true, if successful
     */
    @Override
    public final ArrayList<AddressValidationMultiRes> validateAddress(
            final AddressValidationRequest addressValidationRequest) {
        ObjectWriter ow = new ObjectMapper().writer()
                .withDefaultPrettyPrinter();

        ArrayList<AddressValidationMultiRes> validAddressList = null;

        AddressValidationResponse addressValidationResponse = null;
        try {
            String addressRequestJson = ow
                    .writeValueAsString(addressValidationRequest);
            String addressValidationUrl = addressDoctorUrl + addressRequestJson;
            addressValidationResponse = (AddressValidationResponse) StubInvokerUtil
                    .restGetServiceInvoker(addressValidationUrl,
                            AddressValidationResponse.class);

            if (!StringUtils.isEmpty(addressValidationResponse)) {
                validAddressList = addressValidationResponse
                        .getAddressValidationMultiResList();
            }
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }

        return validAddressList;
    }

    /**
     * Vat validation.
     *
     * @param countryCode
     *            the country code
     * @param taxVatRegNum
     *            the tax vat reg num
     * @return true, if successful
     */
    @Override
    public final boolean vatValidation(final String countryCode,
            final String taxVatRegNum) {
        boolean isValid = false;
        final String vatUrl = vatValidationUrl + "countryCode=" + countryCode
                + "&taxRegistrationNumber=" + taxVatRegNum;

        final VatIdValidationResponse vatIdValidationResponse = (VatIdValidationResponse) StubInvokerUtil
                .restGetServiceInvoker(vatUrl, VatIdValidationResponse.class);
        if ("true".equalsIgnoreCase(vatIdValidationResponse.getIsValid())) {
            isValid = false;
        }
        return isValid;
    }
}
