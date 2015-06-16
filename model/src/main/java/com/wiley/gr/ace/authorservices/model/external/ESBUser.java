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
    @JsonProperty("FirstName")
    private String firstName;

    /** The zip. */
    @JsonProperty("Zip")
    private String zip;

    /** The country. */
    @JsonProperty("Country")
    private String country;

    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;

    /** The ecid. */
    @JsonProperty("ECID")
    private String ecid;

    /** The email id. */
    @JsonProperty("EmailID")
    private String emailID;

    /** The account identifier. */
    @JsonProperty("AccountIdentifier")
    private String accountIdentifier;

    /**
     * Gets the street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street.
     *
     * @param street
     *            the new street
     */
    public void setStreet(String street) {
        this.street = street;
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
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role
     *            the new role
     */
    public void setRole(String role) {
        this.role = role;
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
     * Gets the zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip.
     *
     * @param zip
     *            the new zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country
     *            the new country
     */
    public void setCountry(String country) {
        this.country = country;
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
     * Gets the ecid.
     *
     * @return the ecid
     */
    public String getEcid() {
        return ecid;
    }

    /**
     * Sets the ecid.
     *
     * @param ecid
     *            the new ecid
     */
    public void setEcid(String ecid) {
        this.ecid = ecid;
    }

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public String getEmailID() {
        return emailID;
    }

    /**
     * Sets the email id.
     *
     * @param emailID
     *            the new email id
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    /**
     * Gets the account identifier.
     *
     * @return the account identifier
     */
    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * Sets the account identifier.
     *
     * @param accountIdentifier
     *            the new account identifier
     */
    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

}
