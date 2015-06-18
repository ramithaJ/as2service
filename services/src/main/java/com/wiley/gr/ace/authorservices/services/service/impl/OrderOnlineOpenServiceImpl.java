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

package com.wiley.gr.ace.authorservices.services.service.impl;

import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * @author virtusa version 1.0
 *
 */
public class OrderOnlineOpenServiceImpl implements OrderOnlineOpenService {

    /**
     * This method will take userId and orderId as input and calls external
     * service to get details of Online order details
     */
    @Override
    public OnlineOpenOrder getOnlineOpenOrderDetails(final String userId,
            final String orderId) {
        OnlineOpenOrder onlineOpenOrder = new OnlineOpenOrder();
        
        return onlineOpenOrder;
    }

}
