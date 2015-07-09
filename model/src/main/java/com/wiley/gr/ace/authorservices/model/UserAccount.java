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
 * The Class UserAccount.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class UserAccount {

    /** The title. */
    private Title title;

    /** The suffix. */
    private Suffix suffix;

    /** The first name. */
    private String firstName;

    /** The middle name. */
    private String middleName;

    /** The last name. */
    private String lastName;

    /** The alternative name. */
    private String alternativeName;

    /** The industry. */
    private String industry;

    /** The job category. */
    private String jobCategory;

    /** The orcid id. */
    private String orcidId;

    /** The opt in flag. */
    private boolean optInFlag;

    /** The profile visibility flag. */
    private boolean profileVisibilityFlag;

    /** The profile visibility map. */
    private boolean profileVisibilityMap;

    /** The email vo. */
    private String emailVO;

    /** The sequrity vo. */
    private String sequrityVO;

    /** The address vo. */
    private String addressVO;

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final Title getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the title to set
     */
    public final void setTitle(final Title title) {
        this.title = title;
    }

    /**
     * Gets the suffix.
     *
     * @return the suffix
     */
    public final Suffix getSuffix() {
        return suffix;
    }

    /**
     * Sets the suffix.
     *
     * @param suffix
     *            the suffix to set
     */
    public final void setSuffix(final Suffix suffix) {
        this.suffix = suffix;
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
     * Gets the alternative name.
     *
     * @return the alternativeName
     */
    public final String getAlternativeName() {
        return alternativeName;
    }

    /**
     * Sets the alternative name.
     *
     * @param alternativeName
     *            the alternativeName to set
     */
    public final void setAlternativeName(final String alternativeName) {
        this.alternativeName = alternativeName;
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
     * Checks if is opt in flag.
     *
     * @return the optInFlag
     */
    public final boolean isOptInFlag() {
        return optInFlag;
    }

    /**
     * Sets the opt in flag.
     *
     * @param optInFlag
     *            the optInFlag to set
     */
    public final void setOptInFlag(final boolean optInFlag) {
        this.optInFlag = optInFlag;
    }

    /**
     * Checks if is profile visibility flag.
     *
     * @return the profileVisibilityFlag
     */
    public final boolean isProfileVisibilityFlag() {
        return profileVisibilityFlag;
    }

    /**
     * Sets the profile visibility flag.
     *
     * @param profileVisibilityFlag
     *            the profileVisibilityFlag to set
     */
    public final void setProfileVisibilityFlag(
            final boolean profileVisibilityFlag) {
        this.profileVisibilityFlag = profileVisibilityFlag;
    }

    /**
     * Checks if is profile visibility map.
     *
     * @return the profileVisibilityMap
     */
    public final boolean isProfileVisibilityMap() {
        return profileVisibilityMap;
    }

    /**
     * Sets the profile visibility map.
     *
     * @param profileVisibilityMap
     *            the profileVisibilityMap to set
     */
    public final void setProfileVisibilityMap(final boolean profileVisibilityMap) {
        this.profileVisibilityMap = profileVisibilityMap;
    }

    /**
     * Gets the email vo.
     *
     * @return the emailVO
     */
    public final String getEmailVO() {
        return emailVO;
    }

    /**
     * Sets the email vo.
     *
     * @param emailVO
     *            the emailVO to set
     */
    public final void setEmailVO(final String emailVO) {
        this.emailVO = emailVO;
    }

    /**
     * Gets the sequrity vo.
     *
     * @return the sequrityVO
     */
    public final String getSequrityVO() {
        return sequrityVO;
    }

    /**
     * Sets the sequrity vo.
     *
     * @param sequrityVO
     *            the sequrityVO to set
     */
    public final void setSequrityVO(final String sequrityVO) {
        this.sequrityVO = sequrityVO;
    }

    /**
     * Gets the address vo.
     *
     * @return the addressVO
     */
    public final String getAddressVO() {
        return addressVO;
    }

    /**
     * Sets the address vo.
     *
     * @param addressVO
     *            the addressVO to set
     */
    public final void setAddressVO(final String addressVO) {
        this.addressVO = addressVO;
    }

}
