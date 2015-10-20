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
     * @return the title
     */
    public final Title getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public final void setTitle(final Title title) {
        this.title = title;
    }

    /**
     * @return the suffix
     */
    public final Suffix getSuffix() {
        return suffix;
    }

    /**
     * @param suffix
     *            the suffix to set
     */
    public final void setSuffix(final Suffix suffix) {
        this.suffix = suffix;
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
     * @return the alternativeName
     */
    public final String getAlternativeName() {
        return alternativeName;
    }

    /**
     * @param alternativeName
     *            the alternativeName to set
     */
    public final void setAlternativeName(final String alternativeName) {
        this.alternativeName = alternativeName;
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
     * @return the orcidId
     */
    public final String getOrcidId() {
        return orcidId;
    }

    /**
     * @param orcidId
     *            the orcidId to set
     */
    public final void setOrcidId(final String orcidId) {
        this.orcidId = orcidId;
    }

    /**
     * @return the optInFlag
     */
    public final boolean isOptInFlag() {
        return optInFlag;
    }

    /**
     * @param optInFlag
     *            the optInFlag to set
     */
    public final void setOptInFlag(final boolean optInFlag) {
        this.optInFlag = optInFlag;
    }

    /**
     * @return the profileVisibilityFlag
     */
    public final boolean isProfileVisibilityFlag() {
        return profileVisibilityFlag;
    }

    /**
     * @param profileVisibilityFlag
     *            the profileVisibilityFlag to set
     */
    public final void setProfileVisibilityFlag(
            final boolean profileVisibilityFlag) {
        this.profileVisibilityFlag = profileVisibilityFlag;
    }

    /**
     * @return the profileVisibilityMap
     */
    public final boolean isProfileVisibilityMap() {
        return profileVisibilityMap;
    }

    /**
     * @param profileVisibilityMap
     *            the profileVisibilityMap to set
     */
    public final void setProfileVisibilityMap(final boolean profileVisibilityMap) {
        this.profileVisibilityMap = profileVisibilityMap;
    }

    /**
     * @return the emailVO
     */
    public final String getEmailVO() {
        return emailVO;
    }

    /**
     * @param emailVO
     *            the emailVO to set
     */
    public final void setEmailVO(final String emailVO) {
        this.emailVO = emailVO;
    }

    /**
     * @return the sequrityVO
     */
    public final String getSequrityVO() {
        return sequrityVO;
    }

    /**
     * @param sequrityVO
     *            the sequrityVO to set
     */
    public final void setSequrityVO(final String sequrityVO) {
        this.sequrityVO = sequrityVO;
    }

    /**
     * @return the addressVO
     */
    public final String getAddressVO() {
        return addressVO;
    }

    /**
     * @param addressVO
     *            the addressVO to set
     */
    public final void setAddressVO(final String addressVO) {
        this.addressVO = addressVO;
    }

}
