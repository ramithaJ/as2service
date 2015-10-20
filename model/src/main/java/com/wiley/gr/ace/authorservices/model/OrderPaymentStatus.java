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
package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class OrderPaymentStatus.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class OrderPaymentStatus {

    /** The order status. */
    private String orderStatus;

    /** The order type. */
    private String orderType;

    /**
     * This field holds the value of availableActions.
     */
    private List<String> availableActionsList;

    /**
     * This field holds the value of additionalParam.
     */
    private String additionalParam;

    /**
     * Gets the available actions list.
     *
     * @return the availableActionsList
     */
    public final List<String> getAvailableActionsList() {
        return availableActionsList;
    }

    /**
     * Sets the available actions list.
     *
     * @param availableActionsList
     *            the availableActionsList to set
     */
    public final void setAvailableActionsList(
            final List<String> availableActionsList) {
        this.availableActionsList = availableActionsList;
    }

    /**
     * Gets the additional param.
     *
     * @return the additionalParam
     */
    public final String getAdditionalParam() {
        return additionalParam;
    }

    /**
     * Sets the additional param.
     *
     * @param additionalParam
     *            the additionalParam to set
     */
    public final void setAdditionalParam(final String additionalParam) {
        this.additionalParam = additionalParam;
    }

    /**
     * Gets the order status.
     *
     * @return the order status
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the order status.
     *
     * @param orderStatus
     *            the new order status
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

}
