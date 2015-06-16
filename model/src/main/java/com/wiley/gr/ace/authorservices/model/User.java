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
 * The Class User.
 *
 * @author virtusa
 * 	version 1.0
 */
/**
 * @author DISHARIDE
 *
 */
@JsonInclude(Include.NON_NULL)
public class User {

    /** The user id. */
    private Integer userId;
    /** The title. */
    private String title;

    /** The first name. */
    private String firstName;

    /** The middle name. */
    private String middleName;

    /** The last name. */
    private String lastName;

    /** The suffix. */
    private String suffix;

    /** The alternate name. */
    private String alternateName;

    /** The primary email addr. */
    private String primaryEmailAddr;

    /** The recovery email address. */
    private String recoveryEmailAddress;

    /** The additional email address. */
    private String additionalEmailAddress;

    /** The industry. */
    private String industry;

    /** The job category. */
    private String jobCategory;

    /** The orcid id. */
    private String orcidID;

    /** The visible attributes. */
    private String[] visibleAttributes;

    // Need to confirm the datatype
    /** The contact id. */
    private String contactId;

    /** The password. */
    private String password;

    /** The search full name. */
    private boolean searchFullName;

    /** The invitation guid. */
    private String invitationGuid;

    /** The country. */
    private Country country;

    /** The country name ne. */
    private String countryNameNE;

    /** The terms of use flg. */
    private Character termsOfUseFlg;

    /** The user reference data. */
    private UserReferenceData userReferenceData;

    /** The addresses. */
    private Addresses addresses;

    /** The affiliation. */
    private Affiliation affiliation;

    /**
     * Gets the affiliation.
     *
     * @return the affiliation
     */
    public Affiliation getAffiliation() {
        return affiliation;
    }

    /**
     * Sets the affiliation.
     *
     * @param affiliation
     *            the new affiliation
     */
    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public Addresses getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses
     *            the new addresses
     */
    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the user id.
     *
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * Gets the middle name.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName
     *            the new middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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
     * Gets the alternate name.
     *
     * @return the alternate name
     */
    public String getAlternateName() {
        return alternateName;
    }

    /**
     * Sets the alternate name.
     *
     * @param alternateName
     *            the new alternate name
     */
    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    /**
     * Gets the primary email addr.
     *
     * @return the primary email addr
     */
    public String getPrimaryEmailAddr() {
        return primaryEmailAddr;
    }

    /**
     * Sets the primary email addr.
     *
     * @param primaryEmailAddr
     *            the new primary email addr
     */
    public void setPrimaryEmailAddr(String primaryEmailAddr) {
        this.primaryEmailAddr = primaryEmailAddr;
    }

    /**
     * Gets the recovery email address.
     *
     * @return the recovery email address
     */
    public String getRecoveryEmailAddress() {
        return recoveryEmailAddress;
    }

    /**
     * Sets the recovery email address.
     *
     * @param recoveryEmailAddress
     *            the new recovery email address
     */
    public void setRecoveryEmailAddress(String recoveryEmailAddress) {
        this.recoveryEmailAddress = recoveryEmailAddress;
    }

    /**
     * Gets the additional email address.
     *
     * @return the additional email address
     */
    public String getAdditionalEmailAddress() {
        return additionalEmailAddress;
    }

    /**
     * Sets the additional email address.
     *
     * @param additionalEmailAddress
     *            the new additional email address
     */
    public void setAdditionalEmailAddress(String additionalEmailAddress) {
        this.additionalEmailAddress = additionalEmailAddress;
    }

    /**
     * Gets the correspondance address.
     *
     * @return the correspondance address
     */

    /**
     * Gets the industry.
     *
     * @return the industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Sets the industry.
     *
     * @param industry
     *            the new industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * Gets the job category.
     *
     * @return the job category
     */
    public String getJobCategory() {
        return jobCategory;
    }

    /**
     * Sets the job category.
     *
     * @param jobCategory
     *            the new job category
     */
    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    /**
     * Gets the orcid id.
     *
     * @return the orcid id
     */
    public String getOrcidID() {
        return orcidID;
    }

    /**
     * Sets the orcid id.
     *
     * @param orcidID
     *            the new orcid id
     */
    public void setOrcidID(String orcidID) {
        this.orcidID = orcidID;
    }

    /**
     * Gets the visible attributes.
     *
     * @return the visible attributes
     */
    public String[] getVisibleAttributes() {
        return visibleAttributes;
    }

    /**
     * Sets the visible attributes.
     *
     * @param visibleAttributes
     *            the new visible attributes
     */
    public void setVisibleAttributes(String[] visibleAttributes) {
        this.visibleAttributes = visibleAttributes;
    }

    /**
     * Gets the contact id.
     *
     * @return the contactId
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Sets the contact id.
     *
     * @param contactId
     *            the contactId to set
     */
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if is search full name.
     *
     * @return true, if is search full name
     */
    public boolean isSearchFullName() {
        return searchFullName;
    }

    /**
     * Sets the search full name.
     *
     * @param searchFullName
     *            the new search full name
     */
    public void setSearchFullName(boolean searchFullName) {
        this.searchFullName = searchFullName;
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
     * Gets the terms of use flg.
     *
     * @return the terms of use flg
     */
    public Character getTermsOfUseFlg() {
        return termsOfUseFlg;
    }

    /**
     * Sets the terms of use flg.
     *
     * @param termsOfUseFlg
     *            the new terms of use flg
     */
    public void setTermsOfUseFlg(Character termsOfUseFlg) {
        this.termsOfUseFlg = termsOfUseFlg;
    }

    /**
     * Gets the user reference data.
     *
     * @return the user reference data
     */
    public UserReferenceData getUserReferenceData() {
        return userReferenceData;
    }

    /**
     * Sets the user reference data.
     *
     * @param userReferenceData
     *            the new user reference data
     */
    public void setUserReferenceData(UserReferenceData userReferenceData) {
        this.userReferenceData = userReferenceData;
    }

    /**
     * Gets the country name ne.
     *
     * @return the country name ne
     */
    public String getCountryNameNE() {
        return countryNameNE;
    }

    /**
     * Sets the country name ne.
     *
     * @param countryNameNE
     *            the new country name ne
     */
    public void setCountryNameNE(String countryNameNE) {
        this.countryNameNE = countryNameNE;
    }

    /**
     * Gets the invitation guid.
     *
     * @return the invitation guid
     */
    public String getInvitationGuid() {
        return invitationGuid;
    }

    /**
     * Sets the invitation guid.
     *
     * @param invitationGuid
     *            the new invitation guid
     */
    public void setInvitationGuid(String invitationGuid) {
        this.invitationGuid = invitationGuid;
    }

}
