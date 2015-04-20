package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author kpshiva
 */
@JsonInclude(Include.NON_NULL)
public class Institution {

	/** The institution id. */
	private String institutionId;

	/** The institution name. */
	private String institutionName;

	/**
	 * Gets the institution id.
	 *
	 * @return the institution id
	 */
	public String getInstitutionId() {
		return institutionId;
	}

	/**
	 * Sets the institution id.
	 *
	 * @param institutionId
	 *            the new institution id
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * Gets the institution name.
	 *
	 * @return the institution name
	 */
	public String getInstitutionName() {
		return institutionName;
	}

	/**
	 * Sets the institution name.
	 *
	 * @param institutionName
	 *            the new institution name
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

}
