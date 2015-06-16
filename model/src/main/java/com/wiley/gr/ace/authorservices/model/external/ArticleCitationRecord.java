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

/**
 * The Class ArticleCitationRecord.
 *
 * @author yugandhark
 */
public class ArticleCitationRecord {

    /** The article title. */
    private String articleTitle;

    /** The citation count. */
    private Integer citationCount;

    /**
     * Gets the article title.
     *
     * @return the article title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            the new article title
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets the citation count.
     *
     * @return the citation count
     */
    public Integer getCitationCount() {
        return citationCount;
    }

    /**
     * Sets the citation count.
     *
     * @param citationCount
     *            the new citation count
     */
    public void setCitationCount(Integer citationCount) {
        this.citationCount = citationCount;
    }
}
