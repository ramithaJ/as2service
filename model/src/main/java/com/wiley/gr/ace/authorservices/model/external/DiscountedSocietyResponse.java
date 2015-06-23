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

	@JsonProperty("societies")
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

}
