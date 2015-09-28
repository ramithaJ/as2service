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
 * The Class ArticleInfo.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "even:articleInfo")
public class ArticleInfo {

	/** The article id. */
	@XmlElement(name = "art:articleID")
	private String articleID;

	/** The article name. */
	@XmlElement(name = "art:articleName")
	private String articleName;

	/**
	 * Gets the article id.
	 *
	 * @return the articleID
	 */
	public String getArticleID() {
		return articleID;
	}

	/**
	 * Sets the article id.
	 *
	 * @param articleID
	 *            the articleID to set
	 */
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	/**
	 * Gets the article name.
	 *
	 * @return the articleName
	 */
	public String getArticleName() {
		return articleName;
	}

	/**
	 * Sets the article name.
	 *
	 * @param articleName
	 *            the articleName to set
	 */
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

}
