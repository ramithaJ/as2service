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
 * The Class Address.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Address {

    /** The address type. */
    private String addressType;

    /** The title. */
    private String title;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The suffix. */
    private String suffix;

    /** The institution. */
    private String institution;

    /** The department. */
    private String department;

    /** The address line1. */
    private String addressLine1;

    /** The address line2. */
    private String addressLine2;

    /** The city. */
    private String city;

    /** The state. */
    private String state;

    /** The post code. */
    private String postCode;

    /** The country. */
    private Country country;

    /** The phone number. */
    private String phoneNumber;

    /** The fax number. */
    private String faxNumber;

    /** The address fag. */
    private Character addressFag;

    /** The region. */
    private String region;

    /**
     * Gets the address type.
     *
     * @return the address type
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the address type.
     *
     * @param addressType
     *            the new address type
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * Gets the region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region.
     *
     * @param region
     *            the new region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the suffix.
     *
     * @return the suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Sets the suffix.
     *
     * @param suffix
     *            the new suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Gets the institution.
     *
     * @return the institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Sets the institution.
     *
     * @param institution
     *            the new institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * Gets the department.
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param department
     *            the new department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the address line1.
     *
     * @return the address line1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the address line1.
     *
     * @param addressLine1
     *            the new address line1
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Gets the address line2.
     *
     * @return the address line2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the address line2.
     *
     * @param addressLine2
     *            the new address line2
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the post code.
     *
     * @return the post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the post code.
     *
     * @param postCode
     *            the new post code
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country
     *            the new country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber
     *            the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the fax number.
     *
     * @return the fax number
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the fax number.
     *
     * @param faxNumber
     *            the new fax number
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * Gets the address fag.
     *
     * @return the address fag
     */
    public Character getAddressFag() {
        return addressFag;
    }

    /**
     * Sets the address fag.
     *
     * @param addressFag
     *            the new address fag
     */
    public void setAddressFag(Character addressFag) {
        this.addressFag = addressFag;
    }

}
