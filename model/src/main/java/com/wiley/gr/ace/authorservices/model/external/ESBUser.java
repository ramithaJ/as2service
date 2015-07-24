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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ESBUser.
 * 
 * @author virtusa version 1.0
 */
public class ESBUser {

    /** The street. */
    @JsonProperty("Street")
    private String street;

    /** The state. */
    @JsonProperty("State")
    private String state;

    /** The address. */
    @JsonProperty("Address")
    private String address;

    /** The role. */
    @JsonProperty("Role")
    private String role;

    /** The first name. */
    @JsonProperty("firstName")
    private String firstName;

    /** The zip. */
    @JsonProperty("Zip")
    private String zip;

    /** The country. */
    @JsonProperty("Country")
    private String country;

    /** The last name. */
    @JsonProperty("lastName")
    private String lastName;

    /** The ecid. */
    @JsonProperty("ECID")
    private String ecid;

    /** The email id. */
    @JsonProperty("EmailID")
    private String emailId;

    /** The account identifier. */
    @JsonProperty("AccountIdentifier")
    private String accountIdentifier;

    @JsonProperty("FoundIN")
    private String foundIn;

    /**
     * Gets the street.
     *
     * @return the street
     */
    public final String getStreet() {
        return street;
    }

    /**
     * Sets the street.
     *
     * @param street
     *            the street to set
     */
    public final void setStreet(final String street) {
        this.street = street;
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
     * Gets the address.
     *
     * @return the address
     */
    public final String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the address to set
     */
    public final void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public final String getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role
     *            the role to set
     */
    public final void setRole(final String role) {
        this.role = role;
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
     * Gets the zip.
     *
     * @return the zip
     */
    public final String getZip() {
        return zip;
    }

    /**
     * Sets the zip.
     *
     * @param zip
     *            the zip to set
     */
    public final void setZip(final String zip) {
        this.zip = zip;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public final String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country
     *            the country to set
     */
    public final void setCountry(final String country) {
        this.country = country;
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
     * Gets the ecid.
     *
     * @return the ecid
     */
    public final String getEcid() {
        return ecid;
    }

    /**
     * Sets the ecid.
     *
     * @param ecid
     *            the ecid to set
     */
    public final void setEcid(final String ecid) {
        this.ecid = ecid;
    }

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the new email id
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the account identifier.
     *
     * @return the accountIdentifier
     */
    public final String getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Sets the account identifier.
     *
     * @param accountIdentifier
     *            the accountIdentifier to set
     */
    public final void setAccountIdentifier(final String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public final String getFoundIn() {
        return foundIn;
    }

    public final void setFoundIn(final String foundIn) {
        this.foundIn = foundIn;
    }

}
