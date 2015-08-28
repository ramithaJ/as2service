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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.ArticleLinks;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.LicenseDetails;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.TrackLicense;
import com.wiley.gr.ace.authorservices.model.ViewAssignedArticle;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.ArticlePdfResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournalResponse;
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

    /** The article wol url. */
    @Value("${articleWol.url}")
    private String articleWolUrl;

    /**
     * this method will take emailId as in input and call external service (ESb)
     * to get article info.
     *
     * @param emailId
     *            the email id
     * @return the article info
     * @throws Exception
     *             the exception
     */
    @Override
    public final ArticleInfoDetails getArticleInfo(final String emailId)
            throws Exception {
        LOGGER.info("inside getArticleInfo method of ArticleAssignmentServiceImpl");
        return esbInterfaceService.getArticleInfo(emailId);
    }

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean associationConfirmation(
            final AssociationConfirmation associationConfirmation)
            throws Exception {
        LOGGER.info("inside associationConfirmation method of ArticleAssignmentServiceImpl");
        return bpmInterfaceService.finishTask(associationConfirmation);
    }

    /**
     * View assigned article.
     *
     * @param articleId
     *            the article id
     * @return the view assigned article
     * @throws Exception
     *             the exception
     */
    @Override
    public final ViewAssignedArticle viewAssignedArticle(final String articleId)
            throws Exception {
        LOGGER.info("inside viewAssignedArticle method of ArticleAssignmentServiceImpl");
        final ViewAssignedArticle viewAssignedArticle = new ViewAssignedArticle();
        final PdhLookupArticleResponse pdhLookupArticleResponse = esbInterfaceService
                .viewAssignedArticle(articleId);
        if (!StringUtils.isEmpty(pdhLookupArticleResponse)) {
            viewAssignedArticle
                    .setArticleData(getArticleData(pdhLookupArticleResponse));
            viewAssignedArticle
                    .setJournalData(getJournalData(pdhLookupArticleResponse));
            viewAssignedArticle
                    .setPublicationData(getPublicationData(pdhLookupArticleResponse));
            viewAssignedArticle
                    .setArticleLinks(checkArticleOOorOa(pdhLookupArticleResponse));
            viewAssignedArticle
                    .setLicenseDetails(getLicenseData(pdhLookupArticleResponse));
        }

        return viewAssignedArticle;

    }

    /**
     * Gets the article data.
     *
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @return the article data
     */
    private ArticleDetails getArticleData(
            final PdhLookupArticleResponse pdhLookupArticleResponse) {
        ArticleDetails articleDetails = null;

        articleDetails = new ArticleDetails();
        articleDetails.setArticleId(pdhLookupArticleResponse
                .getArticleUniqueID());
        articleDetails.setArticleTitle(pdhLookupArticleResponse.getTitle());
        articleDetails.setArticleAuthors(pdhLookupArticleResponse
                .getAuthorName());
        articleDetails
                .setArticleCoAuthors(parseCoAuthors(pdhLookupArticleResponse));
        articleDetails.setCorrespondingAuthorEmail(pdhLookupArticleResponse
                .getAuthorEmail());
        articleDetails.setArticleDOI(pdhLookupArticleResponse.getArticleDoi());
        articleDetails.setAcceptanceDate(pdhLookupArticleResponse
                .getAcceptedDate());
        articleDetails.setIssueNum(pdhLookupArticleResponse.getIssueNumber());
        articleDetails.setVolumeNum(pdhLookupArticleResponse.getVolumeNumber());
        articleDetails.setEditorialRefCd(pdhLookupArticleResponse
                .getEditorialRefCode());
        articleDetails
                .setJpcmsInternalId(pdhLookupArticleResponse.getJpcmsId());
        articleDetails.setPublicationDate(pdhLookupArticleResponse
                .getPublicationYear());
        return articleDetails;
    }

    /**
     * Parses the co authors.
     *
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @return the list
     */
    private List<String> parseCoAuthors(
            final PdhLookupArticleResponse pdhLookupArticleResponse) {
        final List<String> coAuthors = new ArrayList<String>();
        coAuthors.add(pdhLookupArticleResponse.getCoAuthorName());
        return coAuthors;
    }

    /**
     * Gets the journal data.
     *
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @return the journal data
     * @throws Exception
     *             the exception
     */
    private JournalDetails getJournalData(
            final PdhLookupArticleResponse pdhLookupArticleResponse)
            throws Exception {
        final PdhLookupJournalResponse pdhLookupJournalResponse = esbInterfaceService
                .getPdhLookupJournalResponse(pdhLookupArticleResponse
                        .getJournalUniqueID());
        JournalDetails journalDetails = null;
        if (!StringUtils.isEmpty(pdhLookupJournalResponse)) {
            journalDetails = new JournalDetails();
            journalDetails.setJournalId(pdhLookupArticleResponse
                    .getJournalUniqueID());
            journalDetails.setJournalTitle(pdhLookupJournalResponse.getTitle());
            journalDetails.setJournalDoi(pdhLookupJournalResponse
                    .getJournalDoi());
            journalDetails.setJournalPrintIssn(pdhLookupJournalResponse
                    .getPrintIssn());
            journalDetails.setJournalElectronicIssn(pdhLookupJournalResponse
                    .getElectronicIssn());
            journalDetails.setJournalImageLink(pdhLookupJournalResponse
                    .getBannerImage());
        }
        return journalDetails;
    }

    /**
     * Gets the publication data.
     *
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @return the publication data
     */
    private PublicationDetails getPublicationData(
            final PdhLookupArticleResponse pdhLookupArticleResponse) {
        final PublicationDetails publicationDetails = new PublicationDetails();
        publicationDetails.setModifiedDate(pdhLookupArticleResponse
                .getPublicationYear());
        publicationDetails.setPublicationStatus("Make OO");
        publicationDetails.setPublicationPath("From AS 2.0");
        return publicationDetails;
    }

    /**
     * Check article o oor oa.
     *
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @return the article links
     * @throws Exception
     *             the exception
     */
    private ArticleLinks checkArticleOOorOa(
            final PdhLookupArticleResponse pdhLookupArticleResponse)
            throws Exception {
        final ArticleLinks articleLinks = new ArticleLinks();
        if ("Y".equals(pdhLookupArticleResponse.getIsArticleOO())) {
            final ArticlePdfResponse articlePdfResponse = esbInterfaceService
                    .getArticlePdfResponse(pdhLookupArticleResponse
                            .getArticleDoi());
            if (!StringUtils.isEmpty(articlePdfResponse)) {
                articleLinks.setOrderId("232");
                articleLinks.setArticlePdfUrl(articlePdfResponse
                        .getGetPdfResponse().getPdfUrl());
            }
        } else {
            articleLinks.setArticleWolUrl(articleWolUrl
                    + pdhLookupArticleResponse.getArticleDoi() + "/full");

        }
        return articleLinks;
    }

    /**
     * Gets the license data.
     *
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @return the license data
     * @throws Exception
     *             the exception
     */
    private LicenseDetails getLicenseData(
            final PdhLookupArticleResponse pdhLookupArticleResponse)
            throws Exception {
        LicenseDetails licenseDetails = null;
        final TrackLicense trackLicense = licenseService.trackLicenseStatus(
                pdhLookupArticleResponse.getArticleUniqueID(),
                pdhLookupArticleResponse.getaId());
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
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean checkIfArticleInvited(final String dhId)
            throws Exception {
        LOGGER.info("inside checkIfArticleInvited method of ArticleAssignmentServiceImpl");
        boolean isArticleInvited = false;
        if ("Y".equalsIgnoreCase(esbInterfaceService.viewAssignedArticle(dhId)
                .getInvitedInAs())) {
            isArticleInvited = true;
        }
        return isArticleInvited;
    }

}
