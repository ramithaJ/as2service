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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CoAuthorDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CoAuthorDetails {

    /** The co author last name. */
    private String coAuthorLastName;

    /** The co author first name. */
    private String coAuthorFirstName;

    /** The co author email. */
    private String coAuthorEmail;

    /**
     * Gets the co author last name.
     *
     * @return the co author last name
     */
    public String getCoAuthorLastName() {
        return coAuthorLastName;
    }

    /**
     * Sets the co author last name.
     *
     * @param coAuthorLastName
     *            the new co author last name
     */
    public void setCoAuthorLastName(final String coAuthorLastName) {
        this.coAuthorLastName = coAuthorLastName;
    }

    /**
     * Gets the co author first name.
     *
     * @return the co author first name
     */
    public String getCoAuthorFirstName() {
        return coAuthorFirstName;
    }

    /**
     * Sets the co author first name.
     *
     * @param coAuthorFirstName
     *            the new co author first name
     */
    public void setCoAuthorFirstName(final String coAuthorFirstName) {
        this.coAuthorFirstName = coAuthorFirstName;
    }

    /**
     * Gets the co author email.
     *
     * @return the co author email
     */
    public String getCoAuthorEmail() {
        return coAuthorEmail;
    }

    /**
     * Sets the co author email.
     *
     * @param coAuthorEmail
     *            the new co author email
     */
    public void setCoAuthorEmail(final String coAuthorEmail) {
        this.coAuthorEmail = coAuthorEmail;
    }
}
