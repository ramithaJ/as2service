package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SecondaryIds {

	@JsonProperty("id")
	private List<Id> id = new ArrayList<Id>();

	/**
	 * 
	 * @return The id
	 */
	public List<Id> getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(List<Id> id) {
		this.id = id;
	}

}