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
 * The Class Address.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Address implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * This field holds the value of id
     */
    @NotBlank
    @NotNull
    private String addressId;

    @NotBlank
    @NotNull
    /** The address type. */
    private String addressType = "";

    private String emailId;

    /** The title. */
    private String title = "";

    /** The first name. */
    private String firstName = "";

    /** The last name. */
    private String lastName = "";

    /** The suffix. */
    private String suffix = "";

    /** The institution. */
    private String institutionId = "";

    /** The institution. */
    private String institutionName = "";

    /** The department. */
    private String departmentId = "";

    /** The department. */
    private String departmentName = "";

    /** The address line1. */
    private String addressLine1 = "";

    /** The address line2. */
    private String addressLine2 = "";

    /** The city. */
    private String city = "";

    /** The state. */
    private String state;

    /**
     * This field holds the value of stateCode.
     */
    private String stateCode;

    /** The post code. */
    private String postCode = "";

    /** The country. */
    private Country country;

    /**
     * This field holds the value of countryCode.
     */
    private String countryCode;

    /** The phone number. */
    private String phoneNumber = "";

    /** The fax number. */
    private String faxNumber = "";

    /** The address fag. */
    private Character addressFlag = 'N';

    /** The region. */
    private String region = "";

    public final String getEmailId() {
        return emailId;
    }

    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
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
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Gets the address type.
     *
     * @return the addressType
     */
    public final String getAddressType() {
        return addressType;
    }

    /**
     * @return the addressId
     */
    public final String getAddressId() {
        return addressId;
    }

    /**
     * @param addressId
     *            the addressId to set
     */
    public final void setAddressId(final String addressId) {
        this.addressId = addressId;
    }

    /**
     * Sets the address type.
     *
     * @param addressType
     *            the addressType to set
     */
    public final void setAddressType(final String addressType) {
        this.addressType = addressType;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
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
     * Gets the suffix.
     *
     * @return the suffix
     */
    public final String getSuffix() {
        return suffix;
    }

    /**
     * Sets the suffix.
     *
     * @param suffix
     *            the suffix to set
     */
    public final void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

    /**
     * Gets the address line1.
     *
     * @return the addressLine1
     */
    public final String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the address line1.
     *
     * @param addressLine1
     *            the addressLine1 to set
     */
    public final void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Gets the address line2.
     *
     * @return the addressLine2
     */
    public final String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the address line2.
     *
     * @param addressLine2
     *            the addressLine2 to set
     */
    public final void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
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
     * @return the state
     */
    public final String getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public final void setState(final String state) {
        this.state = state;
    }

    /**
     * Gets the post code.
     *
     * @return the postCode
     */
    public final String getPostCode() {
        return postCode;
    }

    /**
     * Sets the post code.
     *
     * @param postCode
     *            the postCode to set
     */
    public final void setPostCode(final String postCode) {
        this.postCode = postCode;
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
     * @return the institutionName
     */
    public final String getInstitutionName() {
        return institutionName;
    }

    /**
     * @return the departmentName
     */
    public final String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param institutionName
     *            the institutionName to set
     */
    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * @param departmentName
     *            the departmentName to set
     */
    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
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
     * Gets the phone number.
     *
     * @return the phoneNumber
     */
    public final String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber
     *            the phoneNumber to set
     */
    public final void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the fax number.
     *
     * @return the faxNumber
     */
    public final String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the fax number.
     *
     * @param faxNumber
     *            the faxNumber to set
     */
    public final void setFaxNumber(final String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * @return the addressFlag
     */
    public final Character getAddressFlag() {
        return addressFlag;
    }

    /**
     * @param addressFlag
     *            the addressFlag to set
     */
    public final void setAddressFlag(final Character addressFlag) {
        this.addressFlag = addressFlag;
    }

    /**
     * Gets the region.
     *
     * @return the region
     */
    public final String getRegion() {
        return region;
    }

    /**
     * Sets the region.
     *
     * @param region
     *            the region to set
     */
    public final void setRegion(final String region) {
        this.region = region;
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

}
