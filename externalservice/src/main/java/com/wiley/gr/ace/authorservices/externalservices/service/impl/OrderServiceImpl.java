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

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.external.CancelOrderRequest;
import com.wiley.gr.ace.authorservices.model.external.DiscountRequest;
import com.wiley.gr.ace.authorservices.model.external.DiscountResponse;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSocietyResponse;
import com.wiley.gr.ace.authorservices.model.external.InstitutionDiscountsResponse;
import com.wiley.gr.ace.authorservices.model.external.OrderDataList;
import com.wiley.gr.ace.authorservices.model.external.OrderRequest;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.SocietyMemberDiscount;
import com.wiley.gr.ace.authorservices.model.external.TaxRequest;
import com.wiley.gr.ace.authorservices.model.external.TaxResponse;
import com.wiley.gr.ace.authorservices.model.external.WOAAccount;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;

/**
 * 
 * @author virtusa version 1.0
 */
public class OrderServiceImpl implements OrderService {

	/**
	 * This field holds the value of orderserviceurl.
	 */
	@Value("${createorder.url}")
	private String createorderurl;

	/**
	 * This field holds the value of orderserviceurlview.
	 */
	@Value("${orderservice.url.view}")
	private String orderserviceurlview;

	/**
	 * This field holds the value of quoteurl.
	 */
	@Value("${quote.url}")
	private String quoteurl;

	/**
	 * This field holds the value of lookupjournalurl.
	 */
	@Value("${lookupjournal.url}")
	private String lookupjournalurl;

	/**
	 * This field holds the value of lookuparticleurl.
	 */
	@Value("${lookuparticle.url}")
	private String lookuparticleurl;

	/**
	 * This field holds the value of discountedSocietiesForJournalUrl.
	 */
	@Value("${discountedSocietiesForJournal.url}")
	private String discountedSocietiesForJournalUrl;

	/**
	 * This field holds the value of SocietyMemberDiscountsurl.
	 */
	@Value("${societyMemberDiscounts.url}")
	private String societyMemberDiscountsurl;

	/**
	 * This field holds the value of woaAccountsurl.
	 */
	@Value("${woaAccounts.url}")
	private String woaAccountsurl;

	/**
	 * This field holds the value of institutionDiscountsurl.
	 */
	@Value("${institutionDiscounts.url}")
	private String institutionDiscountsurl;

	/**
	 * This field holds the value of gettaxurl.
	 */
	@Value("${gettax.url}")
	private String gettaxurl;

	/**
	 * This field holds the value of getdiscountsurl.
	 */
	@Value("${getdiscounts.url}")
	private String getdiscountsurl;

	/**
	 * This field holds the value of cancelOrderUrl.
	 */
	@Value("${cancelOrder.url}")
	private String cancelOrderUrl;

	/** Calling Stub */
	@Override
	public final OrderDataList getOrderDetails(final String userId,
			final String orderId) {

		return (OrderDataList) StubInvokerUtil.invokeJsonStub(
				orderserviceurlview, HttpMethod.POST, OrderDataList.class);

	}

	/** Calling Stub */
	@Override
	public final OrderResponse submitOnlineOpenOrder(
			final OrderRequest orderRequest) {

		return (OrderResponse) StubInvokerUtil.restServiceInvoker(
				createorderurl, orderRequest, OrderResponse.class);
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
	public final Quote getQuote(final QuoteRequest quoteRequest) {

		return (Quote) StubInvokerUtil.invokeJsonStub(quoteurl,
				HttpMethod.POST, Quote.class);
	}

	/**
	 * Method to call getDiscountedSocietiesForJournal external service.
	 * 
	 * @param journalAcronym
	 *            - the input value
	 * @return DiscountedSocietyResponse
	 */
	@Override
	public DiscountedSocietyResponse getDiscountedSocietiesForJournal(
			final String journalAcronym) {

		return (DiscountedSocietyResponse) RestServiceInvokerUtil
				.getServiceData(discountedSocietiesForJournalUrl
						+ journalAcronym, DiscountedSocietyResponse.class);
	}

	/**
	 * Method to get WOA Accounts.
	 */
	@Override
	public WileyOpenAccessFunders getWoaAcounts() {

		return (WileyOpenAccessFunders) StubInvokerUtil.invokeJsonStub(
				woaAccountsurl, HttpMethod.POST, WileyOpenAccessFunders.class);
	}

	/**
	 * Method to get society Member discounts.
	 * 
	 * @param DHID
	 *            - the input value
	 * @return SocietyMemberDiscount
	 */
	@Override
	public SocietyMemberDiscount getSocietyMemberDiscount(String DHID) {

		return (SocietyMemberDiscount) StubInvokerUtil.restGetServiceInvoker(
				societyMemberDiscountsurl + DHID, SocietyMemberDiscount.class);
	}

	/**
	 * Method to get Discount Institutions by institutionCode.
	 * 
	 * @param institutionCode
	 *            - the input value
	 * @return InstitutionDiscountsResponse
	 */
	@Override
	public InstitutionDiscountsResponse getInstitutionDiscounts() {

		return (InstitutionDiscountsResponse) RestServiceInvokerUtil
				.getServiceData(institutionDiscountsurl,
						InstitutionDiscountsResponse.class);
	}

	/** @param orderId */
	@Override
	public OrderDataList getAllOrders(final String orderId) {
		return (OrderDataList) StubInvokerUtil.invokeJsonStub(
				orderserviceurlview, HttpMethod.POST, OrderDataList.class);
	}

	@Override
	public Object sendNonRestrictedWOAAccountListToAdmin(
			final List<WOAAccount> nonRestrictedWOAAccountList) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method returns discount response while saving the order details.
	 * 
	 * @param discountRequest
	 *            - the input value
	 * @return discountAmount
	 */
	public String getDiscounts(final DiscountRequest discountRequest) {

		DiscountResponse response = (DiscountResponse) StubInvokerUtil
				.restServiceInvoker(getdiscountsurl, discountRequest,
						DiscountResponse.class);

		return response.getDiscountResponseObject().getDiscountAmount();
	}

	@Override
	public String getTaxAmount(final TaxRequest taxRequest) {
		TaxResponse response = (TaxResponse) StubInvokerUtil.invokeJsonStub(
				gettaxurl, HttpMethod.POST, TaxResponse.class);

		return response.getItem().get(0).getDiscountedLineAmount();
	}

	@Override
	public OrderResponse cancelOnlineOpenOrder(
			final CancelOrderRequest cancelOrderRequest) {

		return (OrderResponse) StubInvokerUtil.restServiceInvoker(
				cancelOrderUrl, cancelOrderRequest, OrderResponse.class);
	}

	@Override
	public String getResearchFunderDOI(String funderId) {
		// TODO Need to retrieve the DOI from the Cache
		return "1234";
	}
}