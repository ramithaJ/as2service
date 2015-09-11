package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ResearchFundersResponse {

	@JsonProperty("funder")
	private List<Funder> funder = new ArrayList<Funder>();

	/**
	 * 
	 * @return The funder
	 */
	public List<Funder> getFunder() {
		return funder;
	}

	/**
	 * 
	 * @param funder
	 *            The funder
	 */
	public void setFunder(List<Funder> funder) {
		this.funder = funder;
	}

}