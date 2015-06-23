package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class DiscountedSociety.
 * 
 * @author virtusa version 1.0
 */
public class DiscountedSociety {

	@JsonProperty("societyName")
	private String societyName;
	
	@JsonProperty("valueType")
	private String valueType;
	
	@JsonProperty("value")
	private String value;

	/**
	 * 
	 * @return The societyName
	 */
	public String getSocietyName() {
		return societyName;
	}

	/**
	 * 
	 * @param societyName
	 *            The societyName
	 */
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
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
	 * @return The value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            The value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}