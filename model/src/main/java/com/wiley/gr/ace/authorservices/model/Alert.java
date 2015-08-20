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

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Alert.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Alert implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    @NotBlank
    @NotNull
    /** The alert id. */
    private String alertId;
    @NotBlank
    @NotNull
    /** The alert name. */
    private String alertName;

    @NotBlank
    @NotNull
    /** The on screen. */
    private boolean onScreen = false;

    @NotBlank
    @NotNull
    /** The email. */
    private boolean email = false;
    @JsonProperty("Status")
    @NotBlank
    @NotNull
    private String status;

    /**
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets the alert id.
     *
     * @return the alertId
     */
    public final String getAlertId() {
        return alertId;
    }

    /**
     * Sets the alert id.
     *
     * @param alertId
     *            the alertId to set
     */
    public final void setAlertId(final String alertId) {
        this.alertId = alertId;
    }

    /**
     * Gets the alert name.
     *
     * @return the alertName
     */
    public final String getAlertName() {
        return alertName;
    }

    /**
     * Sets the alert name.
     *
     * @param alertName
     *            the alertName to set
     */
    public final void setAlertName(final String alertName) {
        this.alertName = alertName;
    }

    /**
     * Checks if is on screen.
     *
     * @return the onScreen
     */
    public final boolean isOnScreen() {
        return onScreen;
    }

    /**
     * Sets the on screen.
     *
     * @param onScreen
     *            the onScreen to set
     */
    public final void setOnScreen(final boolean onScreen) {
        this.onScreen = onScreen;
    }

    /**
     * Checks if is email.
     *
     * @return the email
     */
    public final boolean isEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the email to set
     */
    public final void setEmail(final boolean email) {
        this.email = email;
    }

}
