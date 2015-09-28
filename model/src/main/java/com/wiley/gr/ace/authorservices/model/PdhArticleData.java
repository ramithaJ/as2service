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
package com.wiley.gr.ace.authorservices.model;

import java.util.Date;
import java.util.List;

/**
 * The Class PdhArticleData.
 *
 * @author virtusa version 1.0
 */
public class PdhArticleData {

    /** The dh id. */
    private String dhId;

    /** The article id. */
    private String articleId;

    /** The title. */
    private String title;

    /** The author role. */
    private String authorRole;

    /** The author name. */
    private String authorName;

    /** The author email. */
    private String authorEmail;

    /** The co authors. */
    private List<String> coAuthors;

    /** The article aid. */
    private String articleAid;

    /** The article doi. */
    private String articleDoi;

    /** The editorial ref code. */
    private String editorialRefCode;

    /** The journal dh id. */
    private String journalDhId;

    /** The journal id. */
    private String journalId;

    /** The is invited in as. */
    private String isInvitedInAs;

    /** The jpcms id. */
    private String jpcmsId;

    /** The jpcms copyright line. */
    private String jpcmsCopyrightLine;

    /** The article type. */
    private String articleType;

    /** The issue. */
    private String issue;

    /** The volume. */
    private String volume;

    /** The publication year. */
    private String publicationYear;

    /** The wiley received date. */
    private Date wileyReceivedDate;

    /** The accepted date. */
    private Date acceptedDate;

    /** The received date. */
    private Date receivedDate;

    /** The revised date. */
    private Date revisedDate;

    /** The submitted date. */
    private Date submittedDate;

    /** The cta rcvd date. */
    private Date ctaRcvdDate;

    /** The book in date. */
    private Date bookInDate;

    /** The proof out date. */
    private Date proofOutDate;

    /** The proof rcvd date. */
    private Date proofRcvdDate;

    /** The early view date. */
    private Date earlyViewDate;

    /** The accptd article pub online date. */
    private Date accptdArticlePubOnlineDate;

    /** The rvsd article proof rcvd date. */
    private Date rvsdArticleProofRcvdDate;

    /** The rvsd article proof apprvd date. */
    private Date rvsdArticleProofApprvdDate;

    /** The issue pub online date. */
    private Date issuePubOnlineDate;

    /** The article wol date. */
    private Date articleWolDate;

    /** The product region. */
    private String productRegion;

    /**
     * Gets the product region.
     *
     * @return the product region
     */
    public final String getProductRegion() {
        return productRegion;
    }

    /**
     * Sets the product region.
     *
     * @param productRegion
     *            the new product region
     */
    public final void setProductRegion(final String productRegion) {
        this.productRegion = productRegion;
    }

    /**
     * Gets the dh id.
     *
     * @return the dh id
     */
    public final String getDhId() {
        return dhId;
    }

    /**
     * Sets the dh id.
     *
     * @param dhId
     *            the new dh id
     */
    public final void setDhId(final String dhId) {
        this.dhId = dhId;
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
     * Gets the title.
     *
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the new title
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the author role.
     *
     * @return the author role
     */
    public final String getAuthorRole() {
        return authorRole;
    }

    /**
     * Sets the author role.
     *
     * @param authorRole
     *            the new author role
     */
    public final void setAuthorRole(final String authorRole) {
        this.authorRole = authorRole;
    }

    /**
     * Gets the author name.
     *
     * @return the author name
     */
    public final String getAuthorName() {
        return authorName;
    }

    /**
     * Sets the author name.
     *
     * @param authorName
     *            the new author name
     */
    public final void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    /**
     * Gets the author email.
     *
     * @return the author email
     */
    public final String getAuthorEmail() {
        return authorEmail;
    }

    /**
     * Sets the author email.
     *
     * @param authorEmail
     *            the new author email
     */
    public final void setAuthorEmail(final String authorEmail) {
        this.authorEmail = authorEmail;
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
     * Gets the article aid.
     *
     * @return the article aid
     */
    public final String getArticleAid() {
        return articleAid;
    }

    /**
     * Sets the article aid.
     *
     * @param articleAid
     *            the new article aid
     */
    public final void setArticleAid(final String articleAid) {
        this.articleAid = articleAid;
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
     * Gets the journal dh id.
     *
     * @return the journal dh id
     */
    public final String getJournalDhId() {
        return journalDhId;
    }

    /**
     * Sets the journal dh id.
     *
     * @param journalDhId
     *            the new journal dh id
     */
    public final void setJournalDhId(final String journalDhId) {
        this.journalDhId = journalDhId;
    }

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId
     *            the new journal id
     */
    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
    }

    /**
     * Gets the checks if is invited in as.
     *
     * @return the checks if is invited in as
     */
    public final String getIsInvitedInAs() {
        return isInvitedInAs;
    }

    /**
     * Sets the checks if is invited in as.
     *
     * @param isInvitedInAs
     *            the new checks if is invited in as
     */
    public final void setIsInvitedInAs(final String isInvitedInAs) {
        this.isInvitedInAs = isInvitedInAs;
    }

    /**
     * Gets the jpcms id.
     *
     * @return the jpcms id
     */
    public final String getJpcmsId() {
        return jpcmsId;
    }

    /**
     * Sets the jpcms id.
     *
     * @param jpcmsId
     *            the new jpcms id
     */
    public final void setJpcmsId(final String jpcmsId) {
        this.jpcmsId = jpcmsId;
    }

    /**
     * Gets the jpcms copyright line.
     *
     * @return the jpcms copyright line
     */
    public final String getJpcmsCopyrightLine() {
        return jpcmsCopyrightLine;
    }

    /**
     * Sets the jpcms copyright line.
     *
     * @param jpcmsCopyrightLine
     *            the new jpcms copyright line
     */
    public final void setJpcmsCopyrightLine(final String jpcmsCopyrightLine) {
        this.jpcmsCopyrightLine = jpcmsCopyrightLine;
    }

    /**
     * Gets the article type.
     *
     * @return the article type
     */
    public final String getArticleType() {
        return articleType;
    }

    /**
     * Sets the article type.
     *
     * @param articleType
     *            the new article type
     */
    public final void setArticleType(final String articleType) {
        this.articleType = articleType;
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
     * Gets the publication year.
     *
     * @return the publication year
     */
    public final String getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets the publication year.
     *
     * @param publicationYear
     *            the new publication year
     */
    public final void setPublicationYear(final String publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Gets the wiley received date.
     *
     * @return the wiley received date
     */
    public final Date getWileyReceivedDate() {
        return wileyReceivedDate;
    }

    /**
     * Sets the wiley received date.
     *
     * @param wileyReceivedDate
     *            the new wiley received date
     */
    public final void setWileyReceivedDate(final Date wileyReceivedDate) {
        this.wileyReceivedDate = wileyReceivedDate;
    }

    /**
     * Gets the accepted date.
     *
     * @return the accepted date
     */
    public final Date getAcceptedDate() {
        return acceptedDate;
    }

    /**
     * Sets the accepted date.
     *
     * @param acceptedDate
     *            the new accepted date
     */
    public final void setAcceptedDate(final Date acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    /**
     * Gets the received date.
     *
     * @return the received date
     */
    public final Date getReceivedDate() {
        return receivedDate;
    }

    /**
     * Sets the received date.
     *
     * @param receivedDate
     *            the new received date
     */
    public final void setReceivedDate(final Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * Gets the revised date.
     *
     * @return the revised date
     */
    public final Date getRevisedDate() {
        return revisedDate;
    }

    /**
     * Sets the revised date.
     *
     * @param revisedDate
     *            the new revised date
     */
    public final void setRevisedDate(final Date revisedDate) {
        this.revisedDate = revisedDate;
    }

    /**
     * Gets the submitted date.
     *
     * @return the submitted date
     */
    public final Date getSubmittedDate() {
        return submittedDate;
    }

    /**
     * Sets the submitted date.
     *
     * @param submittedDate
     *            the new submitted date
     */
    public final void setSubmittedDate(final Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     * Gets the cta rcvd date.
     *
     * @return the cta rcvd date
     */
    public final Date getCtaRcvdDate() {
        return ctaRcvdDate;
    }

    /**
     * Sets the cta rcvd date.
     *
     * @param ctaRcvdDate
     *            the new cta rcvd date
     */
    public final void setCtaRcvdDate(final Date ctaRcvdDate) {
        this.ctaRcvdDate = ctaRcvdDate;
    }

    /**
     * Gets the book in date.
     *
     * @return the book in date
     */
    public final Date getBookInDate() {
        return bookInDate;
    }

    /**
     * Sets the book in date.
     *
     * @param bookInDate
     *            the new book in date
     */
    public final void setBookInDate(final Date bookInDate) {
        this.bookInDate = bookInDate;
    }

    /**
     * Gets the proof out date.
     *
     * @return the proof out date
     */
    public final Date getProofOutDate() {
        return proofOutDate;
    }

    /**
     * Sets the proof out date.
     *
     * @param proofOutDate
     *            the new proof out date
     */
    public final void setProofOutDate(final Date proofOutDate) {
        this.proofOutDate = proofOutDate;
    }

    /**
     * Gets the proof rcvd date.
     *
     * @return the proof rcvd date
     */
    public final Date getProofRcvdDate() {
        return proofRcvdDate;
    }

    /**
     * Sets the proof rcvd date.
     *
     * @param proofRcvdDate
     *            the new proof rcvd date
     */
    public final void setProofRcvdDate(final Date proofRcvdDate) {
        this.proofRcvdDate = proofRcvdDate;
    }

    /**
     * Gets the early view date.
     *
     * @return the early view date
     */
    public final Date getEarlyViewDate() {
        return earlyViewDate;
    }

    /**
     * Sets the early view date.
     *
     * @param earlyViewDate
     *            the new early view date
     */
    public final void setEarlyViewDate(final Date earlyViewDate) {
        this.earlyViewDate = earlyViewDate;
    }

    /**
     * Gets the accptd article pub online date.
     *
     * @return the accptd article pub online date
     */
    public final Date getAccptdArticlePubOnlineDate() {
        return accptdArticlePubOnlineDate;
    }

    /**
     * Sets the accptd article pub online date.
     *
     * @param accptdArticlePubOnlineDate
     *            the new accptd article pub online date
     */
    public final void setAccptdArticlePubOnlineDate(
            final Date accptdArticlePubOnlineDate) {
        this.accptdArticlePubOnlineDate = accptdArticlePubOnlineDate;
    }

    /**
     * Gets the rvsd article proof rcvd date.
     *
     * @return the rvsd article proof rcvd date
     */
    public final Date getRvsdArticleProofRcvdDate() {
        return rvsdArticleProofRcvdDate;
    }

    /**
     * Sets the rvsd article proof rcvd date.
     *
     * @param rvsdArticleProofRcvdDate
     *            the new rvsd article proof rcvd date
     */
    public final void setRvsdArticleProofRcvdDate(
            final Date rvsdArticleProofRcvdDate) {
        this.rvsdArticleProofRcvdDate = rvsdArticleProofRcvdDate;
    }

    /**
     * Gets the rvsd article proof apprvd date.
     *
     * @return the rvsd article proof apprvd date
     */
    public final Date getRvsdArticleProofApprvdDate() {
        return rvsdArticleProofApprvdDate;
    }

    /**
     * Sets the rvsd article proof apprvd date.
     *
     * @param rvsdArticleProofApprvdDate
     *            the new rvsd article proof apprvd date
     */
    public final void setRvsdArticleProofApprvdDate(
            final Date rvsdArticleProofApprvdDate) {
        this.rvsdArticleProofApprvdDate = rvsdArticleProofApprvdDate;
    }

    /**
     * Gets the issue pub online date.
     *
     * @return the issue pub online date
     */
    public final Date getIssuePubOnlineDate() {
        return issuePubOnlineDate;
    }

    /**
     * Sets the issue pub online date.
     *
     * @param issuePubOnlineDate
     *            the new issue pub online date
     */
    public final void setIssuePubOnlineDate(final Date issuePubOnlineDate) {
        this.issuePubOnlineDate = issuePubOnlineDate;
    }

    /**
     * Gets the article wol date.
     *
     * @return the article wol date
     */
    public final Date getArticleWolDate() {
        return articleWolDate;
    }

    /**
     * Sets the article wol date.
     *
     * @param articleWolDate
     *            the new article wol date
     */
    public final void setArticleWolDate(final Date articleWolDate) {
        this.articleWolDate = articleWolDate;
    }

}
