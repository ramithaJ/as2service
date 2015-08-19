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
 * The Class LicenseChoiceRequest.
 * 
 * @author virtusa version 1.0
 */
public class LicenseChoiceRequest extends WALSRequest {

    /** The online open. */
    private String onlineOpen;
    
    private String userId;
    
    private String requestId;

    public final String getUserId() {
        return userId;
    }

    public final String getRequestId() {
        return requestId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    /** The funders. */
    private Funders funders;

    /**
     * Gets the online open.
     *
     * @return the online open
     */
    public final String getOnlineOpen() {
        return onlineOpen;
    }

    /**
     * Sets the online open.
     *
     * @param onlineOpen the new online open
     */
    public final void setOnlineOpen(final String onlineOpen) {
        this.onlineOpen = onlineOpen;
    }

    /**
     * Gets the funders.
     *
     * @return the funders
     */
    public final Funders getFunders() {
        return funders;
    }

    /**
     * Sets the funders.
     *
     * @param funders the new funders
     */
    public final void setFunders(final Funders funders) {
        this.funders = funders;
    }

}
