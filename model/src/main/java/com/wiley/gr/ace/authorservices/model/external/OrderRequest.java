package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author virtusa version1.0
 *
 */
public class OrderRequest {

	/** The application key. */
	private String applicationKey;

	/** The order data. */
	@JsonProperty("Order")
	private OrderData orderData;

	/** The user ID. */
	private String userID;

	/** The correlation ID. */
	private String correlationID;

	/**
	 * @return the applicationKey
	 */
	public String getApplicationKey() {
		return applicationKey;
	}

	/**
	 * @param applicationKey
	 *            the applicationKey to set
	 */
	public void setApplicationKey(String applicationKey) {
		this.applicationKey = applicationKey;
	}

	/**
	 * @return the orderData
	 */
	public OrderData getOrderData() {
		return orderData;
	}

	/**
	 * @param orderData
	 *            the orderData to set
	 */
	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the correlationID
	 */
	public String getCorrelationID() {
		return correlationID;
	}

	/**
	 * @param correlationID
	 *            the correlationID to set
	 */
	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
	}

}
