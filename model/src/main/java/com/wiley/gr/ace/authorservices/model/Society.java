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

    /** The Constant serialVersionUID. */
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
    private String startDate;

    /** The end date. */
    @NotNull
    private String endDate;

    
    private String id;
    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId(final String id) {
        this.id = id;
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
     * Gets the society id.
     *
     * @return the societyId
     */
    public final String getSocietyId() {
        return societyId;
    }

    /**
     * Sets the society id.
     *
     * @param societyId
     *            the societyId to set
     */
    public final void setSocietyId(final String societyId) {
        this.societyId = societyId;
    }

    /**
     * Gets the society name.
     *
     * @return the societyName
     */
    public final String getSocietyName() {
        return societyName;
    }

    /**
     * Sets the society name.
     *
     * @param societyName
     *            the societyName to set
     */
    public final void setSocietyName(final String societyName) {
        this.societyName = societyName;
    }

    /**
     * Gets the membership number.
     *
     * @return the membershipNumber
     */
    public final String getMembershipNumber() {
        return membershipNumber;
    }

    /**
     * Sets the membership number.
     *
     * @param membershipNumber
     *            the membershipNumber to set
     */
    public final void setMembershipNumber(final String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    /**
     * Gets the promo code.
     *
     * @return the promoCode
     */
    public final String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the promo code.
     *
     * @param promoCode
     *            the promoCode to set
     */
    public final void setPromoCode(final String promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * Gets the start date.
     *
     * @return the startDate
     */
    public final String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate
     *            the startDate to set
     */
    public final void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the endDate
     */
    public final String getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate
     *            the endDate to set
     */
    public final void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

}
