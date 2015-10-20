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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.ArticleInfo;
import com.wiley.gr.ace.authorservices.model.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.LicenseDetails;
import com.wiley.gr.ace.authorservices.model.PdhArticleData;
import com.wiley.gr.ace.authorservices.model.PdhJournalData;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.TrackLicense;
import com.wiley.gr.ace.authorservices.model.ViewAssignedArticle;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;
import com.wiley.gr.ace.authorservices.services.service.LicenseService;

/**
 * The Class ArticleAssignmentServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class ArticleAssignmentServiceImpl implements ArticleAssignmentService {

    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ArticleAssignmentServiceImpl.class);

    /** The esb interface service. */
    @Autowired(required = true)
    private ESBInterfaceService esbInterfaceService;

    /** The Shared service. */
    @Autowired(required = true)
    private TaskService bpmInterfaceService;

    /** The license service. */
    @Autowired(required = true)
    private LicenseService licenseService;

    /**
     * this method will take emailId as in input and call external service (ESb)
     * to get article info.
     *
     * @param emailId
     *            the email id
     * @return the article info
     */
    @Override
    public final ArticleInfoDetails getArticleInfoDetails(final String emailId) {
        LOGGER.info("inside getArticleInfo method of ArticleAssignmentServiceImpl");

        List<ArticleInfo> articleInfoList = new ArrayList<ArticleInfo>();

        ArticleInfoDetails articleInfoDetails = new ArticleInfoDetails();
        articleInfoDetails.setArticleInfo(articleInfoList);
        return articleInfoDetails;
    }

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     */
    @Override
    public final boolean associationConfirmation(
            final AssociationConfirmation associationConfirmation) {
        LOGGER.info("inside associationConfirmation method of ArticleAssignmentServiceImpl");
        return bpmInterfaceService.finishTask(associationConfirmation);
    }

    /**
     * View assigned article.
     *
     * @param articleId
     *            the article id
     * @return the view assigned article
     */
    @Override
    public final ViewAssignedArticle viewAssignedArticle(final String articleId) {
        LOGGER.info("inside viewAssignedArticle method of ArticleAssignmentServiceImpl");
        final ViewAssignedArticle viewAssignedArticle = new ViewAssignedArticle();
        final PdhArticleData pdhArticleData = (PdhArticleData) esbInterfaceService
                .getPdhLookupResponse(articleId);
        if (!StringUtils.isEmpty(pdhArticleData)) {
            viewAssignedArticle
                    .setArticleData(parseFullArticleDetails(pdhArticleData));
            viewAssignedArticle.setJournalData(getJournalDetails(pdhArticleData
                    .getJournalDhId()));
            viewAssignedArticle.setPublicationData(getPublicationData());
            viewAssignedArticle.setLicenseDetails(getLicenseData(pdhArticleData
                    .getDhId()));
        }

        return viewAssignedArticle;

    }

    /**
     * Gets the journal details.
     *
     * @param journalDhId
     *            the journal dh id
     * @return the journal details
     * @throws UserException
     *             the user exception
     */
    private JournalDetails getJournalDetails(final String journalDhId)
            throws UserException {
        PdhJournalData pdhJournalData = (PdhJournalData) esbInterfaceService
                .getPdhLookupResponse(journalDhId);
        JournalDetails journalData = new JournalDetails();
        journalData.setJournalId(pdhJournalData.getJournalId());
        journalData.setJournalTitle(pdhJournalData.getJournalTitle());
        journalData.setJournalDoi(pdhJournalData.getJournalDoi());
        journalData.setJournalPrintIssn(pdhJournalData.getPrintIssn());
        journalData
                .setJournalElectronicIssn(pdhJournalData.getElectronicIssn());
        journalData.setBannerImageLink(pdhJournalData.getBannerImageLink());
        journalData.setCoverImageLink(pdhJournalData.getCoverImageLink());
        return journalData;
    }

    /**
     * Parses the full article details.
     *
     * @param pdhArticleData
     *            the pdh article data
     * @return the article details
     * @throws UserException
     *             the user exception
     */
    private ArticleDetails parseFullArticleDetails(
            final PdhArticleData pdhArticleData) throws UserException {
        ArticleDetails articleDetails = new ArticleDetails();
        articleDetails.setArticleId(pdhArticleData.getArticleId());
        articleDetails.setArticleTitle(pdhArticleData.getTitle());
        articleDetails.setArticleDOI(pdhArticleData.getArticleDoi());
        articleDetails.setAcceptanceDate(pdhArticleData.getAcceptedDate()
                .toString());
        articleDetails.setArticleAuthorName(pdhArticleData.getAuthorName());
        articleDetails.setCorrespondingAuthorEmail(pdhArticleData
                .getAuthorEmail());
        articleDetails.setArticleCoAuthors(pdhArticleData.getCoAuthors());
        articleDetails.setIssueNum(pdhArticleData.getIssue());
        articleDetails.setVolumeNum(pdhArticleData.getVolume());
        articleDetails.setEditorialRefCd(pdhArticleData.getEditorialRefCode());
        articleDetails.setJpcmsInternalId(pdhArticleData.getJpcmsId());
        return articleDetails;
    }

    /**
     * Gets the publication data.
     *
     * @return the publication data
     */
    private PublicationDetails getPublicationData() {
        PublicationDetails publicationDetails = new PublicationDetails();
        publicationDetails.setModifiedDate(new String());
        publicationDetails.setPublicationStatus(new String());
        publicationDetails.setPublicationPath(new String());
        return publicationDetails;
    }

    /**
     * Gets the license data.
     *
     * @param dhId
     *            the dh id
     * @return the license data
     * @throws UserException
     *             the user exception
     */
    private LicenseDetails getLicenseData(final String dhId)
            throws UserException {
        LicenseDetails licenseDetails = null;
        TrackLicense trackLicense;
        try {
            trackLicense = licenseService.trackLicenseStatus(dhId, dhId);
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
        }
        if (!StringUtils.isEmpty(trackLicense)) {
            licenseDetails = new LicenseDetails();
            licenseDetails.setLicenseStatus(trackLicense.getLicenseStatus());
            licenseDetails.setLicenseSignedDate(trackLicense.getLicenseDate());
        }
        return licenseDetails;
    }

    /**
     * Check if article invited.
     *
     * @param dhId
     *            the dh id
     * @return true, if successful
     */
    @Override
    public final boolean checkIfArticleInvited(final String dhId) {
        LOGGER.info("inside checkIfArticleInvited method of ArticleAssignmentServiceImpl");
        final PdhArticleData pdhArticleData = (PdhArticleData) esbInterfaceService
                .getPdhLookupResponse(dhId);
        boolean isArticleInvited = false;
        if (AuthorServicesConstants.AS_ALM_TNC_FLAG
                .equalsIgnoreCase(pdhArticleData.getIsInvitedInAs())) {
            isArticleInvited = true;
        }
        return isArticleInvited;
    }

}
