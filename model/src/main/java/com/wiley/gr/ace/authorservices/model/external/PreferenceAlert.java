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

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class PreferenceAlert.
 * 
 * @author virtusa version 1.0
 */
public class PreferenceAlert {
    
    /** The preference key. */
    @JsonProperty("prefereceKey")
    private String preferenceKey;
    
    /** The alert type. */
    private AlertType alertType;
    

    /**
     * Gets the preference key.
     *
     * @return the preference key
     */
    public final String getPreferenceKey() {
        return preferenceKey;
    }

    /**
     * Sets the preference key.
     *
     * @param preferenceKey the new preference key
     */
    public final void setPreferenceKey(final String preferenceKey) {
        this.preferenceKey = preferenceKey;
    }

    /**
     * Gets the alert type.
     *
     * @return the alert type
     */
    public final AlertType getAlertType() {
        return alertType;
    }

    /**
     * Sets the alert type.
     *
     * @param alertType the new alert type
     */
    public final void setAlertType(final AlertType alertType) {
        this.alertType = alertType;
    }

 
}
