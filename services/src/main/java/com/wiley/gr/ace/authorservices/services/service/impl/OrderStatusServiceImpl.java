/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.HashMap;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants.OO_ORDER_STATUS;
import com.wiley.gr.ace.authorservices.model.OrderStatus;
import com.wiley.gr.ace.authorservices.services.service.OrderStatusService;

/**
 * @author Virtusa version1.0
 *
 */
public class OrderStatusServiceImpl implements OrderStatusService {
    
   @Autowired
   Environment env;
    private static HashMap<String, OrderStatus> orderStatusMap = new HashMap<String, OrderStatus>();

    @Override
    public HashMap<String, OrderStatus> getOrderStatusMap() {
    
        for (OO_ORDER_STATUS ooOrderStatus : AuthorServicesConstants.OO_ORDER_STATUS
                .values()) {

            OrderStatus orderStatus = new OrderStatus();
            StringTokenizer stk = new StringTokenizer(
                    env.getProperty("Submit_Url"),
                    ":");
            orderStatus.setStatus(stk.nextElement().toString());
            orderStatus.setActionsRequired(stk.nextElement().toString());
            orderStatusMap.put(ooOrderStatus.name(), orderStatus);
        }
        return orderStatusMap;
    }
}
