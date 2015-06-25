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
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Affiliation.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Affiliation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** The user Id . */
    private String affiliationId;

    /** The user id. */
    private int userId;

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
    public void setAffiliationId(final String affiliationId) {
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
     * @return the userId
     */
    public final int getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final int userId) {
        this.userId = userId;
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
     * @return the departmentId
     */
    public final String getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     *            the departmentId to set
     */
    public final void setDepartmentId(final String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the departmentName
     */
    public final String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName
     *            the departmentName to set
     */
    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the visibility
     */
    public final String getVisibility() {
        return visibility;
    }

    /**
     * @param visibility
     *            the visibility to set
     */
    public final void setVisibility(final String visibility) {
        this.visibility = visibility;
    }

    /**
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public final void setType(final String type) {
        this.type = type;
    }

    /**
     * @return the roleTitle
     */
    public final String getRoleTitle() {
        return roleTitle;
    }

    /**
     * @param roleTitle
     *            the roleTitle to set
     */
    public final void setRoleTitle(final String roleTitle) {
        this.roleTitle = roleTitle;
    }

    /**
     * @return the city
     */
    public final String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public final void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return the stateCode
     */
    public final String getStateCode() {
        return stateCode;
    }

    /**
     * @param stateCode
     *            the stateCode to set
     */
    public final void setStateCode(final String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * @return the countryCode
     */
    public final String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode
     *            the countryCode to set
     */
    public final void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the startDate
     */
    public final Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public final void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public final Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public final void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the organization
     */
    public final Organization getOrganization() {
        return organization;
    }

    /**
     * @param organization
     *            the organization to set
     */
    public final void setOrganization(final Organization organization) {
        this.organization = organization;
    }

    /**
     * @return the disambiguatedOrganization
     */
    public final DisambiguatedOrganization getDisambiguatedOrganization() {
        return disambiguatedOrganization;
    }

    /**
     * @param disambiguatedOrganization
     *            the disambiguatedOrganization to set
     */
    public final void setDisambiguatedOrganization(
            final DisambiguatedOrganization disambiguatedOrganization) {
        this.disambiguatedOrganization = disambiguatedOrganization;
    }

}
