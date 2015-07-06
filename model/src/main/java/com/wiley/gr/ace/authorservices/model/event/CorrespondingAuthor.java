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

// TODO: Auto-generated Javadoc
/**
 * The Class Author.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "even:correspondingAuthor")
public class CorrespondingAuthor {

	/** The user id. */
	@XmlElement(name = "art:userID")
	private String userID;

	/** The registered ind. */
	@XmlElement(name = "art:registeredInd")
	private String registeredInd;

	/** The email. */
	@XmlElement(name = "art:email")
	private String email;

	/** The full name. */
	@XmlElement(name = "art:fullName")
	private String fullName;

	/**
	 * Gets the user id.
	 *
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * Gets the registered ind.
	 *
	 * @return the registeredInd
	 */
	public String getRegisteredInd() {
		return registeredInd;
	}

	/**
	 * Sets the registered ind.
	 *
	 * @param registeredInd
	 *            the registeredInd to set
	 */
	public void setRegisteredInd(String registeredInd) {
		this.registeredInd = registeredInd;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
