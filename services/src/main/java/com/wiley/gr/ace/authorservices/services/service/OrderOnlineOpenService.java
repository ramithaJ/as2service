package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;


/**
 * @author virtusa version 1.0
 *
 */
public interface OrderOnlineOpenService {
	
	/**
	 * @param userId
	 * @param orderId
	 * @return
	 */
	OnlineOpenOrder getOnlineOpenOrderDetails(String userId, String orderId);
	
	/**
	 * @param userId
	 * @param articleId
	 * @return
	 */
	QuoteDetails getQuote(String userId, String articleId);
	/**
     * @param userId
     * @return
     */
    List<OrderDetails> getAllOrders(Integer userId,String type);

}
