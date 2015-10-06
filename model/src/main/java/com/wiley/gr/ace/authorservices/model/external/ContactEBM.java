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
 * The Class ContactEBM.
 */
public class ContactEBM {

    /** The customer details. */
    @JsonProperty("CustomerDetails")
    private CDMUser customerDetails;

    /** The contact profile. */
    @JsonProperty("ContactProfile")
    private ContactProfile contactProfile;

    /**
     * Gets the customer details.
     *
     * @return the customer details
     */
    public final CDMUser getCustomerDetails() {
        return customerDetails;
    }

    /**
     * Sets the customer details.
     *
     * @param customerDetails
     *            the new customer details
     */
    public final void setCustomerDetails(final CDMUser customerDetails) {
        this.customerDetails = customerDetails;
    }

    /**
     * Gets the contact profile.
     *
     * @return the contact profile
     */
    public final ContactProfile getContactProfile() {
        return contactProfile;
    }

    /**
     * Sets the contact profile.
     *
     * @param contactProfile
     *            the new contact profile
     */
    public final void setContactProfile(final ContactProfile contactProfile) {
        this.contactProfile = contactProfile;
    }
}
