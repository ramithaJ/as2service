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
package com.wiley.gr.ace.authorservices.services.service;

import java.util.ArrayList;

import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;

/**
 * The Interface OpenAccessService.
 * 
 * @author virtusa version 1.0
 */
public interface OpenAccessService {

    /**
     * Gets the open access details.
     *
     * @param userId
     *            the user id
     * @param articleId
     *            the article id
     * @param journalId
     *            the journal id
     * @return the open access details
     * @throws Exception
     *             the exception
     */
    OpenAccessPaymentData getOpenAccessDetails(String userId, String articleId,
            String journalId) throws Exception;

    /**
     * Validate address.
     *
     * @param address
     *            the address
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    ArrayList<Address> validateAddress(Address address) throws Exception;

    /**
     * Validate vat tax details.
     *
     * @param countryCode
     *            the country code
     * @param vatTaxRegNum
     *            the vat tax reg num
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    boolean validateVatTaxDetails(String countryCode, String vatTaxRegNum)
            throws Exception;

    /**
     * @param userId
     * @param orderId
     * @return
     */
    OnlineOpenOrder viewOpenAccess(final String userId, final String orderId);
}
