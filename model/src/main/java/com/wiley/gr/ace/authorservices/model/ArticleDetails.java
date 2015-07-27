/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleDetails.
 */
@JsonInclude(Include.NON_NULL)
public class ArticleDetails {

    /** The article title. */
    private String articleTitle;

    /** The article id. */
    @NotNull
    @NotBlank
    private String articleId;

    /** The article doi. */
    private String articleDoi;

    /** The publication date. */
    private String publicationDate;

    /** The acceptance date. */
    private String acceptanceDate;

    /** The article accepted in oo. */
    private String articleAcceptedInOO;

    /** The article authors. */
    private String articleAuthorName;

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

    /** The jpcms internal id. */
    private String jpcmsInternalId;

    /**
     * Gets the article title.
     *
     * @return the articleTitle
     */
    public final String getArticleTitle() {
        return articleTitle;
    }

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
     * Gets the jpcms internal id.
     *
     * @return the jpcms internal id
     */
    public final String getJpcmsInternalId() {
        return jpcmsInternalId;
    }

    /**
     * Sets the jpcms internal id.
     *
     * @param jpcmsInternalId
     *            the new jpcms internal id
     */
    public final void setJpcmsInternalId(final String jpcmsInternalId) {
        this.jpcmsInternalId = jpcmsInternalId;
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
     * Gets the publication date.
     *
     * @return the publication date
     */
    public final String getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the publication date.
     *
     * @param publicationDate
     *            the new publication date
     */
    public final void setPublicationDate(final String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Gets the acceptance date.
     *
     * @return the acceptance date
     */
    public final String getAcceptanceDate() {
        return acceptanceDate;
    }

    /**
     * Sets the acceptance date.
     *
     * @param acceptanceDate
     *            the new acceptance date
     */
    public final void setAcceptanceDate(final String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    /**
     * Gets the article accepted in oo.
     *
     * @return the article accepted in oo
     */
    public final String getArticleAcceptedInOO() {
        return articleAcceptedInOO;
    }

    /**
     * Sets the article accepted in oo.
     *
     * @param articleAcceptedInOO
     *            the new article accepted in oo
     */
    public final void setArticleAcceptedInOO(final String articleAcceptedInOO) {
        this.articleAcceptedInOO = articleAcceptedInOO;
    }

    /**
     * Gets the article author name.
     *
     * @return the article author name
     */
    public final String getArticleAuthorName() {
        return articleAuthorName;
    }

    /**
     * Sets the article author name.
     *
     * @param articleAuthorName
     *            the new article author name
     */
    public final void setArticleAuthorName(final String articleAuthorName) {
        this.articleAuthorName = articleAuthorName;
    }

    /**
     * Gets the article co authors.
     *
     * @return the article co authors
     */
    public final List<String> getArticleCoAuthors() {
        return articleCoAuthors;
    }

    /**
     * Sets the article co authors.
     *
     * @param articleCoAuthors
     *            the new article co authors
     */
    public final void setArticleCoAuthors(final List<String> articleCoAuthors) {
        this.articleCoAuthors = articleCoAuthors;
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
