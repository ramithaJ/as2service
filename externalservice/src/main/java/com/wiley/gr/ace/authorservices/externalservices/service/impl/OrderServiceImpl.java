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
import com.wiley.gr.ace.authorservices.model.external.InstitutionDiscounts;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.OrderDataList;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.SocietyMemberDiscount;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;

/**
 * 
 * @author virtusa version 1.0
 */
public class OrderServiceImpl implements OrderService {

    /**
     * This field holds the value of orderserviceurl
     */
    @Value("${orderservice.url}")
    private String orderserviceurl;

    /**
     * This field holds the value of orderserviceurlview
     */
    @Value("${orderservice.url.view}")
    private String orderserviceurlview;

    /**
     * This field holds the value of quoteurl
     */
    @Value("${quote.url}")
    private String quoteurl;

    /**
     * This field holds the value of lookupjournalurl
     */
    @Value("${lookupjournal.url}")
    private String lookupjournalurl;

    /**
     * This field holds the value of lookuparticleurl
     */
    @Value("${lookuparticle.url}")
    private String lookuparticleurl;

    /**
     * This field holds the value of discountedSocietiesurl
     */
    @Value("${discountedSocieties.url}")
    private String discountedSocietiesurl;

    /**
     * This field holds the value of SocietyMemberDiscountsurl
     */
    @Value("${SocietyMemberDiscounts.url}")
    private String SocietyMemberDiscountsurl;

    /**
     * This field holds the value of woaAccountsurl
     */
    @Value("${woaAccounts.url}")
    private String woaAccountsurl;

    /**
     * This field holds the value of institutionDiscountsurl
     */
    @Value("${institutionDiscounts.url}")
    private String institutionDiscountsurl;

    /** Calling Stub */
    @Override
    public final OrderDataList getOrderDetails(final String userId,
            final String orderId) {

        return (OrderDataList) StubInvokerUtil.invokeJsonStub(
                orderserviceurlview, HttpMethod.POST, OrderDataList.class);

    }

    /** Calling Stub */
    @Override
    public final OrderResponse submitOnlineOpenOrder(final OrderData orderData) {

        return (OrderResponse) StubInvokerUtil.invokeJsonStub(orderserviceurl,
                HttpMethod.POST, OrderResponse.class);

    }

    /**
     * Method to call PDHLookupJournal external service.
     */
    @Override
    public final PdhJournalResponse pdhLookUpJournal(final Integer DHId) {

        return (PdhJournalResponse) StubInvokerUtil.invokeJsonStub(
                lookupjournalurl, HttpMethod.POST, PdhJournalResponse.class);
    }

    /**
     * Method to call PDHLookupArticle external service.
     */
    @Override
    public final PdhArticleResponse pdhLookUpArticle(final Integer DHId) {

        return (PdhArticleResponse) StubInvokerUtil.invokeJsonStub(
                lookuparticleurl, HttpMethod.POST, PdhArticleResponse.class);
    }

    /**
     * Method to call getQuote external service.
     */
    @Override
    public final Quote getQuote(final String articleId) {

        return (Quote) StubInvokerUtil.invokeJsonStub(quoteurl,
                HttpMethod.POST, Quote.class);
    }

    /**
     * Method to call getDiscountedSocietiesForJournal external service.
     */
    @Override
    public DiscountedSocietyResponse getDiscountedSocietiesForJournal(
            final String journalId) {

        return (DiscountedSocietyResponse) StubInvokerUtil.invokeJsonStub(
                discountedSocietiesurl, HttpMethod.GET,
                DiscountedSocietyResponse.class);
    }

    /**
     * Method to get WOA Accounts
     */
    @Override
    public WileyOpenAccessFunders getWoaAcounts() {

        return (WileyOpenAccessFunders) StubInvokerUtil.invokeJsonStub(
                woaAccountsurl, HttpMethod.POST, WileyOpenAccessFunders.class);
    }

    /**
     * Method to get society Member discounts
     */
    @Override
    public SocietyMemberDiscount getSocietyMemberDiscount() {

        return (SocietyMemberDiscount) StubInvokerUtil.invokeJsonStub(
                SocietyMemberDiscountsurl, HttpMethod.POST,
                SocietyMemberDiscount.class);
    }

    @Override
    public InstitutionDiscounts getInstitutionDiscounts() {

        return (InstitutionDiscounts) StubInvokerUtil.invokeJsonStub(
                institutionDiscountsurl, HttpMethod.POST,
                InstitutionDiscounts.class);
    }

    public static void main(final String[] args) {

    }
}