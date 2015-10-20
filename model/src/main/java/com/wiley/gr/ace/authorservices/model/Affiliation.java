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

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Affiliation.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Affiliation implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The affiliation id. */
    @NotBlank
    @NotNull
    /** The user Id . */
    private String affiliationId;

    /** The user id. */
    @NotBlank
    @NotNull
    /** The user id. */
    private String userId;

    /** The institution id. */
    @NotBlank
    @NotNull
    /** The institution id. */
    private String institutionId;

    /** The institution name. */
    @NotBlank
    @NotNull
    /** The institution name. */
    private String institutionName;

    /** The id. */
    @NotBlank
    @NotNull
    private String id;

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

    /** The country. */
    private Country country;

    /** The state. */
    private String state;

    /** The department id. */
    private String departmentId;

    /** The start date. */
    private String startDate;

    /** The end date. */
    private String endDate;

    /** The organization. */
    private Organization organization;

    /** The disambiguated organization. */
    private DisambiguatedOrganization disambiguatedOrganization;

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
     * Gets the institution name.
     *
     * @return the institutionName
     */
    public final String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the institution name.
     *
     * @param institutionName
     *            the institutionName to set
     */
    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * Gets the affiliation id.
     *
     * @return the affiliation id
     */
    public final String getAffiliationId() {
        return affiliationId;
    }

    /**
     * Sets the affiliation id.
     *
     * @param affiliationId
     *            the new affiliation id
     */
    public final void setAffiliationId(final String affiliationId) {
        this.affiliationId = affiliationId;
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
     * @param state
     *            the state to set
     */
    public final void setState(final String state) {
        this.state = state;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
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
     * Gets the institution id.
     *
     * @return the institutionId
     */
    public final String getInstitutionId() {
        return institutionId;
    }

    /**
     * Sets the institution id.
     *
     * @param institutionId
     *            the institutionId to set
     */
    public final void setInstitutionId(final String institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * Gets the department id.
     *
     * @return the departmentId
     */
    public final String getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the department id.
     *
     * @param departmentId
     *            the departmentId to set
     */
    public final void setDepartmentId(final String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets the department name.
     *
     * @return the departmentName
     */
    public final String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the department name.
     *
     * @param departmentName
     *            the departmentName to set
     */
    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets the visibility.
     *
     * @return the visibility
     */
    public final String getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility.
     *
     * @param visibility
     *            the visibility to set
     */
    public final void setVisibility(final String visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type
     *            the type to set
     */
    public final void setType(final String type) {
        this.type = type;
    }

    /**
     * Gets the role title.
     *
     * @return the roleTitle
     */
    public final String getRoleTitle() {
        return roleTitle;
    }

    /**
     * Sets the role title.
     *
     * @param roleTitle
     *            the roleTitle to set
     */
    public final void setRoleTitle(final String roleTitle) {
        this.roleTitle = roleTitle;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public final Country getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country
     *            the country to set
     */
    public final void setCountry(final Country country) {
        this.country = country;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public final String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *            the city to set
     */
    public final void setCity(final String city) {
        this.city = city;
    }

    /**
     * Gets the state code.
     *
     * @return the stateCode
     */
    public final String getStateCode() {
        return stateCode;
    }

    /**
     * Sets the state code.
     *
     * @param stateCode
     *            the stateCode to set
     */
    public final void setStateCode(final String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * Gets the country code.
     *
     * @return the countryCode
     */
    public final String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode
     *            the countryCode to set
     */
    public final void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the start date.
     *
     * @return the startDate
     */
    public final String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param date
     *            the startDate to set
     */
    public final void setStartDate(final String date) {
        this.startDate = date;
    }

    /**
     * Gets the end date.
     *
     * @return the endDate
     */
    public final String getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate
     *            the endDate to set
     */
    public final void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the organization.
     *
     * @return the organization
     */
    public final Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the organization.
     *
     * @param organization
     *            the organization to set
     */
    public final void setOrganization(final Organization organization) {
        this.organization = organization;
    }

    /**
     * Gets the disambiguated organization.
     *
     * @return the disambiguatedOrganization
     */
    public final DisambiguatedOrganization getDisambiguatedOrganization() {
        return disambiguatedOrganization;
    }

    /**
     * Sets the disambiguated organization.
     *
     * @param disambiguatedOrganization
     *            the disambiguatedOrganization to set
     */
    public final void setDisambiguatedOrganization(
            final DisambiguatedOrganization disambiguatedOrganization) {
        this.disambiguatedOrganization = disambiguatedOrganization;
    }

}
