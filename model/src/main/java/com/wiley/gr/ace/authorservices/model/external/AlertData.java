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
 * The Class Alert.
 *
 * @author yugandhark
 */
public class AlertData {
    
    
    @JsonProperty("Type")
    private AlertType type;

 
    /** The alert id. */
    @JsonProperty("AlertID")
    private String alertID;

    /** The status. */
    @JsonProperty("Status")
    private String status;
  
    private String id;
    /**
     * Gets the alert id.
     *
     * @return the alert id
     */
    public final String getAlertID() {
        return alertID;
    }

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the alert id.
     *
     * @param alertID the new alert id
     */
    public final void setAlertID(final String alertID) {
        this.alertID = alertID;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return the type
     */
    public final AlertType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public final void setType(AlertType type) {
        this.type = type;
    }

 

}
