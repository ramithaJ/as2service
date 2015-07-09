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
 * The Class AccessReasons.
 *
 * @author virtusa version 1.0
 */
public class AccessReasons {

    /** The access id. */
    private String accessId;

    /** The access reason. */
    private String accessReason;

    /**
     * Gets the access id.
     *
     * @return the accessId
     */
    public final String getAccessId() {
        return accessId;
    }

    /**
     * Gets the access reason.
     *
     * @return the accessReason
     */
    public final String getAccessReason() {
        return accessReason;
    }

    /**
     * Sets the access reason.
     *
     * @param accessReason
     *            the accessReason to set
     */
    public final void setAccessReason(final String accessReason) {
        this.accessReason = accessReason;
    }

    /**
     * Sets the access id.
     *
     * @param accessId
     *            the accessId to set
     */
    public final void setAccessId(final String accessId) {
        this.accessId = accessId;
    }

}
