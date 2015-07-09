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

/**
 * The Class AlertElement.
 * 
 * @author virtusa version 1.0
 */
public class AlertElement {

    /** The alertid. */
    private String alertid;

    /** The type. */
    private String type;

    /**
     * Gets the alertid.
     *
     * @return the alertid
     */
    public final String getAlertid() {
        return alertid;
    }

    /**
     * Sets the alertid.
     *
     * @param alertid
     *            the alertid to set
     */
    public final void setAlertid(final String alertid) {
        this.alertid = alertid;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type
     *            the type to set
     */
    public final void setType(final String type) {
        this.type = type;
    }

}
