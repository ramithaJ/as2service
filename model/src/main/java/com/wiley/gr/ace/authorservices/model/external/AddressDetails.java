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
 * The Class AddressDetails.
 * 
 * @author virtusa version 1.0
 */
public class AddressDetails {

    /** The address. */
    @JsonProperty("Address")
    private List<AddressElement> address;

    /**
     * Gets the address.
     *
     * @return the address
     */
    public final List<AddressElement> getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the address to set
     */
    public final void setAddress(final List<AddressElement> address) {
        this.address = address;
    }

}
