package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscountResponseObject {

	@JsonProperty("discountPercentage")
	private String discountPercentage;

	@JsonProperty("discountValue")
	private String discountAmount;

	@JsonProperty("discountTypeCode")
	private String discountTypeCode;

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
