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
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;

/**
 * The Interface ValidationService.
 * 
 * @author virtusa version 1.0
 */
public interface ValidationService {

    /**
     * Validate address.
     *
     * @param addressValidationRequest
     *            the address validation request
     * @return true, if successful
     */
    boolean validateAddress(AddressValidationRequest addressValidationRequest);

    /**
     * Vat validation.
     *
     * @param countryCode
     *            the countri code
     * @param taxVatRegNum
     *            the tax vat reg num
     * @return true, if successful
     */
    boolean vatValidation(String countryCode, String taxVatRegNum);
}
