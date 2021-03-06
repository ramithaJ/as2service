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

    /** The article co authors. */
    private List<String> coAuthors;

    /** The email. */
    private String email;

    /** The issue. */
    private String issue;

    /** The volume. */
    private String volume;

    /** The editorial ref code. */
    private String editorialRefCode;

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the new article id
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the article title.
     *
     * @return the article title
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            the new article title
     */
    public final void setArticleTitle(final String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets the article doi.
     *
     * @return the article doi
     */
    public final String getArticleDoi() {
        return articleDoi;
    }

    /**
     * Sets the article doi.
     *
     * @param articleDoi
     *            the new article doi
     */
    public final void setArticleDoi(final String articleDoi) {
        this.articleDoi = articleDoi;
    }

    /**
     * Gets the co authors.
     *
     * @return the co authors
     */
    public final List<String> getCoAuthors() {
        return coAuthors;
    }

    /**
     * Sets the co authors.
     *
     * @param coAuthors
     *            the new co authors
     */
    public final void setCoAuthors(final List<String> coAuthors) {
        this.coAuthors = coAuthors;
    }

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

}
