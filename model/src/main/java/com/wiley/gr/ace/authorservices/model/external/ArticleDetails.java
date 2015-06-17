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
     * @return the articleId
     */
    public final Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     *            the articleId to set
     */
    public final void setArticleId(final Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * @return the articleName
     */
    public final String getArticleName() {
        return articleName;
    }

    /**
     * @param articleName
     *            the articleName to set
     */
    public final void setArticleName(final String articleName) {
        this.articleName = articleName;
    }

    /**
     * @return the articleDoi
     */
    public final String getArticleDoi() {
        return articleDoi;
    }

    /**
     * @param articleDoi
     *            the articleDoi to set
     */
    public final void setArticleDoi(final String articleDoi) {
        this.articleDoi = articleDoi;
    }

    /**
     * @return the publicationDate
     */
    public final String getPublicationDate() {
        return publicationDate;
    }

    /**
     * @param publicationDate
     *            the publicationDate to set
     */
    public final void setPublicationDate(final String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * @return the acceptanceDate
     */
    public final String getAcceptanceDate() {
        return acceptanceDate;
    }

    /**
     * @param acceptanceDate
     *            the acceptanceDate to set
     */
    public final void setAcceptanceDate(final String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    /**
     * @return the articleAcceptedInOO
     */
    public final String getArticleAcceptedInOO() {
        return articleAcceptedInOO;
    }

    /**
     * @param articleAcceptedInOO
     *            the articleAcceptedInOO to set
     */
    public final void setArticleAcceptedInOO(final String articleAcceptedInOO) {
        this.articleAcceptedInOO = articleAcceptedInOO;
    }

    /**
     * @return the articleAuthors
     */
    public final List<ArticleAuthors> getArticleAuthors() {
        return articleAuthors;
    }

    /**
     * @param articleAuthors
     *            the articleAuthors to set
     */
    public final void setArticleAuthors(final List<ArticleAuthors> articleAuthors) {
        this.articleAuthors = articleAuthors;
    }

    /**
     * @return the articleCoAuthors
     */
    public final List<ArticleCoAuthors> getArticleCoAuthors() {
        return articleCoAuthors;
    }

    /**
     * @param articleCoAuthors
     *            the articleCoAuthors to set
     */
    public final void setArticleCoAuthors(
            final List<ArticleCoAuthors> articleCoAuthors) {
        this.articleCoAuthors = articleCoAuthors;
    }

}
