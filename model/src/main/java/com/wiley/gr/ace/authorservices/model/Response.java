package com.wiley.gr.ace.authorservices.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	@JsonProperty("numFound")
	private Integer numFound;

	@JsonProperty("start")
	private Integer start;

	@JsonProperty("docs")
	private List<Doc> docs = new ArrayList<Doc>();

	/**
	 * 
	 * @return The numFound
	 */
	public Integer getNumFound() {
		return numFound;
	}

	/**
	 * 
	 * @param numFound
	 *            The numFound
	 */
	public void setNumFound(Integer numFound) {
		this.numFound = numFound;
	}

	/**
	 * 
	 * @return The start
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * 
	 * @param start
	 *            The start
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * 
	 * @return The docs
	 */
	public List<Doc> getDocs() {
		return docs;
	}

	/**
	 * 
	 * @param docs
	 *            The docs
	 */
	public void setDocs(List<Doc> docs) {
		this.docs = docs;
	}

}