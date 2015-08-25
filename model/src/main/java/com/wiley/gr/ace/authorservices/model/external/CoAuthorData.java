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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CoAuthor.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CoAuthorData implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @JsonProperty("Id")
    private String id;

    /** The user id. */
    @JsonProperty("UserId")
    private String userId;

    /** The email id. */
    @JsonProperty("EmailId")
    private String emailId;

    /** The first name. */
    @JsonProperty("FirstName")
    private String firstName;

    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;

    /** The institution code. */
    @JsonProperty("InstitutionCd")
    private String institutionCode;

    /** The inst name. */
    @JsonProperty("InstitutionName")
    private String instName;

    /** The department code. */
    @JsonProperty("DepartmentCd")
    private String departmentCode;

    /** The dept name. */
    @JsonProperty("DepartmentName")
    private String deptName;

    /** The phone no. */
    @JsonProperty("PhoneNo")
    private String phoneNo;

    /** The status. */
    @JsonProperty("Status")
    private String status;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

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
     * Gets the email id.
     *
     * @return the emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the emailId to set
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
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
     * Gets the institution code.
     *
     * @return the institutionCode
     */
    public final String getInstitutionCode() {
        return institutionCode;
    }

    /**
     * Sets the institution code.
     *
     * @param institutionCode
     *            the institutionCode to set
     */
    public final void setInstitutionCode(final String institutionCode) {
        this.institutionCode = institutionCode;
    }

    /**
     * Gets the inst name.
     *
     * @return the instName
     */
    public final String getInstName() {
        return instName;
    }

    /**
     * Sets the inst name.
     *
     * @param instName
     *            the instName to set
     */
    public final void setInstName(final String instName) {
        this.instName = instName;
    }

    /**
     * Gets the department code.
     *
     * @return the departmentCode
     */
    public final String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * Sets the department code.
     *
     * @param departmentCode
     *            the departmentCode to set
     */
    public final void setDepartmentCode(final String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /**
     * Gets the dept name.
     *
     * @return the deptName
     */
    public final String getDeptName() {
        return deptName;
    }

    /**
     * Sets the dept name.
     *
     * @param deptName
     *            the deptName to set
     */
    public final void setDeptName(final String deptName) {
        this.deptName = deptName;
    }

    /**
     * Gets the phone no.
     *
     * @return the phoneNo
     */
    public final String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the phone no.
     *
     * @param phoneNo
     *            the phoneNo to set
     */
    public final void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
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
