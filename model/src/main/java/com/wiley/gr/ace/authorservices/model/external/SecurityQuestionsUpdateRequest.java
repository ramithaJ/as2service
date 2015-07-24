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
public class SecurityQuestionsUpdateRequest {

    /** This field holds the value of existingEmail. */
    @JsonProperty("ExistingEmail")
    private String Email;

    /** This field holds the value of newPassword. */
    @JsonProperty("ExistingPassword")
    private String Password;

    /** This field holds the value of sourceSystem. */
    @JsonProperty("SourceSystem")
    private String sSystem;

    /** This field holds the value of userSecurityQuestions. */
    @JsonProperty("UserSecurityQuestions")
    private UserSecurityQuestions userSecurityQuestions;

    /**
     * @return the email
     */
    public final String getEmail() {
        return Email;
    }

    /**
     * @param email
     *            the email to set
     */
    public final void setEmail(final String email) {
        Email = email;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return Password;
    }

    /**
     * @param password
     *            the password to set
     */
    public final void setPassword(final String password) {
        Password = password;
    }

    /**
     * @return the sSystem
     */
    public final String getsSystem() {
        return sSystem;
    }

    /**
     * @param sSystem
     *            the sSystem to set
     */
    public final void setsSystem(final String sSystem) {
        this.sSystem = sSystem;
    }

    /**
     * @return the userSecurityQuestions
     */
    public final UserSecurityQuestions getUserSecurityQuestions() {
        return userSecurityQuestions;
    }

    /**
     * @param userSecurityQuestions
     *            the userSecurityQuestions to set
     */
    public final void setUserSecurityQuestions(
            final UserSecurityQuestions userSecurityQuestions) {
        this.userSecurityQuestions = userSecurityQuestions;
    }

}
