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
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.PDHLookup;

/**
 * 
 * @author virtusa version 1.0
 */
public class OrderServiceImpl implements OrderService {

    @Value("${orderservice.url}")
    private String orderserviceurl;

    /**Calling Stub  */
    @Override
    public OrderData getOrderDetails(String userId, String orderId) {

        return (OrderData) StubInvokerUtil.invokeJsonStub(orderserviceurl, HttpMethod.POST, OrderData.class);

    }
    
    /**
     * Method to call PDHLookup external service.
     */
    @Override
    public PDHLookup isOnlineOpen(final Integer DHId) {
     
        return (PDHLookup) StubInvokerUtil.invokeJsonStub("http://jsonstub.com/pdh/lookupjournal", HttpMethod.POST, PDHLookup.class);
    }

    @Override
    public PDHLookup articleTitle(Integer DHId) {

        return (PDHLookup) StubInvokerUtil.invokeJsonStub("http://jsonstub.com/pdh/lookuparticle", HttpMethod.POST, PDHLookup.class);
    }

    @Override
    public PDHLookup journalTitile(Integer DHId) {
        
        return (PDHLookup) StubInvokerUtil.invokeJsonStub("http://jsonstub.com/pdh/lookupjournal", HttpMethod.POST, PDHLookup.class);
    }

    @Override
    public boolean getQuote() {
        // TODO Auto-generated method stub
        return false;
    }
}