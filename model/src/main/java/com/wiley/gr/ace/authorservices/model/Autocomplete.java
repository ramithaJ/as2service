/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;
import java.net.URL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class User.
 *
 * @author virtusa
 * version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Autocomplete implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The Key
     */
    private String key;
    
    /**
     * The phrase
     */
    private String phrase;
    
    /**
     * The count
     */
    private int count;
    
    /**
     * The dataPath
     */
    private URL dataPath;
    
    /**
     * The clear
     */
    private Boolean clear;

	/**
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return
	 */
	public String getPhrase() {
		return phrase;
	}

	/**
	 * @param phrase
	 */
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	/**
	 * @return
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return
	 */
	public URL getDataPath() {
		return dataPath;
	}

	/**
	 * @param dataPath
	 */
	public void setDataPath(URL dataPath) {
		this.dataPath = dataPath;
	}

	/**
	 * @return
	 */
	public Boolean isClear() {
		return clear;
	}

	/**
	 * @param clear
	 */
	public void setClear(Boolean clear) {
		this.clear = clear;
	}

	/**
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}