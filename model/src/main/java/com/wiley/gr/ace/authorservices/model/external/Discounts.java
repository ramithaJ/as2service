package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Discounts {
      
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