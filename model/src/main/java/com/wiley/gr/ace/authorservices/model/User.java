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
 * The Class User.
 *
 * @author virtusa
 * version 1.0
 */
/**
 * @author DISHARIDE
 *
 */
@JsonInclude(Include.NON_NULL)
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
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
     * @return the userId
     */
    public final Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final Integer userId) {
        this.userId = userId;
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
     * @return the middleName
     */
    public final String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName
     *            the middleName to set
     */
    public final void setMiddleName(final String middleName) {
        this.middleName = middleName;
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
     * @return the alternateName
     */
    public final String getAlternateName() {
        return alternateName;
    }

    /**
     * @param alternateName
     *            the alternateName to set
     */
    public final void setAlternateName(final String alternateName) {
        this.alternateName = alternateName;
    }

    /**
     * @return the primaryEmailAddr
     */
    public final String getPrimaryEmailAddr() {
        return primaryEmailAddr;
    }

    /**
     * @param primaryEmailAddr
     *            the primaryEmailAddr to set
     */
    public final void setPrimaryEmailAddr(final String primaryEmailAddr) {
        this.primaryEmailAddr = primaryEmailAddr;
    }

    /**
     * @return the recoveryEmailAddress
     */
    public final String getRecoveryEmailAddress() {
        return recoveryEmailAddress;
    }

    /**
     * @param recoveryEmailAddress
     *            the recoveryEmailAddress to set
     */
    public final void setRecoveryEmailAddress(final String recoveryEmailAddress) {
        this.recoveryEmailAddress = recoveryEmailAddress;
    }

    /**
     * @return the additionalEmailAddress
     */
    public final String getAdditionalEmailAddress() {
        return additionalEmailAddress;
    }

    /**
     * @param additionalEmailAddress
     *            the additionalEmailAddress to set
     */
    public final void setAdditionalEmailAddress(
            final String additionalEmailAddress) {
        this.additionalEmailAddress = additionalEmailAddress;
    }

    /**
     * @return the industry
     */
    public final String getIndustry() {
        return industry;
    }

    /**
     * @param industry
     *            the industry to set
     */
    public final void setIndustry(final String industry) {
        this.industry = industry;
    }

    /**
     * @return the jobCategory
     */
    public final String getJobCategory() {
        return jobCategory;
    }

    /**
     * @param jobCategory
     *            the jobCategory to set
     */
    public final void setJobCategory(final String jobCategory) {
        this.jobCategory = jobCategory;
    }

    /**
     * @return the orcidID
     */
    public final String getOrcidID() {
        return orcidID;
    }

    /**
     * @param orcidID
     *            the orcidID to set
     */
    public final void setOrcidID(final String orcidID) {
        this.orcidID = orcidID;
    }

    /**
     * @return the visibleAttributes
     */
    public final String[] getVisibleAttributes() {
        return visibleAttributes;
    }

    /**
     * @param visibleAttributes
     *            the visibleAttributes to set
     */
    public final void setVisibleAttributes(final String[] visibleAttributes) {
        this.visibleAttributes = visibleAttributes;
    }

    /**
     * @return the contactId
     */
    public final String getContactId() {
        return contactId;
    }

    /**
     * @param contactId
     *            the contactId to set
     */
    public final void setContactId(final String contactId) {
        this.contactId = contactId;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the searchFullName
     */
    public final boolean isSearchFullName() {
        return searchFullName;
    }

    /**
     * @param searchFullName
     *            the searchFullName to set
     */
    public final void setSearchFullName(final boolean searchFullName) {
        this.searchFullName = searchFullName;
    }

    /**
     * @return the invitationGuid
     */
    public final String getInvitationGuid() {
        return invitationGuid;
    }

    /**
     * @param invitationGuid
     *            the invitationGuid to set
     */
    public final void setInvitationGuid(final String invitationGuid) {
        this.invitationGuid = invitationGuid;
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
     * @return the countryNameNE
     */
    public final String getCountryNameNE() {
        return countryNameNE;
    }

    /**
     * @param countryNameNE
     *            the countryNameNE to set
     */
    public final void setCountryNameNE(final String countryNameNE) {
        this.countryNameNE = countryNameNE;
    }

    /**
     * @return the termsOfUseFlg
     */
    public final Character getTermsOfUseFlg() {
        return termsOfUseFlg;
    }

    /**
     * @param termsOfUseFlg
     *            the termsOfUseFlg to set
     */
    public final void setTermsOfUseFlg(final Character termsOfUseFlg) {
        this.termsOfUseFlg = termsOfUseFlg;
    }

    /**
     * @return the userReferenceData
     */
    public final UserReferenceData getUserReferenceData() {
        return userReferenceData;
    }

    /**
     * @param userReferenceData
     *            the userReferenceData to set
     */
    public final void setUserReferenceData(
            final UserReferenceData userReferenceData) {
        this.userReferenceData = userReferenceData;
    }

    /**
     * @return the addresses
     */
    public final Addresses getAddresses() {
        return addresses;
    }

    /**
     * @param addresses
     *            the addresses to set
     */
    public final void setAddresses(final Addresses addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the affiliation
     */
    public final Affiliation getAffiliation() {
        return affiliation;
    }

    /**
     * @param affiliation
     *            the affiliation to set
     */
    public final void setAffiliation(final Affiliation affiliation) {
        this.affiliation = affiliation;
    }

}
