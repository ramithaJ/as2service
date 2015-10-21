package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscountResponse {

    @JsonProperty("Discount")
    private DiscountResponseObject discountResponseObject;

    /**
     * @return the discountResponseObject
     */
    public DiscountResponseObject getDiscountResponseObject() {
        return discountResponseObject;
    }

    /**
     * @param discountResponseObject
     *            the discountResponseObject to set
     */
    public void setDiscountResponseObject(
            DiscountResponseObject discountResponseObject) {
        this.discountResponseObject = discountResponseObject;
    }

    @Override
    public String toString() {
        return "DiscountResponse [discountResponseObject="
                + discountResponseObject + "]";
    }

}
