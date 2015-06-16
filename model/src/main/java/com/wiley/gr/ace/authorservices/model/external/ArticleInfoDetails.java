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

import java.util.List;

/**
 * The Class ArticleInfoDetails.
 *
 * @author yugandhark
 */
public class ArticleInfoDetails {

    /** The article info. */
    private List<ArticleInfo> articleInfo;

    /**
     * Gets the article info.
     *
     * @return the article info
     */
    public List<ArticleInfo> getArticleInfo() {
        return articleInfo;
    }

    /**
     * Sets the article info.
     *
     * @param articleInfo
     *            the new article info
     */
    public void setArticleInfo(List<ArticleInfo> articleInfo) {
        this.articleInfo = articleInfo;
    }

}
