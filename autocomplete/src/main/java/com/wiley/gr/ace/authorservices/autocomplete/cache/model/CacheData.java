package com.wiley.gr.ace.authorservices.autocomplete.cache.model;

import java.io.Serializable;

/**
 *
 * @author virtusa
 * @version 1.0
 */
public class CacheData implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The name */
	private String name = null;

	/** The code */
	private String code = null;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\",\"code\":\"" + code + "\"}";
	}

}
