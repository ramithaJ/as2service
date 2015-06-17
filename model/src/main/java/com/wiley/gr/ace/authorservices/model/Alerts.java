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

import java.util.List;

/**
 * The Class Alerts.
 *
 * @author virtusa
 */
public class Alerts {

    /** The alerts list. */
    private List<Alert> alertsList;

    /** The emails list. */
    private List<String> emailsList;

    /**
     * @return the alertsList
     */
    public final List<Alert> getAlertsList() {
        return alertsList;
    }

    /**
     * @param alertsList
     *            the alertsList to set
     */
    public final void setAlertsList(final List<Alert> alertsList) {
        this.alertsList = alertsList;
    }

    /**
     * @return the emailsList
     */
    public final List<String> getEmailsList() {
        return emailsList;
    }

    /**
     * @param emailsList
     *            the emailsList to set
     */
    public final void setEmailsList(final List<String> emailsList) {
        this.emailsList = emailsList;
    }

}
