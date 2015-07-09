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

/**
 * The Class SharedServieRequest.
 *
 * @author virtusa version 1.0
 */
public class SharedServieRequest {

    /** The user id. */
    private String userId;

    /** The password. */
    private String password;

    /** The authentication type. */
    private String authenticationType;

    /** The app key. */
    private String appKey;

    /**
     * Gets the user id.
     *
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the authentication type.
     *
     * @return the authenticationType
     */
    public final String getAuthenticationType() {
        return authenticationType;
    }

    /**
     * Sets the authentication type.
     *
     * @param authenticationType
     *            the authenticationType to set
     */
    public final void setAuthenticationType(final String authenticationType) {
        this.authenticationType = authenticationType;
    }

    /**
     * Gets the app key.
     *
     * @return the appKey
     */
    public final String getAppKey() {
        return appKey;
    }

    /**
     * Sets the app key.
     *
     * @param appKey
     *            the appKey to set
     */
    public final void setAppKey(final String appKey) {
        this.appKey = appKey;
    }

}
