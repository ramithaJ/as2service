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
 * The Class ContactProfile.
 */
public class ContactProfile {

    /**
     * Gets the contact identification.
     *
     * @return the contact identification
     */
    public final ContactIdentification getContactIdentification() {
        return contactIdentification;
    }

    /**
     * Sets the contact identification.
     *
     * @param contactIdentification
     *            the new contact identification
     */
    public final void setContactIdentification(
            final ContactIdentification contactIdentification) {
        this.contactIdentification = contactIdentification;
    }

    /** The contact identification. */
    @JsonProperty("ContactIdentification")
    private ContactIdentification contactIdentification;
}
