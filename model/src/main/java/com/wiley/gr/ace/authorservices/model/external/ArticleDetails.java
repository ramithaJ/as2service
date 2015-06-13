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
 * @author yugandhark
 *
 */
public class ArticleDetails {

    private Integer articleId;

    private String articleName;

    private String articleDoi;

    private String publicationDate;

    private String acceptanceDate;

    private String articleAcceptedInOO;

    private List<ArticleAuthors> articleAuthors;

    private List<ArticleCoAuthors> articleCoAuthors;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDoi() {
        return articleDoi;
    }

    public void setArticleDoi(String articleDoi) {
        this.articleDoi = articleDoi;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getArticleAcceptedInOO() {
        return articleAcceptedInOO;
    }

    public void setArticleAcceptedInOO(String articleAcceptedInOO) {
        this.articleAcceptedInOO = articleAcceptedInOO;
    }

    public List<ArticleAuthors> getArticleAuthors() {
        return articleAuthors;
    }

    public void setArticleAuthors(List<ArticleAuthors> articleAuthors) {
        this.articleAuthors = articleAuthors;
    }

    public List<ArticleCoAuthors> getArticleCoAuthors() {
        return articleCoAuthors;
    }

    public void setArticleCoAuthors(List<ArticleCoAuthors> articleCoAuthors) {
        this.articleCoAuthors = articleCoAuthors;
    }

}
