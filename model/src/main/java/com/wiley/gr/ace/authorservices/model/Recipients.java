/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */

package com.wiley.gr.ace.authorservices.model;


/**
 * The Class Recipients.
 */

public class Recipients {

    /** The recipient id. */
    private String recipientId = "";
    
    private String recipentsName;

    public final String getRecipentsName() {
        return recipentsName;
    }

    public final void setRecipentsName(final String recipentsName) {
        this.recipentsName = recipentsName;
    }

    /**
     * Gets the recipient id.
     *
     * @return the recipient id
     */
    public final String getRecipientId() {
        return recipientId;
    }

    /**
     * Sets the recipient id.
     *
     * @param recipientId
     *            the new recipient id
     */
    public final void setRecipientId(final String recipientId) {
        this.recipientId = recipientId;
    }

}
