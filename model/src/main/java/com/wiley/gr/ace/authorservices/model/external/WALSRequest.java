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

/**
 * The Class WALSRequest.
 * 
 * @author virtusa version 1.0
 */
public class WALSRequest {

    /** The request created timestamp. */
    private String requestCreatedTimestamp;

    /** The dh id. */
    private String dhId;

    /**
     * Gets the request created timestamp.
     *
     * @return the request created timestamp
     */
    public final String getRequestCreatedTimestamp() {
        return requestCreatedTimestamp;
    }

    /**
     * Sets the request created timestamp.
     *
     * @param requestCreatedTimestamp the new request created timestamp
     */
    public final void setRequestCreatedTimestamp(final String requestCreatedTimestamp) {
        this.requestCreatedTimestamp = requestCreatedTimestamp;
    }

    /**
     * Gets the dh id.
     *
     * @return the dh id
     */
    public final String getDhId() {
        return dhId;
    }

    /**
     * Sets the dh id.
     *
     * @param dhId the new dh id
     */
    public final void setDhId(final String dhId) {
        this.dhId = dhId;
    }
}
