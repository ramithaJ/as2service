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
