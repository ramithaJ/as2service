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

import java.util.List;

/**
 * The Class AddressDetails.
 * 
 * @author virtusa version 1.0
 */
public class AddressDetails {

    /** The address. */
    private List<Address> address;

    /**
     * Gets the address.
     *
     * @return the address
     */
    public final List<Address> getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the address to set
     */
    public final void setAddress(final List<Address> address) {
        this.address = address;
    }

}
