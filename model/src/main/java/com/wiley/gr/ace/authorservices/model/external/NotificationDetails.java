/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author Virtusa version1.0
 *
 */
public class NotificationDetails {

	/**
	 * This field holds the value of articleId
	 */
	private String articleId;
	
	/**
	 * This field holds the value of notificationId
	 */
	private String notificationId;
	
	/**
	 * This field holds the value of userEmailId
	 */
	private String userEmailId;
	
	/**
	 * This field holds the value of type
	 */
	private String type;
	
	/**
	 * This field holds the value of subType
	 */
	private String subType;
	
	/**
	 * This field holds the value of recievedDate
	 */
	private String recievedDate;

	/**
	 * @return the articleId
	 */
	public final String getArticleId() {
		return articleId;
	}

	/**
	 * @param articleId the articleId to set
	 */
	public final void setArticleId(final String articleId) {
		this.articleId = articleId;
	}

	/**
	 * @return the notificationId
	 */
	public final String getNotificationId() {
		return notificationId;
	}

	/**
	 * @param notificationId the notificationId to set
	 */
	public final void setNotificationId(final String notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 * @return the userEmailId
	 */
	public final String getUserEmailId() {
		return userEmailId;
	}

	/**
	 * @param userEmailId the userEmailId to set
	 */
	public final void setUserEmailId(final String userEmailId) {
		this.userEmailId = userEmailId;
	}

	/**
	 * @return the type
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(final String type) {
		this.type = type;
	}

	/**
	 * @return the subType
	 */
	public final String getSubType() {
		return subType;
	}

	/**
	 * @param subType the subType to set
	 */
	public final void setSubType(final String subType) {
		this.subType = subType;
	}

	/**
	 * @return the recievedDate
	 */
	public final String getRecievedDate() {
		return recievedDate;
	}

	/**
	 * @param recievedDate the recievedDate to set
	 */
	public final void setRecievedDate(final String recievedDate) {
		this.recievedDate = recievedDate;
	}
	
	
}
