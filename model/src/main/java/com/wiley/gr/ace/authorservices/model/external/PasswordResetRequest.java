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
 * The Class PasswordResetRequest.
 */
public class PasswordResetRequest {

    /** This field holds the value of updateUserSecurityAttributes. */
    @JsonProperty("UpdateUserSecurityAttributes")
    private PasswordReset updateUserSecurityAttributes;

    /**
     * Gets the update user security attributes.
     *
     * @return the updateUserSecurityAttributes
     */
    public final PasswordReset getUpdateUserSecurityAttributes() {
        return updateUserSecurityAttributes;
    }

    /**
     * Sets the update user security attributes.
     *
     * @param updateUserSecurityAttributes            the updateUserSecurityAttributes to set
     */
    public final void setUpdateUserSecurityAttributes(
            final PasswordReset updateUserSecurityAttributes) {
        this.updateUserSecurityAttributes = updateUserSecurityAttributes;
    }

}
