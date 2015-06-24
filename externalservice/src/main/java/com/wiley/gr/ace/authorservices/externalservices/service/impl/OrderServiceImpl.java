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
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSocietyResponse;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;

/**
 * 
 * @author virtusa version 1.0
 */
public class OrderServiceImpl implements OrderService {

    @Value("${orderservice.url}")
    private String orderserviceurl;
    @Value("${orderservice.url.view}")
    private String orderserviceurlview;
    @Value("${quote.url}")
    private String quoteurl;

    @Value("${lookupjournal.url}")
    private String lookupjournalurl;
    
    @Value("${lookuparticle.url}")
    private String lookuparticleurl;
    
    @Value("${discountedSocieties.url}")
    private String discountedSocietiesurl;
    
    /**Calling Stub  */
    @Override
    public final OrderData getOrderDetails(String userId, String orderId) {

        return (OrderData) StubInvokerUtil.invokeJsonStub(orderserviceurlview, HttpMethod.POST, OrderData.class);

    }
    
    /**Calling Stub  */
    @Override
    public final OrderResponse submitOnlineOpenOrder(OrderData orderData) {

        return (OrderResponse) StubInvokerUtil.invokeJsonStub(orderserviceurl, HttpMethod.POST, OrderResponse.class);
    
    }
    
    /**
     * Method to call PDHLookupJournal external service.
     */
    @Override
    public final PdhJournalResponse pdhLookUpJournal(final Integer DHId) {
     
        return (PdhJournalResponse) StubInvokerUtil.invokeJsonStub(lookupjournalurl, HttpMethod.POST, PdhJournalResponse.class);
    }

    /**
     * Method to call PDHLookupArticle external service.
     */
    @Override
    public final PdhArticleResponse pdhLookUpArticle(final Integer DHId) {

        return (PdhArticleResponse) StubInvokerUtil.invokeJsonStub(lookuparticleurl, HttpMethod.POST, PdhArticleResponse.class);
    }

    /**
     * Method to call getQuote external service.
     */
    @Override
    public final Quote getQuote(final String articleId) {

        return (Quote) StubInvokerUtil.invokeJsonStub(quoteurl, HttpMethod.POST, Quote.class);
    }

	
    /**
     * Method to call getDiscountedSocietiesForJournal external service.
     */
	@Override
	public DiscountedSocietyResponse getDiscountedSocietiesForJournal(
			String journalId) {
		
		return (DiscountedSocietyResponse)StubInvokerUtil.invokeJsonStub(discountedSocietiesurl, HttpMethod.GET, DiscountedSocietyResponse.class);
	}

}