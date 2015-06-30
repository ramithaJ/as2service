package com.wiley.gr.ace.authorservices.model.external;


public class DiscountResponse {

	private String discoUntTypeName;
	private String discountTypeCode;
	private String valueType;
	private String discountValue;

	/**
	 * 
	 * @return The discoUntTypeName
	 */
	public String getDiscoUntTypeName() {
		return discoUntTypeName;
	}

	/**
	 * 
	 * @param discoUntTypeName
	 *            The disco untTypeName
	 */
	public void setDiscoUntTypeName(String discoUntTypeName) {
		this.discoUntTypeName = discoUntTypeName;
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
	 * @return The valueType
	 */
	public String getValueType() {
		return valueType;
	}

	/**
	 * 
	 * @param valueType
	 *            The valueType
	 */
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	/**
	 * 
	 * @return The discountValue
	 */
	public String getDiscountValue() {
		return discountValue;
	}

	/**
	 * 
	 * @param discountValue
	 *            The discountValue
	 */
	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
	}

	@Override
	public String toString() {
		return "DiscountResponse [discoUntTypeName=" + discoUntTypeName
				+ ", discountTypeCode=" + discountTypeCode + ", valueType="
				+ valueType + ", discountValue=" + discountValue + "]";
	}

}
