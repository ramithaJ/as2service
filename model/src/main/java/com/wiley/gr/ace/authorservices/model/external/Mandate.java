package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mandate {

	@JsonProperty("start")
	private String start;

	@JsonProperty("end")
	private String end;

	@JsonProperty("name")
	private String name;

	@JsonProperty("embargoDays")
	private Integer embargoDays;

	/**
	 * 
	 * @return The start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * 
	 * @param start
	 *            The start
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * 
	 * @return The end
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * 
	 * @param end
	 *            The end
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The embargoDays
	 */
	public Integer getEmbargoDays() {
		return embargoDays;
	}

	/**
	 * 
	 * @param embargoDays
	 *            The embargoDays
	 */
	public void setEmbargoDays(Integer embargoDays) {
		this.embargoDays = embargoDays;
	}

}