/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
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

/**
 * @author virtusa version 1.0
 *
 */
public class EntityValue {

    /**
     * This field holds the value of profile.
     */
    private ProfileRequest profile;

    /**
     * This field holds the value of email.
     */
    private EmailRequest email;

    /**
     * @return the email
     */
    public final EmailRequest getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public final void setEmail(final EmailRequest email) {
        this.email = email;
    }

    /**
     * @return the profile
     */
    public final ProfileRequest getProfile() {
        return profile;
    }

    /**
     * @param profile
     *            the profile to set
     */
    public final void setProfile(final ProfileRequest profile) {
        this.profile = profile;
    }

}
