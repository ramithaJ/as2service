package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author kpshiva
 */
@JsonInclude(Include.NON_NULL)
public class Title {

	/** The title id. */
	private String titleId;

	/** The title name. */
	private String titleName;

	/**
	 * Gets the title id.
	 *
	 * @return the title id
	 */
	public String getTitleId() {
		return titleId;
	}

	/**
	 * Sets the title id.
	 *
	 * @param titleId
	 *            the new title id
	 */
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	/**
	 * Gets the title name.
	 *
	 * @return the title name
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * Sets the title name.
	 *
	 * @param titleName
	 *            the new title name
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
}
