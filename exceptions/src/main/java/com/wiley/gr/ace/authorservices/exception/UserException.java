/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.exception;

public class UserException extends RuntimeException {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * This field holds the value of errorCode.
     */
    private String errorCode;

    /**
     * This field holds the value of description.
     */
    private String description;

    public UserException(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
    
    public UserException() {
    }
    /**
     * @return the errorCode
     */
    public final String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            the errorCode to set
     */
    public final void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public final void setDescription(String description) {
        this.description = description;
    }

}
