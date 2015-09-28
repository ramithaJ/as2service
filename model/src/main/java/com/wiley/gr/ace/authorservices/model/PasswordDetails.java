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

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class PasswordDetails.
 *
 * @author virtusa version 1.0
 */
public class PasswordDetails {

    /** The user id. */
    private String userId;

    /** The email id. */
    @NotNull
    @NotBlank
    @Email
    private String emailId;

    /** The old password. */
    @NotNull
    @NotBlank
    private String oldPassword;

    /** The new password. */
    @NotNull
    @NotBlank
    private String newPassword;

    /**
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
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

}
