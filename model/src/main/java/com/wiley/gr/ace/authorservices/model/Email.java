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
package com.wiley.gr.ace.authorservices.model;

/**
 * The Class Email.
 *
 * @author virtusa version 1.0
 */
public class Email {

    /**
     * This field holds the value of existingEmail
     */
    private String existingEmail;

    /**
     * This field holds the value of newEmail
     */
    private String newEmail;

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
     * @return the newEmail
     */
    public final String getNewEmail() {
        return newEmail;
    }

    /**
     * @param newEmail
     *            the newEmail to set
     */
    public final void setNewEmail(final String newEmail) {
        this.newEmail = newEmail;
    }

}
