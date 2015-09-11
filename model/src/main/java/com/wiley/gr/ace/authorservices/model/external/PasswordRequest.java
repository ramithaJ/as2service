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
 * The Class PasswordRequest.
 */
public class PasswordRequest {

    /** This field holds the value of existingEmail. */
    @JsonProperty("ExistingEmail")
    private String existingEmail;

    /** This field holds the value of existingPassword. */
    @JsonProperty("ExistingPassword")
    private String existingPassword;

    /** This field holds the value of newPassword. */
    @JsonProperty("NewPassword")
    private String newPassword;

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
     * Gets the existing password.
     *
     * @return the existingPassword
     */
    public final String getExistingPassword() {
        return existingPassword;
    }

    /**
     * Sets the existing password.
     *
     * @param existingPassword            the existingPassword to set
     */
    public final void setExistingPassword(final String existingPassword) {
        this.existingPassword = existingPassword;
    }

    /**
     * Gets the new password.
     *
     * @return the newPassword
     */
    public final String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the new password.
     *
     * @param newPassword            the newPassword to set
     */
    public final void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
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
