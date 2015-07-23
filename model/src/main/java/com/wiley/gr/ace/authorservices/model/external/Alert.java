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
 * @author yugandhark
 *
 */
public class Alert {

    @JsonProperty("AlertID")
    private String alertID;

    @JsonProperty("Status")
    private String status;

    public final String getAlertID() {
        return alertID;
    }

    public final void setAlertID(final String alertID) {
        this.alertID = alertID;
    }

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

}
