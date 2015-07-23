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
 * The Class Affiliation.
 *
 * @author yugandhark
 */
public class Affiliation {

    /** The id. */
    @JsonProperty("Id")
    private String id;

    /** The start date. */
    @JsonProperty("StartDate")
    private String startDate;

    /** The end date. */
    @JsonProperty("EndDate")
    private String endDate;

    /** The City. */
    @JsonProperty("City")
    private String City;

    /** The state. */
    @JsonProperty("State")
    private String state;

    /** The country cd. */
    @JsonProperty("countryCd")
    private String countryCd;

    /** The institution cd. */
    @JsonProperty("InstitutionCd")
    private String institutionCd;

    /** The institution name. */
    @JsonProperty("InstitutionName")
    private String institutionName;

    /** The department cd. */
    @JsonProperty("DepartmentCd")
    private String departmentCd;

    /** The department name. */
    @JsonProperty("DepartmentName")
    private String departmentName;

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
     * @param id the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public final String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public final void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public final String getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public final void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public final String getCity() {
        return City;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public final void setCity(final String city) {
        City = city;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public final String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the new state
     */
    public final void setState(final String state) {
        this.state = state;
    }

    /**
     * Gets the country cd.
     *
     * @return the country cd
     */
    public final String getCountryCd() {
        return countryCd;
    }

    /**
     * Sets the country cd.
     *
     * @param countryCd the new country cd
     */
    public final void setCountryCd(final String countryCd) {
        this.countryCd = countryCd;
    }

    /**
     * Gets the institution cd.
     *
     * @return the institution cd
     */
    public final String getInstitutionCd() {
        return institutionCd;
    }

    /**
     * Sets the institution cd.
     *
     * @param institutionCd the new institution cd
     */
    public final void setInstitutionCd(final String institutionCd) {
        this.institutionCd = institutionCd;
    }

    /**
     * Gets the institution name.
     *
     * @return the institution name
     */
    public final String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the institution name.
     *
     * @param institutionName the new institution name
     */
    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * Gets the department cd.
     *
     * @return the department cd
     */
    public final String getDepartmentCd() {
        return departmentCd;
    }

    /**
     * Sets the department cd.
     *
     * @param departmentCd the new department cd
     */
    public final void setDepartmentCd(final String departmentCd) {
        this.departmentCd = departmentCd;
    }

    /**
     * Gets the department name.
     *
     * @return the department name
     */
    public final String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the department name.
     *
     * @param departmentName the new department name
     */
    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
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
     * @param status the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }
}
