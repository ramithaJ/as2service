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

package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class RequestOnlineOpen.
 */
@JsonInclude(Include.NON_NULL)
public class RequestOnlineOpen {

    /** The user id. */
    private String userId;

    /** The article id. */
    private String articleId;

    /** The article title. */
    private String articleTitle;

    /** The message. */
    private String message;

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
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
     * Gets the message.
     *
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message
     *            the new message
     */
    public final void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets the article title.
     *
     * @return the article title
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            the new article title
     */
    public final void setArticleTitle(final String articleTitle) {
        this.articleTitle = articleTitle;
    }

}
