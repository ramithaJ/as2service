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

package com.wiley.gr.ace.authorservices.model.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class InvitationStartEventData.
 * 
 * @author virtusa version 1.0
 */

@XmlRootElement(name = "eventData", namespace = "http://www.wiley.com/bpm/event")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvitationStartEventData {

	/** The article id. */
	@XmlElement(name="articleId")
	private String articleId;

	/** The email. */
	@XmlElement(name="email")
	private String email;

	/** The user role. */
	@XmlElement(name="userRole")
	private String userRole;

	/** The user id. */
	@XmlElement(name="userID")
	private String userID;

	/** The notification id. */
	@XmlElement(name="notificationId")
	private String notificationId;

	/**
	 * Gets the notification id.
	 *
	 * @return the notification id
	 */
	public final String getNotificationId() {
		return notificationId;
	}

	/**
	 * Sets the notification id.
	 *
	 * @param notificationId
	 *            the new notification id
	 */
	public final void setNotificationId(final String notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 * Gets the article id.
	 *
	 * @return the article id
	 */
	public final String getArticleId() {
		return articleId;
	}

	/**
	 * Sets the article id.
	 *
	 * @param articleId
	 *            the new article id
	 */
	public final void setArticleId(final String articleId) {
		this.articleId = articleId;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public final void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public final String getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole
	 *            the new user role
	 */
	public final void setUserRole(final String userRole) {
		this.userRole = userRole;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public final String getUserID() {
		return userID;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userID
	 *            the new user id
	 */
	public final void setUserID(final String userID) {
		this.userID = userID;
	}

}
