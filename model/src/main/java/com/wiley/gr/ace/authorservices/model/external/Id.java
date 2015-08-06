package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Id {

	@JsonProperty("type")
	private String type;

	@JsonProperty("_content_")
	private String Content;

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The Content
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * 
	 * @param Content
	 *            The _content_
	 */
	public void setContent(String Content) {
		this.Content = Content;
	}


}