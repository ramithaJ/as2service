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

public interface OrderService {

    /**
     * @param userId
     * @param orderId
     * @return OrderData
     */
    OrderData getOrderDetails(String userId, String orderId);
    
    /**
     * @return OrderData
     */
    OrderResponse submitOnlineOpenOrder(OrderData orderData);
    
    /**
     * @param DHId
     * @return PdhJournalResponse
     */
    PdhJournalResponse pdhLookUpJournal(Integer DHId);
    
    /**
     * @param DHId
     * @return PdhArticleResponse
     */
    PdhArticleResponse pdhLookUpArticle(Integer DHId);
    
    /**
     * @param articleId
     * @return Quote
     */
    Quote getQuote(String articleId);
    
    
    /**
     * @param DHId
     * @return PdhArticleResponse
     */
    DiscountedSocietyResponse getDiscountedSocietiesForJournal(String journalId);
}
