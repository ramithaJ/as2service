package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parent {

	@JsonProperty("uri")
	private String uri;

	@JsonProperty("id")
	private String id;

	@JsonProperty("secondaryIds")
	private SecondaryIds secondaryIds;

	/**
	 * 
	 * @return The uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * 
	 * @param uri
	 *            The uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The secondaryIds
	 */
	public SecondaryIds getSecondaryIds() {
		return secondaryIds;
	}

	/**
	 * 
	 * @param secondaryIds
	 *            The secondaryIds
	 */
	public void setSecondaryIds(SecondaryIds secondaryIds) {
		this.secondaryIds = secondaryIds;
	}

}