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
 * The Class UserAddress.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class UserAddress {

    /** The title vo. */
    private String titleVO;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The suffix vo. */
    private String suffixVO;

    /** The institution vo. */
    private String institutionVO;

    /** The department vo. */
    private String departmentVO;

    /** The address line1. */
    private String addressLine1;

    /** The address line2. */
    private String addressLine2;

    /** The city. */
    private String city;

    /** The state vo. */
    private String stateVO;

    /** The zip code. */
    private String zipCode;

    /** The country vo. */
    private String countryVO;

    /** The phone number. */
    private String phoneNumber;

    /** The fax number. */
    private String faxNumber;

    /**
     * @return the titleVO
     */
    public final String getTitleVO() {
        return titleVO;
    }

    /**
     * @param titleVO
     *            the titleVO to set
     */
    public final void setTitleVO(final String titleVO) {
        this.titleVO = titleVO;
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
     * @return the suffixVO
     */
    public final String getSuffixVO() {
        return suffixVO;
    }

    /**
     * @param suffixVO
     *            the suffixVO to set
     */
    public final void setSuffixVO(final String suffixVO) {
        this.suffixVO = suffixVO;
    }

    /**
     * @return the institutionVO
     */
    public final String getInstitutionVO() {
        return institutionVO;
    }

    /**
     * @param institutionVO
     *            the institutionVO to set
     */
    public final void setInstitutionVO(final String institutionVO) {
        this.institutionVO = institutionVO;
    }

    /**
     * @return the departmentVO
     */
    public final String getDepartmentVO() {
        return departmentVO;
    }

    /**
     * @param departmentVO
     *            the departmentVO to set
     */
    public final void setDepartmentVO(final String departmentVO) {
        this.departmentVO = departmentVO;
    }

    /**
     * @return the addressLine1
     */
    public final String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @param addressLine1
     *            the addressLine1 to set
     */
    public final void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public final String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param addressLine2
     *            the addressLine2 to set
     */
    public final void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
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
     * @return the stateVO
     */
    public final String getStateVO() {
        return stateVO;
    }

    /**
     * @param stateVO
     *            the stateVO to set
     */
    public final void setStateVO(final String stateVO) {
        this.stateVO = stateVO;
    }

    /**
     * @return the zipCode
     */
    public final String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode
     *            the zipCode to set
     */
    public final void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the countryVO
     */
    public final String getCountryVO() {
        return countryVO;
    }

    /**
     * @param countryVO
     *            the countryVO to set
     */
    public final void setCountryVO(final String countryVO) {
        this.countryVO = countryVO;
    }

    /**
     * @return the phoneNumber
     */
    public final String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     *            the phoneNumber to set
     */
    public final void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the faxNumber
     */
    public final String getFaxNumber() {
        return faxNumber;
    }

    /**
     * @param faxNumber
     *            the faxNumber to set
     */
    public final void setFaxNumber(final String faxNumber) {
        this.faxNumber = faxNumber;
    }

}
