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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ErrorResponse.
 *
 * @author Virtusa version1.0
 */
public class ErrorResponse implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /** This field holds the value of error. */
    @JsonProperty("Error")
    protected ErrorPayLoad error;

    /**
     * Gets the error.
     *
     * @return the error
     */
    public final ErrorPayLoad getError() {
        return error;
    }

    /**
     * Sets the error.
     *
     * @param error
     *            the error to set
     */
    public final void setError(final ErrorPayLoad error) {
        this.error = error;
    }

}
