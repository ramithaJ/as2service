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
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.LicenseDetails;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.ViewAssignedArticle;
import com.wiley.gr.ace.authorservices.model.ArticleInfo;
import com.wiley.gr.ace.authorservices.model.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.ArticleUserRoleDetails;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.ProductContributor;
import com.wiley.gr.ace.authorservices.model.external.ProductDates;
import com.wiley.gr.ace.authorservices.model.external.Title;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.services.ArticleAssignmentDAO;
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

    /** The article assignment dao. */
    @Autowired(required = true)
    private ArticleAssignmentDAO articleAssignmentDAO;

    /** The esb interface service. */
    @Autowired(required = true)
    private ESBInterfaceService esbInterfaceService;

    /** The Shared service. */
    @Autowired(required = true)
    private TaskService bpmInterfaceService;

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
    public final ArticleInfoDetails getArticleInfoDetails(final String emailId)
            throws Exception {
        LOGGER.info("inside getArticleInfo method of ArticleAssignmentServiceImpl");
        List<ProductPersonRelations> productPersonRelationsList = articleAssignmentDAO
                .getProductPersonRelations(emailId);
        List<ArticleInfo> articleInfoList = new ArrayList<ArticleInfo>();
        if (!StringUtils.isEmpty(productPersonRelationsList)) {
            for (final ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                articleInfoList
                        .add(getPdhLookupArticle(productPersonRelations));
            }
        }
        ArticleInfoDetails articleInfoDetails = new ArticleInfoDetails();
        articleInfoDetails.setArticleInfo(articleInfoList);
        return articleInfoDetails;
    }

    /**
     * Gets the pdh lookup article.
     *
     * @param productPersonRelations
     *            the product person relations
     * @return the pdh lookup article
     * @throws Exception
     *             the exception
     */
    private ArticleInfo getPdhLookupArticle(
            ProductPersonRelations productPersonRelations) throws Exception {
        ArticleInfo articleInfo = null;
        Integer articleId = productPersonRelations.getProducts().getDhId();
        if (!StringUtils.isEmpty(articleId)
                && "Article".equalsIgnoreCase(productPersonRelations
                        .getProducts().getDhTypeCd())) {
            PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) esbInterfaceService
                    .getPdhLookupResponse(String.valueOf(articleId));
            if (!StringUtils.isEmpty(pdhLookupArticle)) {
                articleInfo = new ArticleInfo();
                articleInfo.setArticleAuthId(productPersonRelations
                        .getUserProfile().getUserId());
                articleInfo
                        .setArticleDetails(getArticleDetails(pdhLookupArticle));
                articleInfo
                        .setArticleUserRoleDetails(getArticleUserRoleDetails(pdhLookupArticle));
            }
        }
        return articleInfo;
    }

    /**
     * Gets the article details.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails getArticleDetails(
            final PdhLookupArticle pdhLookupArticle) throws Exception {
        Title title = pdhLookupArticle.getArticleProductEntities().getTitle();
        ArticleDetails articleDetails = null;
        if (!StringUtils.isEmpty(title)) {
            articleDetails = new ArticleDetails();
            articleDetails.setArticleId(title.getTitleDhProdId());
            articleDetails.setArticleTitle(title.getTitleText());
            articleDetails
                    .setPublicationDate(getPublicationDate(pdhLookupArticle));
        }
        return articleDetails;
    }

    /**
     * Gets the publication date.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @return the publication date
     * @throws Exception
     *             the exception
     */
    private String getPublicationDate(final PdhLookupArticle pdhLookupArticle)
            throws Exception {
        List<ProductDates> productDatesList = pdhLookupArticle
                .getArticleProductEntities().getProductDates();
        String publicationDate = null;
        if (!StringUtils.isEmpty(productDatesList)) {
            for (ProductDates productDates : productDatesList) {
                if ("ART_ACC_DT".equalsIgnoreCase(productDates
                        .getDhDateTypeCd())) {
                    publicationDate = productDates.getProdDtDateValue();
                }
            }
        }
        return publicationDate;
    }

    /**
     * Gets the article user role details.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @return the article user role details
     * @throws Exception
     *             the exception
     */
    private ArticleUserRoleDetails getArticleUserRoleDetails(
            final PdhLookupArticle pdhLookupArticle) throws Exception {
        List<ProductContributor> productContributorList = pdhLookupArticle
                .getArticleProductEntities().getProductContributor();
        ArticleUserRoleDetails articleUserRoleDetails = null;
        if (!StringUtils.isEmpty(productContributorList)) {
            for (ProductContributor productContributor : productContributorList) {
                articleUserRoleDetails = new ArticleUserRoleDetails();
                String authorRoleCd = productContributor.getDhRoleTypeCd();
                if ("Corresponding Author".equalsIgnoreCase(authorRoleCd)) {
                    articleUserRoleDetails.setRoleCode(productContributor
                            .getDhProdTypeCd());
                    articleUserRoleDetails.setRoleName(productContributor
                            .getFirstName().concat(" ")
                            .concat(productContributor.getLastName()));
                }
            }
        }
        return articleUserRoleDetails;
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
            viewAssignedArticle.setOrderData(getOrderId());
            viewAssignedArticle
                    .setLicenseData(getLicenseData(pdhLookupArticleResponse));
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
        articleDetails.setArticleAuthorName(pdhLookupArticleResponse
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
        PdhLookupJournalResponse pdhLookupJournalResponse = esbInterfaceService
                .getPdhLookupJournalResponse(pdhLookupArticleResponse
                        .getJournalUniqueID());
        JournalDetails journalDetails = new JournalDetails();
        journalDetails.setJournalId(pdhLookupArticleResponse
                .getJournalUniqueID());
        journalDetails.setJournalTitle(pdhLookupJournalResponse.getTitle());
        journalDetails.setJournalDoi(pdhLookupJournalResponse.getJournalDoi());
        journalDetails.setJournalPrintIssn(pdhLookupJournalResponse
                .getPrintIssn());
        journalDetails.setJournalElectronicIssn(pdhLookupJournalResponse
                .getElectronicIssn());
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
        PublicationDetails publicationDetails = new PublicationDetails();
        publicationDetails.setModifiedDate(pdhLookupArticleResponse
                .getPublicationYear());
        publicationDetails.setPublicationStatus("Make OO");
        publicationDetails.setPublicationPath("From AS 2.0");
        return publicationDetails;
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    private OrderDetails getOrderId() {
        final OrderDetails orderData = new OrderDetails();
        orderData.setOrderId("11232");
        return orderData;
    }

    /**
     * Gets the license data.
     *
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @return the license data
     */
    private LicenseDetails getLicenseData(
            final PdhLookupArticleResponse pdhLookupArticleResponse) {
        LicenseDetails licenseDetails = new LicenseDetails();
        licenseDetails.setLicenseSignedDate(pdhLookupArticleResponse
                .getLicense());
        licenseDetails.setLicenseStatus("Sign License Agreement");
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
