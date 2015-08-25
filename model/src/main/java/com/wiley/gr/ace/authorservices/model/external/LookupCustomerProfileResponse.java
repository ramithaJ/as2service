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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LookupCustomerProfileResponse.
 *
 * @author yugandhark
 */
@JsonInclude(Include.NON_NULL)
public class LookupCustomerProfileResponse implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /** The customer profile. */
    @JsonProperty("CustomerProfile")
    private CustomerProfile customerProfile;

    /**
     * Gets the customer profile.
     *
     * @return the customer profile
     */
    public final CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    /**
     * Sets the customer profile.
     *
     * @param customerProfile
     *            the new customer profile
     */
    public final void setCustomerProfile(final CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

}
