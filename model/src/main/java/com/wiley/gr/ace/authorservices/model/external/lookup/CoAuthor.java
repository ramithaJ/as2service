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
package com.wiley.gr.ace.authorservices.model.external.lookup;

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
    private String institutionCd;

    @JsonProperty("InstitutionName")
    private String institutionName;

    @JsonProperty("DepartmentCd")
    private String departmentCd;

    @JsonProperty("DepartmentName")
    private String departmentName;

    @JsonProperty("PhoneNo")
    private String phoneNo;

    @JsonProperty("Status")
    private String status;

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final String getEmailId() {
        return emailId;
    }

    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getInstitutionCd() {
        return institutionCd;
    }

    public final void setInstitutionCd(final String institutionCd) {
        this.institutionCd = institutionCd;
    }

    public final String getInstitutionName() {
        return institutionName;
    }

    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    public final String getDepartmentCd() {
        return departmentCd;
    }

    public final void setDepartmentCd(final String departmentCd) {
        this.departmentCd = departmentCd;
    }

    public final String getDepartmentName() {
        return departmentName;
    }

    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    public final String getPhoneNo() {
        return phoneNo;
    }

    public final void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

}
