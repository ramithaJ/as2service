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

package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class OrderDataList.
 */
public class OrderDataList {

    /** The order datas. */
    @JsonProperty("Order")
    private List<OrderData> orderDatas;

    /**
     * Gets the order datas.
     *
     * @return the order datas
     */
    public final List<OrderData> getOrderDatas() {
        return orderDatas;
    }

    /**
     * Sets the order datas.
     *
     * @param orderDatas
     *            the new order datas
     */
    public final void setOrderDatas(final List<OrderData> orderDatas) {
        this.orderDatas = orderDatas;
    }

}
