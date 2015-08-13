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
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants.OO_ORDER_STATUS;
import com.wiley.gr.ace.authorservices.model.OrderStatus;

/**
 * @author Virtusa version1.0
 *
 */
@Configuration
@PropertySource("classpath:/userManagement.properties")
public class OrderStatusServiceImpl {

    private static HashMap<String, OrderStatus> orderStatusMap = new HashMap<String, OrderStatus>();

    @Autowired
    private Environment environment;

    // @Autowired
    // @Qualifier(value = "orderStatusOOproperties")
    // private Properties orderStatusOOproperties;

    public HashMap<String, OrderStatus> getOrderStatusMap() {

        for (OO_ORDER_STATUS ooOrderStatus : AuthorServicesConstants.OO_ORDER_STATUS
                .values()) {
            System.err.println(environment);
            OrderStatus orderStatus = new OrderStatus();
            StringTokenizer stk = new StringTokenizer(
                    environment.getProperty(ooOrderStatus.name()), ":");
            orderStatus.setStatus(stk.nextElement().toString());
            orderStatus.setActionsRequired(stk.nextElement().toString());
            orderStatusMap.put(ooOrderStatus.name(), orderStatus);
        }
        return orderStatusMap;
    }
}
