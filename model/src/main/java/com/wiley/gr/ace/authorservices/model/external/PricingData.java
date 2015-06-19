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
 * The Class Pricing.
 *
 * @author virtusa version 1.0
 */
public class PricingData {

	private Double productBasePrice;
	private Double amountToBePaid;
	private String currency;
	private Discounts discounts;

	/**
	 * 
	 * @return The productBasePrice
	 */
	public Double getProductBasePrice() {
		return productBasePrice;
	}

	/**
	 * 
	 * @param productBasePrice
	 *            The productBasePrice
	 */
	public void setProductBasePrice(Double productBasePrice) {
		this.productBasePrice = productBasePrice;
	}

	/**
	 * 
	 * @return The amountToBePaid
	 */
	public Double getAmountToBePaid() {
		return amountToBePaid;
	}

	/**
	 * 
	 * @param amountToBePaid
	 *            The amountToBePaid
	 */
	public void setAmountToBePaid(Double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

	/**
	 * 
	 * @return The currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @param currency
	 *            The currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 
	 * @return The discounts
	 */
	public Discounts getDiscounts() {
		return discounts;
	}

	/**
	 * 
	 * @param discounts
	 *            The discounts
	 */
	public void setDiscounts(Discounts discounts) {
		this.discounts = discounts;
	}
}
