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

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.LicenseDetails;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.ViewAssignedArticle;
import com.wiley.gr.ace.authorservices.model.external.Art;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.CoAuthorDetails;
import com.wiley.gr.ace.authorservices.model.external.GetArticleDetails;
import com.wiley.gr.ace.authorservices.model.external.LastSignedLicense;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

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

    /** The order service. */
    @Autowired(required = true)
    private OrderService orderService;

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
     * @param emailId
     *            the email id
     * @return the view assigned article
     * @throws Exception
     *             the exception
     */
    @Override
    public final ViewAssignedArticle viewAssignedArticle(final String emailId)
            throws Exception {
        LOGGER.info("inside viewAssignedArticle method of ArticleAssignmentServiceImpl");
        final ViewAssignedArticle viewAssignedArticle = new ViewAssignedArticle();
        final GetArticleDetails getArticleDetails = esbInterfaceService
                .viewAssignedArticle(emailId);
        if (!StringUtils.isEmpty(getArticleDetails)) {
            viewAssignedArticle
                    .setArticleData(getArticleData(getArticleDetails));
            viewAssignedArticle
                    .setJournalData(getJournalData(getArticleDetails));
            viewAssignedArticle
                    .setPublicationData(getPublicationData(getArticleDetails));
            viewAssignedArticle.setOrderData(getOrderId());
            viewAssignedArticle
                    .setLicenseData(getLicenseData(getArticleDetails));
        }

        return viewAssignedArticle;

    }

    /**
     * Gets the article data.
     *
     * @param getArticleDetails
     *            the get article details
     * @return the article data
     */
    private final ArticleDetails getArticleData(
            final GetArticleDetails getArticleDetails) {
        ArticleDetails articleDetails = null;
        final Art art = getArticleDetails.getArt();
        if (!StringUtils.isEmpty(art)) {
            articleDetails = new ArticleDetails();
            articleDetails.setArticleId(art.getAid());
            articleDetails.setArticleTitle(art.getTitle());
            final String authorName = art.getCorrespondingAuthorFirstName()
                    + art.getCorrespondingAuthorLastName();
            articleDetails.setArticleAuthorName(authorName);
            articleDetails.setArticleCoAuthors(parseCoAuthors(art));
            articleDetails.setEmail(art.getCorrespondingAuthorEmail());
            articleDetails.setArticleDoi(art.getDoi());
            articleDetails.setAcceptanceDate(art.getAcceptedDt());
            articleDetails.setIssue(art.getIssNum());
            articleDetails.setVolume(art.getVolNum());
            articleDetails.setEditorialRefCode(art.getEdRefCode());
            articleDetails.setJpcmsInternalId(art.getJpcmsInternalId());
            articleDetails.setPublicationDate(art.getPubYear());
        }
        return articleDetails;
    }

    /**
     * Parses the co authors.
     *
     * @param art
     *            the art
     * @return the list
     */
    private final List<String> parseCoAuthors(final Art art) {
        final List<CoAuthorDetails> coAuthorsList = art.getCoAuthors();
        final List<String> coAuthors = new ArrayList<String>();
        if (!StringUtils.isEmpty(coAuthorsList)) {
            for (final CoAuthorDetails coAuthorDetails : coAuthorsList) {
                final String coAuthorName = coAuthorDetails
                        .getCoAuthorFirstName()
                        + coAuthorDetails.getCoAuthorLastName();
                coAuthors.add(coAuthorName);
            }
        }
        return coAuthors;
    }

    /**
     * Gets the journal data.
     *
     * @param getArticleDetails
     *            the get article details
     * @return the journal data
     */
    private final JournalDetails getJournalData(
            final GetArticleDetails getArticleDetails) {
        final Art art = getArticleDetails.getArt();
        JournalDetails journalDetails = null;
        if (!StringUtils.isEmpty(art)) {
            journalDetails = new JournalDetails();
            journalDetails.setJournalId(art.getJrnlId());
            journalDetails.setJournalTitle(art.getJrnlTitle());
            journalDetails.setJournalDoi(art.getJrnlDoi());
            journalDetails.setJournalPrintIssn(art.getJrnlPissn());
            journalDetails.setJournalElectronicIssn(art.getJrnlEissn());
        }
        return journalDetails;
    }

    /**
     * Gets the publication data.
     *
     * @param getArticleDetails
     *            the get article details
     * @return the publication data
     */
    private final PublicationDetails getPublicationData(
            final GetArticleDetails getArticleDetails) {
        final Art art = getArticleDetails.getArt();
        PublicationDetails publicationDetails = null;
        if (!StringUtils.isEmpty(art)) {
            publicationDetails = new PublicationDetails();
            publicationDetails.setModifiedDate(art.getPubYear());
            publicationDetails.setPublicationStatus("Make OO");
            publicationDetails.setPublicationPath("From AS 2.0");
        }
        return publicationDetails;
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    private final OrderDetails getOrderId() {
        final OrderDetails orderData = new OrderDetails();
        orderData.setOrderId("11232");
        return orderData;
    }

    /**
     * Gets the license data.
     *
     * @param getArticleDetails
     *            the get article details
     * @return the license data
     */
    private final LicenseDetails getLicenseData(
            final GetArticleDetails getArticleDetails) {
        final LastSignedLicense lastSignedLicense = getArticleDetails
                .getLastSignedLicense();
        LicenseDetails licenseDetails = null;
        if (!StringUtils.isEmpty(lastSignedLicense)) {
            licenseDetails = new LicenseDetails();
            licenseDetails.setLicenseSignedDate(lastSignedLicense
                    .getLicenseSignDate());
            licenseDetails.setLicenseStatus(lastSignedLicense
                    .getSignedElectronically());
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
    public final boolean checkIfArticleInvited(final Integer dhId)
            throws Exception {
        LOGGER.info("inside checkIfArticleInvited method of ArticleAssignmentServiceImpl");
        boolean isArticleInvited = false;
        if ("Y".equalsIgnoreCase(orderService.pdhLookUpArticle(dhId)
                .getIsArticleInvited())) {
            isArticleInvited = true;
        }
        return isArticleInvited;
    }

}
