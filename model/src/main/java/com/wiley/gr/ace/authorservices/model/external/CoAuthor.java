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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author virtusa version 1.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class CoAuthor {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("InstitutionCd")
    private String institutionCode;

    @JsonProperty("InstitutionName")
    private String instName;

    @JsonProperty("DepartmentCd")
    private String departmentCode;

    @JsonProperty("DepartmentName")
    private String deptName;

    @JsonProperty("PhoneNo")
    private String phoneNo;

    @JsonProperty("Status")
    private String status;

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
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
     * @return the institutionCode
     */
    public final String getInstitutionCode() {
        return institutionCode;
    }

    /**
     * @param institutionCode
     *            the institutionCode to set
     */
    public final void setInstitutionCode(final String institutionCode) {
        this.institutionCode = institutionCode;
    }

    /**
     * @return the instName
     */
    public final String getInstName() {
        return instName;
    }

    /**
     * @param instName
     *            the instName to set
     */
    public final void setInstName(final String instName) {
        this.instName = instName;
    }

    /**
     * @return the departmentCode
     */
    public final String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * @param departmentCode
     *            the departmentCode to set
     */
    public final void setDepartmentCode(final String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /**
     * @return the deptName
     */
    public final String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     *            the deptName to set
     */
    public final void setDeptName(final String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return the phoneNo
     */
    public final String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo
     *            the phoneNo to set
     */
    public final void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

}
