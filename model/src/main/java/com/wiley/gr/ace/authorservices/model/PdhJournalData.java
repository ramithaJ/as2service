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
package com.wiley.gr.ace.authorservices.model;

import java.util.Date;
import java.util.List;

/**
 * The Class PdhJournalData.
 *
 * @author virtusa version 1.0
 */
public class PdhJournalData {

    /** The dh id. */
    private String dhId;

    /** The journal id. */
    private String journalId;

    /** The journal title. */
    private String journalTitle;

    /** The alternate title. */
    private String alternateTitle;

    /** The journal doi. */
    private String journalDoi;

    /** The wol code. */
    private String wolCode;

    /** The journal code. */
    private String journalCode;

    /** The e journal code. */
    private String eJournalCode;

    /** The jpcms internal id. */
    private String jpcmsInternalId;

    /** The jpcms id. */
    private String jpcmsId;

    /** The print issn. */
    private String printIssn;

    /** The electronic issn. */
    private String electronicIssn;

    /** The journal oid. */
    private String journalOid;

    /** The isbn. */
    private String isbn;

    /** The group code. */
    private String groupCode;

    /** The subcription type. */
    private String subcriptionType;

    /** The in jpcms. */
    private String inJpcms;

    /** The new office. */
    private String newOffice;

    /** The production office. */
    private String productionOffice;

    /** The publication group. */
    private String publicationGroup;

    /** The publication date. */
    private Date publicationDate;

    /** The online open status. */
    private String onlineOpenStatus;

    /** The publisher location. */
    private String publisherLocation;

    /** The isi impact factor. */
    private String isiImpactFactor;

    /** The subject code. */
    private List<String> subjectCode;

    /** The pub source code. */
    private String pubSourceCode;

    /** The print code. */
    private String printCode;

    /** The ownership status. */
    private String ownershipStatus;

    /** The journal status. */
    private String journalStatus;

    /** The cover image link. */
    private String coverImageLink;

    /** The banner image link. */
    private String bannerImageLink;

    /** The thumbnail link. */
    private String thumbnailLink;

    /** The product region. */
    private String productRegion;

    /** The product status. */
    private String productStatus;

    /** The product rss url. */
    private String productRssUrl;

    /** The product wol url. */
    private String productWolUrl;

    /** The prices. */
    private List<Prices> prices;

    /** The currency. */
    private String currency;

    /** The journal acronym. */
    private String journalAcronym;

    /**
     * Gets the prices.
     *
     * @return the prices
     */
    public final List<Prices> getPrices() {
        return prices;
    }

    /**
     * Sets the prices.
     *
     * @param prices
     *            the new prices
     */
    public final void setPrices(final List<Prices> prices) {
        this.prices = prices;
    }

    /**
     * Gets the journal status.
     *
     * @return the journal status
     */
    public final String getJournalStatus() {
        return journalStatus;
    }

    /**
     * Sets the journal status.
     *
     * @param journalStatus
     *            the new journal status
     */
    public final void setJournalStatus(final String journalStatus) {
        this.journalStatus = journalStatus;
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
    public final void setAlternateTitle(String alternateTitle) {
        this.alternateTitle = alternateTitle;
    }

    /**
     * Gets the publication date.
     *
     * @return the publication date
     */
    public final Date getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the publication date.
     *
     * @param publicationDate
     *            the new publication date
     */
    public final void setPublicationDate(final Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Gets the journal acronym.
     *
     * @return the journal acronym
     */
    public final String getJournalAcronym() {
        return journalAcronym;
    }

    /**
     * Sets the journal acronym.
     *
     * @param journalAcronym
     *            the new journal acronym
     */
    public final void setJournalAcronym(final String journalAcronym) {
        this.journalAcronym = journalAcronym;
    }

    /**
     * Gets the journal code.
     *
     * @return the journal code
     */
    public final String getJournalCode() {
        return journalCode;
    }

    /**
     * Sets the journal code.
     *
     * @param journalCode
     *            the new journal code
     */
    public final void setJournalCode(final String journalCode) {
        this.journalCode = journalCode;
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public final String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency
     *            the new currency
     */
    public final void setCurrency(final String currency) {
        this.currency = currency;
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
     * Gets the journal title.
     *
     * @return the journal title
     */
    public final String getJournalTitle() {
        return journalTitle;
    }

    /**
     * Sets the journal title.
     *
     * @param journalTitle
     *            the new journal title
     */
    public final void setJournalTitle(final String journalTitle) {
        this.journalTitle = journalTitle;
    }

    /**
     * Gets the journal doi.
     *
     * @return the journal doi
     */
    public final String getJournalDoi() {
        return journalDoi;
    }

    /**
     * Sets the journal doi.
     *
     * @param journalDoi
     *            the new journal doi
     */
    public final void setJournalDoi(final String journalDoi) {
        this.journalDoi = journalDoi;
    }

    /**
     * Gets the wol code.
     *
     * @return the wol code
     */
    public final String getWolCode() {
        return wolCode;
    }

    /**
     * Sets the wol code.
     *
     * @param wolCode
     *            the new wol code
     */
    public final void setWolCode(final String wolCode) {
        this.wolCode = wolCode;
    }

    /**
     * Gets the e journal code.
     *
     * @return the e journal code
     */
    public final String geteJournalCode() {
        return eJournalCode;
    }

    /**
     * Sets the e journal code.
     *
     * @param eJournalCode
     *            the new e journal code
     */
    public final void seteJournalCode(final String eJournalCode) {
        this.eJournalCode = eJournalCode;
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
     * Gets the prints the issn.
     *
     * @return the prints the issn
     */
    public final String getPrintIssn() {
        return printIssn;
    }

    /**
     * Sets the prints the issn.
     *
     * @param printIssn
     *            the new prints the issn
     */
    public final void setPrintIssn(final String printIssn) {
        this.printIssn = printIssn;
    }

    /**
     * Gets the electronic issn.
     *
     * @return the electronic issn
     */
    public final String getElectronicIssn() {
        return electronicIssn;
    }

    /**
     * Sets the electronic issn.
     *
     * @param electronicIssn
     *            the new electronic issn
     */
    public final void setElectronicIssn(final String electronicIssn) {
        this.electronicIssn = electronicIssn;
    }

    /**
     * Gets the journal oid.
     *
     * @return the journal oid
     */
    public final String getJournalOid() {
        return journalOid;
    }

    /**
     * Sets the journal oid.
     *
     * @param journalOid
     *            the new journal oid
     */
    public final void setJournalOid(final String journalOid) {
        this.journalOid = journalOid;
    }

    /**
     * Gets the isbn.
     *
     * @return the isbn
     */
    public final String getIsbn() {
        return isbn;
    }

    /**
     * Sets the isbn.
     *
     * @param isbn
     *            the new isbn
     */
    public final void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the group code.
     *
     * @return the group code
     */
    public final String getGroupCode() {
        return groupCode;
    }

    /**
     * Sets the group code.
     *
     * @param groupCode
     *            the new group code
     */
    public final void setGroupCode(final String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * Gets the subcription type.
     *
     * @return the subcription type
     */
    public final String getSubcriptionType() {
        return subcriptionType;
    }

    /**
     * Sets the subcription type.
     *
     * @param subcriptionType
     *            the new subcription type
     */
    public final void setSubcriptionType(final String subcriptionType) {
        this.subcriptionType = subcriptionType;
    }

    /**
     * Gets the in jpcms.
     *
     * @return the in jpcms
     */
    public final String getInJpcms() {
        return inJpcms;
    }

    /**
     * Sets the in jpcms.
     *
     * @param inJpcms
     *            the new in jpcms
     */
    public final void setInJpcms(final String inJpcms) {
        this.inJpcms = inJpcms;
    }

    /**
     * Gets the new office.
     *
     * @return the new office
     */
    public final String getNewOffice() {
        return newOffice;
    }

    /**
     * Sets the new office.
     *
     * @param newOffice
     *            the new new office
     */
    public final void setNewOffice(final String newOffice) {
        this.newOffice = newOffice;
    }

    /**
     * Gets the production office.
     *
     * @return the production office
     */
    public final String getProductionOffice() {
        return productionOffice;
    }

    /**
     * Sets the production office.
     *
     * @param productionOffice
     *            the new production office
     */
    public final void setProductionOffice(final String productionOffice) {
        this.productionOffice = productionOffice;
    }

    /**
     * Gets the publication group.
     *
     * @return the publication group
     */
    public final String getPublicationGroup() {
        return publicationGroup;
    }

    /**
     * Sets the publication group.
     *
     * @param publicationGroup
     *            the new publication group
     */
    public final void setPublicationGroup(final String publicationGroup) {
        this.publicationGroup = publicationGroup;
    }

    /**
     * Gets the online open status.
     *
     * @return the online open status
     */
    public final String getOnlineOpenStatus() {
        return onlineOpenStatus;
    }

    /**
     * Sets the online open status.
     *
     * @param onlineOpenStatus
     *            the new online open status
     */
    public final void setOnlineOpenStatus(final String onlineOpenStatus) {
        this.onlineOpenStatus = onlineOpenStatus;
    }

    /**
     * Gets the publisher location.
     *
     * @return the publisher location
     */
    public final String getPublisherLocation() {
        return publisherLocation;
    }

    /**
     * Sets the publisher location.
     *
     * @param publisherLocation
     *            the new publisher location
     */
    public final void setPublisherLocation(final String publisherLocation) {
        this.publisherLocation = publisherLocation;
    }

    /**
     * Gets the isi impact factor.
     *
     * @return the isi impact factor
     */
    public final String getIsiImpactFactor() {
        return isiImpactFactor;
    }

    /**
     * Sets the isi impact factor.
     *
     * @param isiImpactFactor
     *            the new isi impact factor
     */
    public final void setIsiImpactFactor(final String isiImpactFactor) {
        this.isiImpactFactor = isiImpactFactor;
    }

    /**
     * Gets the subject code.
     *
     * @return the subject code
     */
    public final List<String> getSubjectCode() {
        return subjectCode;
    }

    /**
     * Sets the subject code.
     *
     * @param subjectCode
     *            the new subject code
     */
    public final void setSubjectCode(final List<String> subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * Gets the pub source code.
     *
     * @return the pub source code
     */
    public final String getPubSourceCode() {
        return pubSourceCode;
    }

    /**
     * Sets the pub source code.
     *
     * @param pubSourceCode
     *            the new pub source code
     */
    public final void setPubSourceCode(final String pubSourceCode) {
        this.pubSourceCode = pubSourceCode;
    }

    /**
     * Gets the prints the code.
     *
     * @return the prints the code
     */
    public final String getPrintCode() {
        return printCode;
    }

    /**
     * Sets the prints the code.
     *
     * @param printCode
     *            the new prints the code
     */
    public final void setPrintCode(final String printCode) {
        this.printCode = printCode;
    }

    /**
     * Gets the ownership status.
     *
     * @return the ownership status
     */
    public final String getOwnershipStatus() {
        return ownershipStatus;
    }

    /**
     * Sets the ownership status.
     *
     * @param ownershipStatus
     *            the new ownership status
     */
    public final void setOwnershipStatus(final String ownershipStatus) {
        this.ownershipStatus = ownershipStatus;
    }

    /**
     * Gets the cover image link.
     *
     * @return the cover image link
     */
    public final String getCoverImageLink() {
        return coverImageLink;
    }

    /**
     * Sets the cover image link.
     *
     * @param coverImageLink
     *            the new cover image link
     */
    public final void setCoverImageLink(final String coverImageLink) {
        this.coverImageLink = coverImageLink;
    }

    /**
     * Gets the banner image link.
     *
     * @return the banner image link
     */
    public final String getBannerImageLink() {
        return bannerImageLink;
    }

    /**
     * Sets the banner image link.
     *
     * @param bannerImageLink
     *            the new banner image link
     */
    public final void setBannerImageLink(final String bannerImageLink) {
        this.bannerImageLink = bannerImageLink;
    }

    /**
     * Gets the thumbnail link.
     *
     * @return the thumbnail link
     */
    public final String getThumbnailLink() {
        return thumbnailLink;
    }

    /**
     * Sets the thumbnail link.
     *
     * @param thumbnailLink
     *            the new thumbnail link
     */
    public final void setThumbnailLink(final String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

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
     * Gets the product status.
     *
     * @return the product status
     */
    public final String getProductStatus() {
        return productStatus;
    }

    /**
     * Sets the product status.
     *
     * @param productStatus
     *            the new product status
     */
    public final void setProductStatus(final String productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * Gets the product rss url.
     *
     * @return the product rss url
     */
    public final String getProductRssUrl() {
        return productRssUrl;
    }

    /**
     * Sets the product rss url.
     *
     * @param productRssUrl
     *            the new product rss url
     */
    public final void setProductRssUrl(final String productRssUrl) {
        this.productRssUrl = productRssUrl;
    }

    /**
     * Gets the product wol url.
     *
     * @return the product wol url
     */
    public final String getProductWolUrl() {
        return productWolUrl;
    }

    /**
     * Sets the product wol url.
     *
     * @param productWolUrl
     *            the new product wol url
     */
    public final void setProductWolUrl(final String productWolUrl) {
        this.productWolUrl = productWolUrl;
    }

}
