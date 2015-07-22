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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author yugandhark
 *
 */
public class Affiliation {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("StartDate")
    private String startDate;

    @JsonProperty("EndDate")
    private String endDate;

    @JsonProperty("City")
    private String City;

    @JsonProperty("State")
    private String state;

    @JsonProperty("countryCd")
    private String countryCd;

    @JsonProperty("InstitutionCd")
    private String institutionCd;

    @JsonProperty("InstitutionName")
    private String institutionName;

    @JsonProperty("DepartmentCd")
    private String departmentCd;

    @JsonProperty("DepartmentName")
    private String departmentName;

    @JsonProperty("Status")
    private String status;

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getStartDate() {
        return startDate;
    }

    public final void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public final String getEndDate() {
        return endDate;
    }

    public final void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    public final String getCity() {
        return City;
    }

    public final void setCity(final String city) {
        City = city;
    }

    public final String getState() {
        return state;
    }

    public final void setState(final String state) {
        this.state = state;
    }

    public final String getCountryCd() {
        return countryCd;
    }

    public final void setCountryCd(final String countryCd) {
        this.countryCd = countryCd;
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

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }
}
