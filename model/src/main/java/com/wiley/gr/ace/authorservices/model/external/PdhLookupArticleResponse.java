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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PdhLookupArticleResponse.
 *
 * @author virtusa version 1.0
 */
public class PdhLookupArticleResponse {

    /** The title. */
    @JsonProperty("title")
    private String title;

    /** The alternate title. */
    @JsonProperty("alternateTitle")
    private String alternateTitle;

    /** The article unique id. */
    @JsonProperty("ArticleUniqueID")
    private String articleUniqueID;

    /** The journal unique id. */
    @JsonProperty("JournalUniqueID")
    private String journalUniqueID;

    /** The editorial ref code. */
    @JsonProperty("EditorialRefCode")
    private String editorialRefCode;

    /** The a id. */
    @JsonProperty("AID")
    private String aId;

    /** The jpcms id. */
    @JsonProperty("jpcmsID")
    private String jpcmsId;

    /** The article doi. */
    @JsonProperty("DOI")
    private String articleDoi;

    /** The new element. */
    @JsonProperty("NewElement")
    private String newElement;

    /** The volume number. */
    @JsonProperty("VolumeNumber")
    private String volumeNumber;

    /** The issue number. */
    @JsonProperty("IssueNumber")
    private String issueNumber;

    /** The page number. */
    @JsonProperty("PageNumber")
    private String pageNumber;

    /** The publication year. */
    @JsonProperty("PublicationYear")
    private String publicationYear;

    /** The received date. */
    @JsonProperty("ReceivedDate")
    private String receivedDate;

    /** The accepted date. */
    @JsonProperty("AcceptedDate")
    private String acceptedDate;

    /** The article accepted in oo. */
    @JsonProperty("articleAcceptedInOO")
    private String articleAcceptedInOO;

    /** The submitted date. */
    @JsonProperty("SubmittedDate")
    private String submittedDate;

    /** The revised date. */
    @JsonProperty("RevisedDate")
    private String revisedDate;

    /** The classification. */
    @JsonProperty("Classification")
    private String classification;

    /** The wals participation. */
    @JsonProperty("WALSParticipation")
    private String walsParticipation;

    /** The cta. */
    @JsonProperty("CTA")
    private String cta;

    /** The cta received date. */
    @JsonProperty("CTAReceivedDate")
    private String ctaReceivedDate;

    /** The jpcms copyright line. */
    @JsonProperty("JPCMSCopyrightLine")
    private String jpcmsCopyrightLine;

    /** The wol copyright line. */
    @JsonProperty("WOLCopyrightLine")
    private String wolCopyrightLine;

    /** The license. */
    @JsonProperty("License")
    private String license;

    /** The author name. */
    @JsonProperty("author_name")
    private String authorName;

    /** The author email. */
    @JsonProperty("author_email")
    private String authorEmail;

    /** The co author name. */
    @JsonProperty("co_author_name")
    private String coAuthorName;

    /** The co author email. */
    @JsonProperty("co_author_email")
    private String coAuthorEmail;

    /** The invited in as. */
    @JsonProperty("invited_in_as")
    private String invitedInAs;

    /** The booking date. */
    @JsonProperty("booking_date")
    private String bookingDate;

    /** The proof out date. */
    @JsonProperty("proof_out_date")
    private String proofOutDate;

    /** The proof received date. */
    @JsonProperty("proof_received_date")
    private String proofReceivedDate;

    /** The published date. */
    @JsonProperty("published_date")
    private String publishedDate;

    /** The proof approved date. */
    @JsonProperty("proof_approved_date")
    private String proofApprovedDate;

    /** The withdrawn date pre acceptance. */
    @JsonProperty("withdrawn_date_pre_acceptance")
    private String withdrawnDatePreAcceptance;

    /** The withdrawn date after acceptance. */
    @JsonProperty("withdrawn_date_after_acceptance")
    private String withdrawnDateAfterAcceptance;

    /** The proof corrections received date. */
    @JsonProperty("proof_received_production_date")
    private String proofCorrectionsReceivedDate;

    /** The revised proof received date. */
    @JsonProperty("revised_proof_received_date")
    private String revisedProofReceivedDate;

    /** The revised proof approved date. */
    @JsonProperty("revised_proof_approved_date")
    private String revisedProofApprovedDate;

    /** The alert associate unpagpub online. */
    @JsonProperty("alert_associate_unpagpubOnline")
    private String alertAssociateUnpagpubOnline;

    /** The wol date. */
    @JsonProperty("wol_date")
    private String wolDate;

    /** The rejected date. */
    @JsonProperty("rejectedDate")
    private String rejectedDate;

    /** The iss pub online date. */
    @JsonProperty("issPubOnlineDate")
    private String issPubOnlineDate;

    /** The page count. */
    @JsonProperty("pageCount")
    private String pageCount;

    /** The proof page count. */
    @JsonProperty("proofPageCount")
    private String proofPageCount;

    /** The color pages. */
    @JsonProperty("colorPages")
    private String colorPages;

    /** The incl excel price. */
    @JsonProperty("inclExcelPrice")
    private String inclExcelPrice;

    /** The author affiliations. */
    @JsonProperty("authorAffiliations")
    private String authorAffiliations;

    /** The author address. */
    @JsonProperty("authorAddress")
    private String authorAddress;

    /** The co author affiliations. */
    @JsonProperty("coAuthorAffiliations")
    private String coAuthorAffiliations;

    /** The co author address. */
    @JsonProperty("coAuthorAddress")
    private String coAuthorAddress;

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
     * Gets the alternate title.
     *
     * @return the alternate title
     */
    public final String getAlternateTitle() {
        return alternateTitle;
    }

    /**
     * Sets the alternate title.
     *
     * @param alternateTitle
     *            the new alternate title
     */
    public final void setAlternateTitle(final String alternateTitle) {
        this.alternateTitle = alternateTitle;
    }

    /**
     * Gets the article unique id.
     *
     * @return the article unique id
     */
    public final String getArticleUniqueID() {
        return articleUniqueID;
    }

    /**
     * Sets the article unique id.
     *
     * @param articleUniqueID
     *            the new article unique id
     */
    public final void setArticleUniqueID(final String articleUniqueID) {
        this.articleUniqueID = articleUniqueID;
    }

    /**
     * Gets the journal unique id.
     *
     * @return the journal unique id
     */
    public final String getJournalUniqueID() {
        return journalUniqueID;
    }

    /**
     * Sets the journal unique id.
     *
     * @param journalUniqueID
     *            the new journal unique id
     */
    public final void setJournalUniqueID(final String journalUniqueID) {
        this.journalUniqueID = journalUniqueID;
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
     * Gets the a id.
     *
     * @return the a id
     */
    public final String getaId() {
        return aId;
    }

    /**
     * Sets the a id.
     *
     * @param aId
     *            the new a id
     */
    public final void setaId(final String aId) {
        this.aId = aId;
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
     * Gets the new element.
     *
     * @return the new element
     */
    public final String getNewElement() {
        return newElement;
    }

    /**
     * Sets the new element.
     *
     * @param newElement
     *            the new new element
     */
    public final void setNewElement(final String newElement) {
        this.newElement = newElement;
    }

    /**
     * Gets the volume number.
     *
     * @return the volume number
     */
    public final String getVolumeNumber() {
        return volumeNumber;
    }

    /**
     * Sets the volume number.
     *
     * @param volumeNumber
     *            the new volume number
     */
    public final void setVolumeNumber(final String volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    /**
     * Gets the issue number.
     *
     * @return the issue number
     */
    public final String getIssueNumber() {
        return issueNumber;
    }

    /**
     * Sets the issue number.
     *
     * @param issueNumber
     *            the new issue number
     */
    public final void setIssueNumber(final String issueNumber) {
        this.issueNumber = issueNumber;
    }

    /**
     * Gets the page number.
     *
     * @return the page number
     */
    public final String getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the page number.
     *
     * @param pageNumber
     *            the new page number
     */
    public final void setPageNumber(final String pageNumber) {
        this.pageNumber = pageNumber;
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
     * Gets the received date.
     *
     * @return the received date
     */
    public final String getReceivedDate() {
        return receivedDate;
    }

    /**
     * Sets the received date.
     *
     * @param receivedDate
     *            the new received date
     */
    public final void setReceivedDate(final String receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * Gets the accepted date.
     *
     * @return the accepted date
     */
    public final String getAcceptedDate() {
        return acceptedDate;
    }

    /**
     * Sets the accepted date.
     *
     * @param acceptedDate
     *            the new accepted date
     */
    public final void setAcceptedDate(final String acceptedDate) {
        this.acceptedDate = acceptedDate;
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
    public final void setArticleAcceptedInOO(String articleAcceptedInOO) {
        this.articleAcceptedInOO = articleAcceptedInOO;
    }

    /**
     * Gets the submitted date.
     *
     * @return the submitted date
     */
    public final String getSubmittedDate() {
        return submittedDate;
    }

    /**
     * Sets the submitted date.
     *
     * @param submittedDate
     *            the new submitted date
     */
    public final void setSubmittedDate(final String submittedDate) {
        this.submittedDate = submittedDate;
    }

    /**
     * Gets the revised date.
     *
     * @return the revised date
     */
    public final String getRevisedDate() {
        return revisedDate;
    }

    /**
     * Sets the revised date.
     *
     * @param revisedDate
     *            the new revised date
     */
    public final void setRevisedDate(final String revisedDate) {
        this.revisedDate = revisedDate;
    }

    /**
     * Gets the classification.
     *
     * @return the classification
     */
    public final String getClassification() {
        return classification;
    }

    /**
     * Sets the classification.
     *
     * @param classification
     *            the new classification
     */
    public final void setClassification(final String classification) {
        this.classification = classification;
    }

    /**
     * Gets the wals participation.
     *
     * @return the wals participation
     */
    public final String getWalsParticipation() {
        return walsParticipation;
    }

    /**
     * Sets the wals participation.
     *
     * @param walsParticipation
     *            the new wals participation
     */
    public final void setWalsParticipation(final String walsParticipation) {
        this.walsParticipation = walsParticipation;
    }

    /**
     * Gets the cta.
     *
     * @return the cta
     */
    public final String getCta() {
        return cta;
    }

    /**
     * Sets the cta.
     *
     * @param cta
     *            the new cta
     */
    public final void setCta(final String cta) {
        this.cta = cta;
    }

    /**
     * Gets the cta received date.
     *
     * @return the cta received date
     */
    public final String getCtaReceivedDate() {
        return ctaReceivedDate;
    }

    /**
     * Sets the cta received date.
     *
     * @param ctaReceivedDate
     *            the new cta received date
     */
    public final void setCtaReceivedDate(final String ctaReceivedDate) {
        this.ctaReceivedDate = ctaReceivedDate;
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
     * Gets the wol copyright line.
     *
     * @return the wol copyright line
     */
    public final String getWolCopyrightLine() {
        return wolCopyrightLine;
    }

    /**
     * Sets the wol copyright line.
     *
     * @param wolCopyrightLine
     *            the new wol copyright line
     */
    public final void setWolCopyrightLine(final String wolCopyrightLine) {
        this.wolCopyrightLine = wolCopyrightLine;
    }

    /**
     * Gets the license.
     *
     * @return the license
     */
    public final String getLicense() {
        return license;
    }

    /**
     * Sets the license.
     *
     * @param license
     *            the new license
     */
    public final void setLicense(final String license) {
        this.license = license;
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
     * Gets the co author name.
     *
     * @return the co author name
     */
    public final String getCoAuthorName() {
        return coAuthorName;
    }

    /**
     * Sets the co author name.
     *
     * @param coAuthorName
     *            the new co author name
     */
    public final void setCoAuthorName(final String coAuthorName) {
        this.coAuthorName = coAuthorName;
    }

    /**
     * Gets the co author email.
     *
     * @return the co author email
     */
    public final String getCoAuthorEmail() {
        return coAuthorEmail;
    }

    /**
     * Sets the co author email.
     *
     * @param coAuthorEmail
     *            the new co author email
     */
    public final void setCoAuthorEmail(final String coAuthorEmail) {
        this.coAuthorEmail = coAuthorEmail;
    }

    /**
     * Gets the invited in as.
     *
     * @return the invited in as
     */
    public final String getInvitedInAs() {
        return invitedInAs;
    }

    /**
     * Sets the invited in as.
     *
     * @param invitedInAs
     *            the new invited in as
     */
    public final void setInvitedInAs(final String invitedInAs) {
        this.invitedInAs = invitedInAs;
    }

    /**
     * Gets the booking date.
     *
     * @return the booking date
     */
    public final String getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the booking date.
     *
     * @param bookingDate
     *            the new booking date
     */
    public final void setBookingDate(final String bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * Gets the proof out date.
     *
     * @return the proof out date
     */
    public final String getProofOutDate() {
        return proofOutDate;
    }

    /**
     * Sets the proof out date.
     *
     * @param proofOutDate
     *            the new proof out date
     */
    public final void setProofOutDate(final String proofOutDate) {
        this.proofOutDate = proofOutDate;
    }

    /**
     * Gets the proof received date.
     *
     * @return the proof received date
     */
    public final String getProofReceivedDate() {
        return proofReceivedDate;
    }

    /**
     * Sets the proof received date.
     *
     * @param proofReceivedDate
     *            the new proof received date
     */
    public final void setProofReceivedDate(final String proofReceivedDate) {
        this.proofReceivedDate = proofReceivedDate;
    }

    /**
     * Gets the published date.
     *
     * @return the published date
     */
    public final String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets the published date.
     *
     * @param publishedDate
     *            the new published date
     */
    public final void setPublishedDate(final String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * Gets the proof approved date.
     *
     * @return the proof approved date
     */
    public final String getProofApprovedDate() {
        return proofApprovedDate;
    }

    /**
     * Sets the proof approved date.
     *
     * @param proofApprovedDate
     *            the new proof approved date
     */
    public final void setProofApprovedDate(final String proofApprovedDate) {
        this.proofApprovedDate = proofApprovedDate;
    }

    /**
     * Gets the withdrawn date pre acceptance.
     *
     * @return the withdrawn date pre acceptance
     */
    public final String getWithdrawnDatePreAcceptance() {
        return withdrawnDatePreAcceptance;
    }

    /**
     * Sets the withdrawn date pre acceptance.
     *
     * @param withdrawnDatePreAcceptance
     *            the new withdrawn date pre acceptance
     */
    public final void setWithdrawnDatePreAcceptance(
            final String withdrawnDatePreAcceptance) {
        this.withdrawnDatePreAcceptance = withdrawnDatePreAcceptance;
    }

    /**
     * Gets the withdrawn date after acceptance.
     *
     * @return the withdrawn date after acceptance
     */
    public final String getWithdrawnDateAfterAcceptance() {
        return withdrawnDateAfterAcceptance;
    }

    /**
     * Sets the withdrawn date after acceptance.
     *
     * @param withdrawnDateAfterAcceptance
     *            the new withdrawn date after acceptance
     */
    public final void setWithdrawnDateAfterAcceptance(
            final String withdrawnDateAfterAcceptance) {
        this.withdrawnDateAfterAcceptance = withdrawnDateAfterAcceptance;
    }

    /**
     * Gets the proof corrections received date.
     *
     * @return the proof corrections received date
     */
    public final String getProofCorrectionsReceivedDate() {
        return proofCorrectionsReceivedDate;
    }

    /**
     * Sets the proof corrections received date.
     *
     * @param proofCorrectionsReceivedDate
     *            the new proof corrections received date
     */
    public final void setProofCorrectionsReceivedDate(
            final String proofCorrectionsReceivedDate) {
        this.proofCorrectionsReceivedDate = proofCorrectionsReceivedDate;
    }

    /**
     * Gets the revised proof received date.
     *
     * @return the revised proof received date
     */
    public final String getRevisedProofReceivedDate() {
        return revisedProofReceivedDate;
    }

    /**
     * Sets the revised proof received date.
     *
     * @param revisedProofReceivedDate
     *            the new revised proof received date
     */
    public final void setRevisedProofReceivedDate(
            final String revisedProofReceivedDate) {
        this.revisedProofReceivedDate = revisedProofReceivedDate;
    }

    /**
     * Gets the revised proof approved date.
     *
     * @return the revised proof approved date
     */
    public final String getRevisedProofApprovedDate() {
        return revisedProofApprovedDate;
    }

    /**
     * Sets the revised proof approved date.
     *
     * @param revisedProofApprovedDate
     *            the new revised proof approved date
     */
    public final void setRevisedProofApprovedDate(
            final String revisedProofApprovedDate) {
        this.revisedProofApprovedDate = revisedProofApprovedDate;
    }

    /**
     * Gets the alert associate unpagpub online.
     *
     * @return the alert associate unpagpub online
     */
    public final String getAlertAssociateUnpagpubOnline() {
        return alertAssociateUnpagpubOnline;
    }

    /**
     * Sets the alert associate unpagpub online.
     *
     * @param alertAssociateUnpagpubOnline
     *            the new alert associate unpagpub online
     */
    public final void setAlertAssociateUnpagpubOnline(
            final String alertAssociateUnpagpubOnline) {
        this.alertAssociateUnpagpubOnline = alertAssociateUnpagpubOnline;
    }

    /**
     * Gets the wol date.
     *
     * @return the wol date
     */
    public final String getWolDate() {
        return wolDate;
    }

    /**
     * Sets the wol date.
     *
     * @param wolDate
     *            the new wol date
     */
    public final void setWolDate(final String wolDate) {
        this.wolDate = wolDate;
    }

    /**
     * Gets the rejected date.
     *
     * @return the rejected date
     */
    public final String getRejectedDate() {
        return rejectedDate;
    }

    /**
     * Sets the rejected date.
     *
     * @param rejectedDate
     *            the new rejected date
     */
    public final void setRejectedDate(final String rejectedDate) {
        this.rejectedDate = rejectedDate;
    }

    /**
     * Gets the iss pub online date.
     *
     * @return the iss pub online date
     */
    public final String getIssPubOnlineDate() {
        return issPubOnlineDate;
    }

    /**
     * Sets the iss pub online date.
     *
     * @param issPubOnlineDate
     *            the new iss pub online date
     */
    public final void setIssPubOnlineDate(final String issPubOnlineDate) {
        this.issPubOnlineDate = issPubOnlineDate;
    }

    /**
     * Gets the page count.
     *
     * @return the page count
     */
    public final String getPageCount() {
        return pageCount;
    }

    /**
     * Sets the page count.
     *
     * @param pageCount
     *            the new page count
     */
    public final void setPageCount(final String pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Gets the proof page count.
     *
     * @return the proof page count
     */
    public final String getProofPageCount() {
        return proofPageCount;
    }

    /**
     * Sets the proof page count.
     *
     * @param proofPageCount
     *            the new proof page count
     */
    public final void setProofPageCount(final String proofPageCount) {
        this.proofPageCount = proofPageCount;
    }

    /**
     * Gets the color pages.
     *
     * @return the color pages
     */
    public final String getColorPages() {
        return colorPages;
    }

    /**
     * Sets the color pages.
     *
     * @param colorPages
     *            the new color pages
     */
    public final void setColorPages(final String colorPages) {
        this.colorPages = colorPages;
    }

    /**
     * Gets the incl excel price.
     *
     * @return the incl excel price
     */
    public final String getInclExcelPrice() {
        return inclExcelPrice;
    }

    /**
     * Sets the incl excel price.
     *
     * @param inclExcelPrice
     *            the new incl excel price
     */
    public final void setInclExcelPrice(final String inclExcelPrice) {
        this.inclExcelPrice = inclExcelPrice;
    }

    /**
     * Gets the author affiliations.
     *
     * @return the author affiliations
     */
    public final String getAuthorAffiliations() {
        return authorAffiliations;
    }

    /**
     * Sets the author affiliations.
     *
     * @param authorAffiliations
     *            the new author affiliations
     */
    public final void setAuthorAffiliations(final String authorAffiliations) {
        this.authorAffiliations = authorAffiliations;
    }

    /**
     * Gets the author address.
     *
     * @return the author address
     */
    public final String getAuthorAddress() {
        return authorAddress;
    }

    /**
     * Sets the author address.
     *
     * @param authorAddress
     *            the new author address
     */
    public final void setAuthorAddress(final String authorAddress) {
        this.authorAddress = authorAddress;
    }

    /**
     * Gets the co author affiliations.
     *
     * @return the co author affiliations
     */
    public final String getCoAuthorAffiliations() {
        return coAuthorAffiliations;
    }

    /**
     * Sets the co author affiliations.
     *
     * @param coAuthorAffiliations
     *            the new co author affiliations
     */
    public final void setCoAuthorAffiliations(final String coAuthorAffiliations) {
        this.coAuthorAffiliations = coAuthorAffiliations;
    }

    /**
     * Gets the co author address.
     *
     * @return the co author address
     */
    public final String getCoAuthorAddress() {
        return coAuthorAddress;
    }

    /**
     * Sets the co author address.
     *
     * @param coAuthorAddress
     *            the new co author address
     */
    public final void setCoAuthorAddress(final String coAuthorAddress) {
        this.coAuthorAddress = coAuthorAddress;
    }

}
