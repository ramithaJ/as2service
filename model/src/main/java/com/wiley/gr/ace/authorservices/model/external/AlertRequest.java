
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
* 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;


/**
 * The Class AlertRequest.
 * 
 * @author virtusa version 1.0
 */
public class AlertRequest {
    
    /** The preferred email id. */
    private String preferredEmailId;
    
    /** The alert list. */
    private List<PreferenceAlert> alert;
    
    /**
     * Gets the preferred email id.
     *
     * @return the preferred email id
     */
    public final String getPreferredEmailId() {
        return preferredEmailId;
    }
    
    /**
     * Sets the preferred email id.
     *
     * @param preferredEmailId the new preferred email id
     */
    public final void setPreferredEmailId(final String preferredEmailId) {
        this.preferredEmailId = preferredEmailId;
    }

    /**
     * Gets the alert.
     *
     * @return the alert
     */
    public List<PreferenceAlert> getAlert() {
        return alert;
    }

    /**
     * Sets the alert.
     *
     * @param alert the new alert
     */
    public void setAlert(List<PreferenceAlert> alert) {
        this.alert = alert;
    }
    

}
