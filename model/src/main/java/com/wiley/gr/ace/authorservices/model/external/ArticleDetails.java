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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleDetails {

    /** The article id. */
    private String articleId;

    /** The article title. */
    private String articleTitle;

    /** The article doi. */
    private String articleDoi;
    
    /** The article authors. */
    private String articleAuthors;

    /** The article co authors. */
    private List<String> articleCoAuthors;

    /** The email. */
    private String email;

    /** The issue. */
    private String issue;

    /** The volume. */
    private String volume;

    /** The editorial ref code. */
    private String editorialRefCode;

    /**
     * Gets the email.
     *
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the new email
     */
    public final void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the issue.
     *
     * @return the issue
     */
    public final String getIssue() {
        return issue;
    }

    /**
     * Sets the issue.
     *
     * @param issue
     *            the new issue
     */
    public final void setIssue(final String issue) {
        this.issue = issue;
    }

    /**
     * Gets the volume.
     *
     * @return the volume
     */
    public final String getVolume() {
        return volume;
    }

    /**
     * Sets the volume.
     *
     * @param volume
     *            the new volume
     */
    public final void setVolume(final String volume) {
        this.volume = volume;
    }

    /**
     * Gets the editorial ref code.
     *
     * @return the editorial ref code
     */
    public final String getEditorialRefCode() {
        return editorialRefCode;
    }

    /**
     * Sets the editorial ref code.
     *
     * @param editorialRefCode
     *            the new editorial ref code
     */
    public final void setEditorialRefCode(final String editorialRefCode) {
        this.editorialRefCode = editorialRefCode;
    }

    /**
     * Gets the article id.
     *
     * @return the articleId
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the articleId to set
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the article title.
     *
     * @return the articleTitle
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            the articleTitle to set
     */
    public final void setArticleTitle(final String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets the article doi.
     *
     * @return the articleDoi
     */
    public final String getArticleDoi() {
        return articleDoi;
    }

    /**
     * Sets the article doi.
     *
     * @param articleDoi
     *            the articleDoi to set
     */
    public final void setArticleDoi(final String articleDoi) {
        this.articleDoi = articleDoi;
    }

    /**
     * Gets the article authors.
     *
     * @return the article authors
     */
    public final String getArticleAuthors() {
        return articleAuthors;
    }

    /**
     * Sets the article authors.
     *
     * @param articleAuthors
     *            the new article authors
     */
    public final void setArticleAuthors(final String articleAuthors) {
        this.articleAuthors = articleAuthors;
    }

    /**
     * Gets the article co authors.
     *
     * @return the articleCoAuthors
     */
    public final List<String> getArticleCoAuthors() {
        return articleCoAuthors;
    }

    /**
     * Sets the article co authors.
     *
     * @param articleCoAuthors
     *            the articleCoAuthors to set
     */
    public final void setArticleCoAuthors(final List<String> articleCoAuthors) {
        this.articleCoAuthors = articleCoAuthors;
    }

}
