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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * The Class ViewOrderResponse.
 *
 * @author virtusa version 1.0
 */
public class ViewOrderResponse {

    /** The order data. */
    private List<OrderData> orderData;

    /**
     * Gets the order data.
     *
     * @return the order data
     */
    public final List<OrderData> getOrderData() {
        return orderData;
    }

    /**
     * Sets the order data.
     *
     * @param orderData
     *            the new order data
     */
    public final void setOrderData(final List<OrderData> orderData) {
        this.orderData = orderData;
    }

}
