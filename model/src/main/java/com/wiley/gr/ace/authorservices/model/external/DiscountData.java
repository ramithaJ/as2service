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

	private Double discountValue;
	private String discountTypeCode;
	private String discountTypeName;
	private SocietyData societyData;
	private String promoCode;
	private AffiliationData affiliationData;

	/**
	 * 
	 * @return The discountValue
	 */
	public Double getDiscountValue() {
		return discountValue;
	}

	/**
	 * 
	 * @param discountValue
	 *            The discountValue
	 */
	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	/**
	 * 
	 * @return The discountTypeCode
	 */
	public String getDiscountTypeCode() {
		return discountTypeCode;
	}

	/**
	 * 
	 * @param discountTypeCode
	 *            The discountTypeCode
	 */
	public void setDiscountTypeCode(String discountTypeCode) {
		this.discountTypeCode = discountTypeCode;
	}

	/**
	 * 
	 * @return The discountTypeName
	 */
	public String getDiscountTypeName() {
		return discountTypeName;
	}

	/**
	 * 
	 * @param discountTypeName
	 *            The discountTypeName
	 */
	public void setDiscountTypeName(String discountTypeName) {
		this.discountTypeName = discountTypeName;
	}

	/**
	 * 
	 * @return The societyData
	 */
	public SocietyData getSocietyData() {
		return societyData;
	}

	/**
	 * 
	 * @param societyData
	 *            The societyData
	 */
	public void setSocietyData(SocietyData societyData) {
		this.societyData = societyData;
	}

	/**
	 * 
	 * @return The promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * 
	 * @param promoCode
	 *            The promoCode
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * 
	 * @return The affiliationData
	 */
	public AffiliationData getAffiliationData() {
		return affiliationData;
	}

	/**
	 * 
	 * @param affiliationData
	 *            The affiliationData
	 */
	public void setAffiliationData(AffiliationData affiliationData) {
		this.affiliationData = affiliationData;
	}

}
