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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleDetails.
 */
@JsonInclude(Include.NON_NULL)
public class ArticleDetails {

    /** The article title. */
    private String articleTitle;

    /** The article aid. */
    private String articleAID;

    /**
     * Gets the article title.
     *
     * @return the articleTitle
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            the articleTitle to set
     */
    public final void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets the article aid.
     *
     * @return the articleAID
     */
    public final String getArticleAID() {
        return articleAID;
    }

    /**
     * Sets the article aid.
     *
     * @param articleAID
     *            the articleAID to set
     */
    public final void setArticleAID(String articleAID) {
        this.articleAID = articleAID;
    }

}
