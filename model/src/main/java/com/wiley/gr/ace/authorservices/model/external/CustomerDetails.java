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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CustomerDetails.
 *
 * @author yugandhark
 */
public class CustomerDetails {

    /** The alternative name. */
    @JsonProperty("AlternativeName")
    private String alternativeName;

    /** The primary email. */
    @JsonProperty("PrimaryEmail")
    private String primaryEmail;

    /** The secondary email. */
    @JsonProperty("SecondaryEmail")
    private String secondaryEmail;

    /** The name. */
    @JsonProperty("FirstName")
    private String fName;

    /** The m name. */
    @JsonProperty("MiddleName")
    private String mName;

    /** The l name. */
    @JsonProperty("LastName")
    private String lName;

    /** The user suffix. */
    @JsonProperty("Suffix")
    private String userSuffix;

    /** The ec id. */
    @JsonProperty("ECID")
    private String ecId;

    /** The orc id. */
    @JsonProperty("ORCID")
    private String orcId;

    /** The opt in flag. */
    @JsonProperty("OptInFlag")
    private String optInFlag;

    /** The job category code. */
    @JsonProperty("JobCategoryCode")
    private String jobCategoryCode;

    /** The industry code. */
    @JsonProperty("IndustryCode")
    private String industryCode;

    /** The title. */
    @JsonProperty("Title")
    private String title;

    /** The profile visibility. */
    @JsonProperty("ProfileVisibility")
    private String profileVisibility;
    
    /** The password. */
    @JsonProperty("Password")
    private String password;

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
     * @param alternativeName            the alternativeName to set
     */
    public final void setAlternativeName(final String alternativeName) {
        this.alternativeName = alternativeName;
    }

    /**
     * Gets the primary email.
     *
     * @return the primaryEmail
     */
    public final String getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * Sets the primary email.
     *
     * @param primaryEmail            the primaryEmail to set
     */
    public final void setPrimaryEmail(final String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * Gets the secondary email.
     *
     * @return the secondaryEmail
     */
    public final String getSecondaryEmail() {
        return secondaryEmail;
    }

    /**
     * Sets the secondary email.
     *
     * @param secondaryEmail            the secondaryEmail to set
     */
    public final void setSecondaryEmail(final String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * Gets the f name.
     *
     * @return the fName
     */
    public final String getfName() {
        return fName;
    }

    /**
     * Sets the f name.
     *
     * @param fName            the fName to set
     */
    public final void setfName(final String fName) {
        this.fName = fName;
    }

    /**
     * Gets the m name.
     *
     * @return the mName
     */
    public final String getmName() {
        return mName;
    }

    /**
     * Sets the m name.
     *
     * @param mName            the mName to set
     */
    public final void setmName(final String mName) {
        this.mName = mName;
    }

    /**
     * Gets the l name.
     *
     * @return the lName
     */
    public final String getlName() {
        return lName;
    }

    /**
     * Sets the l name.
     *
     * @param lName            the lName to set
     */
    public final void setlName(final String lName) {
        this.lName = lName;
    }

    /**
     * Gets the user suffix.
     *
     * @return the userSuffix
     */
    public final String getUserSuffix() {
        return userSuffix;
    }

    /**
     * Sets the user suffix.
     *
     * @param userSuffix            the userSuffix to set
     */
    public final void setUserSuffix(final String userSuffix) {
        this.userSuffix = userSuffix;
    }

    /**
     * Gets the ec id.
     *
     * @return the ecId
     */
    public final String getEcId() {
        return ecId;
    }

    /**
     * Sets the ec id.
     *
     * @param ecId            the ecId to set
     */
    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    /**
     * Gets the orc id.
     *
     * @return the orcId
     */
    public final String getOrcId() {
        return orcId;
    }

    /**
     * Sets the orc id.
     *
     * @param orcId            the orcId to set
     */
    public final void setOrcId(final String orcId) {
        this.orcId = orcId;
    }

    /**
     * Gets the opt in flag.
     *
     * @return the optInFlag
     */
    public final String getOptInFlag() {
        return optInFlag;
    }

    /**
     * Sets the opt in flag.
     *
     * @param optInFlag            the optInFlag to set
     */
    public final void setOptInFlag(final String optInFlag) {
        this.optInFlag = optInFlag;
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
     * @param jobCategoryCode            the jobCategoryCode to set
     */
    public final void setJobCategoryCode(final String jobCategoryCode) {
        this.jobCategoryCode = jobCategoryCode;
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
     * @param industryCode            the industryCode to set
     */
    public final void setIndustryCode(final String industryCode) {
        this.industryCode = industryCode;
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
     * @param title            the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the profile visibility.
     *
     * @return the profileVisibility
     */
    public final String getProfileVisibility() {
        return profileVisibility;
    }

    /**
     * Sets the profile visibility.
     *
     * @param profileVisibility            the profileVisibility to set
     */
    public final void setProfileVisibility(final String profileVisibility) {
        this.profileVisibility = profileVisibility;
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
     * @param password the new password
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

}
