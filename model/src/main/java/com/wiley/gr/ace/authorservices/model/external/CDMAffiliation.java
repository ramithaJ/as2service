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

package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class CDMAffiliation.
 */
public class CDMAffiliation {

    /** The institution id. */
    private String institutionId;

    /** The institution name. */
    private String institutionName;

    /** The department id. */
    private String departmentId;

    /** The department name. */
    private String departmentName;

    /** The city. */
    private String city;

    /** The country code. */
    private String countryCode;

    /** The country name. */
    private String countryName;

    /** The affiliation id. */
    private String affiliationId;

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
     * @return the countryName
     */
    public final String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName
     *            the countryName to set
     */
    public final void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the affiliationId
     */
    public final String getAffiliationId() {
        return affiliationId;
    }

    /**
     * @param affiliationId
     *            the affiliationId to set
     */
    public final void setAffiliationId(final String affiliationId) {
        this.affiliationId = affiliationId;
    }

}
