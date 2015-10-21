package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author virtusa
 * @version 1.0
 */
public class DiscountResponseObject {

    /** The discount percentage. */
    @JsonProperty("discountPercentage")
    private String discountPercentage;

    /** The discount value. */
    @JsonProperty("discountValue")
    private String discountAmount;

    /** The discount type code. */
    @JsonProperty("discountTypeCode")
    private String discountTypeCode;

    /** The discount type name. */
    @JsonProperty("discountTypeName")
    private String discountTypeName;

    /**
     * @return the discountPercentage
     */
    public String getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * @param discountPercentage
     *            the discountPercentage to set
     */
    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    /**
     * @return the discountAmount
     */
    public String getDiscountAmount() {
        return discountAmount;
    }

    /**
     * @param discountAmount
     *            the discountAmount to set
     */
    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "DiscountResponseObject [discountPercentage="
                + discountPercentage + ", discountAmount=" + discountAmount
                + ", discountTypeCode=" + discountTypeCode
                + ", discountTypeName=" + discountTypeName + "]";
    }

}
