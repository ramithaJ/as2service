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
    private String articleDOI;

    /** The publication date. */
    private String publicationDate;

    /** The acceptance date. */
    private String acceptanceDate;

    /** The article accepted in oo. */
    private String articleAcceptedInOO;

    /** The article authors. */
    private String articleAuthors;

    /** The article co authors. */
    private List<String> articleCoAuthors;

    /** The email. */
    private String correspondingAuthorEmail;

    /** The issue num. */
    private String issueNum;

    /** The volume num. */
    private String volumeNum;

    /** The editorial ref cd. */
    private String editorialRefCd;

    /** The jpcms internal id. */
    private String jpcmsInternalId;

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
     * Gets the article doi.
     *
     * @return the article doi
     */
    public final String getArticleDOI() {
        return articleDOI;
    }

    /**
     * Sets the article doi.
     *
     * @param articleDOI
     *            the new article doi
     */
    public final void setArticleDOI(final String articleDOI) {
        this.articleDOI = articleDOI;
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
     * Gets the corresponding author email.
     *
     * @return the corresponding author email
     */
    public final String getCorrespondingAuthorEmail() {
        return correspondingAuthorEmail;
    }

    /**
     * Sets the corresponding author email.
     *
     * @param correspondingAuthorEmail
     *            the new corresponding author email
     */
    public final void setCorrespondingAuthorEmail(
            final String correspondingAuthorEmail) {
        this.correspondingAuthorEmail = correspondingAuthorEmail;
    }

    /**
     * Gets the issue num.
     *
     * @return the issue num
     */
    public final String getIssueNum() {
        return issueNum;
    }

    /**
     * Sets the issue num.
     *
     * @param issueNum
     *            the new issue num
     */
    public final void setIssueNum(final String issueNum) {
        this.issueNum = issueNum;
    }

    /**
     * Gets the volume num.
     *
     * @return the volume num
     */
    public final String getVolumeNum() {
        return volumeNum;
    }

    /**
     * Sets the volume num.
     *
     * @param volumeNum
     *            the new volume num
     */
    public final void setVolumeNum(final String volumeNum) {
        this.volumeNum = volumeNum;
    }

    /**
     * Gets the editorial ref cd.
     *
     * @return the editorial ref cd
     */
    public final String getEditorialRefCd() {
        return editorialRefCd;
    }

    /**
     * Sets the editorial ref cd.
     *
     * @param editorialRefCd
     *            the new editorial ref cd
     */
    public final void setEditorialRefCd(final String editorialRefCd) {
        this.editorialRefCd = editorialRefCd;
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

}
