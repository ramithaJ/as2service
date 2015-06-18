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
 * The Class ArticleCitationRecord.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleCitationRecord {

    /** The article title. */
    private String articleTitle;

    /** The citation count. */
    private Integer citationCount;

    /**
     * @return the articleTitle
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

    /**
     * @param articleTitle
     *            the articleTitle to set
     */
    public final void setArticleTitle(final String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * @return the citationCount
     */
    public final Integer getCitationCount() {
        return citationCount;
    }

    /**
     * @param citationCount
     *            the citationCount to set
     */
    public final void setCitationCount(final Integer citationCount) {
        this.citationCount = citationCount;
    }

}
