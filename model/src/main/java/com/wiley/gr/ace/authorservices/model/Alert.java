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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Alert.
 */
@JsonInclude(Include.NON_NULL)
public class Alert {

    /** The alert id. */
    private String alertId;

    /** The alert name. */
    private String alertName;

    /** The on screen. */
    private boolean onScreen;

    /** The email. */
    private boolean email;

    /**
     * @return the alertId
     */
    public final String getAlertId() {
        return alertId;
    }

    /**
     * @param alertId the alertId to set
     */
    public final void setAlertId(final String alertId) {
        this.alertId = alertId;
    }

    /**
     * @return the alertName
     */
    public final String getAlertName() {
        return alertName;
    }

    /**
     * @param alertName the alertName to set
     */
    public final void setAlertName(final String alertName) {
        this.alertName = alertName;
    }

    /**
     * @return the onScreen
     */
    public final boolean isOnScreen() {
        return onScreen;
    }

    /**
     * @param onScreen the onScreen to set
     */
    public final void setOnScreen(final boolean onScreen) {
        this.onScreen = onScreen;
    }

    /**
     * @return the email
     */
    public final boolean isEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public final void setEmail(final boolean email) {
        this.email = email;
    }

   

}
