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
     * @return the openAccessStatus
     */
    public final String getOpenAccessStatus() {
        return openAccessStatus;
    }

    /**
     * @param openAccessStatus
     *            the openAccessStatus to set
     */
    public final void setOpenAccessStatus(final String openAccessStatus) {
        this.openAccessStatus = openAccessStatus;
    }

    /**
     * @return the onlineOpenStatus
     */
    public final String getOnlineOpenStatus() {
        return onlineOpenStatus;
    }

    /**
     * @param onlineOpenStatus
     *            the onlineOpenStatus to set
     */
    public final void setOnlineOpenStatus(final String onlineOpenStatus) {
        this.onlineOpenStatus = onlineOpenStatus;
    }

}
