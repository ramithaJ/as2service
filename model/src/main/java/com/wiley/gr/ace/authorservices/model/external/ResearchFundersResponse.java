package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResearchFundersResponse {

	private FunderData funders;

	/**
	 * @return the funders
	 */
	public FunderData getFunders() {
		return funders;
	}

	/**
	 * @param funders the funders to set
	 */
	public void setFunders(FunderData funders) {
		this.funders = funders;
	}

	
}