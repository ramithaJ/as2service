/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */

package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Amount.
 */
@JsonInclude(Include.NON_NULL)
public class Amount {

    /** The amount. */
    private String amount = "";

    /** The currency. */
    private String currency = "";

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public final String getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount
     *            the new amount
     */
    public final void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public final String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency
     *            the new currency
     */
    public final void setCurrency(final String currency) {
        this.currency = currency;
    }

}
