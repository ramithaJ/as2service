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
package com.wiley.gr.ace.authorservices.model.external.lookup;

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
    private String firstName;

    @JsonProperty("MiddleName")
    private String middleName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Suffix")
    private String suffix;

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

    public final String getAlternativeName() {
        return alternativeName;
    }

    public final void setAlternativeName(final String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public final String getPrimaryEmail() {
        return primaryEmail;
    }

    public final void setPrimaryEmail(final String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public final String getSecondaryEmail() {
        return secondaryEmail;
    }

    public final void setSecondaryEmail(final String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getMiddleName() {
        return middleName;
    }

    public final void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getSuffix() {
        return suffix;
    }

    public final void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

    public final String getEcId() {
        return ecId;
    }

    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    public final String getOrcId() {
        return orcId;
    }

    public final void setOrcId(final String orcId) {
        this.orcId = orcId;
    }

    public final String getOptInFlag() {
        return optInFlag;
    }

    public final void setOptInFlag(final String optInFlag) {
        this.optInFlag = optInFlag;
    }

    public final String getJobCategoryCode() {
        return jobCategoryCode;
    }

    public final void setJobCategoryCode(final String jobCategoryCode) {
        this.jobCategoryCode = jobCategoryCode;
    }

    public final String getIndustryCode() {
        return industryCode;
    }

    public final void setIndustryCode(final String industryCode) {
        this.industryCode = industryCode;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getProfileVisibility() {
        return profileVisibility;
    }

    public final void setProfileVisibility(final String profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

}
