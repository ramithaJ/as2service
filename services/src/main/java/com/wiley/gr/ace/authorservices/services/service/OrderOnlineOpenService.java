package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;


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

	/**
	 * @param userId
	 * @param onlineOpenOrder
	 */
	OrderResponse submitOnlineOpenOrder(String userId, OnlineOpenOrder onlineOpenOrder);
	
	
	/**
	 * @param userId
	 * @param onlineOpenOrder
	 */
	List<String> retrieveDiscountedWOAFunderList(String userId, String DHID);
	
	
	/**
	 * @param userId
	 * @param onlineOpenOrder
	 */
	List<String> retrieveSocietyDiscountListForJournal(String userId, String DHID);
	
	/**
	 * @param order
	 * @return
	 */
	String saveLaterOrder(OnlineOpenOrder order);

}
