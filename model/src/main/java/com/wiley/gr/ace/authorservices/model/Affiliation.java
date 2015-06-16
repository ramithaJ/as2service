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

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Affiliation.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Affiliation {

    /** The user Id . */
    private String affiliationId;

    /** The user id. */
    private String userId;

    /** The institution id. */
    private String institutionId;

    /** The department id. */
    private String departmentId;

    /**
     * Gets the affiliation id.
     *
     * @return the affiliation id
     */
    public String getAffiliationId() {
        return affiliationId;
    }

    /**
     * Sets the affiliation id.
     *
     * @param affiliationId
     *            the new affiliation id
     */
    public void setAffiliationId(String affiliationId) {
        this.affiliationId = affiliationId;
    }

    /** The department name. */
    private String departmentName;

    /** The visibility. */
    private String visibility;

    /** The type. */
    private String type;

    /** The role title. */
    private String roleTitle;

    /** The city. */
    private String city;

    /** The state code. */
    private String stateCode;

    /** The country code. */
    private String countryCode;

    /** The start date. */
    private Date startDate;

    /** The end date. */
    private Date endDate;

    /** The organization. */
    private Organization organization;

    /** The disambiguated organization. */
    private DisambiguatedOrganization disambiguatedOrganization;

    /**
     * Gets the disambiguated organization.
     *
     * @return the disambiguated organization
     */
    public DisambiguatedOrganization getDisambiguatedOrganization() {
        return disambiguatedOrganization;
    }

    /**
     * Sets the disambiguated organization.
     *
     * @param disambiguatedOrganization
     *            the new disambiguated organization
     */
    public void setDisambiguatedOrganization(
            DisambiguatedOrganization disambiguatedOrganization) {
        this.disambiguatedOrganization = disambiguatedOrganization;
    }

    /**
     * Gets the organization.
     *
     * @return the organization
     */
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the organization.
     *
     * @param organization
     *            the new organization
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    /**
     * Gets the visibility.
     *
     * @return the visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility.
     *
     * @param visibility
     *            the new visibility
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type
     *            the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the role title.
     *
     * @return the role title
     */
    public String getRoleTitle() {
        return roleTitle;
    }

    /**
     * Sets the role title.
     *
     * @param roleTitle
     *            the new role title
     */
    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
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

    /**
     * Gets the user Id.
     *
     * @return the user Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user Id.
     *
     * @param userId
     *            the new user id
     * @return the user Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *            the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state code.
     *
     * @return the state code
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Sets the state code.
     *
     * @param stateCode
     *            the new state code
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode
     *            the new country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate
     *            the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate
     *            the new end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
