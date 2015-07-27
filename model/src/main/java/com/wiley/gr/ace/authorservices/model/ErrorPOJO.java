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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This is the generic errorVO returned by the service.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ErrorPOJO {

    /** The code. */
    private String code;

    /** The message. */
    private String message;

    /**
     * Instantiates a new error pojo.
     */
    public ErrorPOJO() {
    }

    /**
     * Instantiates a new error pojo.
     *
     * @param code
     *            the code
     * @param message
     *            the message
     */
    public ErrorPOJO(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public final String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code
     *            the code to set
     */
    public final void setCode(final String code) {
        this.code = code;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message
     *            the message to set
     */
    public final void setMessage(final String message) {
        this.message = message;
    }

}
