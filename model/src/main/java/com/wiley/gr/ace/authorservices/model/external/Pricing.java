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
 * @author virtusa
 * version 1.0
 */
public class Pricing {
    
    private String productBasePrice;
    
    private String amountToBePaid;
    
    private String currency;

    public String getProductBasePrice() {
        return productBasePrice;
    }

    public void setProductBasePrice(String productBasePrice) {
        this.productBasePrice = productBasePrice;
    }

    public String getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(String amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}