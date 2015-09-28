package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class DiscountedSocietyResponse.
 * 
 * @author virtusa version 1.0
 */
public class DiscountedSocietyResponse {
	
	@JsonProperty("societyName")
	private String societyName;
	
	@JsonProperty("societyCode")
	private String societyCode;

	@JsonProperty("discount")
	private List<DiscountedSociety> societies = new ArrayList<DiscountedSociety>();

	/**
	 * 
	 * @return The societies
	 */
	public List<DiscountedSociety> getSocieties() {
		return societies;
	}

	/**
	 * 
	 * @param societies
	 *            The societies
	 */
	public void setSocieties(List<DiscountedSociety> societies) {
		this.societies = societies;
	}

	/**
	 * @return the societyName
	 */
	public String getSocietyName() {
		return societyName;
	}

	/**
	 * @param societyName the societyName to set
	 */
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	/**
	 * @return the societyCode
	 */
	public String getSocietyCode() {
		return societyCode;
	}

	/**
	 * @param societyCode the societyCode to set
	 */
	public void setSocietyCode(String societyCode) {
		this.societyCode = societyCode;
	}
	
}
