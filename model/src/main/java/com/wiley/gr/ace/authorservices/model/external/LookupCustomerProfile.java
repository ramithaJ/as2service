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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LookupCustomerProfile.
 *
 * @author yugandhark
 */
public class LookupCustomerProfile {

    /** The lookup customer profile response. */
    @JsonProperty("LookupCustomerProfileResponse")
    private LookupCustomerProfileResponse lookupCustomerProfileResponse;

    /**
     * Gets the lookup customer profile response.
     *
     * @return the lookup customer profile response
     */
    public final LookupCustomerProfileResponse getLookupCustomerProfileResponse() {
        return lookupCustomerProfileResponse;
    }

    /**
     * Sets the lookup customer profile response.
     *
     * @param lookupCustomerProfileResponse the new lookup customer profile response
     */
    public final void setLookupCustomerProfileResponse(
            final LookupCustomerProfileResponse lookupCustomerProfileResponse) {
        this.lookupCustomerProfileResponse = lookupCustomerProfileResponse;
    }

}
