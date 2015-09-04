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
import com.wiley.gr.ace.authorservices.model.ArticleInfo;
import com.wiley.gr.ace.authorservices.model.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.ArticleUserRoleDetails;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.JournalData;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.ViewAssignedArticle;
import com.wiley.gr.ace.authorservices.model.external.Identifier;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournal;
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
                        .setArticleUserRoleDetails(getArticleAuthorRoleDetails(pdhLookupArticle));
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
            articleDetails.setDhId(title.getTitleDhProdId());
            articleDetails.setArticleTitle(title.getTitleText());
            articleDetails.setArticleId(getArticleInfo(pdhLookupArticle,
                    articleDetails).getArticleId());
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
    private ArticleUserRoleDetails getArticleAuthorRoleDetails(
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
        final PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) esbInterfaceService
                .getPdhLookupResponse(articleId);
        if (!StringUtils.isEmpty(pdhLookupArticle)) {
            viewAssignedArticle
                    .setArticleData(parseFullArticleDetails(pdhLookupArticle));
            viewAssignedArticle.setJournalData(getJournalDetails());
            viewAssignedArticle.setPublicationData(getPublicationData());
            viewAssignedArticle.setOrderData(getOrderId());
        }

        return viewAssignedArticle;

    }

    /**
     * Gets the journal details.
     *
     * @return the journal details
     * @throws Exception
     *             the exception
     */
    private JournalData getJournalDetails() throws Exception {
        PdhLookupJournal pdhLookupJournal = (PdhLookupJournal) esbInterfaceService
                .getPdhLookupResponse("6839245");
        List<Title> titleList = pdhLookupJournal.getJournalProductEntities()
                .getTitle();
        JournalData journalData = null;
        if (!StringUtils.isEmpty(titleList)) {
            for (Title title : titleList) {
                if ("8118618".equals(title.getTitleDhId())) {
                    journalData = new JournalData();
                    journalData.setJournalTitle(title.getTitleText());
                    journalData = getJournalInfo(pdhLookupJournal, journalData);
                }
            }
        }
        return journalData;
    }

    /**
     * Parses the full article details.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails parseFullArticleDetails(
            final PdhLookupArticle pdhLookupArticle) throws Exception {
        ArticleDetails articleDetails = null;
        Title title = pdhLookupArticle.getArticleProductEntities().getTitle();
        if (!StringUtils.isEmpty(title)) {
            articleDetails = new ArticleDetails();
            articleDetails.setDhId(title.getTitleDhId());
            articleDetails.setArticleTitle(title.getTitleText());
            articleDetails = parseArticleDates(pdhLookupArticle, articleDetails);
            articleDetails = parseArticleAuthors(pdhLookupArticle,
                    articleDetails);
            articleDetails.setArticleDOI(getArticleInfo(pdhLookupArticle,
                    articleDetails).getArticleDOI());
        }
        return articleDetails;
    }

    /**
     * Parses the article dates.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param articleDetails
     *            the article details
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails parseArticleDates(
            final PdhLookupArticle pdhLookupArticle,
            final ArticleDetails articleDetails) throws Exception {
        List<ProductDates> productDatesList = pdhLookupArticle
                .getArticleProductEntities().getProductDates();
        if (!StringUtils.isEmpty(productDatesList)) {
            for (ProductDates productDates : productDatesList) {
                if ("ART_ACC_DT".equalsIgnoreCase(productDates
                        .getDhDateTypeCd())) {
                    articleDetails.setAcceptanceDate(productDates
                            .getProdDtDateValue());
                }
            }
        }
        return articleDetails;
    }

    /**
     * Parses the article authors.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param articleDetails
     *            the article details
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails parseArticleAuthors(
            final PdhLookupArticle pdhLookupArticle,
            final ArticleDetails articleDetails) throws Exception {
        List<ProductContributor> productContributors = pdhLookupArticle
                .getArticleProductEntities().getProductContributor();
        if (!StringUtils.isEmpty(productContributors)) {
            List<String> coAuthors = new ArrayList<String>();
            String coAuthorsNames = null;
            for (ProductContributor productContributor : productContributors) {
                String authorRoleCd = productContributor.getDhRoleTypeCd();
                if ("Corresponding Author".equalsIgnoreCase(authorRoleCd)) {
                    articleDetails.setArticleAuthorName(productContributor
                            .getFirstName().concat(" ")
                            .concat(productContributor.getLastName()));
                } else if ("Author".equalsIgnoreCase(authorRoleCd)) {
                    coAuthorsNames = productContributor.getFirstName()
                            .concat(" ")
                            .concat(productContributor.getLastName());
                    coAuthors.add(coAuthorsNames);
                }
            }
            articleDetails.setArticleCoAuthors(coAuthors);
        }
        return articleDetails;
    }

    /**
     * Gets the article info.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param articleDetails
     *            the article details
     * @return the article doi
     * @throws Exception
     *             the exception
     */
    private ArticleDetails getArticleInfo(
            final PdhLookupArticle pdhLookupArticle,
            final ArticleDetails articleDetails) throws Exception {
        List<Identifier> identifiersList = pdhLookupArticle
                .getArticleProductEntities().getIdentifier();
        if (!StringUtils.isEmpty(identifiersList)) {
            for (Identifier identifier : identifiersList) {
                if ("ARTICLE_IDENTIFIER".equalsIgnoreCase(identifier
                        .getDhTypeCd())) {
                    articleDetails.setArticleId(identifier.getIdentCd());
                } else if ("DOI".equalsIgnoreCase(identifier.getDhTypeCd())) {
                    articleDetails.setArticleDOI(identifier.getIdentCd());
                }
            }
        }
        return articleDetails;
    }

    /**
     * Gets the journal info.
     *
     * @param pdhLookupJournal
     *            the pdh lookup journal
     * @param journalData
     *            the article details
     * @return the journal data
     * @throws Exception
     *             the exception
     */
    private JournalData getJournalInfo(final PdhLookupJournal pdhLookupJournal,
            final JournalData journalData) throws Exception {
        List<Identifier> identifiersList = pdhLookupJournal
                .getJournalProductEntities().getIdentifier();
        if (!StringUtils.isEmpty(identifiersList)) {
            for (Identifier identifier : identifiersList) {
                if ("ISSN".equalsIgnoreCase(identifier.getDhTypeCd())) {
                    journalData.setIssn(identifier.getIdentCd());
                } else if ("DOI".equalsIgnoreCase(identifier.getDhTypeCd())) {
                    journalData.setJournalDoi(identifier.getIdentCd());
                } else if ("DOI".equalsIgnoreCase(identifier.getDhTypeCd())) {
                    journalData.setJournalDoi(identifier.getIdentCd());
                }
                journalData.setDhId("OA.1125.JOURNAL");
            }
        }
        return journalData;
    }

    /**
     * Gets the publication data.
     *
     * @return the publication data
     */
    private PublicationDetails getPublicationData() {
        PublicationDetails publicationDetails = new PublicationDetails();
        publicationDetails.setModifiedDate("2015-08-28T14:06:31Z");
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
