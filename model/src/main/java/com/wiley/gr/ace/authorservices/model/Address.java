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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Address.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

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
     * @return the addressType
     */
    public final String getAddressType() {
        return addressType;
    }

    /**
     * @param addressType
     *            the addressType to set
     */
    public final void setAddressType(final String addressType) {
        this.addressType = addressType;
    }

    /**
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
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
     * @return the suffix
     */
    public final String getSuffix() {
        return suffix;
    }

    /**
     * @param suffix
     *            the suffix to set
     */
    public final void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

    /**
     * @return the institution
     */
    public final String getInstitution() {
        return institution;
    }

    /**
     * @param institution
     *            the institution to set
     */
    public final void setInstitution(final String institution) {
        this.institution = institution;
    }

    /**
     * @return the department
     */
    public final String getDepartment() {
        return department;
    }

    /**
     * @param department
     *            the department to set
     */
    public final void setDepartment(final String department) {
        this.department = department;
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
     * @return the postCode
     */
    public final String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode
     *            the postCode to set
     */
    public final void setPostCode(final String postCode) {
        this.postCode = postCode;
    }

    /**
     * @return the country
     */
    public final Country getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public final void setCountry(final Country country) {
        this.country = country;
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

    /**
     * @return the addressFag
     */
    public final Character getAddressFag() {
        return addressFag;
    }

    /**
     * @param addressFag
     *            the addressFag to set
     */
    public final void setAddressFag(final Character addressFag) {
        this.addressFag = addressFag;
    }

    /**
     * @return the region
     */
    public final String getRegion() {
        return region;
    }

    /**
     * @param region
     *            the region to set
     */
    public final void setRegion(final String region) {
        this.region = region;
    }

}
