/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */

package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Grants.
 */
public class Grants {

    /** The grant number. */
	@JsonInclude(Include.NON_NULL)
    private String grantNumber = "";

    /** The recipients list. */
    private List<Recipients> recipientsList;

    /**
     * Gets the grant number.
     *
     * @return the grant number
     */
    public final String getGrantNumber() {
        return grantNumber;
    }

    /**
     * Sets the grant number.
     *
     * @param grantNumber
     *            the new grant number
     */
    public final void setGrantNumber(final String grantNumber) {
        this.grantNumber = grantNumber;
    }

    /**
     * Gets the recipients list.
     *
     * @return the recipients list
     */
    public final List<Recipients> getRecipientsList() {
        return recipientsList;
    }

    /**
     * Sets the recipients list.
     *
     * @param recipientsList
     *            the new recipients list
     */
    public final void setRecipientsList(final List<Recipients> recipientsList) {
        this.recipientsList = recipientsList;
    }

}
