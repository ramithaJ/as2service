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

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class LicenseStatus.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LicenseStatus {

	/** The info. */
	private String info;

	/** The actions. */
	private ArrayList<String> actions;

	/** The task ids. */
	private ArrayList<String> taskIds;

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the actions
	 */
	public ArrayList<String> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(ArrayList<String> actions) {
		this.actions = actions;
	}

	/**
	 * @return the taskIds
	 */
	public ArrayList<String> getTaskIds() {
		return taskIds;
	}

	/**
	 * @param taskIds the taskIds to set
	 */
	public void setTaskIds(ArrayList<String> taskIds) {
		this.taskIds = taskIds;
	}

}
