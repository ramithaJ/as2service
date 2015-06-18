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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wiley.gr.ace.authorservices.model.UserProfile;

/**
 * The Class UserProfileResponse.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class UserProfileResponse {

    /** The customer profile. */
    private UserProfile customerProfile;

    /**
     * @return the customerProfile
     */
    public final UserProfile getCustomerProfile() {
        return customerProfile;
    }

    /**
     * @param customerProfile
     *            the customerProfile to set
     */
    public final void setCustomerProfile(final UserProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

}
