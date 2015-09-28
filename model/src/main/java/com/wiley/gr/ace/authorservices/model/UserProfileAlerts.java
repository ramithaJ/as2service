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

/**
 * The Class UserProfileAlerts.
 *
 * @author virtusa
 */
public class UserProfileAlerts {

    /** The alerts. */
    private Alerts alerts;

    /**
     * @return the alerts
     */
    public final Alerts getAlerts() {
        return alerts;
    }

    /**
     * @param alerts
     *            the alerts to set
     */
    public final void setAlerts(final Alerts alerts) {
        this.alerts = alerts;
    }

}
