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
 * The Class ArticleInfo.
 *
 * @author yugandhark
 */
public class ArticleInfo {

    /** The article auth id. */
    private Integer articleAuthId;

    /** The article details. */
    private ArticleDetails articleDetails;

    /** The article user role details. */
    private ArticleUserRoleDetails articleUserRoleDetails;

    /**
     * Gets the article auth id.
     *
     * @return the article auth id
     */
    public Integer getArticleAuthId() {
        return articleAuthId;
    }

    /**
     * Sets the article auth id.
     *
     * @param articleAuthId
     *            the new article auth id
     */
    public void setArticleAuthId(Integer articleAuthId) {
        this.articleAuthId = articleAuthId;
    }

    /**
     * Gets the article details.
     *
     * @return the article details
     */
    public ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the article details.
     *
     * @param articleDetails
     *            the new article details
     */
    public void setArticleDetails(ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * Gets the article user role details.
     *
     * @return the article user role details
     */
    public ArticleUserRoleDetails getArticleUserRoleDetails() {
        return articleUserRoleDetails;
    }

    /**
     * Sets the article user role details.
     *
     * @param articleUserRoleDetails
     *            the new article user role details
     */
    public void setArticleUserRoleDetails(
            ArticleUserRoleDetails articleUserRoleDetails) {
        this.articleUserRoleDetails = articleUserRoleDetails;
    }
}
