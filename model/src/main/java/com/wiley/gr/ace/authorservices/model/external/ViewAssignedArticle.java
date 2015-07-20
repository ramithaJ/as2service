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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ViewAssignedArticle.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ViewAssignedArticle {

    /** The article data. */
    private ArticleData articleData;

    /**
     * Gets the article data.
     *
     * @return the article data
     */
    public final ArticleData getArticleData() {
        return articleData;
    }

    /**
     * Sets the article data.
     *
     * @param articleData
     *            the new article data
     */
    public final void setArticleData(final ArticleData articleData) {
        this.articleData = articleData;
    }

}
