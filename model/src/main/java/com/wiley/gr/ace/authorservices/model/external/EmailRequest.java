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
public class EmailRequest {

    /**
     * This field holds the value of primaryEmail.
     */
    private String primaryEmail;

    /**
     * This field holds the value of recoveryEmail.
     */
    private String recoveryEmail;

    /**
     * This field holds the value of oldEmail.
     */
    private String oldEmail;

    /**
     * @return the primaryEmail
     */
    public final String getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * @param primaryEmail
     *            the primaryEmail to set
     */
    public final void setPrimaryEmail(final String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * @return the recoveryEmail
     */
    public final String getRecoveryEmail() {
        return recoveryEmail;
    }

    /**
     * @param recoveryEmail
     *            the recoveryEmail to set
     */
    public final void setRecoveryEmail(final String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    /**
     * @return the oldEmail
     */
    public final String getOldEmail() {
        return oldEmail;
    }

    /**
     * @param oldEmail
     *            the oldEmail to set
     */
    public final void setOldEmail(final String oldEmail) {
        this.oldEmail = oldEmail;
    }

}
