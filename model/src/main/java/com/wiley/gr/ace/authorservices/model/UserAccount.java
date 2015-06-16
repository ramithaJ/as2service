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
    public Title getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the new title
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * Gets the suffix.
     *
     * @return the suffix
     */
    public Suffix getSuffix() {
        return suffix;
    }

    /**
     * Sets the suffix.
     *
     * @param suffix
     *            the new suffix
     */
    public void setSuffix(Suffix suffix) {
        this.suffix = suffix;
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
     * Gets the alternative name.
     *
     * @return the alternative name
     */
    public String getAlternativeName() {
        return alternativeName;
    }

    /**
     * Sets the alternative name.
     *
     * @param alternativeName
     *            the new alternative name
     */
    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

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
    public String getOrcidId() {
        return orcidId;
    }

    /**
     * Sets the orcid id.
     *
     * @param orcidId
     *            the new orcid id
     */
    public void setOrcidId(String orcidId) {
        this.orcidId = orcidId;
    }

    /**
     * Checks if is opt in flag.
     *
     * @return true, if is opt in flag
     */
    public boolean isOptInFlag() {
        return optInFlag;
    }

    /**
     * Sets the opt in flag.
     *
     * @param optInFlag
     *            the new opt in flag
     */
    public void setOptInFlag(boolean optInFlag) {
        this.optInFlag = optInFlag;
    }

    /**
     * Checks if is profile visibility flag.
     *
     * @return true, if is profile visibility flag
     */
    public boolean isProfileVisibilityFlag() {
        return profileVisibilityFlag;
    }

    /**
     * Sets the profile visibility flag.
     *
     * @param profileVisibilityFlag
     *            the new profile visibility flag
     */
    public void setProfileVisibilityFlag(boolean profileVisibilityFlag) {
        this.profileVisibilityFlag = profileVisibilityFlag;
    }

    /**
     * Checks if is profile visibility map.
     *
     * @return true, if is profile visibility map
     */
    public boolean isProfileVisibilityMap() {
        return profileVisibilityMap;
    }

    /**
     * Sets the profile visibility map.
     *
     * @param profileVisibilityMap
     *            the new profile visibility map
     */
    public void setProfileVisibilityMap(boolean profileVisibilityMap) {
        this.profileVisibilityMap = profileVisibilityMap;
    }

    /**
     * Gets the email vo.
     *
     * @return the email vo
     */
    public String getEmailVO() {
        return emailVO;
    }

    /**
     * Sets the email vo.
     *
     * @param emailVO
     *            the new email vo
     */
    public void setEmailVO(String emailVO) {
        this.emailVO = emailVO;
    }

    /**
     * Gets the sequrity vo.
     *
     * @return the sequrity vo
     */
    public String getSequrityVO() {
        return sequrityVO;
    }

    /**
     * Sets the sequrity vo.
     *
     * @param sequrityVO
     *            the new sequrity vo
     */
    public void setSequrityVO(String sequrityVO) {
        this.sequrityVO = sequrityVO;
    }

    /**
     * Gets the address vo.
     *
     * @return the address vo
     */
    public String getAddressVO() {
        return addressVO;
    }

    /**
     * Sets the address vo.
     *
     * @param addressVO
     *            the new address vo
     */
    public void setAddressVO(String addressVO) {
        this.addressVO = addressVO;
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

}
