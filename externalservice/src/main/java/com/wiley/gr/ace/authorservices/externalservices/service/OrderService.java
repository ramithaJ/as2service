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

package com.wiley.gr.ace.authorservices.externalservices.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.external.CancelOrderRequest;
import com.wiley.gr.ace.authorservices.model.external.DiscountRequest;
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
import com.wiley.gr.ace.authorservices.model.external.WOAAccount;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;

/**
 * 
 * @author virtusa version 1.0
 */

public interface OrderService {

    /**
     * @param userId
     * @param orderId
     * @return OrderData
     */
    OrderDataList getOrderDetails(String userId, String orderId);

    /**
     * @return OrderData
     */
    OrderResponse submitOnlineOpenOrder(OrderRequest orderRequest);

    /**
     * @param dhid
     * @return PdhJournalResponse
     */
    PdhJournalResponse pdhLookUpJournal(Integer dhid);

    /**
     * @param dhid
     * @return PdhArticleResponse
     */
    PdhArticleResponse pdhLookUpArticle(Integer dhid);

    /**
     *
     * @param quoteRequest
     * @return
     */
    Quote getQuote(QuoteRequest quoteRequest);

    /**
     * @param journalAcronym
     * @return PdhArticleResponse
     */
    DiscountedSocietyResponse getDiscountedSocietiesForJournal(String journalAcronym);

    /**
     * @return PdhArticleResponse
     */
    WileyOpenAccessFunders getWoaAcounts();

    /**
     * @return SocietyMemberDiscount
     */
    SocietyMemberDiscount getSocietyMemberDiscount(String dhid);

    /**
     * @return InstitutionDiscounts
     */
    InstitutionDiscountsResponse getInstitutionDiscounts();

    /**
     * @param orderId
     * @return
     */
    OrderDataList getAllOrders(String orderId);

    /**
     * This method send the non restricted WOA Account List to the admin
     * 
     * @param nonRestrictedWOAAccountList
     * @return
     */
    Object sendNonRestrictedWOAAccountListToAdmin(
            List<WOAAccount> nonRestrictedWOAAccountList);

    /**
     * @param discountRequest
     */
    String getDiscounts(DiscountRequest discountRequest);

    /**
     * @param taxRequest
     * @return
     */
    String getTaxAmount(TaxRequest taxRequest);

    /**
     * @param cancelOrderRequest
     * @return
     */
    OrderResponse cancelOnlineOpenOrder(CancelOrderRequest cancelOrderRequest);

	/**
	 * @param funderId
	 * @return doi
	 */
	String getResearchFunderDOI(String funderId);


}
