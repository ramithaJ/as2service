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
package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class Customer.
 *
 * @author virtusa version 1.0
 */
public class Customer {

    /** The ec id. */
    private String ecId;

    /** The email id. */
    private String emailId;

    /** The order id. */
    private String orderId;

    /**
     * @return the ecId
     */
    public final String getEcId() {
        return ecId;
    }

    /**
     * @param ecId
     *            the ecId to set
     */
    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    /**
     * @return the emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the orderId
     */
    public final String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public final void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

}
