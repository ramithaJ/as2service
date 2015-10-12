/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * @author virtusa version 1.0
 *
 */
public class ProfileRequest {

    /**
     * This field holds the value of titleCode.
     */
    private String titleCode;

    /**
     * This field holds the value of firstName.
     */
    private String firstName;

    /**
     * This field holds the value of middleName.
     */
    private String middleName;

    /**
     * This field holds the value of lastName.
     */
    private String lastName;

    /**
     * This field holds the value of suffixCode.
     */
    private String suffixCode;

    /**
     * This field holds the value of alternativeName.
     */
    private String alternativeName;

    /**
     * This field holds the value of industryCode.
     */
    private String industryCode;

    /**
     * This field holds the value of jobCategoryCode.
     */
    private String jobCategoryCode;

    /**
     * This field holds the value of sendEmail.
     */
    private String sendEmail;

    /**
     * This field holds the value of primaryEmail.
     */
    private String primaryEmail;

    /**
     * This field holds the value of recoveryEmail.
     */
    private String recoveryEmail;

    /**
     * This field holds the value of oldEmail.
     */
    private String oldEmail;

    /**
     * This field holds the value of interestList.
     */
    private List<InterestList> interestList;

    /**
     * This field holds the value of orcid.
     */
    private String orcid;

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
     * @return the recoveryEmail
     */
    public final String getRecoveryEmail() {
        return recoveryEmail;
    }

    /**
     * @param recoveryEmail
     *            the recoveryEmail to set
     */
    public final void setRecoveryEmail(final String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    /**
     * @return the oldEmail
     */
    public final String getOldEmail() {
        return oldEmail;
    }

    /**
     * @param oldEmail
     *            the oldEmail to set
     */
    public final void setOldEmail(final String oldEmail) {
        this.oldEmail = oldEmail;
    }

    /**
     * @return the interestList
     */
    public final List<InterestList> getInterestList() {
        return interestList;
    }

    /**
     * @param interestList
     *            the interestList to set
     */
    public final void setInterestList(final List<InterestList> interestList) {
        this.interestList = interestList;
    }

    /**
     * @return the orcid
     */
    public final String getOrcid() {
        return orcid;
    }

    /**
     * @param orcid
     *            the orcid to set
     */
    public final void setOrcid(final String orcid) {
        this.orcid = orcid;
    }

    /**
     * @return the titleCode
     */
    public final String getTitleCode() {
        return titleCode;
    }

    /**
     * @param titleCode
     *            the titleCode to set
     */
    public final void setTitleCode(final String titleCode) {
        this.titleCode = titleCode;
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
     * @return the suffixCode
     */
    public final String getSuffixCode() {
        return suffixCode;
    }

    /**
     * @param suffixCode
     *            the suffixCode to set
     */
    public final void setSuffixCode(final String suffixCode) {
        this.suffixCode = suffixCode;
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
     * @return the sendEmail
     */
    public final String getSendEmail() {
        return sendEmail;
    }

    /**
     * @param sendEmail
     *            the sendEmail to set
     */
    public final void setSendEmail(final String sendEmail) {
        this.sendEmail = sendEmail;
    }

}
