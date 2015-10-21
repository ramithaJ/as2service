package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class DiscountedSociety.
 * 
 * @author virtusa version 1.0
 */
public class DiscountedSociety {

    /** The discount value type. */
    @JsonProperty("discountValueType")
    private String discountValueType;

    /** The discount value. */
    @JsonProperty("discountValue")
    private String discountValue;

    /** The discount code. */
    @JsonProperty("discountCode")
    private String discountCode;

    /** The discount type name. */
    @JsonProperty("discountTypeName")
    private String discountTypeName;

    /** The promo code. */
    @JsonProperty("promoCode")
    private String promoCode;

    /**
     * @return the discountValueType
     */
    public String getDiscountValueType() {
        return discountValueType;
    }

    /**
     * @param discountValueType
     *            the discountValueType to set
     */
    public void setDiscountValueType(String discountValueType) {
        this.discountValueType = discountValueType;
    }

    /**
     * @return the discountValue
     */
    public String getDiscountValue() {
        return discountValue;
    }

    /**
     * @param discountValue
     *            the discountValue to set
     */
    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }

    /**
     * @return the discountCode
     */
    public String getDiscountCode() {
        return discountCode;
    }

    /**
     * @param discountCode
     *            the discountCode to set
     */
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    /**
     * @return the discountTypeName
     */
    public String getDiscountTypeName() {
        return discountTypeName;
    }

    /**
     * @param discountTypeName
     *            the discountTypeName to set
     */
    public void setDiscountTypeName(String discountTypeName) {
        this.discountTypeName = discountTypeName;
    }

    /**
     * @return the promoCode
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * @param promoCode
     *            the promoCode to set
     */
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

}