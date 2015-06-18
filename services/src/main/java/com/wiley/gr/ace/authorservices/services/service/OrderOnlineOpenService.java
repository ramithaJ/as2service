package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;


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
	
	

}
