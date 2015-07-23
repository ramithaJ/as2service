/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Virtusa version1.0
 *
 */
public class ForcefulReset {

    /**
     * This field holds the value of existingEmail
     */
    @JsonProperty("ExistingEmail")
    private String existingEmail;

    /**
     * This field holds the value of newPassword
     */
    @JsonProperty("NewPassword")
    private String newPassword;

    /**
     * This field holds the value of sourceSystem
     */
    @JsonProperty("SourceSystem")
    private String sourceSystem;

    /**
     * @return the existingEmail
     */
    public final String getExistingEmail() {
        return existingEmail;
    }

    /**
     * @param existingEmail
     *            the existingEmail to set
     */
    public final void setExistingEmail(final String existingEmail) {
        this.existingEmail = existingEmail;
    }

    /**
     * @return the newPassword
     */
    public final String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword
     *            the newPassword to set
     */
    public final void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the sourceSystem
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * @param sourceSystem
     *            the sourceSystem to set
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

}
