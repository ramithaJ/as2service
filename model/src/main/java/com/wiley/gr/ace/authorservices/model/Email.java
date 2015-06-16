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

    /** The old email id. */
    private String oldEmailId;

    /** The new email id. */
    private String newEmailId;

    /**
     * Gets the old email id.
     *
     * @return the old email id
     */
    public String getOldEmailId() {
        return oldEmailId;
    }

    /**
     * Sets the old email id.
     *
     * @param oldEmailId
     *            the new old email id
     */
    public void setOldEmailId(String oldEmailId) {
        this.oldEmailId = oldEmailId;
    }

    /**
     * Gets the new email id.
     *
     * @return the new email id
     */
    public String getNewEmailId() {
        return newEmailId;
    }

    /**
     * Sets the new email id.
     *
     * @param newEmailId
     *            the new new email id
     */
    public void setNewEmailId(String newEmailId) {
        this.newEmailId = newEmailId;
    }

}
