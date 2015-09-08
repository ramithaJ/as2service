package com.wiley.gr.ace.authorservices.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHeaderParams {

	@JsonProperty("q")
	private String q;
	@JsonProperty("fq")
	private List<String> fq = new ArrayList<String>();
	@JsonProperty("wt")
	private String wt;

	/**
	 * 
	 * @return The q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * 
	 * @param q
	 *            The q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * 
	 * @return The fq
	 */
	public List<String> getFq() {
		return fq;
	}

	/**
	 * 
	 * @param fq
	 *            The fq
	 */
	public void setFq(List<String> fq) {
		this.fq = fq;
	}

	/**
	 * 
	 * @return The wt
	 */
	public String getWt() {
		return wt;
	}

	/**
	 * 
	 * @param wt
	 *            The wt
	 */
	public void setWt(String wt) {
		this.wt = wt;
	}

}