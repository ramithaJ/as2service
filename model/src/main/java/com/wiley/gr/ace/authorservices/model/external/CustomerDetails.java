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
 * @author yugandhark
 *
 */
public class CustomerDetails {

    @JsonProperty("AlternativeName")
    private String alternativeName;

    @JsonProperty("PrimaryEmail")
    private String primaryEmail;

    @JsonProperty("SecondaryEmail")
    private String secondaryEmail;

    @JsonProperty("FirstName")
    private String fName;

    @JsonProperty("MiddleName")
    private String mName;

    @JsonProperty("LastName")
    private String lName;

    @JsonProperty("Suffix")
    private String userSuffix;

    @JsonProperty("ECID")
    private String ecId;

    @JsonProperty("ORCID")
    private String orcId;

    @JsonProperty("OptInFlag")
    private String optInFlag;

    @JsonProperty("JobCategoryCode")
    private String jobCategoryCode;

    @JsonProperty("IndustryCode")
    private String industryCode;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("ProfileVisibility")
    private String profileVisibility;
    
    @JsonProperty("Password")
    private String password;

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
     * @return the primaryEmail
     */
    public final String getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * @param primaryEmail
     *            the primaryEmail to set
     */
    public final void setPrimaryEmail(final String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * @return the secondaryEmail
     */
    public final String getSecondaryEmail() {
        return secondaryEmail;
    }

    /**
     * @param secondaryEmail
     *            the secondaryEmail to set
     */
    public final void setSecondaryEmail(final String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * @return the fName
     */
    public final String getfName() {
        return fName;
    }

    /**
     * @param fName
     *            the fName to set
     */
    public final void setfName(final String fName) {
        this.fName = fName;
    }

    /**
     * @return the mName
     */
    public final String getmName() {
        return mName;
    }

    /**
     * @param mName
     *            the mName to set
     */
    public final void setmName(final String mName) {
        this.mName = mName;
    }

    /**
     * @return the lName
     */
    public final String getlName() {
        return lName;
    }

    /**
     * @param lName
     *            the lName to set
     */
    public final void setlName(final String lName) {
        this.lName = lName;
    }

    /**
     * @return the userSuffix
     */
    public final String getUserSuffix() {
        return userSuffix;
    }

    /**
     * @param userSuffix
     *            the userSuffix to set
     */
    public final void setUserSuffix(final String userSuffix) {
        this.userSuffix = userSuffix;
    }

    /**
     * @return the ecId
     */
    public final String getEcId() {
        return ecId;
    }

    /**
     * @param ecId
     *            the ecId to set
     */
    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    /**
     * @return the orcId
     */
    public final String getOrcId() {
        return orcId;
    }

    /**
     * @param orcId
     *            the orcId to set
     */
    public final void setOrcId(final String orcId) {
        this.orcId = orcId;
    }

    /**
     * @return the optInFlag
     */
    public final String getOptInFlag() {
        return optInFlag;
    }

    /**
     * @param optInFlag
     *            the optInFlag to set
     */
    public final void setOptInFlag(final String optInFlag) {
        this.optInFlag = optInFlag;
    }

    /**
     * @return the jobCategoryCode
     */
    public final String getJobCategoryCode() {
        return jobCategoryCode;
    }

    /**
     * @param jobCategoryCode
     *            the jobCategoryCode to set
     */
    public final void setJobCategoryCode(final String jobCategoryCode) {
        this.jobCategoryCode = jobCategoryCode;
    }

    /**
     * @return the industryCode
     */
    public final String getIndustryCode() {
        return industryCode;
    }

    /**
     * @param industryCode
     *            the industryCode to set
     */
    public final void setIndustryCode(final String industryCode) {
        this.industryCode = industryCode;
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
     * @return the profileVisibility
     */
    public final String getProfileVisibility() {
        return profileVisibility;
    }

    /**
     * @param profileVisibility
     *            the profileVisibility to set
     */
    public final void setProfileVisibility(final String profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

}
