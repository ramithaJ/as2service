package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Funder {

	@JsonProperty("uri")
	private String uri;

	@JsonProperty("id")
	private String id;

	@JsonProperty("secondaryIds")
	private SecondaryIds secondaryIds;

	@JsonProperty("name")
	private String name;

	@JsonProperty("altName")
	private String altName;

	@JsonProperty("parent")
	private Parent parent;

	@JsonProperty("ultimateParent")
	private UltimateParent ultimateParent;

	@JsonProperty("mandates")
	private Mandates mandates;

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
	 * @return The altName
	 */
	public String getAltName() {
		return altName;
	}

	/**
	 * 
	 * @param altName
	 *            The altName
	 */
	public void setAltName(String altName) {
		this.altName = altName;
	}

	/**
	 * 
	 * @return The parent
	 */
	public Parent getParent() {
		return parent;
	}

	/**
	 * 
	 * @param parent
	 *            The parent
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}

	/**
	 * 
	 * @return The ultimateParent
	 */
	public UltimateParent getUltimateParent() {
		return ultimateParent;
	}

	/**
	 * 
	 * @param ultimateParent
	 *            The ultimateParent
	 */
	public void setUltimateParent(UltimateParent ultimateParent) {
		this.ultimateParent = ultimateParent;
	}

	/**
	 * 
	 * @return The mandates
	 */
	public Mandates getMandates() {
		return mandates;
	}

	/**
	 * 
	 * @param mandates
	 *            The mandates
	 */
	public void setMandates(Mandates mandates) {
		this.mandates = mandates;
	}

}