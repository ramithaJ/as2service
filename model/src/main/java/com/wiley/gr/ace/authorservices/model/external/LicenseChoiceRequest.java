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

    /** The user id. */
    private String userId;

    /** The request id. */
    private String requestId;

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
     * @param onlineOpen
     *            the new online open
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
     * @param funders
     *            the new funders
     */
    public final void setFunders(final Funders funders) {
        this.funders = funders;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     *            the requestId to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
