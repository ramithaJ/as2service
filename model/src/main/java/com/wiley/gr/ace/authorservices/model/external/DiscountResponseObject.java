package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscountResponseObject {

	@JsonProperty("DiscountPercentage")
	private String discountPercentage;

	@JsonProperty("DiscountAmount")
	private String discountAmount;

	@JsonProperty("isValid")
	private Boolean isValid;

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

	/**
	 * @return the isValid
	 */
	public Boolean getIsValid() {
		return isValid;
	}

	/**
	 * @param isValid
	 *            the isValid to set
	 */
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "DiscountResponseObject [discountPercentage="
				+ discountPercentage + ", discountAmount=" + discountAmount
				+ ", isValid=" + isValid + "]";
	}

}
