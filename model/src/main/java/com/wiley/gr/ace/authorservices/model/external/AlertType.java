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

package com.wiley.gr.ace.authorservices.model.external;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AlertType.
 */
public class AlertType implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The onscreen. */
    @JsonProperty("OnScreen")
    private String onscreen;

    /** The email. */
    @JsonProperty("Email")
    private String email;

    /**
     * @return the onscreen
     */
    public final String getOnscreen() {
        return onscreen;
    }

    /**
     * @param onscreen
     *            the onscreen to set
     */
    public final void setOnscreen(final String onscreen) {
        this.onscreen = onscreen;
    }

    /**
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public final void setEmail(final String email) {
        this.email = email;
    }
}
