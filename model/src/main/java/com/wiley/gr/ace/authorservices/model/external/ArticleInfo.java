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
 * @author virtusa version 1.0
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
     * @return the articleAuthId
     */
    public final Integer getArticleAuthId() {
        return articleAuthId;
    }

    /**
     * Sets the article auth id.
     *
     * @param articleAuthId
     *            the articleAuthId to set
     */
    public final void setArticleAuthId(final Integer articleAuthId) {
        this.articleAuthId = articleAuthId;
    }

    /**
     * Gets the article details.
     *
     * @return the articleDetails
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the article details.
     *
     * @param articleDetails
     *            the articleDetails to set
     */
    public final void setArticleDetails(final ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * Gets the article user role details.
     *
     * @return the articleUserRoleDetails
     */
    public final ArticleUserRoleDetails getArticleUserRoleDetails() {
        return articleUserRoleDetails;
    }

    /**
     * Sets the article user role details.
     *
     * @param articleUserRoleDetails
     *            the articleUserRoleDetails to set
     */
    public final void setArticleUserRoleDetails(
            final ArticleUserRoleDetails articleUserRoleDetails) {
        this.articleUserRoleDetails = articleUserRoleDetails;
    }

}
