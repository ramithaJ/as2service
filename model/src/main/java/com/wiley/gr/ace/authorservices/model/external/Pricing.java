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

/**
 * The Class Pricing.
 *
 * @author virtusa version 1.0
 */
public class Pricing {

    /** The product base price. */
    private String productBasePrice;

    /**
     * Gets the product base price.
     *
     * @return the productBasePrice
     */
    public final String getProductBasePrice() {
        return productBasePrice;
    }

    /**
     * Sets the product base price.
     *
     * @param productBasePrice
     *            the productBasePrice to set
     */
    public final void setProductBasePrice(final String productBasePrice) {
        this.productBasePrice = productBasePrice;
    }

    /**
     * Gets the amount to be paid.
     *
     * @return the amountToBePaid
     */
    public final String getAmountToBePaid() {
        return amountToBePaid;
    }

    /**
     * Sets the amount to be paid.
     *
     * @param amountToBePaid
     *            the amountToBePaid to set
     */
    public final void setAmountToBePaid(final String amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
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
     *            the currency to set
     */
    public final void setCurrency(final String currency) {
        this.currency = currency;
    }

    /** The amount to be paid. */
    private String amountToBePaid;

    /** The currency. */
    private String currency;
}
