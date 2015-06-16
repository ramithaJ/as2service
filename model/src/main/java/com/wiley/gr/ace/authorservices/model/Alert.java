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
     * Gets the alert id.
     *
     * @return the alert id
     */
    public String getAlertId() {
        return alertId;
    }

    /**
     * Sets the alert id.
     *
     * @param alertId
     *            the new alert id
     */
    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    /**
     * Gets the alert name.
     *
     * @return the alert name
     */
    public String getAlertName() {
        return alertName;
    }

    /**
     * Sets the alert name.
     *
     * @param alertName
     *            the new alert name
     */
    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    /**
     * Checks if is on screen.
     *
     * @return true, if is on screen
     */
    public boolean isOnScreen() {
        return onScreen;
    }

    /**
     * Sets the on screen.
     *
     * @param onScreen
     *            the new on screen
     */
    public void setOnScreen(boolean onScreen) {
        this.onScreen = onScreen;
    }

    /**
     * Checks if is email.
     *
     * @return true, if is email
     */
    public boolean isEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the new email
     */
    public void setEmail(boolean email) {
        this.email = email;
    }

}
