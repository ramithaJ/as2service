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
 * The Class OrderPaymentStatus.
 *
 * @author yugandhark
 */
public class OrderPaymentStatus {

    /** The open access status. */
    private String openAccessStatus;

    /** The online open status. */
    private String onlineOpenStatus;

    /**
     * Gets the open access status.
     *
     * @return the open access status
     */
    public String getOpenAccessStatus() {
        return openAccessStatus;
    }

    /**
     * Sets the open access status.
     *
     * @param openAccessStatus
     *            the new open access status
     */
    public void setOpenAccessStatus(String openAccessStatus) {
        this.openAccessStatus = openAccessStatus;
    }

    /**
     * Gets the online open status.
     *
     * @return the online open status
     */
    public String getOnlineOpenStatus() {
        return onlineOpenStatus;
    }

    /**
     * Sets the online open status.
     *
     * @param onlineOpenStatus
     *            the new online open status
     */
    public void setOnlineOpenStatus(String onlineOpenStatus) {
        this.onlineOpenStatus = onlineOpenStatus;
    }
}
