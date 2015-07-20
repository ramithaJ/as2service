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
 * The Class CoAuthorList.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "even:correspondingAuthor")
public class CoAuthorList {
	
	/** The user id. */
	@XmlElement(name = "art:userID")
	private String coAuthUserID;

	/** The registered ind. */
	@XmlElement(name = "art:registeredInd")
	private String coAuthRegisteredInd;

	/** The email. */
	@XmlElement(name = "art:email")
	private String coAuthEmail;

	/** The full name. */
	@XmlElement(name = "art:fullName")
	private String coAuthFullName;

	/**
	 * @return the coAuthUserID
	 */
	public String getCoAuthUserID() {
		return coAuthUserID;
	}

	/**
	 * @param coAuthUserID the coAuthUserID to set
	 */
	public void setCoAuthUserID(String coAuthUserID) {
		this.coAuthUserID = coAuthUserID;
	}

	/**
	 * @return the coAuthRegisteredInd
	 */
	public String getCoAuthRegisteredInd() {
		return coAuthRegisteredInd;
	}

	/**
	 * @param coAuthRegisteredInd the coAuthRegisteredInd to set
	 */
	public void setCoAuthRegisteredInd(String coAuthRegisteredInd) {
		this.coAuthRegisteredInd = coAuthRegisteredInd;
	}

	/**
	 * @return the coAuthEmail
	 */
	public String getCoAuthEmail() {
		return coAuthEmail;
	}

	/**
	 * @param coAuthEmail the coAuthEmail to set
	 */
	public void setCoAuthEmail(String coAuthEmail) {
		this.coAuthEmail = coAuthEmail;
	}

	/**
	 * @return the coAuthFullName
	 */
	public String getCoAuthFullName() {
		return coAuthFullName;
	}

	/**
	 * @param coAuthFullName the coAuthFullName to set
	 */
	public void setCoAuthFullName(String coAuthFullName) {
		this.coAuthFullName = coAuthFullName;
	}

	
}
