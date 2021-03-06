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
package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class NotificationHistoryData.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class NotificationHistory {

    /** The notifications. */
    @JsonProperty("payload")
    private List<Notifications> notifications;

    /**
     * Gets the notifications.
     *
     * @return the notifications
     */
    public final List<Notifications> getNotifications() {
        return notifications;
    }

    /**
     * Sets the notifications.
     *
     * @param notifications
     *            the new notifications
     */
    public final void setNotifications(final List<Notifications> notifications) {
        this.notifications = notifications;
    }

}
