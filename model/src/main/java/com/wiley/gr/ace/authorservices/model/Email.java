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
    private String oldEmailId;

    /**
     * This field holds the value of newEmail
     */
    private String newEmailId;

    /**
     * @return the oldEmailId
     */
    public final String getOldEmailId() {
        return oldEmailId;
    }

    /**
     * @param oldEmailId
     *            the oldEmailId to set
     */
    public final void setOldEmailId(final String oldEmailId) {
        this.oldEmailId = oldEmailId;
    }

    /**
     * @return the newEmailId
     */
    public final String getNewEmailId() {
        return newEmailId;
    }

    /**
     * @param newEmailId
     *            the newEmailId to set
     */
    public final void setNewEmailId(final String newEmailId) {
        this.newEmailId = newEmailId;
    }

}
