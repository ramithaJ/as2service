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
 * The Class UserSecurityAttributes.
 *
 * @author Virtusa version1.0
 */
public class UserSecurityAttributes {

    /** This field holds the value of existingEmail. */
    @JsonProperty("ExistingEmail")
    private String existingEmail;

    /** This field holds the value of newEmail. */
    @JsonProperty("NewEmail")
    private String newEmail;

    /** This field holds the value of sourceSystem. */
    @JsonProperty("SourceSystem")
    private String sourceSystem;

    /**
     * Gets the existing email.
     *
     * @return the existingEmail
     */
    public final String getExistingEmail() {
        return existingEmail;
    }

    /**
     * Sets the existing email.
     *
     * @param existingEmail            the existingEmail to set
     */
    public final void setExistingEmail(final String existingEmail) {
        this.existingEmail = existingEmail;
    }

    /**
     * Gets the new email.
     *
     * @return the newEmail
     */
    public final String getNewEmail() {
        return newEmail;
    }

    /**
     * Sets the new email.
     *
     * @param newEmail            the newEmail to set
     */
    public final void setNewEmail(final String newEmail) {
        this.newEmail = newEmail;
    }

    /**
     * Gets the source system.
     *
     * @return the sourceSystem
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * Sets the source system.
     *
     * @param sourceSystem            the sourceSystem to set
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }
}
