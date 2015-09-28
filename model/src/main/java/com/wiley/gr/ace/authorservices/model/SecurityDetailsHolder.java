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

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SecurityDetailsHolder.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class SecurityDetailsHolder {

    /** The email id. */
    @NotNull
    @NotEmpty
    private String emailId;

    /** The security details. */
    private List<SecurityDetails> securityDetails = new ArrayList<SecurityDetails>();

    /** The password. */
    private String oldPassword;

    /**
     * This field holds the value of password.
     */
    private String password;

    /** The is force reset. */
    @JsonProperty
    private boolean isForceReset;

    /**
     * Gets the email id.
     *
     * @return the emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the emailId to set
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the security details.
     *
     * @return the securityDetails
     */
    public final List<SecurityDetails> getSecurityDetails() {
        return securityDetails;
    }

    /**
     * Sets the security details.
     *
     * @param securityDetails
     *            the securityDetails to set
     */
    public final void setSecurityDetails(
            final List<SecurityDetails> securityDetails) {
        this.securityDetails = securityDetails;
    }

    /**
     * @return the oldPassword
     */
    public final String getOldPassword() {
        return oldPassword;
    }

    /**
     * @param oldPassword
     *            the oldPassword to set
     */
    public final void setOldPassword(final String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Checks if is force reset.
     *
     * @return the isForceReset
     */
    public final boolean isForceReset() {
        return isForceReset;
    }

    /**
     * Sets the force reset.
     *
     * @param isForceReset
     *            the isForceReset to set
     */
    public final void setForceReset(final boolean isForceReset) {
        this.isForceReset = isForceReset;
    }

}
