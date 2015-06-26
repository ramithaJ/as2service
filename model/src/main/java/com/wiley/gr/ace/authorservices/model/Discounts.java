/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */

package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Discounts.
 */
@JsonInclude(Include.NON_NULL)
public class Discounts {

    /** The institution id. */
    private String institutionId = "";

    /** The society id. */
    private String societyId = "";

    /** The other discounts. */
    private String otherDiscounts = "";

    /** The promo code. */
    private String promoCode = "";

    /** The original funder. */
    private String originalFunder = "";

    /**
     * Gets the original funder.
     *
     * @return the original funder
     */
    public final String getOriginalFunder() {
        return originalFunder;
    }

    /**
     * Sets the original funder.
     *
     * @param originalFunder
     *            the new original funder
     */
    public final void setOriginalFunder(String originalFunder) {
        this.originalFunder = originalFunder;
    }

    /**
     * Gets the institution id.
     *
     * @return the institution id
     */
    public final String getInstitutionId() {
        return institutionId;
    }

    /**
     * Sets the institution id.
     *
     * @param institutionId
     *            the new institution id
     */
    public final void setInstitutionId(final String institutionId) {
        this.institutionId = institutionId;
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
     * Gets the other discounts.
     *
     * @return the other discounts
     */
    public final String getOtherDiscounts() {
        return otherDiscounts;
    }

    /**
     * Sets the other discounts.
     *
     * @param otherDiscounts
     *            the new other discounts
     */
    public final void setOtherDiscounts(final String otherDiscounts) {
        this.otherDiscounts = otherDiscounts;
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

}
