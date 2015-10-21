package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Discounts.
 *
 * @author virtusa
 * @version 1.0
 */
public class Discounts {
    /** The discount data. */
    @JsonProperty("discount")
    private DiscountData discountData;

    /**
     * 
     * @return The discountData
     */
    public DiscountData getDiscount() {
        return discountData;
    }

    /**
     * 
     * @param discountData
     *            The discountData
     */
    public void setDiscount(final DiscountData discountData) {
        this.discountData = discountData;
    }

}