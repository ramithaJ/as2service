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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CoAuthor.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CoAuthor implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** The user id. */
    private Integer userId;

    /** The co author id. */
    private String coAuthorId;

    /** The title. */
    private String title;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The email id. */
    private String emailId;

    /** The phone. */
    private String phone;

    /** The institution id. */
    private String institutionId;

    /** The institution name. */
    private String institutionName;

    /**
     * @return the userId
     */
    public final Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the coAuthorId
     */
    public final String getCoAuthorId() {
        return coAuthorId;
    }

    /**
     * @param coAuthorId
     *            the coAuthorId to set
     */
    public final void setCoAuthorId(final String coAuthorId) {
        this.coAuthorId = coAuthorId;
    }

    /**
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
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
     * @return the phone
     */
    public final String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public final void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * @return the institutionId
     */
    public final String getInstitutionId() {
        return institutionId;
    }

    /**
     * @param institutionId
     *            the institutionId to set
     */
    public final void setInstitutionId(final String institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * @return the institutionName
     */
    public final String getInstitutionName() {
        return institutionName;
    }

    /**
     * @param institutionName
     *            the institutionName to set
     */
    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

}
