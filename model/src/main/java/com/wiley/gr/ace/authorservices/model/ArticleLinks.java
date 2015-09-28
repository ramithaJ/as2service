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
 * The Class ArticleLinks.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleLinks {

    /** The order id. */
    private String orderId;

    /** The article pdf url. */
    private String articlePdfUrl;

    /** The article wol url. */
    private String articleWolUrl;

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    public final String getOrderId() {
        return orderId;
    }

    /**
     * Sets the order id.
     *
     * @param orderId
     *            the new order id
     */
    public final void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the article wol url.
     *
     * @return the article wol url
     */
    public final String getArticleWolUrl() {
        return articleWolUrl;
    }

    /**
     * Sets the article wol url.
     *
     * @param articleWolUrl
     *            the new article wol url
     */
    public final void setArticleWolUrl(final String articleWolUrl) {
        this.articleWolUrl = articleWolUrl;
    }

    /**
     * Gets the article pdf url.
     *
     * @return the article pdf url
     */
    public final String getArticlePdfUrl() {
        return articlePdfUrl;
    }

    /**
     * Sets the article pdf url.
     *
     * @param articlePdfUrl
     *            the new article pdf url
     */
    public final void setArticlePdfUrl(final String articlePdfUrl) {
        this.articlePdfUrl = articlePdfUrl;
    }
}
