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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Addresses.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Addresses implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The correspondence address. */
    private Address correspondenceAddress;

    /** The billing address. */
    private Address billingAddress;

    /** The shipping address. */
    private Address shippingAddress;

    /**
     * Gets the correspondence address.
     *
     * @return the correspondenceAddress
     */
    public final Address getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    /**
     * Sets the correspondence address.
     *
     * @param correspondenceAddress
     *            the correspondenceAddress to set
     */
    public final void setCorrespondenceAddress(
            final Address correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    /**
     * Gets the billing address.
     *
     * @return the billingAddress
     */
    public final Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the billing address.
     *
     * @param billingAddress
     *            the billingAddress to set
     */
    public final void setBillingAddress(final Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Gets the shipping address.
     *
     * @return the shippingAddress
     */
    public final Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the shipping address.
     *
     * @param shippingAddress
     *            the shippingAddress to set
     */
    public final void setShippingAddress(final Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
