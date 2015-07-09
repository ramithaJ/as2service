/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
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

/**
 * The Class Discount.
 *
 * @author virtusa version 1.0
 */
public class Discount {

    /** The discount value. */
    private String discountValue;

    /** The discount type. */
    private String discountType;

    /** The society code. */
    private String societyCode;

    /**
     * Gets the discount value.
     *
     * @return the discountValue
     */
    public final String getDiscountValue() {
        return discountValue;
    }

    /**
     * Sets the discount value.
     *
     * @param discountValue
     *            the discountValue to set
     */
    public final void setDiscountValue(final String discountValue) {
        this.discountValue = discountValue;
    }

    /**
     * Gets the discount type.
     *
     * @return the discountType
     */
    public final String getDiscountType() {
        return discountType;
    }

    /**
     * Sets the discount type.
     *
     * @param discountType
     *            the discountType to set
     */
    public final void setDiscountType(final String discountType) {
        this.discountType = discountType;
    }

    /**
     * Gets the society code.
     *
     * @return the societyCode
     */
    public final String getSocietyCode() {
        return societyCode;
    }

    /**
     * Sets the society code.
     *
     * @param societyCode
     *            the societyCode to set
     */
    public final void setSocietyCode(final String societyCode) {
        this.societyCode = societyCode;
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
     * Gets the other discounts.
     *
     * @return the otherDiscounts
     */
    public final String getOtherDiscounts() {
        return otherDiscounts;
    }

    /**
     * Sets the other discounts.
     *
     * @param otherDiscounts
     *            the otherDiscounts to set
     */
    public final void setOtherDiscounts(final String otherDiscounts) {
        this.otherDiscounts = otherDiscounts;
    }

    /** The promo code. */
    private String promoCode;

    /** The other discounts. */
    private String otherDiscounts;

}
