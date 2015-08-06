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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class ESBResponse.
 *
 * @author virtusa
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ESBResponse {

    /**
     * attributes.
     */
    private Response response;

    /**
     * Gets the response.
     *
     * @return the response
     */
    public final Response getResponse() {
        return response;
    }

    /**
     * Sets the response.
     *
     * @param response
     *            the response to set
     */
    public final void setResponse(final Response response) {
        this.response = response;
    }

}
