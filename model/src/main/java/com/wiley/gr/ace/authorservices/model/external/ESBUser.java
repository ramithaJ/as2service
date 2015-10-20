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

import java.util.ArrayList;
import java.util.List;

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

    /** The Found in. */
    @JsonProperty("FoundIN")
    private String foundIN;

    /** The primary email addr. */
    private String primaryEmailAddr;

    /** The asid. */
    @JsonProperty("ASID")
    private String asid;

    /** The orcid id. */
    private String orcidId;

    /** The institution. */
    private String institution;

    /** The addresses. */
    private List<ESBUserAddress> addresses;

    /**
     * Gets the orcid id.
     *
     * @return the orcid id
     */
    public final String getOrcidId() {
        return orcidId;
    }

    /**
     * Sets the orcid id.
     *
     * @param orcidId
     *            the new orcid id
     */
    public final void setOrcidId(final String orcidId) {
        this.orcidId = orcidId;
    }

    /**
     * Gets the institution.
     *
     * @return the institution
     */
    public final String getInstitution() {
        return institution;
    }

    /**
     * Sets the institution.
     *
     * @param institution
     *            the new institution
     */
    public final void setInstitution(final String institution) {
        this.institution = institution;
    }

    /**
     * @return the asid
     */
    public final String getAsid() {
        return asid;
    }

    /**
     * @param asid
     *            the asid to set
     */
    public final void setAsid(final String asid) {
        this.asid = asid;
    }

    /**
     * @return the addresses
     */
    public final List<ESBUserAddress> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses
     *            the addresses to set
     */
    public final void setAddresses(final List<ESBUserAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the primary email addr.
     *
     * @return the primary email addr
     */
    public final String getPrimaryEmailAddr() {
        return primaryEmailAddr;
    }

    /**
     * Sets the primary email addr.
     *
     * @param primaryEmailAddr
     *            the new primary email addr
     */
    public final void setPrimaryEmailAddr(final String primaryEmailAddr) {
        this.primaryEmailAddr = primaryEmailAddr;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses
     *            the new addresses
     */
    public final void setAddresses(final ArrayList<ESBUserAddress> addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the found in.
     *
     * @return the found in
     */
    public final String getFoundIN() {
        return foundIN;
    }

    /**
     * Sets the found in.
     *
     * @param foundIN
     *            the new found in
     */
    public final void setFoundIN(final String foundIN) {
        this.foundIN = foundIN;
    }

    /**
     * @return the street
     */
    public final String getStreet() {
        return street;
    }

    /**
     * @param street
     *            the street to set
     */
    public final void setStreet(final String street) {
        this.street = street;
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
     * @return the address
     */
    public final String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public final void setAddress(final String address) {
        this.address = address;
    }

    /**
     * @return the role
     */
    public final String getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public final void setRole(final String role) {
        this.role = role;
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
     * @return the zip
     */
    public final String getZip() {
        return zip;
    }

    /**
     * @param zip
     *            the zip to set
     */
    public final void setZip(final String zip) {
        this.zip = zip;
    }

    /**
     * @return the country
     */
    public final String getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public final void setCountry(final String country) {
        this.country = country;
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
     * @return the ecid
     */
    public final String getEcid() {
        return ecid;
    }

    /**
     * @param ecid
     *            the ecid to set
     */
    public final void setEcid(final String ecid) {
        this.ecid = ecid;
    }

    /**
     * @return the emailID
     */
    public final String getEmailID() {
        return emailID;
    }

    /**
     * @param emailID
     *            the emailID to set
     */
    public final void setEmailID(final String emailID) {
        this.emailID = emailID;
    }

    /**
     * @return the accountIdentifier
     */
    public final String getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * @param accountIdentifier
     *            the accountIdentifier to set
     */
    public final void setAccountIdentifier(final String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

}
