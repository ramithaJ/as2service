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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CustomerDetails.
 *
 * @author yugandhark
 */
@JsonInclude(Include.NON_NULL)
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

    /** The l name. */
    @JsonProperty("LastName")
    private String lName;
    
    /** The m name. */
    @JsonProperty("MiddleName")
    private String mName;

    /** The user suffix. */
    @JsonProperty("Suffix")
    private String userSuffix;

    /** The ec id. */
    @JsonProperty("ECID")
    private String ecId;

    /** The ec id. */
    @JsonProperty("Password")
    private String pswd;
    
    /** The ec id. */
    @JsonProperty("ASID")
    private String asid;
    
    /** The ec id. */
    @JsonProperty("UserRole")
    private String userRole;
    
    /** The ec id. */
    @JsonProperty("NickName")
    private String nickName;
    
    /** The orc id. */
    @JsonProperty("ORCID")
    private String orcId;

    /** The opt in flag. */
    @JsonProperty("OptInFlag")
    private String optInFlag;

    /** The opt in flag. */
    @JsonProperty("CustomerType")
    private String customerType;
    
    /** The opt in flag. */
    @JsonProperty("UserStatus")
    private String userStatus;
    
    /** The opt in flag. */
    @JsonProperty("TCFlag")
    private String tcFlag;
    
    /** The opt in flag. */
    @JsonProperty("SendEmail")
    private String sendEmail;
    
    /** The job category code. */
    @JsonProperty("JobCategoryCode")
    private String jobCategoryCode;

    /** The industry code. */
    @JsonProperty("IndustryCode")
    private String industryCode;

    /** The profile visibility. */
    @JsonProperty("ProfileVisibility")
    private String profileVisibility;
    
    /** The title. */
    @JsonProperty("Title")
    private String title;

    @JsonProperty("SkipTargetSystem")
    private String skipTargetSystem;

    /**
     * @return the alternativeName
     */
    public final String getAlternativeName() {
        return alternativeName;
    }

    /**
     * @param alternativeName the alternativeName to set
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
     * @param primaryEmail the primaryEmail to set
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
     * @param secondaryEmail the secondaryEmail to set
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
     * @param fName the fName to set
     */
    public final void setfName(final String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public final String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public final void setlName(final String lName) {
        this.lName = lName;
    }

    /**
     * @return the mName
     */
    public final String getmName() {
        return mName;
    }

    /**
     * @param mName the mName to set
     */
    public final void setmName(final String mName) {
        this.mName = mName;
    }

    /**
     * @return the userSuffix
     */
    public final String getUserSuffix() {
        return userSuffix;
    }

    /**
     * @param userSuffix the userSuffix to set
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
     * @param ecId the ecId to set
     */
    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    /**
     * @return the pswd
     */
    public final String getPswd() {
        return pswd;
    }

    /**
     * @param pswd the pswd to set
     */
    public final void setPswd(final String pswd) {
        this.pswd = pswd;
    }

    /**
     * @return the asid
     */
    public final String getAsid() {
        return asid;
    }

    /**
     * @param asid the asid to set
     */
    public final void setAsid(final String asid) {
        this.asid = asid;
    }

    /**
     * @return the userRole
     */
    public final String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public final void setUserRole(final String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the nickName
     */
    public final String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public final void setNickName(final String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the orcId
     */
    public final String getOrcId() {
        return orcId;
    }

    /**
     * @param orcId the orcId to set
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
     * @param optInFlag the optInFlag to set
     */
    public final void setOptInFlag(final String optInFlag) {
        this.optInFlag = optInFlag;
    }

    /**
     * @return the customerType
     */
    public final String getCustomerType() {
        return customerType;
    }

    /**
     * @param customerType the customerType to set
     */
    public final void setCustomerType(final String customerType) {
        this.customerType = customerType;
    }

    /**
     * @return the userStatus
     */
    public final String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus the userStatus to set
     */
    public final void setUserStatus(final String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return the tcFlag
     */
    public final String getTcFlag() {
        return tcFlag;
    }

    /**
     * @param tcFlag the tcFlag to set
     */
    public final void setTcFlag(final String tcFlag) {
        this.tcFlag = tcFlag;
    }

    /**
     * @return the sendEmail
     */
    public final String getSendEmail() {
        return sendEmail;
    }

    /**
     * @param sendEmail the sendEmail to set
     */
    public final void setSendEmail(final String sendEmail) {
        this.sendEmail = sendEmail;
    }

    /**
     * @return the jobCategoryCode
     */
    public final String getJobCategoryCode() {
        return jobCategoryCode;
    }

    /**
     * @param jobCategoryCode the jobCategoryCode to set
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
     * @param industryCode the industryCode to set
     */
    public final void setIndustryCode(final String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * @return the profileVisibility
     */
    public final String getProfileVisibility() {
        return profileVisibility;
    }

    /**
     * @param profileVisibility the profileVisibility to set
     */
    public final void setProfileVisibility(final String profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

    /**
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return the skipTargetSystem
     */
    public final String getSkipTargetSystem() {
        return skipTargetSystem;
    }

    /**
     * @param skipTargetSystem the skipTargetSystem to set
     */
    public final void setSkipTargetSystem(final String skipTargetSystem) {
        this.skipTargetSystem = skipTargetSystem;
    }
    
    

}
