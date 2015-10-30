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

/**
 * The Class AlertType.
 */
public class AlertType implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The onscreen. */
    private String onScreen;

    /** The email. */
    private String email;

    /**
     * @return the onscreen
     */
    public final String getOnScreen() {
        return onScreen;
    }

    /**
     * @param onscreen
     *            the onscreen to set
     */
    public final void setOnScreen(final String onScreen) {
        this.onScreen = onScreen;
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
