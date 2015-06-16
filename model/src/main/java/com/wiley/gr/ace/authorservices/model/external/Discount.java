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

    /** The promo code. */
    private String promoCode;

    /** The other discounts. */
    private String otherDiscounts;

    /**
     * Gets the discount value.
     *
     * @return the discount value
     */
    public String getDiscountValue() {
        return discountValue;
    }

    /**
     * Sets the discount value.
     *
     * @param discountValue
     *            the new discount value
     */
    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    /**
     * Gets the discount type.
     *
     * @return the discount type
     */
    public String getDiscountType() {
        return discountType;
    }

    /**
     * Sets the discount type.
     *
     * @param discountType
     *            the new discount type
     */
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * Gets the society code.
     *
     * @return the society code
     */
    public String getSocietyCode() {
        return societyCode;
    }

    /**
     * Sets the society code.
     *
     * @param societyCode
     *            the new society code
     */
    public void setSocietyCode(String societyCode) {
        this.societyCode = societyCode;
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
     * Gets the other discounts.
     *
     * @return the other discounts
     */
    public String getOtherDiscounts() {
        return otherDiscounts;
    }

    /**
     * Sets the other discounts.
     *
     * @param otherDiscounts
     *            the new other discounts
     */
    public void setOtherDiscounts(String otherDiscounts) {
        this.otherDiscounts = otherDiscounts;
    }
}