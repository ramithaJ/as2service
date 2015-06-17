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
     * @return the discountValue
     */
    public final String getDiscountValue() {
        return discountValue;
    }

    /**
     * @param discountValue
     *            the discountValue to set
     */
    public final void setDiscountValue(final String discountValue) {
        this.discountValue = discountValue;
    }

    /**
     * @return the discountType
     */
    public final String getDiscountType() {
        return discountType;
    }

    /**
     * @param discountType
     *            the discountType to set
     */
    public final void setDiscountType(final String discountType) {
        this.discountType = discountType;
    }

    /**
     * @return the societyCode
     */
    public final String getSocietyCode() {
        return societyCode;
    }

    /**
     * @param societyCode
     *            the societyCode to set
     */
    public final void setSocietyCode(final String societyCode) {
        this.societyCode = societyCode;
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
     * @return the otherDiscounts
     */
    public final String getOtherDiscounts() {
        return otherDiscounts;
    }

    /**
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
