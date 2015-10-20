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
 * The Class QuoteRequest.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class QuoteRequest {

    /**
     * This field holds the value of article
     */
    private Article article;

    /**
     * This field holds the value of requestCreatedTimestamp
     */
    private String requestCreatedTimestamp;

    /**
     * This field holds the value of requestType
     */
    private String requestType;

    /**
     * @return the article
     */
    public final Article getArticle() {
        return article;
    }

    /**
     * @param article
     *            the article to set
     */
    public final void setArticle(final Article article) {
        this.article = article;
    }

    /**
     * @return the requestCreatedTimestamp
     */
    public final String getRequestCreatedTimestamp() {
        return requestCreatedTimestamp;
    }

    /**
     * @param requestCreatedTimestamp
     *            the requestCreatedTimestamp to set
     */
    public final void setRequestCreatedTimestamp(
            final String requestCreatedTimestamp) {
        this.requestCreatedTimestamp = requestCreatedTimestamp;
    }

    /**
     * @return the requestType
     */
    public final String getRequestType() {
        return requestType;
    }

    /**
     * @param requestType
     *            the requestType to set
     */
    public final void setRequestType(final String requestType) {
        this.requestType = requestType;
    }

}
