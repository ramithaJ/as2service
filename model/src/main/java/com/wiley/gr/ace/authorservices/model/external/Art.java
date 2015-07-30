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
 * The Class Art.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Art {

    /** The wals participation. */
    private String walsParticipation;

    /** The iss num. */
    private String issNum;

    /** The co authors. */
    private List<CoAuthorDetails> coAuthors;

    /** The auth serv enabled. */
    private String authServEnabled;

    /** The jrnl id. */
    private String jrnlId;

    /** The aid. */
    private String aid;

    /** The title. */
    private String title;

    /** The admin override article wals participation. */
    private String adminOverrideArticleWALSParticipation;

    /** The ed ref code. */
    private String edRefCode;

    /** The vol num. */
    private String volNum;

    /** The iss acronym. */
    private String issAcronym;

    /** The art license. */
    private String artLicense;

    /** The copyright line. */
    private String copyrightLine;

    /** The pub year. */
    private String pubYear;

    /** The jrnl title. */
    private String jrnlTitle;

    /** The jrnl doi. */
    private String jrnlDoi;

    /** The multiple singed licenses available. */
    private String multipleSingedLicensesAvailable;

    /** The cta recd. */
    private String ctaRecd;

    /** The corresponding author email. */
    private String correspondingAuthorEmail;

    /** The wiley received dt. */
    private String wileyReceivedDt;

    /** The corresponding author first name. */
    private String correspondingAuthorFirstName;

    /** The type of cta. */
    private String typeOfCta;

    /** The accepted dt. */
    private String acceptedDt;

    /** The jrnl eissn. */
    private String jrnlEissn;

    /** The jpcms internal id. */
    private String jpcmsInternalId;

    /** The jrnl pissn. */
    private String jrnlPissn;

    /** The corresponding author last name. */
    private String correspondingAuthorLastName;

    /** The classification. */
    private String classification;

    /** The participate in wals. */
    private String participateInWALS;

    /** The doi. */
    private String doi;

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
     * Gets the iss num.
     *
     * @return the iss num
     */
    public final String getIssNum() {
        return issNum;
    }

    /**
     * Sets the iss num.
     *
     * @param issNum
     *            the new iss num
     */
    public final void setIssNum(final String issNum) {
        this.issNum = issNum;
    }

    /**
     * Gets the auth serv enabled.
     *
     * @return the auth serv enabled
     */
    public final String getAuthServEnabled() {
        return authServEnabled;
    }

    /**
     * Sets the auth serv enabled.
     *
     * @param authServEnabled
     *            the new auth serv enabled
     */
    public final void setAuthServEnabled(final String authServEnabled) {
        this.authServEnabled = authServEnabled;
    }

    /**
     * Gets the jrnl id.
     *
     * @return the jrnl id
     */
    public final String getJrnlId() {
        return jrnlId;
    }

    /**
     * Sets the jrnl id.
     *
     * @param jrnlId
     *            the new jrnl id
     */
    public final void setJrnlId(final String jrnlId) {
        this.jrnlId = jrnlId;
    }

    /**
     * Gets the aid.
     *
     * @return the aid
     */
    public final String getAid() {
        return aid;
    }

    /**
     * Sets the aid.
     *
     * @param aid
     *            the new aid
     */
    public final void setAid(final String aid) {
        this.aid = aid;
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
     * Gets the admin override article wals participation.
     *
     * @return the admin override article wals participation
     */
    public final String getAdminOverrideArticleWALSParticipation() {
        return adminOverrideArticleWALSParticipation;
    }

    /**
     * Sets the admin override article wals participation.
     *
     * @param adminOverrideArticleWALSParticipation
     *            the new admin override article wals participation
     */
    public final void setAdminOverrideArticleWALSParticipation(
            final String adminOverrideArticleWALSParticipation) {
        this.adminOverrideArticleWALSParticipation = adminOverrideArticleWALSParticipation;
    }

    /**
     * Gets the ed ref code.
     *
     * @return the ed ref code
     */
    public final String getEdRefCode() {
        return edRefCode;
    }

    /**
     * Sets the ed ref code.
     *
     * @param edRefCode
     *            the new ed ref code
     */
    public final void setEdRefCode(final String edRefCode) {
        this.edRefCode = edRefCode;
    }

    /**
     * Gets the vol num.
     *
     * @return the vol num
     */
    public final String getVolNum() {
        return volNum;
    }

    /**
     * Sets the vol num.
     *
     * @param volNum
     *            the new vol num
     */
    public final void setVolNum(final String volNum) {
        this.volNum = volNum;
    }

    /**
     * Gets the iss acronym.
     *
     * @return the iss acronym
     */
    public final String getIssAcronym() {
        return issAcronym;
    }

    /**
     * Sets the iss acronym.
     *
     * @param issAcronym
     *            the new iss acronym
     */
    public final void setIssAcronym(final String issAcronym) {
        this.issAcronym = issAcronym;
    }

    /**
     * Gets the art license.
     *
     * @return the art license
     */
    public final String getArtLicense() {
        return artLicense;
    }

    /**
     * Sets the art license.
     *
     * @param artLicense
     *            the new art license
     */
    public final void setArtLicense(final String artLicense) {
        this.artLicense = artLicense;
    }

    /**
     * Gets the copyright line.
     *
     * @return the copyright line
     */
    public final String getCopyrightLine() {
        return copyrightLine;
    }

    /**
     * Sets the copyright line.
     *
     * @param copyrightLine
     *            the new copyright line
     */
    public final void setCopyrightLine(final String copyrightLine) {
        this.copyrightLine = copyrightLine;
    }

    /**
     * Gets the pub year.
     *
     * @return the pub year
     */
    public final String getPubYear() {
        return pubYear;
    }

    /**
     * Sets the pub year.
     *
     * @param pubYear
     *            the new pub year
     */
    public final void setPubYear(final String pubYear) {
        this.pubYear = pubYear;
    }

    /**
     * Gets the jrnl title.
     *
     * @return the jrnl title
     */
    public final String getJrnlTitle() {
        return jrnlTitle;
    }

    /**
     * Sets the jrnl title.
     *
     * @param jrnlTitle
     *            the new jrnl title
     */
    public final void setJrnlTitle(final String jrnlTitle) {
        this.jrnlTitle = jrnlTitle;
    }

    /**
     * Gets the jrnl doi.
     *
     * @return the jrnl doi
     */
    public final String getJrnlDoi() {
        return jrnlDoi;
    }

    /**
     * Sets the jrnl doi.
     *
     * @param jrnlDoi
     *            the new jrnl doi
     */
    public final void setJrnlDoi(final String jrnlDoi) {
        this.jrnlDoi = jrnlDoi;
    }

    /**
     * Gets the multiple singed licenses available.
     *
     * @return the multiple singed licenses available
     */
    public final String getMultipleSingedLicensesAvailable() {
        return multipleSingedLicensesAvailable;
    }

    /**
     * Sets the multiple singed licenses available.
     *
     * @param multipleSingedLicensesAvailable
     *            the new multiple singed licenses available
     */
    public final void setMultipleSingedLicensesAvailable(
            final String multipleSingedLicensesAvailable) {
        this.multipleSingedLicensesAvailable = multipleSingedLicensesAvailable;
    }

    /**
     * Gets the cta recd.
     *
     * @return the cta recd
     */
    public final String getCtaRecd() {
        return ctaRecd;
    }

    /**
     * Sets the cta recd.
     *
     * @param ctaRecd
     *            the new cta recd
     */
    public final void setCtaRecd(final String ctaRecd) {
        this.ctaRecd = ctaRecd;
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
     * Gets the wiley received dt.
     *
     * @return the wiley received dt
     */
    public final String getWileyReceivedDt() {
        return wileyReceivedDt;
    }

    /**
     * Sets the wiley received dt.
     *
     * @param wileyReceivedDt
     *            the new wiley received dt
     */
    public final void setWileyReceivedDt(final String wileyReceivedDt) {
        this.wileyReceivedDt = wileyReceivedDt;
    }

    /**
     * Gets the corresponding author first name.
     *
     * @return the corresponding author first name
     */
    public final String getCorrespondingAuthorFirstName() {
        return correspondingAuthorFirstName;
    }

    /**
     * Sets the corresponding author first name.
     *
     * @param correspondingAuthorFirstName
     *            the new corresponding author first name
     */
    public final void setCorrespondingAuthorFirstName(
            final String correspondingAuthorFirstName) {
        this.correspondingAuthorFirstName = correspondingAuthorFirstName;
    }

    /**
     * Gets the type of cta.
     *
     * @return the type of cta
     */
    public final String getTypeOfCta() {
        return typeOfCta;
    }

    /**
     * Sets the type of cta.
     *
     * @param typeOfCta
     *            the new type of cta
     */
    public final void setTypeOfCta(final String typeOfCta) {
        this.typeOfCta = typeOfCta;
    }

    /**
     * Gets the accepted dt.
     *
     * @return the accepted dt
     */
    public final String getAcceptedDt() {
        return acceptedDt;
    }

    /**
     * Sets the accepted dt.
     *
     * @param acceptedDt
     *            the new accepted dt
     */
    public final void setAcceptedDt(final String acceptedDt) {
        this.acceptedDt = acceptedDt;
    }

    /**
     * Gets the jrnl eissn.
     *
     * @return the jrnl eissn
     */
    public final String getJrnlEissn() {
        return jrnlEissn;
    }

    /**
     * Sets the jrnl eissn.
     *
     * @param jrnlEissn
     *            the new jrnl eissn
     */
    public final void setJrnlEissn(final String jrnlEissn) {
        this.jrnlEissn = jrnlEissn;
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
     * Gets the jrnl pissn.
     *
     * @return the jrnl pissn
     */
    public final String getJrnlPissn() {
        return jrnlPissn;
    }

    /**
     * Sets the jrnl pissn.
     *
     * @param jrnlPissn
     *            the new jrnl pissn
     */
    public final void setJrnlPissn(final String jrnlPissn) {
        this.jrnlPissn = jrnlPissn;
    }

    /**
     * Gets the corresponding author last name.
     *
     * @return the corresponding author last name
     */
    public final String getCorrespondingAuthorLastName() {
        return correspondingAuthorLastName;
    }

    /**
     * Sets the corresponding author last name.
     *
     * @param correspondingAuthorLastName
     *            the new corresponding author last name
     */
    public final void setCorrespondingAuthorLastName(
            final String correspondingAuthorLastName) {
        this.correspondingAuthorLastName = correspondingAuthorLastName;
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
     * Gets the co authors.
     *
     * @return the co authors
     */
    public final List<CoAuthorDetails> getCoAuthors() {
        return coAuthors;
    }

    /**
     * Sets the co authors.
     *
     * @param coAuthors
     *            the new co authors
     */
    public final void setCoAuthors(final List<CoAuthorDetails> coAuthors) {
        this.coAuthors = coAuthors;
    }

    /**
     * Gets the participate in wals.
     *
     * @return the participate in wals
     */
    public final String getParticipateInWALS() {
        return participateInWALS;
    }

    /**
     * Sets the participate in wals.
     *
     * @param participateInWALS
     *            the new participate in wals
     */
    public final void setParticipateInWALS(final String participateInWALS) {
        this.participateInWALS = participateInWALS;
    }

    /**
     * Gets the doi.
     *
     * @return the doi
     */
    public final String getDoi() {
        return doi;
    }

    /**
     * Sets the doi.
     *
     * @param doi
     *            the new doi
     */
    public final void setDoi(final String doi) {
        this.doi = doi;
    }

}
