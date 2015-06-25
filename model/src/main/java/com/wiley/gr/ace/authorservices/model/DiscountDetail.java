package com.wiley.gr.ace.authorservices.model;

public class DiscountDetail {

	/**
	 * This field holds the value of discountType
	 */
	private String discountType;

	/**
	 * This field holds the value of discountPercent
	 */
	private String discountPercent;

	/**
	 * This field holds the value of discountAmount
	 */
	private String discountAmount;

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
	public final void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	/**
	 * @return the discountPercent
	 */
	public final String getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * @param discountPercent
	 *            the discountPercent to set
	 */
	public final void setDiscountPercent(String discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * @return the discountAmount
	 */
	public final String getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount
	 *            the discountAmount to set
	 */
	public final void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

}
