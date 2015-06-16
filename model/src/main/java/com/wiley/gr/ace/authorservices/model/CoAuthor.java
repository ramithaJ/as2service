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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CoAuthor.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CoAuthor {

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
     * Gets the co author id.
     *
     * @return the co author id
     */
    public String getCoAuthorId() {
        return coAuthorId;
    }

    /**
     * Sets the co author id.
     *
     * @param coAuthorId
     *            the new co author id
     */
    public void setCoAuthorId(String coAuthorId) {
        this.coAuthorId = coAuthorId;
    }

    /** The department id. */
    private String departmentId;

    /** The department name. */
    private String departmentName;

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the new email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone
     *            the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the institution id.
     *
     * @return the institution id
     */
    public String getInstitutionId() {
        return institutionId;
    }

    /**
     * Sets the institution id.
     *
     * @param institutionId
     *            the new institution id
     */
    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * Gets the institution name.
     *
     * @return the institution name
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the institution name.
     *
     * @param institutionName
     *            the new institution name
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * Gets the department id.
     *
     * @return the department id
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the department id.
     *
     * @param departmentId
     *            the new department id
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets the department name.
     *
     * @return the department name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the department name.
     *
     * @param departmentName
     *            the new department name
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
