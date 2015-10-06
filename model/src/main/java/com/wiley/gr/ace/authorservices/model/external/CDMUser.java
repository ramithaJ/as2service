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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CDMUser.
 */
public class CDMUser {

    /** The send email. */
    @JsonProperty("SendEmail")
    private String sendEmail;

    /** The user role. */
    @JsonProperty("UserRole")
    private String userRole;

    /** The as id. */
    @JsonProperty("ASID")
    private String asId;

    /** The first name. */
    @JsonProperty("FirstName")
    private String firstName;

    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;

    /** The registrant flag. */
    @JsonProperty("RegistrantFlag")
    private String registrantFlag;

    /** The author flag. */
    @JsonProperty("AuthorFlag")
    private String authorFlag;

    /** The source system. */
    @JsonProperty("SourceSystem")
    private String sourceSystem;

    /** The primary email. */
    @JsonProperty("PrimaryEmail")
    private String primaryEmail;

    /**
     * Gets the send email.
     *
     * @return the send email
     */
    public final String getSendEmail() {
        return sendEmail;
    }

    /**
     * Sets the send email.
     *
     * @param sendEmail
     *            the new send email
     */
    public final void setSendEmail(final String sendEmail) {
        this.sendEmail = sendEmail;
    }

    /**
     * Gets the user role.
     *
     * @return the user role
     */
    public final String getUserRole() {
        return userRole;
    }

    /**
     * Sets the user role.
     *
     * @param userRole
     *            the new user role
     */
    public final void setUserRole(final String userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets the as id.
     *
     * @return the as id
     */
    public final String getAsId() {
        return asId;
    }

    /**
     * Sets the as id.
     *
     * @param asId
     *            the new as id
     */
    public final void setAsId(final String asId) {
        this.asId = asId;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the registrant flag.
     *
     * @return the registrant flag
     */
    public final String getRegistrantFlag() {
        return registrantFlag;
    }

    /**
     * Sets the registrant flag.
     *
     * @param registrantFlag
     *            the new registrant flag
     */
    public final void setRegistrantFlag(final String registrantFlag) {
        this.registrantFlag = registrantFlag;
    }

    /**
     * Gets the author flag.
     *
     * @return the author flag
     */
    public final String getAuthorFlag() {
        return authorFlag;
    }

    /**
     * Sets the author flag.
     *
     * @param authorFlag
     *            the new author flag
     */
    public final void setAuthorFlag(final String authorFlag) {
        this.authorFlag = authorFlag;
    }

    /**
     * Gets the source system.
     *
     * @return the source system
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * Sets the source system.
     *
     * @param sourceSystem
     *            the new source system
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    /**
     * Gets the primary email.
     *
     * @return the primary email
     */
    public final String getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * Sets the primary email.
     *
     * @param primaryEmail
     *            the new primary email
     */
    public final void setPrimaryEmail(final String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }
}
