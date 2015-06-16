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
    private String password;

    /** The is force reset. */
    @JsonProperty
    private boolean isForceReset;

    /**
     * Gets the security details.
     *
     * @return the security details
     */
    public List<SecurityDetails> getSecurityDetails() {
        return securityDetails;
    }

    /**
     * Sets the security details.
     *
     * @param securityDetails
     *            the new security details
     */
    public void setSecurityDetails(List<SecurityDetails> securityDetails) {
        this.securityDetails = securityDetails;
    }

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the new email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if is force reset.
     *
     * @return true, if is force reset
     */
    public boolean isForceReset() {
        return isForceReset;
    }

    /**
     * Sets the force reset.
     *
     * @param isForceReset
     *            the new force reset
     */
    public void setForceReset(boolean isForceReset) {
        this.isForceReset = isForceReset;
    }

}
