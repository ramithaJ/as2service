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
package com.wiley.gr.ace.authorservices.model;


/**
 * The Class AddressDetails.
 */
public class AddressDetails {

    /**
     * This field holds the value of billingAddress
     */
    private Address billingAddress;
    
    /**
     * This field holds the value of shippingAddress
     */
    private Address shippingAddress;

    /**
     * @return the billingAddress
     */
    public final Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * @param billingAddress the billingAddress to set
     */
    public final void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * @return the shippingAddress
     */
    public final Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @param shippingAddress the shippingAddress to set
     */
    public final void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    
}
