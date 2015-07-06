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
 * The Class JournalInfo.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "even:journalInfo")
public class JournalInfo {

	/** The journal id. */
	@XmlElement(name = "art:journalID")
	private String journalID;

	/** The journal name. */
	@XmlElement(name = "art:journalName")
	private String journalName;

	/**
	 * Gets the journal id.
	 *
	 * @return the journalID
	 */
	public String getJournalID() {
		return journalID;
	}

	/**
	 * Sets the journal id.
	 *
	 * @param journalID
	 *            the journalID to set
	 */
	public void setJournalID(String journalID) {
		this.journalID = journalID;
	}

	/**
	 * Gets the journal name.
	 *
	 * @return the journalName
	 */
	public String getJournalName() {
		return journalName;
	}

	/**
	 * Sets the journal name.
	 *
	 * @param journalName
	 *            the journalName to set
	 */
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

}
