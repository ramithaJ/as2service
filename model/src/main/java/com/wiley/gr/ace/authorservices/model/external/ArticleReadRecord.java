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
 * The Class ArticleReadRecord.
 *
 * @author yugandhark
 */
public class ArticleReadRecord {

    /** The article title. */
    private String articleTitle;

    /** The read count. */
    private Integer readCount;

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
     * @return the readCount
     */
    public final Integer getReadCount() {
        return readCount;
    }

    /**
     * @param readCount
     *            the readCount to set
     */
    public final void setReadCount(final Integer readCount) {
        this.readCount = readCount;
    }

}
