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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AlertType.
 */
public class AlertType {

    /** The onscreen. */
    @JsonProperty("OnScreen")
    private boolean onscreen;
    
    /** The email. */
    @JsonProperty("Email")
    private boolean email;

    /**
     * @return the onscreen
     */
    public final boolean isOnscreen() {
        return onscreen;
    }

    /**
     * @return the email
     */
    public final boolean isEmail() {
        return email;
    }

    /**
     * @param onscreen the onscreen to set
     */
    public final void setOnscreen(final boolean onscreen) {
        this.onscreen = onscreen;
    }

    /**
     * @param email the email to set
     */
    public final void setEmail(final boolean email) {
        this.email = email;
    }

   
}
