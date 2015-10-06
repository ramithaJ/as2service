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
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class User.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class User implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The user id. */
    @NotBlank
    @NotNull
    /** The user id. */
    private String userId;
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

    /** The industry. */
    private String industryCode;

    /** The job category. */
    private String jobCategory;

    /** The job category. */
    private String jobCategoryCode;

    /** The orcid id. */
    private String orcidId;

    /** The visible attributes. */
    private List<String> visibleAttributes;

    /** The contact id. */
    private String contactId;

    /** The password. */
    private String password;

    /** The search full name. */
    private boolean searchFullName;

    /** The invitation guid. */
    private String participantId;

    /** The country. */
    private Country country;

    /** The country name ne. */
    private String countryNameNE;

    /** The terms of use flg. */
    private String termsOfUseFlg;

    /** The user reference data. */
    private UserReferenceData userReferenceData;

    /** The addresses. */
    private Addresses addresses;

    /** The affiliation. */
    private Affiliation affiliation;

    /** The found in. */
    private String foundIn;

    /** The instituition. */
    private String instituition;

    /** This field holds the value of titleName. */
    private String titleName;

    /** This field holds the value of suffixName. */
    private String suffixName;

    /** The country code. */
    private String countryCode;

    /**
     * This field holds the value of industryName.
     */
    private String industryName;

    /**
     * This field holds the value of jobCategoryName.
     */
    private String jobCategoryName;

    /**
     * Gets the industry name.
     *
     * @return the industryName
     */
    public final String getIndustryName() {
        return industryName;
    }

    /**
     * Sets the industry name.
     *
     * @param industryName
     *            the industryName to set
     */
    public final void setIndustryName(final String industryName) {
        this.industryName = industryName;
    }

    /**
     * Gets the job category name.
     *
     * @return the jobCategoryName
     */
    public final String getJobCategoryName() {
        return jobCategoryName;
    }

    /**
     * Sets the job category name.
     *
     * @param jobCategoryName
     *            the jobCategoryName to set
     */
    public final void setJobCategoryName(final String jobCategoryName) {
        this.jobCategoryName = jobCategoryName;
    }

    /**
     * Gets the title name.
     *
     * @return the titleName
     */
    public final String getTitleName() {
        return titleName;
    }

    /**
     * Sets the title name.
     *
     * @param titleName
     *            the titleName to set
     */
    public final void setTitleName(final String titleName) {
        this.titleName = titleName;
    }

    /**
     * Gets the suffix name.
     *
     * @return the suffixName
     */
    public final String getSuffixName() {
        return suffixName;
    }

    /**
     * Sets the suffix name.
     *
     * @param suffixName
     *            the suffixName to set
     */
    public final void setSuffixName(final String suffixName) {
        this.suffixName = suffixName;
    }

    /**
     * Gets the instituition.
     *
     * @return the instituition
     */
    public final String getInstituition() {
        return instituition;
    }

    /**
     * Sets the instituition.
     *
     * @param instituition
     *            the new instituition
     */
    public final void setInstituition(final String instituition) {
        this.instituition = instituition;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Gets the industry code.
     *
     * @return the industryCode
     */
    public final String getIndustryCode() {
        return industryCode;
    }

    /**
     * Sets the industry code.
     *
     * @param industryCode
     *            the industryCode to set
     */
    public final void setIndustryCode(final String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * Gets the job category code.
     *
     * @return the jobCategoryCode
     */
    public final String getJobCategoryCode() {
        return jobCategoryCode;
    }

    /**
     * Sets the job category code.
     *
     * @param jobCategoryCode
     *            the jobCategoryCode to set
     */
    public final void setJobCategoryCode(final String jobCategoryCode) {
        this.jobCategoryCode = jobCategoryCode;
    }

    /**
     * Gets the user id.
     *
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
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
     * Gets the middle name.
     *
     * @return the middleName
     */
    public final String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name.
     *
     * @param middleName
     *            the middleName to set
     */
    public final void setMiddleName(final String middleName) {
        this.middleName = middleName;
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
     * Gets the alternate name.
     *
     * @return the alternateName
     */
    public final String getAlternateName() {
        return alternateName;
    }

    /**
     * Sets the alternate name.
     *
     * @param alternateName
     *            the alternateName to set
     */
    public final void setAlternateName(final String alternateName) {
        this.alternateName = alternateName;
    }

    /**
     * Gets the primary email addr.
     *
     * @return the primaryEmailAddr
     */
    public final String getPrimaryEmailAddr() {
        return primaryEmailAddr;
    }

    /**
     * Sets the primary email addr.
     *
     * @param primaryEmailAddr
     *            the primaryEmailAddr to set
     */
    public final void setPrimaryEmailAddr(final String primaryEmailAddr) {
        this.primaryEmailAddr = primaryEmailAddr;
    }

    /**
     * Gets the recovery email address.
     *
     * @return the recoveryEmailAddress
     */
    public final String getRecoveryEmailAddress() {
        return recoveryEmailAddress;
    }

    /**
     * Sets the recovery email address.
     *
     * @param recoveryEmailAddress
     *            the recoveryEmailAddress to set
     */
    public final void setRecoveryEmailAddress(final String recoveryEmailAddress) {
        this.recoveryEmailAddress = recoveryEmailAddress;
    }

    /**
     * Gets the additional email address.
     *
     * @return the additionalEmailAddress
     */
    public final String getAdditionalEmailAddress() {
        return additionalEmailAddress;
    }

    /**
     * Sets the additional email address.
     *
     * @param additionalEmailAddress
     *            the additionalEmailAddress to set
     */
    public final void setAdditionalEmailAddress(
            final String additionalEmailAddress) {
        this.additionalEmailAddress = additionalEmailAddress;
    }

    /**
     * Gets the industry.
     *
     * @return the industry
     */
    public final String getIndustry() {
        return industry;
    }

    /**
     * Sets the industry.
     *
     * @param industry
     *            the industry to set
     */
    public final void setIndustry(final String industry) {
        this.industry = industry;
    }

    /**
     * Gets the job category.
     *
     * @return the jobCategory
     */
    public final String getJobCategory() {
        return jobCategory;
    }

    /**
     * Sets the job category.
     *
     * @param jobCategory
     *            the jobCategory to set
     */
    public final void setJobCategory(final String jobCategory) {
        this.jobCategory = jobCategory;
    }

    /**
     * Gets the orcid id.
     *
     * @return the orcidId
     */
    public final String getOrcidId() {
        return orcidId;
    }

    /**
     * Sets the orcid id.
     *
     * @param orcidId
     *            the orcidId to set
     */
    public final void setOrcidId(final String orcidId) {
        this.orcidId = orcidId;
    }

    /**
     * Gets the visible attributes.
     *
     * @return the visibleAttributes
     */
    public final List<String> getVisibleAttributes() {
        return visibleAttributes;
    }

    /**
     * Sets the visible attributes.
     *
     * @param visibleAttributes
     *            the visibleAttributes to set
     */
    public final void setVisibleAttributes(final List<String> visibleAttributes) {
        this.visibleAttributes = visibleAttributes;
    }

    /**
     * Gets the contact id.
     *
     * @return the contactId
     */
    public final String getContactId() {
        return contactId;
    }

    /**
     * Sets the contact id.
     *
     * @param contactId
     *            the contactId to set
     */
    public final void setContactId(final String contactId) {
        this.contactId = contactId;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Checks if is search full name.
     *
     * @return the searchFullName
     */
    public final boolean isSearchFullName() {
        return searchFullName;
    }

    /**
     * Sets the search full name.
     *
     * @param searchFullName
     *            the searchFullName to set
     */
    public final void setSearchFullName(final boolean searchFullName) {
        this.searchFullName = searchFullName;
    }

    /**
     * Gets the participant id.
     *
     * @return the participant id
     */
    public final String getParticipantId() {
        return participantId;
    }

    /**
     * Sets the participant id.
     *
     * @param participantId
     *            the new participant id
     */
    public final void setParticipantId(final String participantId) {
        this.participantId = participantId;
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
     * Sets the country.
     *
     * @param country
     *            the country to set
     */
    public final void setCountry(final Country country) {
        this.country = country;
    }

    /**
     * Gets the country name ne.
     *
     * @return the countryNameNE
     */
    public final String getCountryNameNE() {
        return countryNameNE;
    }

    /**
     * Sets the country name ne.
     *
     * @param countryNameNE
     *            the countryNameNE to set
     */
    public final void setCountryNameNE(final String countryNameNE) {
        this.countryNameNE = countryNameNE;
    }

    /**
     * Gets the terms of use flg.
     *
     * @return the termsOfUseFlg
     */
    public final String getTermsOfUseFlg() {
        return termsOfUseFlg;
    }

    /**
     * Sets the terms of use flg.
     *
     * @param termsOfUseFlg
     *            the termsOfUseFlg to set
     */
    public final void setTermsOfUseFlg(final String termsOfUseFlg) {
        this.termsOfUseFlg = termsOfUseFlg;
    }

    /**
     * Gets the user reference data.
     *
     * @return the userReferenceData
     */
    public final UserReferenceData getUserReferenceData() {
        return userReferenceData;
    }

    /**
     * Sets the user reference data.
     *
     * @param userReferenceData
     *            the userReferenceData to set
     */
    public final void setUserReferenceData(
            final UserReferenceData userReferenceData) {
        this.userReferenceData = userReferenceData;
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public final Addresses getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses
     *            the addresses to set
     */
    public final void setAddresses(final Addresses addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the affiliation.
     *
     * @return the affiliation
     */
    public final Affiliation getAffiliation() {
        return affiliation;
    }

    /**
     * Sets the affiliation.
     *
     * @param affiliation
     *            the affiliation to set
     */
    public final void setAffiliation(final Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * Gets the found in.
     *
     * @return the found in
     */
    public final String getFoundIn() {
        return foundIn;
    }

    /**
     * Sets the found in.
     *
     * @param foundIn
     *            the new found in
     */
    public final void setFoundIn(final String foundIn) {
        this.foundIn = foundIn;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public final String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode
     *            the new country code
     */
    public final void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

}
