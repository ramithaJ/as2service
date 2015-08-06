package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mandates {

	@JsonProperty("mandate")
	private List<Mandate> mandate = new ArrayList<Mandate>();

	/**
	 * 
	 * @return The mandate
	 */
	public List<Mandate> getMandate() {
		return mandate;
	}

	/**
	 * 
	 * @param mandate
	 *            The mandate
	 */
	public void setMandate(List<Mandate> mandate) {
		this.mandate = mandate;
	}

}