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

package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.InvoiceService;
import com.wiley.gr.ace.authorservices.model.external.Invoice;

/**
 * The Class InvoiceServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class InvoiceServiceImpl implements InvoiceService {

    /** The invoice url. */
    @Value("${getInvoice.url}")
    private String invoiceUrl;

    /**
     * Gets the invoice.
     *
     * @param invoice
     *            This method will take invoice as an input an call external
     *            service to get invoice
     * @return the invoice
     */
    @Override
    public final byte[] getInvoice(final Invoice invoice) {

        return (byte[]) StubInvokerUtil.getFile(invoiceUrl, invoice,
                byte[].class);

    }
}
