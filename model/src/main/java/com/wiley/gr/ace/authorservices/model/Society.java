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
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Society.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Society implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** The user Id . */

    private String userId;

    /** The society id. */
    @NotNull
    @NotBlank
    private String societyId;

    /** The society name. */
    @NotNull
    @NotBlank
    private String societyName;

    /** The membership number. */
    @NotNull
    @NotBlank
    private String membershipNumber;

    /** The promo code. */
    @NotNull
    @NotBlank
    private String promoCode;

    /** The start date. */
    @NotNull
    private Date startDate;

    /** The end date. */
    @NotNull
    private Date endDate;

    /**
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the societyId
     */
    public final String getSocietyId() {
        return societyId;
    }

    /**
     * @param societyId
     *            the societyId to set
     */
    public final void setSocietyId(final String societyId) {
        this.societyId = societyId;
    }

    /**
     * @return the societyName
     */
    public final String getSocietyName() {
        return societyName;
    }

    /**
     * @param societyName
     *            the societyName to set
     */
    public final void setSocietyName(final String societyName) {
        this.societyName = societyName;
    }

    /**
     * @return the membershipNumber
     */
    public final String getMembershipNumber() {
        return membershipNumber;
    }

    /**
     * @param membershipNumber
     *            the membershipNumber to set
     */
    public final void setMembershipNumber(final String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    /**
     * @return the promoCode
     */
    public final String getPromoCode() {
        return promoCode;
    }

    /**
     * @param promoCode
     *            the promoCode to set
     */
    public final void setPromoCode(final String promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * @return the startDate
     */
    public final Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public final void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public final Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public final void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

}
