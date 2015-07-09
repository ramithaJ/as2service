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
 * The Class InviteRecords.
 * 
 * @author virtusa version 1.0
 */
public class InviteRecords {

    /** The guid. */
    private String guid;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The email address. */
    private String emailAddress;

    /** The user type. */
    private String userType;

    /** The status. */
    private String status;

    /**
     * Gets the guid.
     *
     * @return the guid
     */
    public final String getGuid() {
        return guid;
    }

    /**
     * Sets the guid.
     *
     * @param guid
     *            the guid to set
     */
    public final void setGuid(final String guid) {
        this.guid = guid;
    }

    /**
     * Gets the first name.
     *
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the firstName to set
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the lastName to set
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address.
     *
     * @return the emailAddress
     */
    public final String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address.
     *
     * @param emailAddress
     *            the emailAddress to set
     */
    public final void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the user type.
     *
     * @return the userType
     */
    public final String getUserType() {
        return userType;
    }

    /**
     * Sets the user type.
     *
     * @param userType
     *            the userType to set
     */
    public final void setUserType(final String userType) {
        this.userType = userType;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the status to set
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

}
