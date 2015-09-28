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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class PdhLookupJournalResponse.
 *
 * @author virtusa version 1.0
 */
public class PdhLookupJournalResponse {

    /** The title. */
    @JsonProperty("title")
    private String title;

    /** The alternate title. */
    @JsonProperty("alternateTitle")
    private String alternateTitle;

    /** The print issn. */
    @JsonProperty("printISSN")
    private String printIssn;

    /** The electronic issn. */
    @JsonProperty("eISSN")
    private String electronicIssn;

    /** The isbn. */
    @JsonProperty("isbn")
    private String isbn;

    /** The jpcms id. */
    @JsonProperty("jpcmsID")
    private String jpcmsId;

    /** The acronym. */
    @JsonProperty("acronym")
    private String acronym;

    /** The family code. */
    @JsonProperty("familyCode")
    private String familyCode;

    /** The group code. */
    @JsonProperty("groupCode")
    private String groupCode;

    /** The print code. */
    @JsonProperty("printCode")
    private String printCode;

    /** The electronic code. */
    @JsonProperty("electronicCode")
    private String electronicCode;

    /** The wol code. */
    @JsonProperty("wolCode")
    private String wolCode;

    /** The status. */
    @JsonProperty("status")
    private String status;

    /** The journal doi. */
    @JsonProperty("doi")
    private String journalDoi;

    /** The pub source. */
    @JsonProperty("pubSource")
    private String pubSource;

    /** The journal type. */
    @JsonProperty("journalType")
    private String journalType;

    /** The product type. */
    @JsonProperty("productType")
    private String productType;

    /** The publication group. */
    @JsonProperty("publicationGroup")
    private String publicationGroup;

    /** The business unit. */
    @JsonProperty("businessUnit")
    private String businessUnit;

    /** The new div bu. */
    @JsonProperty("newDIV_BU")
    private String newDivBu;

    /** The production office. */
    @JsonProperty("productionOffice")
    private String productionOffice;

    /** The publishing entity. */
    @JsonProperty("publishingEntity")
    private String publishingEntity;

    /** The po contact name. */
    @JsonProperty("poContactName")
    private String poContactName;

    /** The po contact email. */
    @JsonProperty("poContactEmail")
    private String poContactEmail;

    /** The vendor book in associates. */
    @JsonProperty("vendorBookInAssociates")
    private String vendorBookInAssociates;

    /** The publisher location reference. */
    @JsonProperty("publisherLocationReference")
    private String publisherLocationReference;

    /** The new office. */
    @JsonProperty("newOffice")
    private String newOffice;

    /** The publication end date. */
    @JsonProperty("publicationEndDate")
    private String publicationEndDate;

    /** The society name. */
    @JsonProperty("societyName")
    private String societyName;

    /** The society acronym. */
    @JsonProperty("societyAcronym")
    private String societyAcronym;

    /** The eo contact. */
    @JsonProperty("eoContact")
    private String eoContact;

    /** The aeo contact. */
    @JsonProperty("aeoContact")
    private String aeoContact;

    /** The edited by. */
    @JsonProperty("editedBy")
    private String editedBy;

    /** The ownership status. */
    @JsonProperty("ownershipStatus")
    private String ownershipStatus;

    /** The subscription type. */
    @JsonProperty("subscriptionType")
    private String subscriptionType;

    /** The open access. */
    @JsonProperty("openAccess")
    private String openAccess;

    /** The online open. */
    @JsonProperty("onlineOpen")
    private String onlineOpen;

    /** The revenue model. */
    @JsonProperty("revenueModel")
    private String revenueModel;

    /** The primary subject code. */
    @JsonProperty("primarySubjectcode")
    private String primarySubjectCode;

    /** The primary subject code description. */
    @JsonProperty("primarySubjectCodeDescription")
    private String primarySubjectCodeDescription;

    /** The secondary subject code. */
    @JsonProperty("subjectCode2")
    private String secondarySubjectCode;

    /** The secondary subject description code. */
    @JsonProperty("subjectDescriptionCode2")
    private String secondarySubjectDescriptionCode;

    /** The impact factor. */
    @JsonProperty("impactFactor")
    private String impactFactor;

    /** The journal citation. */
    @JsonProperty("journalCitation")
    private String journalCitation;

    /** The rss feed. */
    @JsonProperty("rssFeed")
    private String rssFeed;

    /** The external sites. */
    @JsonProperty("externalSites")
    private String externalSites;

    /** The journal mearge id. */
    @JsonProperty("journalMeargeID")
    private String journalMeargeId;

    /** The first pub year. */
    @JsonProperty("firstPubYear")
    private String firstPubYear;

    /** The last pub year. */
    @JsonProperty("lastPubYear")
    private String lastPubYear;

    /** The embrago period. */
    @JsonProperty("embragoPeriod")
    private String embragoPeriod;

    /** The is journal in jpcms. */
    @JsonProperty("isJrInJPCMS")
    private String isJournalInJpcms;

    /** The is article in jpcms. */
    @JsonProperty("isArInJPCMS")
    private String isArticleInJpcms;

    /** The license signed. */
    @JsonProperty("licenseSigned")
    private String licenseSigned;

    /** The wals participation. */
    @JsonProperty("walsParticipation")
    private String walsParticipation;

    /** The wals participate start date. */
    @JsonProperty("walsParticipateStrDate")
    private String walsParticipateStartDate;

    /** The wals participate end date. */
    @JsonProperty("walsParticipateEndDate")
    private String walsParticipateEndDate;

    /** The wals process state. */
    @JsonProperty("walsProcessState")
    private String walsProcessState;

    /** The pubmed participation. */
    @JsonProperty("pubmedParticipation")
    private String pubmedParticipation;

    /** The pubmed central participation. */
    @JsonProperty("pubmedCentralParticipation")
    private String pubmedCentralParticipation;

    /** The base price. */
    @JsonProperty("basePrice")
    private List<BasePrice> basePrice;

    /** The cvr image. */
    @JsonProperty("cvrImage")
    private String cvrImage;

    /** The thumbnail. */
    @JsonProperty("thumbnail")
    private String thumbnail;

    /** The banner image. */
    @JsonProperty("bannerImage")
    private String bannerImage;

    /** The publisher contact. */
    @JsonProperty("publisherContact")
    private String publisherContact;

    /** The submission form. */
    @JsonProperty("submissionForm")
    private String submissionForm;

    /** The color charges. */
    @JsonProperty("colorCharges")
    private String colorCharges;

    /** The page charges. */
    @JsonProperty("pageCharges")
    private String pageCharges;

    /** The eeo url. */
    @JsonProperty("eeoURL")
    private String eeoUrl;

    /** The journal unique id. */
    @JsonProperty("journalUniqueId")
    private String journalUniqueId;

    /** The subscription license. */
    @JsonProperty("subscriptionLicense")
    private String subscriptionLicense;

    /** The non compliant license. */
    @JsonProperty("nonCompliantLicense")
    private String nonCompliantLicense;

    /** The formal title. */
    @JsonProperty("formalTitle")
    private String formalTitle;

    /** The overview. */
    @JsonProperty("overview")
    private String overview;

    /** The page charges quote. */
    @JsonProperty("pageChargesQuote")
    private String pageChargesQuote;

    /** The color charges quote. */
    @JsonProperty("colorChargesQuote")
    private String colorChargesQuote;

    /** The home page url. */
    @JsonProperty("homePageURL")
    private String homePageUrl;

    /** The suppres impact factor. */
    @JsonProperty("suppresImpactFactor")
    private String suppresImpactFactor;

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
     * Gets the acronym.
     *
     * @return the acronym
     */
    public final String getAcronym() {
        return acronym;
    }

    /**
     * Sets the acronym.
     *
     * @param acronym
     *            the new acronym
     */
    public final void setAcronym(final String acronym) {
        this.acronym = acronym;
    }

    /**
     * Gets the family code.
     *
     * @return the family code
     */
    public final String getFamilyCode() {
        return familyCode;
    }

    /**
     * Sets the family code.
     *
     * @param familyCode
     *            the new family code
     */
    public final void setFamilyCode(final String familyCode) {
        this.familyCode = familyCode;
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
     * Gets the electronic code.
     *
     * @return the electronic code
     */
    public final String getElectronicCode() {
        return electronicCode;
    }

    /**
     * Sets the electronic code.
     *
     * @param electronicCode
     *            the new electronic code
     */
    public final void setElectronicCode(final String electronicCode) {
        this.electronicCode = electronicCode;
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
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
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
     * Gets the pub source.
     *
     * @return the pub source
     */
    public final String getPubSource() {
        return pubSource;
    }

    /**
     * Sets the pub source.
     *
     * @param pubSource
     *            the new pub source
     */
    public final void setPubSource(final String pubSource) {
        this.pubSource = pubSource;
    }

    /**
     * Gets the journal type.
     *
     * @return the journal type
     */
    public final String getJournalType() {
        return journalType;
    }

    /**
     * Sets the journal type.
     *
     * @param journalType
     *            the new journal type
     */
    public final void setJournalType(final String journalType) {
        this.journalType = journalType;
    }

    /**
     * Gets the product type.
     *
     * @return the product type
     */
    public final String getProductType() {
        return productType;
    }

    /**
     * Sets the product type.
     *
     * @param productType
     *            the new product type
     */
    public final void setProductType(final String productType) {
        this.productType = productType;
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
     * Gets the business unit.
     *
     * @return the business unit
     */
    public final String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Sets the business unit.
     *
     * @param businessUnit
     *            the new business unit
     */
    public final void setBusinessUnit(final String businessUnit) {
        this.businessUnit = businessUnit;
    }

    /**
     * Gets the new div bu.
     *
     * @return the new div bu
     */
    public final String getNewDivBu() {
        return newDivBu;
    }

    /**
     * Sets the new div bu.
     *
     * @param newDivBu
     *            the new new div bu
     */
    public final void setNewDivBu(final String newDivBu) {
        this.newDivBu = newDivBu;
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
     * Gets the publishing entity.
     *
     * @return the publishing entity
     */
    public final String getPublishingEntity() {
        return publishingEntity;
    }

    /**
     * Sets the publishing entity.
     *
     * @param publishingEntity
     *            the new publishing entity
     */
    public final void setPublishingEntity(final String publishingEntity) {
        this.publishingEntity = publishingEntity;
    }

    /**
     * Gets the po contact name.
     *
     * @return the po contact name
     */
    public final String getPoContactName() {
        return poContactName;
    }

    /**
     * Sets the po contact name.
     *
     * @param poContactName
     *            the new po contact name
     */
    public final void setPoContactName(final String poContactName) {
        this.poContactName = poContactName;
    }

    /**
     * Gets the po contact email.
     *
     * @return the po contact email
     */
    public final String getPoContactEmail() {
        return poContactEmail;
    }

    /**
     * Sets the po contact email.
     *
     * @param poContactEmail
     *            the new po contact email
     */
    public final void setPoContactEmail(final String poContactEmail) {
        this.poContactEmail = poContactEmail;
    }

    /**
     * Gets the vendor book in associates.
     *
     * @return the vendor book in associates
     */
    public final String getVendorBookInAssociates() {
        return vendorBookInAssociates;
    }

    /**
     * Sets the vendor book in associates.
     *
     * @param vendorBookInAssociates
     *            the new vendor book in associates
     */
    public final void setVendorBookInAssociates(
            final String vendorBookInAssociates) {
        this.vendorBookInAssociates = vendorBookInAssociates;
    }

    /**
     * Gets the publisher location reference.
     *
     * @return the publisher location reference
     */
    public final String getPublisherLocationReference() {
        return publisherLocationReference;
    }

    /**
     * Sets the publisher location reference.
     *
     * @param publisherLocationReference
     *            the new publisher location reference
     */
    public final void setPublisherLocationReference(
            final String publisherLocationReference) {
        this.publisherLocationReference = publisherLocationReference;
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
     * Gets the publication end date.
     *
     * @return the publication end date
     */
    public final String getPublicationEndDate() {
        return publicationEndDate;
    }

    /**
     * Sets the publication end date.
     *
     * @param publicationEndDate
     *            the new publication end date
     */
    public final void setPublicationEndDate(final String publicationEndDate) {
        this.publicationEndDate = publicationEndDate;
    }

    /**
     * Gets the society name.
     *
     * @return the society name
     */
    public final String getSocietyName() {
        return societyName;
    }

    /**
     * Sets the society name.
     *
     * @param societyName
     *            the new society name
     */
    public final void setSocietyName(final String societyName) {
        this.societyName = societyName;
    }

    /**
     * Gets the society acronym.
     *
     * @return the society acronym
     */
    public final String getSocietyAcronym() {
        return societyAcronym;
    }

    /**
     * Sets the society acronym.
     *
     * @param societyAcronym
     *            the new society acronym
     */
    public final void setSocietyAcronym(final String societyAcronym) {
        this.societyAcronym = societyAcronym;
    }

    /**
     * Gets the eo contact.
     *
     * @return the eo contact
     */
    public final String getEoContact() {
        return eoContact;
    }

    /**
     * Sets the eo contact.
     *
     * @param eoContact
     *            the new eo contact
     */
    public final void setEoContact(final String eoContact) {
        this.eoContact = eoContact;
    }

    /**
     * Gets the aeo contact.
     *
     * @return the aeo contact
     */
    public final String getAeoContact() {
        return aeoContact;
    }

    /**
     * Sets the aeo contact.
     *
     * @param aeoContact
     *            the new aeo contact
     */
    public final void setAeoContact(final String aeoContact) {
        this.aeoContact = aeoContact;
    }

    /**
     * Gets the edited by.
     *
     * @return the edited by
     */
    public final String getEditedBy() {
        return editedBy;
    }

    /**
     * Sets the edited by.
     *
     * @param editedBy
     *            the new edited by
     */
    public final void setEditedBy(final String editedBy) {
        this.editedBy = editedBy;
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
     * Gets the subscription type.
     *
     * @return the subscription type
     */
    public final String getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * Sets the subscription type.
     *
     * @param subscriptionType
     *            the new subscription type
     */
    public final void setSubscriptionType(final String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    /**
     * Gets the open access.
     *
     * @return the open access
     */
    public final String getOpenAccess() {
        return openAccess;
    }

    /**
     * Sets the open access.
     *
     * @param openAccess
     *            the new open access
     */
    public final void setOpenAccess(final String openAccess) {
        this.openAccess = openAccess;
    }

    /**
     * Gets the online open.
     *
     * @return the online open
     */
    public final String getOnlineOpen() {
        return onlineOpen;
    }

    /**
     * Sets the online open.
     *
     * @param onlineOpen
     *            the new online open
     */
    public final void setOnlineOpen(final String onlineOpen) {
        this.onlineOpen = onlineOpen;
    }

    /**
     * Gets the revenue model.
     *
     * @return the revenue model
     */
    public final String getRevenueModel() {
        return revenueModel;
    }

    /**
     * Sets the revenue model.
     *
     * @param revenueModel
     *            the new revenue model
     */
    public final void setRevenueModel(final String revenueModel) {
        this.revenueModel = revenueModel;
    }

    /**
     * Gets the primary subject code.
     *
     * @return the primary subject code
     */
    public final String getPrimarySubjectCode() {
        return primarySubjectCode;
    }

    /**
     * Sets the primary subject code.
     *
     * @param primarySubjectCode
     *            the new primary subject code
     */
    public final void setPrimarySubjectCode(final String primarySubjectCode) {
        this.primarySubjectCode = primarySubjectCode;
    }

    /**
     * Gets the primary subject code description.
     *
     * @return the primary subject code description
     */
    public final String getPrimarySubjectCodeDescription() {
        return primarySubjectCodeDescription;
    }

    /**
     * Sets the primary subject code description.
     *
     * @param primarySubjectCodeDescription
     *            the new primary subject code description
     */
    public final void setPrimarySubjectCodeDescription(
            final String primarySubjectCodeDescription) {
        this.primarySubjectCodeDescription = primarySubjectCodeDescription;
    }

    /**
     * Gets the secondary subject code.
     *
     * @return the secondary subject code
     */
    public final String getSecondarySubjectCode() {
        return secondarySubjectCode;
    }

    /**
     * Sets the secondary subject code.
     *
     * @param secondarySubjectCode
     *            the new secondary subject code
     */
    public final void setSecondarySubjectCode(final String secondarySubjectCode) {
        this.secondarySubjectCode = secondarySubjectCode;
    }

    /**
     * Gets the secondary subject description code.
     *
     * @return the secondary subject description code
     */
    public final String getSecondarySubjectDescriptionCode() {
        return secondarySubjectDescriptionCode;
    }

    /**
     * Sets the secondary subject description code.
     *
     * @param secondarySubjectDescriptionCode
     *            the new secondary subject description code
     */
    public final void setSecondarySubjectDescriptionCode(
            final String secondarySubjectDescriptionCode) {
        this.secondarySubjectDescriptionCode = secondarySubjectDescriptionCode;
    }

    /**
     * Gets the impact factor.
     *
     * @return the impact factor
     */
    public final String getImpactFactor() {
        return impactFactor;
    }

    /**
     * Sets the impact factor.
     *
     * @param impactFactor
     *            the new impact factor
     */
    public final void setImpactFactor(final String impactFactor) {
        this.impactFactor = impactFactor;
    }

    /**
     * Gets the journal citation.
     *
     * @return the journal citation
     */
    public final String getJournalCitation() {
        return journalCitation;
    }

    /**
     * Sets the journal citation.
     *
     * @param journalCitation
     *            the new journal citation
     */
    public final void setJournalCitation(final String journalCitation) {
        this.journalCitation = journalCitation;
    }

    /**
     * Gets the rss feed.
     *
     * @return the rss feed
     */
    public final String getRssFeed() {
        return rssFeed;
    }

    /**
     * Sets the rss feed.
     *
     * @param rssFeed
     *            the new rss feed
     */
    public final void setRssFeed(final String rssFeed) {
        this.rssFeed = rssFeed;
    }

    /**
     * Gets the external sites.
     *
     * @return the external sites
     */
    public final String getExternalSites() {
        return externalSites;
    }

    /**
     * Sets the external sites.
     *
     * @param externalSites
     *            the new external sites
     */
    public final void setExternalSites(final String externalSites) {
        this.externalSites = externalSites;
    }

    /**
     * Gets the journal mearge id.
     *
     * @return the journal mearge id
     */
    public final String getJournalMeargeId() {
        return journalMeargeId;
    }

    /**
     * Sets the journal mearge id.
     *
     * @param journalMeargeId
     *            the new journal mearge id
     */
    public final void setJournalMeargeId(final String journalMeargeId) {
        this.journalMeargeId = journalMeargeId;
    }

    /**
     * Gets the first pub year.
     *
     * @return the first pub year
     */
    public final String getFirstPubYear() {
        return firstPubYear;
    }

    /**
     * Sets the first pub year.
     *
     * @param firstPubYear
     *            the new first pub year
     */
    public final void setFirstPubYear(final String firstPubYear) {
        this.firstPubYear = firstPubYear;
    }

    /**
     * Gets the last pub year.
     *
     * @return the last pub year
     */
    public final String getLastPubYear() {
        return lastPubYear;
    }

    /**
     * Sets the last pub year.
     *
     * @param lastPubYear
     *            the new last pub year
     */
    public final void setLastPubYear(final String lastPubYear) {
        this.lastPubYear = lastPubYear;
    }

    /**
     * Gets the embrago period.
     *
     * @return the embrago period
     */
    public final String getEmbragoPeriod() {
        return embragoPeriod;
    }

    /**
     * Sets the embrago period.
     *
     * @param embragoPeriod
     *            the new embrago period
     */
    public final void setEmbragoPeriod(final String embragoPeriod) {
        this.embragoPeriod = embragoPeriod;
    }

    /**
     * Gets the checks if is journal in jpcms.
     *
     * @return the checks if is journal in jpcms
     */
    public final String getIsJournalInJpcms() {
        return isJournalInJpcms;
    }

    /**
     * Sets the checks if is journal in jpcms.
     *
     * @param isJournalInJpcms
     *            the new checks if is journal in jpcms
     */
    public final void setIsJournalInJpcms(final String isJournalInJpcms) {
        this.isJournalInJpcms = isJournalInJpcms;
    }

    /**
     * Gets the checks if is article in jpcms.
     *
     * @return the checks if is article in jpcms
     */
    public final String getIsArticleInJpcms() {
        return isArticleInJpcms;
    }

    /**
     * Sets the checks if is article in jpcms.
     *
     * @param isArticleInJpcms
     *            the new checks if is article in jpcms
     */
    public final void setIsArticleInJpcms(final String isArticleInJpcms) {
        this.isArticleInJpcms = isArticleInJpcms;
    }

    /**
     * Gets the license signed.
     *
     * @return the license signed
     */
    public final String getLicenseSigned() {
        return licenseSigned;
    }

    /**
     * Sets the license signed.
     *
     * @param licenseSigned
     *            the new license signed
     */
    public final void setLicenseSigned(final String licenseSigned) {
        this.licenseSigned = licenseSigned;
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
     * Gets the wals participate start date.
     *
     * @return the wals participate start date
     */
    public final String getWalsParticipateStartDate() {
        return walsParticipateStartDate;
    }

    /**
     * Sets the wals participate start date.
     *
     * @param walsParticipateStartDate
     *            the new wals participate start date
     */
    public final void setWalsParticipateStartDate(
            final String walsParticipateStartDate) {
        this.walsParticipateStartDate = walsParticipateStartDate;
    }

    /**
     * Gets the wals participate end date.
     *
     * @return the wals participate end date
     */
    public final String getWalsParticipateEndDate() {
        return walsParticipateEndDate;
    }

    /**
     * Sets the wals participate end date.
     *
     * @param walsParticipateEndDate
     *            the new wals participate end date
     */
    public final void setWalsParticipateEndDate(
            final String walsParticipateEndDate) {
        this.walsParticipateEndDate = walsParticipateEndDate;
    }

    /**
     * Gets the wals process state.
     *
     * @return the wals process state
     */
    public final String getWalsProcessState() {
        return walsProcessState;
    }

    /**
     * Sets the wals process state.
     *
     * @param walsProcessState
     *            the new wals process state
     */
    public final void setWalsProcessState(final String walsProcessState) {
        this.walsProcessState = walsProcessState;
    }

    /**
     * Gets the pubmed participation.
     *
     * @return the pubmed participation
     */
    public final String getPubmedParticipation() {
        return pubmedParticipation;
    }

    /**
     * Sets the pubmed participation.
     *
     * @param pubmedParticipation
     *            the new pubmed participation
     */
    public final void setPubmedParticipation(final String pubmedParticipation) {
        this.pubmedParticipation = pubmedParticipation;
    }

    /**
     * Gets the pubmed central participation.
     *
     * @return the pubmed central participation
     */
    public final String getPubmedCentralParticipation() {
        return pubmedCentralParticipation;
    }

    /**
     * Sets the pubmed central participation.
     *
     * @param pubmedCentralParticipation
     *            the new pubmed central participation
     */
    public final void setPubmedCentralParticipation(
            final String pubmedCentralParticipation) {
        this.pubmedCentralParticipation = pubmedCentralParticipation;
    }

    /**
     * Gets the base price.
     *
     * @return the base price
     */
    public final List<BasePrice> getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price.
     *
     * @param basePrice
     *            the new base price
     */
    public final void setBasePrice(final List<BasePrice> basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets the cvr image.
     *
     * @return the cvr image
     */
    public final String getCvrImage() {
        return cvrImage;
    }

    /**
     * Sets the cvr image.
     *
     * @param cvrImage
     *            the new cvr image
     */
    public final void setCvrImage(final String cvrImage) {
        this.cvrImage = cvrImage;
    }

    /**
     * Gets the thumbnail.
     *
     * @return the thumbnail
     */
    public final String getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the thumbnail.
     *
     * @param thumbnail
     *            the new thumbnail
     */
    public final void setThumbnail(final String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Gets the banner image.
     *
     * @return the banner image
     */
    public final String getBannerImage() {
        return bannerImage;
    }

    /**
     * Sets the banner image.
     *
     * @param bannerImage
     *            the new banner image
     */
    public final void setBannerImage(final String bannerImage) {
        this.bannerImage = bannerImage;
    }

    /**
     * Gets the publisher contact.
     *
     * @return the publisher contact
     */
    public final String getPublisherContact() {
        return publisherContact;
    }

    /**
     * Sets the publisher contact.
     *
     * @param publisherContact
     *            the new publisher contact
     */
    public final void setPublisherContact(final String publisherContact) {
        this.publisherContact = publisherContact;
    }

    /**
     * Gets the submission form.
     *
     * @return the submission form
     */
    public final String getSubmissionForm() {
        return submissionForm;
    }

    /**
     * Sets the submission form.
     *
     * @param submissionForm
     *            the new submission form
     */
    public final void setSubmissionForm(final String submissionForm) {
        this.submissionForm = submissionForm;
    }

    /**
     * Gets the color charges.
     *
     * @return the color charges
     */
    public final String getColorCharges() {
        return colorCharges;
    }

    /**
     * Sets the color charges.
     *
     * @param colorCharges
     *            the new color charges
     */
    public final void setColorCharges(final String colorCharges) {
        this.colorCharges = colorCharges;
    }

    /**
     * Gets the page charges.
     *
     * @return the page charges
     */
    public final String getPageCharges() {
        return pageCharges;
    }

    /**
     * Sets the page charges.
     *
     * @param pageCharges
     *            the new page charges
     */
    public final void setPageCharges(final String pageCharges) {
        this.pageCharges = pageCharges;
    }

    /**
     * Gets the eeo url.
     *
     * @return the eeo url
     */
    public final String getEeoUrl() {
        return eeoUrl;
    }

    /**
     * Sets the eeo url.
     *
     * @param eeoUrl
     *            the new eeo url
     */
    public final void setEeoUrl(final String eeoUrl) {
        this.eeoUrl = eeoUrl;
    }

    /**
     * Gets the journal unique id.
     *
     * @return the journal unique id
     */
    public final String getJournalUniqueId() {
        return journalUniqueId;
    }

    /**
     * Sets the journal unique id.
     *
     * @param journalUniqueId
     *            the new journal unique id
     */
    public final void setJournalUniqueId(final String journalUniqueId) {
        this.journalUniqueId = journalUniqueId;
    }

    /**
     * Gets the subscription license.
     *
     * @return the subscription license
     */
    public final String getSubscriptionLicense() {
        return subscriptionLicense;
    }

    /**
     * Sets the subscription license.
     *
     * @param subscriptionLicense
     *            the new subscription license
     */
    public final void setSubscriptionLicense(final String subscriptionLicense) {
        this.subscriptionLicense = subscriptionLicense;
    }

    /**
     * Gets the non compliant license.
     *
     * @return the non compliant license
     */
    public final String getNonCompliantLicense() {
        return nonCompliantLicense;
    }

    /**
     * Sets the non compliant license.
     *
     * @param nonCompliantLicense
     *            the new non compliant license
     */
    public final void setNonCompliantLicense(final String nonCompliantLicense) {
        this.nonCompliantLicense = nonCompliantLicense;
    }

    /**
     * Gets the formal title.
     *
     * @return the formal title
     */
    public final String getFormalTitle() {
        return formalTitle;
    }

    /**
     * Sets the formal title.
     *
     * @param formalTitle
     *            the new formal title
     */
    public final void setFormalTitle(final String formalTitle) {
        this.formalTitle = formalTitle;
    }

    /**
     * Gets the overview.
     *
     * @return the overview
     */
    public final String getOverview() {
        return overview;
    }

    /**
     * Sets the overview.
     *
     * @param overview
     *            the new overview
     */
    public final void setOverview(final String overview) {
        this.overview = overview;
    }

    /**
     * Gets the page charges quote.
     *
     * @return the page charges quote
     */
    public final String getPageChargesQuote() {
        return pageChargesQuote;
    }

    /**
     * Sets the page charges quote.
     *
     * @param pageChargesQuote
     *            the new page charges quote
     */
    public final void setPageChargesQuote(final String pageChargesQuote) {
        this.pageChargesQuote = pageChargesQuote;
    }

    /**
     * Gets the color charges quote.
     *
     * @return the color charges quote
     */
    public final String getColorChargesQuote() {
        return colorChargesQuote;
    }

    /**
     * Sets the color charges quote.
     *
     * @param colorChargesQuote
     *            the new color charges quote
     */
    public final void setColorChargesQuote(final String colorChargesQuote) {
        this.colorChargesQuote = colorChargesQuote;
    }

    /**
     * Gets the home page url.
     *
     * @return the home page url
     */
    public final String getHomePageUrl() {
        return homePageUrl;
    }

    /**
     * Sets the home page url.
     *
     * @param homePageUrl
     *            the new home page url
     */
    public final void setHomePageUrl(final String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    /**
     * Gets the suppres impact factor.
     *
     * @return the suppres impact factor
     */
    public final String getSuppresImpactFactor() {
        return suppresImpactFactor;
    }

    /**
     * Sets the suppres impact factor.
     *
     * @param suppresImpactFactor
     *            the new suppres impact factor
     */
    public final void setSuppresImpactFactor(final String suppresImpactFactor) {
        this.suppresImpactFactor = suppresImpactFactor;
    }

}
