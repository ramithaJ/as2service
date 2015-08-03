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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ESBUser.
 * 
 * @author virtusa version 1.0
 */
public class ESBUser {

    /** The middle name. */
    private String middleName;

    /** The last name. */
    private String lastName;

    /** The primary email addr. */
    private String primaryEmailAddr;

    /** The title. */
    private String title;

    /** The asid. */
    private String ASID;

    /** The addresses. */
    private ArrayList<ESBUserAddress> addresses;

    /** The first name. */
    private String firstName;

    /** The suffix. */
    private String suffix;

    /** The orcid id. */
    private String orcidId;

    /** The institution. */
    private String institution;

    /** The Found in. */
    @JsonProperty("FoundIN")
    private String foundIN;

    /**
     * Gets the middle name.
     *
     * @return the middle name
     */
    public final String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName
     *            the new middle name
     */
    public final void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
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
     *            the new title
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the asid.
     *
     * @return the asid
     */
    public final String getASID() {
        return ASID;
    }

    /**
     * Sets the asid.
     *
     * @param aSID
     *            the new asid
     */
    public final void setASID(final String aSID) {
        ASID = aSID;
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public final ArrayList<ESBUserAddress> getAddresses() {
        return addresses;
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
     * Gets the first name.
     *
     * @return the first name
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
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
     *            the new suffix
     */
    public final void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

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

}
