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

public class Alert {
	
	private String alertId;
	
	private String alertName;
	
	private boolean onScreen;
	
	private boolean email;


	/**
	 * @return
	 */
	public String getAlertId() {
		return alertId;
	}

	/**
	 * @param alertId
	 */
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	/**
	 * @return
	 */
	public String getAlertName() {
		return alertName;
	}

	/**
	 * @param alertName
	 */
	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	/**
	 * @return
	 */
	public boolean isOnScreen() {
		return onScreen;
	}

	/**
	 * @param onScreen
	 */
	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}

	/**
	 * @return
	 */
	public boolean isEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(boolean email) {
		this.email = email;
	}

}
