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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class PdhLookupArticle.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Lookup-Response")
public class PdhLookupArticle {

    /** The article header. */
    @XmlElement(name = "Header")
    private Header articleHeader;

 

    /** The article product entities. */
    @XmlElement(name = "Product-Entities")
    ArticleProductEntities articleProductEntities;

    /**
     * Gets the article product entities.
     *
     * @return the article product entities
     */
    public ArticleProductEntities getArticleProductEntities() {
		return articleProductEntities;
	}

	/**
	 * Sets the article product entities.
	 *
	 * @param articleProductEntities the new article product entities
	 */
	public void setArticleProductEntities(
			ArticleProductEntities articleProductEntities) {
		this.articleProductEntities = articleProductEntities;
	}

	/**
     * Gets the article header.
     *
     * @return the article header
     */
    public final Header getArticleHeader() {
        return articleHeader;
    }

    /**
     * Sets the article header.
     *
     * @param articleHeader
     *            the new article header
     */
    public final void setArticleHeader(final Header articleHeader) {
        this.articleHeader = articleHeader;
    }


  
}
