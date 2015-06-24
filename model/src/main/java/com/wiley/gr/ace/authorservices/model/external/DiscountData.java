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
 * The Class DiscountData.
 *
 * @author virtusa version 1.0
 */
public class DiscountData {

    /** The discount value. */
    private Double discountValue;

    /** The discount type code. */
    private String discountTypeCode;

    /** The discount type name. */
    private String discountTypeName;

    /** The society data. */
    private SocietyData societyData;

    /** The promo code. */
    private String promoCode;

    /** The affiliation data. */
    private AffiliationData affiliationData;

    /**
     * Gets the discount value.
     *
     * @return The discountValue
     */
    public Double getDiscountValue() {
        return discountValue;
    }

    /**
     * Sets the discount value.
     *
     * @param discountValue
     *            The discountValue
     */
    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    /**
     * Gets the discount type code.
     *
     * @return The discountTypeCode
     */
    public String getDiscountTypeCode() {
        return discountTypeCode;
    }

    /**
     * Sets the discount type code.
     *
     * @param discountTypeCode
     */
    public void setDiscountTypeCode(String discountTypeCode) {
        this.discountTypeCode = discountTypeCode;
    }

    /**
     * Gets the discount type name.
     *
     * @return The discountTypeName
     */
    public String getDiscountTypeName() {
        return discountTypeName;
    }

    /**
     * Sets the discount type name.
     *
     * @param discountTypeName
     */
    public void setDiscountTypeName(String discountTypeName) {
        this.discountTypeName = discountTypeName;
    }

    /**
     * Gets the society data.
     *
     * @return The societyData
     */
    public SocietyData getSocietyData() {
        return societyData;
    }

    /**
     * Sets the society data.
     *
     * @param societyData
     */
    public void setSocietyData(SocietyData societyData) {
        this.societyData = societyData;
    }

    /**
     * Gets the promo code.
     *
     * @return The promoCode
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the promo code.
     *
     * @param promoCode
     */
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * Gets the affiliation data.
     *
     * @return The affiliationData
     */
    public AffiliationData getAffiliationData() {
        return affiliationData;
    }

    /**
     * Sets the affiliation data.
     *
     * @param affiliationData
     */
    public void setAffiliationData(AffiliationData affiliationData) {
        this.affiliationData = affiliationData;
    }

}
