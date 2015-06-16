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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Addresses.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Addresses {

    /** The correspondence address. */
    private Address correspondenceAddress;

    /** The billing address. */
    private Address billingAddress;

    /** The shipping address. */
    private Address shippingAddress;

    /**
     * Gets the correspondence address.
     *
     * @return the correspondence address
     */
    public Address getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    /**
     * Sets the correspondence address.
     *
     * @param correspondenceAddress
     *            the new correspondence address
     */
    public void setCorrespondenceAddress(Address correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    /**
     * Gets the billing address.
     *
     * @return the billing address
     */
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the billing address.
     *
     * @param billingAddress
     *            the new billing address
     */
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Gets the shipping address.
     *
     * @return the shipping address
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the shipping address.
     *
     * @param shippingAddress
     *            the new shipping address
     */
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
