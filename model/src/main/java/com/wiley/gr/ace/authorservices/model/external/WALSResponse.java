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
 * The Class WALSResponse.
 * 
 * @author virtusa version 1.0
 */
public class WALSResponse {

    /** The dh id. */
    @JsonProperty("DH_ID")
    private String dhID;

    /** The response code. */
    private String responseCode;

    /** The response description. */
    private String responseDescription;

    /**
     * Gets the dh id.
     *
     * @return the dh id
     */
    public final String getDhID() {
        return dhID;
    }

    /**
     * Sets the dh id.
     *
     * @param dhID the new dh id
     */
    public final void setDhID(final String dhID) {
        this.dhID = dhID;
    }

    /**
     * Gets the response code.
     *
     * @return the response code
     */
    public final String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code.
     *
     * @param responseCode the new response code
     */
    public final void setResponseCode(final String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Gets the response description.
     *
     * @return the response description
     */
    public final String getResponseDescription() {
        return responseDescription;
    }

    /**
     * Sets the response description.
     *
     * @param responseDescription the new response description
     */
    public final void setResponseDescription(final String responseDescription) {
        this.responseDescription = responseDescription;
    }
}
