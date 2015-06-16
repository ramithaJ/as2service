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
public class Society {

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
     * Gets the user Id.
     *
     * @return the user Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user Id.
     *
     * @param userId
     *            the new user id
     * @return the user Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the society id.
     *
     * @return the society id
     */
    public String getSocietyId() {
        return societyId;
    }

    /**
     * Sets the society id.
     *
     * @param societyId
     *            the new society id
     */
    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    /**
     * Gets the society name.
     *
     * @return the society name
     */
    public String getSocietyName() {
        return societyName;
    }

    /**
     * Sets the society name.
     *
     * @param societyName
     *            the new society name
     */
    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    /**
     * Gets the membership number.
     *
     * @return the membership number
     */
    public String getMembershipNumber() {
        return membershipNumber;
    }

    /**
     * Sets the membership number.
     *
     * @param membershipNumber
     *            the new membership number
     */
    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    /**
     * Gets the promo code.
     *
     * @return the promo code
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the promo code.
     *
     * @param promoCode
     *            the new promo code
     */
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate
     *            the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate
     *            the new end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
