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

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Society.
 *
 * @author yugandhark
 */
@JsonInclude(Include.NON_NULL)
public class SocietyData implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @JsonProperty("Id")
    private String id;

    /** The society name. */
    @JsonProperty("SocietyName")
    private String societyName;

    /** The start date. */
    @JsonProperty("StartDate")
    private String startDate;

    /** The end date. */
    @JsonProperty("EndDate")
    private String endDate;

    /** The promo code. */
    @JsonProperty("PromoCode")
    private String promoCode;

    /** The membership no. */
    @JsonProperty("MembershipNo")
    private String membershipNo;

    /** The society id. */
    @JsonProperty("SocietyID")
    private String societyId;

    /** The status. */
    @JsonProperty("Status")
    private String status;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the society name.
     *
     * @return the society name
     */
    public final String getSocietyName() {
        return societyName;
    }

    /**
     * Sets the society name.
     *
     * @param societyName
     *            the new society name
     */
    public final void setSocietyName(final String societyName) {
        this.societyName = societyName;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public final String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate
     *            the new start date
     */
    public final void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public final String getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate
     *            the new end date
     */
    public final void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the promo code.
     *
     * @return the promo code
     */
    public final String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the promo code.
     *
     * @param promoCode
     *            the new promo code
     */
    public final void setPromoCode(final String promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * Gets the membership no.
     *
     * @return the membership no
     */
    public final String getMembershipNo() {
        return membershipNo;
    }

    /**
     * Sets the membership no.
     *
     * @param membershipNo
     *            the new membership no
     */
    public final void setMembershipNo(final String membershipNo) {
        this.membershipNo = membershipNo;
    }

    /**
     * Gets the society id.
     *
     * @return the society id
     */
    public final String getSocietyId() {
        return societyId;
    }

    /**
     * Sets the society id.
     *
     * @param societyId
     *            the new society id
     */
    public final void setSocietyId(final String societyId) {
        this.societyId = societyId;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

}
