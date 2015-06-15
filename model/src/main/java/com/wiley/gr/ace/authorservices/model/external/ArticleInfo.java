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
 * @author yugandhark
 *
 */
public class ArticleInfo {

    private Integer articleAuthId;

    private ArticleDetails articleDetails;

    private ArticleUserRoleDetails articleUserRoleDetails;

    public Integer getArticleAuthId() {
        return articleAuthId;
    }

    public void setArticleAuthId(Integer articleAuthId) {
        this.articleAuthId = articleAuthId;
    }

    public ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    public void setArticleDetails(ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    public ArticleUserRoleDetails getArticleUserRoleDetails() {
        return articleUserRoleDetails;
    }

    public void setArticleUserRoleDetails(
            ArticleUserRoleDetails articleUserRoleDetails) {
        this.articleUserRoleDetails = articleUserRoleDetails;
    }
}
