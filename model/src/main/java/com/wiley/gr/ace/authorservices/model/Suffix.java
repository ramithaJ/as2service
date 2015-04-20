package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author kpshiva
 */
@JsonInclude(Include.NON_NULL)
public class Suffix {

	/** The suffix id. */
	private String suffixId;

	/** The suffix name. */
	private String suffixName;

	/**
	 * Gets the suffix id.
	 *
	 * @return the suffix id
	 */
	public String getSuffixId() {
		return suffixId;
	}

	/**
	 * Sets the suffix id.
	 *
	 * @param suffixId
	 *            the new suffix id
	 */
	public void setSuffixId(String suffixId) {
		this.suffixId = suffixId;
	}

	/**
	 * Gets the suffix name.
	 *
	 * @return the suffix name
	 */
	public String getSuffixName() {
		return suffixName;
	}

	/**
	 * Sets the suffix name.
	 *
	 * @param suffixName
	 *            the new suffix name
	 */
	public void setSuffixName(String suffixName) {
		this.suffixName = suffixName;
	}

}
