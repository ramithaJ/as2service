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
package com.wiley.gr.ace.authorservices.exception;

/**
 * The Class ASException.
 *
 * @author virtusa version 1.0
 */
public class ASException extends RuntimeException {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * This field holds the value of errorCode.
     */
    private String errorCode;
    /**
     * This field holds the value of t.
     */
    private Throwable t;
    /**
     * This field holds the value of description.
     */
    private String description;

    /**
     * Instantiates a new AS exception.
     *
     * @param errorCode
     *            the error code
     * @param t
     *            the t
     */
    public ASException(final String errorCode, final Throwable t) {
        this.errorCode = errorCode;
        this.t = t;
    }

    /**
     * Instantiates a new AS exception.
     *
     * @param errorCode
     *            the error code
     * @param desc
     *            the desc
     * @param t
     *            the t
     */
    public ASException(final String errorCode, final String desc,
            final Throwable t) {
        this.errorCode = errorCode;
        this.description = desc;
        this.t = t;
    }

    /**
     * Instantiates a new AS exception.
     *
     * @param errorCode
     *            the error code
     * @param desc
     *            the desc
     */
    public ASException(final String errorCode, final String desc) {
        this.errorCode = errorCode;
        this.description = desc;
    }

    /**
     * Instantiates a new AS exception.
     *
     * @param errorCode
     *            the error code
     */
    public ASException(final String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Instantiates a new AS exception.
     *
     * @param t
     *            the t
     */
    public ASException(final Throwable t) {
        this.t = t;
    }

    public ASException() {

    }

    /**
     * Gets the error code.
     *
     * @return errorCode
     */
    public final String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     *
     * @param errorCode
     *            the new error code
     */
    public final void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the description.
     *
     * @return description
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

    /**
     * This method is used to getWrappedException.
     *
     * @return the wrapped exception
     */
    public final Throwable getWrappedException() {
        // Not all ASException will have Wrapped Exception, Inorder to make
        // Generic if Wrapped
        // Exception is not found, send current ASException Object itself
        if (t != null) {
            return t;
        } else {
            return this;
        }
    }

}
