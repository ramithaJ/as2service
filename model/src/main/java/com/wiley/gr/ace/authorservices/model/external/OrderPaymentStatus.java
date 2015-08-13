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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class OrderPaymentStatus.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class OrderPaymentStatus {

    /** The open access status. */
    private String openAccessStatus;

    /** The online open status. */
    private String onlineOpenStatus;

    /**
     * This field holds the value of availableActions.
     */
    private String availableActions;

    /**
     * @return the availableActions
     */
    public final String getAvailableActions() {
        return availableActions;
    }

    /**
     * @param availableActions
     *            the availableActions to set
     */
    public final void setAvailableActions(final String availableActions) {
        this.availableActions = availableActions;
    }

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
