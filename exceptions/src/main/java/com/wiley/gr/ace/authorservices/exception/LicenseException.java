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
package com.wiley.gr.ace.authorservices.exception;

/**
 * The Class LicenseException.
 * 
 * @author virtusa version 1.0
 */
public class LicenseException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8073981922001643728L;

    /** The error code. */
    private String errorKey;

    /** The description. */
    private String description;

    /**
     * Instantiates a new license exception.
     *
     * @param errorKey
     *            the error code
     * @param description
     *            the description
     */
    public LicenseException(String errorKey, String description) {
        this.errorKey = errorKey;
        this.description = description;
    }

    /**
     * Instantiates a new license exception.
     */
    public LicenseException() {

    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public final String getErrorKey() {
        return errorKey;
    }

    /**
     * Sets the error code.
     *
     * @param errorKey
     *            the new error code
     */
    public final void setErrorKey(final String errorKey) {
        this.errorKey = errorKey;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description
     *            the new description
     */
    public final void setDescription(final String description) {
        this.description = description;
    }

}
