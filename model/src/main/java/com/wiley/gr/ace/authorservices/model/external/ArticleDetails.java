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
 * The Class ArticleDetails.
 *
 * @author yugandhark
 */
public class ArticleDetails {

    /** The article id. */
    private Integer articleId;

    /** The article name. */
    private String articleName;

    /** The article doi. */
    private String articleDoi;

    /** The publication date. */
    private String publicationDate;

    /** The acceptance date. */
    private String acceptanceDate;

    /** The article accepted in oo. */
    private String articleAcceptedInOO;

    /** The article authors. */
    private List<ArticleAuthors> articleAuthors;

    /** The article co authors. */
    private List<ArticleCoAuthors> articleCoAuthors;

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the new article id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the article name.
     *
     * @return the article name
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * Sets the article name.
     *
     * @param articleName
     *            the new article name
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    /**
     * Gets the article doi.
     *
     * @return the article doi
     */
    public String getArticleDoi() {
        return articleDoi;
    }

    /**
     * Sets the article doi.
     *
     * @param articleDoi
     *            the new article doi
     */
    public void setArticleDoi(String articleDoi) {
        this.articleDoi = articleDoi;
    }

    /**
     * Gets the publication date.
     *
     * @return the publication date
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the publication date.
     *
     * @param publicationDate
     *            the new publication date
     */
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Gets the acceptance date.
     *
     * @return the acceptance date
     */
    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    /**
     * Sets the acceptance date.
     *
     * @param acceptanceDate
     *            the new acceptance date
     */
    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    /**
     * Gets the article accepted in oo.
     *
     * @return the article accepted in oo
     */
    public String getArticleAcceptedInOO() {
        return articleAcceptedInOO;
    }

    /**
     * Sets the article accepted in oo.
     *
     * @param articleAcceptedInOO
     *            the new article accepted in oo
     */
    public void setArticleAcceptedInOO(String articleAcceptedInOO) {
        this.articleAcceptedInOO = articleAcceptedInOO;
    }

    /**
     * Gets the article authors.
     *
     * @return the article authors
     */
    public List<ArticleAuthors> getArticleAuthors() {
        return articleAuthors;
    }

    /**
     * Sets the article authors.
     *
     * @param articleAuthors
     *            the new article authors
     */
    public void setArticleAuthors(List<ArticleAuthors> articleAuthors) {
        this.articleAuthors = articleAuthors;
    }

    /**
     * Gets the article co authors.
     *
     * @return the article co authors
     */
    public List<ArticleCoAuthors> getArticleCoAuthors() {
        return articleCoAuthors;
    }

    /**
     * Sets the article co authors.
     *
     * @param articleCoAuthors
     *            the new article co authors
     */
    public void setArticleCoAuthors(List<ArticleCoAuthors> articleCoAuthors) {
        this.articleCoAuthors = articleCoAuthors;
    }

}
