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
package com.wiley.gr.ace.authorservices.model;

import java.util.ArrayList;

/**
 * The Class Grant.
 * 
 * @author virtusa version 1.0
 */
public class Grant {

    /** The grant number. */
    private String grantNumber;

    /** The recipients. */
    private ArrayList<GrantRecipients> recipients;

    /**
     * Gets the grant number.
     *
     * @return the grant number
     */
    public final String getGrantNumber() {
        return grantNumber;
    }

    /**
     * Sets the grant number.
     *
     * @param grantNumber the new grant number
     */
    public final void setGrantNumber(final String grantNumber) {
        this.grantNumber = grantNumber;
    }

    /**
     * Gets the recipients.
     *
     * @return the recipients
     */
    public final ArrayList<GrantRecipients> getRecipients() {
        return recipients;
    }

    /**
     * Sets the recipients.
     *
     * @param recipients the new recipients
     */
    public final void setRecipients(final ArrayList<GrantRecipients> recipients) {
        this.recipients = recipients;
    }

}
