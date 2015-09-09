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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.ArticleData;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.CommunicationDetails;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardInfo;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.EmailCommunicationHistory;
import com.wiley.gr.ace.authorservices.model.JournalData;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.PaymentStatus;
import com.wiley.gr.ace.authorservices.model.ProductionStatus;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.external.AffiliationData;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.Identifier;
import com.wiley.gr.ace.authorservices.model.external.InterestData;
import com.wiley.gr.ace.authorservices.model.external.License;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournal;
import com.wiley.gr.ace.authorservices.model.external.ProductContributor;
import com.wiley.gr.ace.authorservices.model.external.ProductDates;
import com.wiley.gr.ace.authorservices.model.external.Production;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunderData;
import com.wiley.gr.ace.authorservices.model.external.SocietyData;
import com.wiley.gr.ace.authorservices.model.external.SystemSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.Title;
import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.services.DashboardDAO;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;

/**
 * This DashboardServiceImpl is for providing service for viewing the Dashboard
 * of Corresponding Author and Co-Author.
 * 
 * @author virtusa version 1.0
 */
public class DashboardServiceImpl implements DashboardService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DashboardServiceImpl.class);

    /** The user profile service. */
    @Autowired(required = true)
    private UserProfiles userProfileService;

    /** The user management service. */
    @Autowired(required = true)
    private UserManagement userManagementService;

    /** The esb interface service. */
    @Autowired(required = true)
    private ESBInterfaceService esbInterfaceService;

    /** The dashboardDAO. */
    @Autowired(required = true)
    private DashboardDAO dashboardDAO;

    /** The notificationService. */
    @Autowired(required = true)
    private NotificationService notificationService;

    /** The security id. */
    @Value("${dashboard.security.id}")
    private String securityId;

    /** The security message. */
    @Value("${dashboard.security.message}")
    private String securityMessage;

    /** The interests id. */
    @Value("${dashboard.interests.id}")
    private String interestsId;

    /** The interests message. */
    @Value("${dashboard.interests.message}")
    private String interestsMessage;

    /** The affiliations id. */
    @Value("${dashboard.affiliations.id}")
    private String affiliationsId;

    /** The affiliations message. */
    @Value("${dashboard.affiliations.message}")
    private String affiliationsMessage;

    /** The societies id. */
    @Value("${dashboard.societies.id}")
    private String societiesId;

    /** The societies message. */
    @Value("${dashboard.societies.message}")
    private String societiesMessage;

    /** The research funder id. */
    @Value("${dashboard.researchfunder.id}")
    private String researchFunderId;

    /** The research funder message. */
    @Value("${dashboard.researchfunder.message}")
    private String researchFunderMessage;

    /** The email id. */
    @Value("${dashboard.email.id}")
    private String emailId;

    /** The email message. */
    @Value("${dashboard.email.message}")
    private String emailMessage;

    /** The orc id. */
    @Value("${dashboard.orcid.id}")
    private String orcId;

    /** The orc id message. */
    @Value("${dashboard.orcid.message}")
    private String orcIdMessage;

    /**
     * Gets the profile meter.
     *
     * @param userId
     *            the user id
     * @return the profile meter
     * @throws Exception
     *             the exception
     */
    @Override
    public final Dashboard getProfileMeter(final String userId)
            throws Exception {
        LOGGER.info("inside getProfileMeter Method of DashboardServiceImpl");
        final Dashboard dashBoard = new Dashboard();
        List<DashboardInfo> dashBoardInfoList = null;
        final LookupCustomerProfile lookupCustomerProfile = userProfileService
                .getLookupCustomerProfile(userId);
        if (!StringUtils.isEmpty(lookupCustomerProfile)) {
            LOGGER.info("lookupCustomerProfile data is found");
            final CustomerProfile customerProfile = lookupCustomerProfile
                    .getLookupCustomerProfileResponse().getCustomerProfile();
            if (!StringUtils.isEmpty(customerProfile)) {
                LOGGER.info("customerProfile data is found");
                dashBoardInfoList = checkingDashboardInfo(customerProfile);
                if (dashBoardInfoList.isEmpty()) {
                    LOGGER.info(" Dashboard Info List is Empty Profile Completed");
                    dashBoard.setProfileMeterMessage("Profile Completed");
                    dashBoard.setDashBoardInfo(dashBoardInfoList);
                } else {
                    LOGGER.info(" Dashboard Info List is  Not Empty Profile Not Completed");
                    dashBoard.setDashBoardInfo(dashBoardInfoList);
                }
            }
        }
        return dashBoard;
    }

    /**
     * Checking dashboard info.
     *
     * @param customerProfile
     *            the customer profile
     * @return the list
     * @throws Exception
     *             the exception
     */
    private List<DashboardInfo> checkingDashboardInfo(
            final CustomerProfile customerProfile) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside checkingDashBoardInfo Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        List<DashboardInfo> dashboardInfoList = new ArrayList<DashboardInfo>();
        dashboardInfo = getSecurityDetailsForUser(customerProfile
                .getCustomerDetails().getPrimaryEmail());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            LOGGER.info(" Dashboard info For No Secuirty Questions");
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getRecoveryEmailAddr(customerProfile
                .getCustomerDetails());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            LOGGER.info(" Dashboard info For No Secondary EmailId");
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getOrcidId(customerProfile.getCustomerDetails());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            LOGGER.info(" Dashboard info For No OrcId");
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getInterestsForUser(customerProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            LOGGER.info(" Dashboard info For No Area of Interests");
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getAffiliationsForUser(customerProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            LOGGER.info(" Dashboard info For No Affiliations");
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getSocietiesForUser(customerProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            LOGGER.info(" Dashboard info For No Societies");
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getFundersListForUser(customerProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            LOGGER.info(" Dashboard info For No Funders");
            dashboardInfoList.add(dashboardInfo);
        }
        return dashboardInfoList;
    }

    /**
     * Gets the security details for user.
     *
     * @param emailId
     *            the email id
     * @return the security details for user
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getSecurityDetailsForUser(final String emailId)
            throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getSecurityDetailsForUser Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        SystemSecurityQuestions systemSecurityQuestions = null;
        if (!StringUtils.isEmpty(emailId)) {
            LOGGER.info(" EmailId is Found to Check Secuirty Questions");
            try {
                systemSecurityQuestions = userManagementService
                        .userSecurityQuestions(emailId)
                        .getSystemSecurityQuestions();
            } catch (UserException userException) {
                LOGGER.info("No user Found with EmailId then No Security Questions on Dashboard"
                        + userException);
                dashboardInfo = new DashboardInfo();
                dashboardInfo.setId(securityId);
                dashboardInfo.setDashBoardInfoMessage(securityMessage);
            }
            if (!StringUtils.isEmpty(systemSecurityQuestions)) {
                dashboardInfo = securityQuestionsChecking(systemSecurityQuestions);
            }
        }
        return dashboardInfo;
    }

    /**
     * Security questions checking.
     *
     * @param systemSecurityQuestions
     *            the system security questions
     * @return the dashboard info
     * @throws Exception
     *             the exception
     */
    private DashboardInfo securityQuestionsChecking(
            final SystemSecurityQuestions systemSecurityQuestions)
            throws Exception {
        LOGGER.info("Inside securityQuestionsChecking method  of DashboardServiceImpl ");
        DashboardInfo dashboardInfo = null;
        List<String> systemSecurityQuestionsList = systemSecurityQuestions
                .getSecurityQuestionList();
        if (!StringUtils.isEmpty(systemSecurityQuestionsList)
                && systemSecurityQuestionsList.isEmpty()) {
            LOGGER.info("Secuirty Questions List is Empty then No Security Questions on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(securityId);
            dashboardInfo.setDashBoardInfoMessage(securityMessage);
        }
        return dashboardInfo;
    }

    /**
     * Gets the interests for user.
     *
     * @param customerProfile
     *            the customer profile
     * @return the interests for user
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getInterestsForUser(
            final CustomerProfile customerProfile) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getInterestsForUser Method of DashboardServiceImpl");
        final List<InterestData> userInterestsList = customerProfile
                .getAreaOfInterest().getInterest();
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(userInterestsList)
                && userInterestsList.isEmpty()) {
            LOGGER.info(" Interests List is Empty then No Interests on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(interestsId);
            dashboardInfo.setDashBoardInfoMessage(interestsMessage);
        }
        return dashboardInfo;
    }

    /**
     * Gets the affiliations for user.
     *
     * @param customerProfile
     *            the customer profile
     * @return the affiliations for user
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getAffiliationsForUser(
            final CustomerProfile customerProfile) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getAffiliationsForUser Method of DashboardServiceImpl");
        final List<AffiliationData> userAffiliationsList = customerProfile
                .getAffiliations().getAffiliation();
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(userAffiliationsList)
                && userAffiliationsList.isEmpty()) {
            LOGGER.info(" Affiliations List is Empty then No Affiliations on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(affiliationsId);
            dashboardInfo.setDashBoardInfoMessage(affiliationsMessage);
        }
        return dashboardInfo;
    }

    /**
     * Gets the societies for user.
     *
     * @param customerProfile
     *            the customer profile
     * @return the societies for user
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getSocietiesForUser(
            final CustomerProfile customerProfile) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getSocietiesForUser Method of DashboardServiceImpl");
        final List<SocietyData> societyList = customerProfile.getSocietyList()
                .getSociety();
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(societyList) && societyList.isEmpty()) {
            LOGGER.info(" Society List is Empty then No Societies on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(societiesId);
            dashboardInfo.setDashBoardInfoMessage(societiesMessage);
        }
        return dashboardInfo;
    }

    /**
     * Gets the funders list for user.
     *
     * @param customerProfile
     *            the customer profile
     * @return the funders list for user
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getFundersListForUser(
            final CustomerProfile customerProfile) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getFundersListForUser Method of DashboardServiceImpl");
        final List<ResearchFunderData> researchFundersList = customerProfile
                .getResearchFunders().getResearchFunder();
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(researchFundersList)
                && researchFundersList.isEmpty()) {
            LOGGER.info(" Funders List is Empty then No Funders on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(researchFunderId);
            dashboardInfo.setDashBoardInfoMessage(researchFunderMessage);
        }
        return dashboardInfo;
    }

    /**
     * Gets the recovery email addr.
     *
     * @param customerDetails
     *            the customer details
     * @return the recovery email addr
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getRecoveryEmailAddr(
            final CustomerDetails customerDetails) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getRecoveryEmailAddr Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(customerDetails.getSecondaryEmail())) {
            LOGGER.info(" If Secondary EmailId Not Found then No Secondary EmailId on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(emailId);
            dashboardInfo.setDashBoardInfoMessage(emailMessage);
        }
        return dashboardInfo;
    }

    /**
     * Gets the orcid id.
     *
     * @param customerDetails
     *            the customer details
     * @return the orcid id
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getOrcidId(final CustomerDetails customerDetails)
            throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getOrcidId Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(customerDetails.getOrcId())) {
            LOGGER.info(" If Orcid Id Not Found then No Orcid Id on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(orcId);
            dashboardInfo.setDashBoardInfoMessage(orcIdMessage);
        }
        return dashboardInfo;
    }

    /**
     * View dashboard.
     *
     * @param userId
     *            to get the data from ESB ExternalService
     * @return DashboardView
     * @throws Exception
     *             the exception
     */
    @Override
    public final DashboardView viewDashboard(final String userId)
            throws Exception {
        LOGGER.info("inside viewDashboard Method of DashboardServiceImpl");
        final DashboardView dashboardView = new DashboardView();
        dashboardView.setArticleData(getArticleAuthorData(userId));
        return dashboardView;
    }

    /**
     * Gets the article author data.
     *
     * @param userId
     *            the user id
     * @return the article author data
     * @throws Exception
     *             the exception
     */
    private List<ArticleData> getArticleAuthorData(final String userId)
            throws Exception {
        LOGGER.info("inside getArticleAuthorData Method of DashboardServiceImpl");
        List<ArticleData> articleDataList = new ArrayList<ArticleData>();
        ArticleData articleData = null;
        final List<ProductPersonRelations> productPersonRelationsList = dashboardDAO
                .getProductPersonRelations(userId);
        if (!StringUtils.isEmpty(productPersonRelationsList)) {
            LOGGER.info("ProductPersonRelations data found");
            for (final ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                articleData = getProductPersonRelations(productPersonRelations);
                articleDataList.add(articleData);
            }
        }
        return articleDataList;
    }

    /**
     * Gets the product person relations.
     *
     * @param productPersonRelations
     *            the product person relations
     * @return the product person relations
     * @throws Exception
     *             the exception
     */
    private ArticleData getProductPersonRelations(
            final ProductPersonRelations productPersonRelations)
            throws Exception {
        ArticleData articleData = null;
        if (!StringUtils.isEmpty(productPersonRelations)) {
            Integer articleId = productPersonRelations.getProducts().getDhId();
            if (!StringUtils.isEmpty(articleId)
                    && "Article".equalsIgnoreCase(productPersonRelations
                            .getProducts().getDhTypeCd())) {
                articleData = getPdhArticleData(articleId);
                articleData.setLicenseStatus(getLicenseStatusForArticle(String
                        .valueOf(articleId)));
                articleData.setOrderPaymentStatus(getPaymentStatus(articleId));
            }
        }
        return articleData;
    }

    /**
     * Gets the pdh article data.
     *
     * @param dhId
     *            the dh id
     * @return the pdh article data
     * @throws Exception
     *             the exception
     */
    private ArticleData getPdhArticleData(final Integer dhId) throws Exception {
        PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) esbInterfaceService
                .getPdhLookupResponse(String.valueOf(dhId));
        ArticleData articleData = null;
        if (!StringUtils.isEmpty(pdhLookupArticle)) {
            articleData = new ArticleData();
            articleData
                    .setArticleUserRole(getArticleAuthorRole(pdhLookupArticle));
            articleData
                    .setArticleDetails(parseArticleDetails(pdhLookupArticle));
            articleData.setJournal(getJournalDetails());
        }
        return articleData;
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
                }
            }
        }
        return journalData;
    }

    /**
     * Gets the article author role.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @return the article author role
     * @throws Exception
     *             the exception
     */
    private String getArticleAuthorRole(final PdhLookupArticle pdhLookupArticle)
            throws Exception {
        List<ProductContributor> productContributorList = pdhLookupArticle
                .getArticleProductEntities().getProductContributor();
        String articleAuthorRole = null;
        if (!StringUtils.isEmpty(productContributorList)) {
            for (ProductContributor productContributor : productContributorList) {
                String authorRoleCd = productContributor.getDhRoleTypeCd();
                if ("Corresponding Author".equalsIgnoreCase(authorRoleCd)) {
                    articleAuthorRole = productContributor.getDhRoleTypeCd();
                }
            }
        }
        return articleAuthorRole;
    }

    /**
     * Parses the article details.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails parseArticleDetails(
            final PdhLookupArticle pdhLookupArticle) throws Exception {
        ArticleDetails articleDetails = null;
        Title title = pdhLookupArticle.getArticleProductEntities().getTitle();
        if (!StringUtils.isEmpty(title)) {
            articleDetails = new ArticleDetails();
            articleDetails.setDhId(title.getTitleDhProdId());
            articleDetails.setArticleTitle(title.getTitleText());
            articleDetails = parseProductDates(pdhLookupArticle, articleDetails);
            articleDetails = parseAuthors(pdhLookupArticle, articleDetails);
            articleDetails.setArticleDOI(getArticleData(pdhLookupArticle,
                    articleDetails).getArticleDOI());
        }
        return articleDetails;
    }

    /**
     * Parses the product dates.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param articleDetails
     *            the article details
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails parseProductDates(
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
     * Parses the authors.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param articleDetails
     *            the article details
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails parseAuthors(
            final PdhLookupArticle pdhLookupArticle,
            final ArticleDetails articleDetails) throws Exception {
        List<ProductContributor> productContributorList = pdhLookupArticle
                .getArticleProductEntities().getProductContributor();
        if (!StringUtils.isEmpty(productContributorList)) {
            List<String> coAuthorsList = new ArrayList<String>();
            String coAuthors = null;
            for (ProductContributor productContributor : productContributorList) {
                String authorRoleCd = productContributor.getDhRoleTypeCd();
                if ("Corresponding Author".equalsIgnoreCase(authorRoleCd)) {
                    articleDetails.setArticleAuthorName(productContributor
                            .getFirstName().concat(" ")
                            .concat(productContributor.getLastName()));
                } else if ("Author".equalsIgnoreCase(authorRoleCd)) {
                    coAuthors = productContributor.getFirstName().concat(" ")
                            .concat(productContributor.getLastName());
                    coAuthorsList.add(coAuthors);
                }
            }
            articleDetails.setArticleCoAuthors(coAuthorsList);
        }
        return articleDetails;
    }

    /**
     * Gets the article data.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param articleDetails
     *            the article details
     * @return the article doi
     * @throws Exception
     *             the exception
     */
    private ArticleDetails getArticleData(
            final PdhLookupArticle pdhLookupArticle,
            final ArticleDetails articleDetails) throws Exception {
        List<Identifier> identifierList = pdhLookupArticle
                .getArticleProductEntities().getIdentifier();
        if (!StringUtils.isEmpty(identifierList)) {
            for (Identifier identifier : identifierList) {
                if ("ARTICLE_IDENTIFIER".equalsIgnoreCase(identifier.getDhTypeCd())) {
                    articleDetails.setArticleId(identifier.getIdentCd());
                }else if("DOI".equalsIgnoreCase(identifier.getDhTypeCd())){
                    articleDetails.setArticleDOI(identifier.getIdentCd());
                }
            }
        }
        return articleDetails;
    }

    /**
     * Gets the license status for article.
     *
     * @param articleId
     *            the article id
     * @return the license status for article
     * @throws Exception
     *             the exception
     */
    private String getLicenseStatusForArticle(final String articleId)
            throws Exception {
        License license = esbInterfaceService.getLicenseStatus(Integer
                .parseInt(articleId));
        String licenseStatus = null;
        if (!StringUtils.isEmpty(license)) {
            licenseStatus = license.getLicenseStatus();
        }
        return licenseStatus;
    }

    /**
     * Gets the payment status.
     *
     * @param articleId
     *            the article id
     * @return the payment status
     * @throws Exception
     *             the exception
     */
    private PaymentStatus getPaymentStatus(final Integer articleId)
            throws Exception {
        LOGGER.info("inside getOrderPaymentStatusForArticle Method of DashboardServiceImpl");
        final PaymentStatus orderPaymentStatus = new PaymentStatus();
        final String openAccessStatus = esbInterfaceService
                .getOpenAccessStatus(articleId).getOpenAccessStatus();
        if (!StringUtils.isEmpty(openAccessStatus)) {
            LOGGER.info("Open Access Status is Found");
            orderPaymentStatus.setOpenAccessStatus(openAccessStatus);
        }
        final String onlineOpenStatus = esbInterfaceService
                .getOnlineOpenStatus(articleId).getOnlineOpenStatus();
        if (!StringUtils.isEmpty(onlineOpenStatus)) {
            LOGGER.info("Open Order Status is Found");
            orderPaymentStatus.setOnlineOpenStatus(onlineOpenStatus);
        }
        return orderPaymentStatus;
    }

    /**
     * Gets the communication details.
     *
     * @param userId
     *            the user id
     * @return the communication details
     * @throws Exception
     *             the exception
     */
    @Override
    public final EmailCommunicationHistory getEmailCommunicationHistory(
            final String userId) throws Exception {
        LOGGER.info("inside getCommunicationDetailsList Method of DashboardServiceImpl");
        final EmailCommunicationHistory emailCommunicationHistory = new EmailCommunicationHistory();
        emailCommunicationHistory
                .setInvitationCommunicationDetails(getInvitationLogsList(userId));
        final NotificationHistory notificationsHistory = notificationService
                .getNotificationHistory(userId);
        if (!StringUtils.isEmpty(notificationsHistory)) {
            LOGGER.info("Notification History Found");
            emailCommunicationHistory.setNotifications(notificationsHistory
                    .getNotifications());
        }
        return emailCommunicationHistory;
    }

    /**
     * Gets the invitation logs list.
     *
     * @param userId
     *            the user id
     * @return the invitation logs list
     * @throws Exception
     *             the exception
     */
    private List<CommunicationDetails> getInvitationLogsList(final String userId)
            throws Exception {
        LOGGER.info("inside getInvitationLogsList Method of DashboardServiceImpl");
        List<CommunicationDetails> communicationDetailsList = null;
        final List<InvitationLog> invitationLogList = dashboardDAO
                .getInvitationLogList(userId);
        if (!StringUtils.isEmpty(invitationLogList)) {
            LOGGER.info("Invitation Logs  Found");
            communicationDetailsList = new ArrayList<CommunicationDetails>();
            for (final InvitationLog invitationLog : invitationLogList) {
                final CommunicationDetails communicationDetails = new CommunicationDetails();
                communicationDetails.setUserId(invitationLog.getUserProfile()
                        .getUserId());
                communicationDetails.setInviationId(invitationLog
                        .getInvitationId());
                communicationDetails.setEmailId(invitationLog.getEmailAddr());
                communicationDetails.setArticleId(invitationLog.getProducts()
                        .getDhId());
                communicationDetails.setSentDate(invitationLog.getSentDate()
                        .toString());
                communicationDetailsList.add(communicationDetails);
            }
        }
        return communicationDetailsList;
    }

    /**
     * Gets the production details.
     *
     * @param userId
     *            the user id
     * @return the production details
     * @throws Exception
     *             the exception
     */
    @Override
    public final DashboardView getProductionDetails(final String userId)
            throws Exception {
        LOGGER.info("inside getProductionDetails Method of DashboardServiceImpl");
        DashboardView dashboardView = null;
        List<ArticleData> articleDataListForProduction = new ArrayList<ArticleData>();
        ArticleData articleData = null;
        final List<ProductPersonRelations> productPersonRelationsList = dashboardDAO
                .getProductPersonRelations(userId);
        if (!StringUtils.isEmpty(productPersonRelationsList)) {
            LOGGER.info("ProductPersonRelations data found");
            for (final ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                if (!StringUtils.isEmpty(productPersonRelations)) {
                    articleData = getProductionArticles(productPersonRelations);
                    articleDataListForProduction.add(articleData);
                }
            }
            dashboardView = new DashboardView();
            dashboardView.setArticleData(articleDataListForProduction);
        }
        return dashboardView;
    }

    /**
     * Gets the production articles.
     *
     * @param productPersonRelations
     *            the product person relations
     * @return the production articles
     * @throws Exception
     *             the exception
     */
    private ArticleData getProductionArticles(
            final ProductPersonRelations productPersonRelations)
            throws Exception {
        ArticleData articleData = null;
        if (!StringUtils.isEmpty(productPersonRelations)) {
            final Integer articleId = productPersonRelations.getProducts()
                    .getDhId();
            if (!StringUtils.isEmpty(articleId)
                    && "Article".equalsIgnoreCase(productPersonRelations
                            .getProducts().getDhTypeCd())) {
                articleData = getProductionDetailsForArticles(articleId);
            }
        }
        return articleData;
    }

    /**
     * Gets the production details for articles.
     *
     * @param articleId
     *            the article id
     * @return the production details for articles
     * @throws Exception
     *             the exception
     */
    private ArticleData getProductionDetailsForArticles(final Integer articleId)
            throws Exception {
        LOGGER.info("inside getProductionDetailsForArticles Method of DashboardServiceImpl");
        ArticleData articleData = getPdhArticleData(articleId);
        final Production productionData = esbInterfaceService
                .getProductionData(articleId).getProduction();
        if (!StringUtils.isEmpty(productionData)) {
            LOGGER.info("Production Data is Found");
            ProductionStatus production = new ProductionStatus();
            production
                    .setProductionStatus(productionData.getProductionStatus());
            production.setProductionStatusDate(productionData
                    .getProductionStatusDate());
            articleData.setProduction(production);
        }
        return articleData;
    }

    /**
     * Gets the published article details.
     *
     * @param userId
     *            the user id
     * @return the published article details
     * @throws Exception
     *             the exception
     */
    @Override
    public final DashboardView getPublishedArticleDetails(final String userId)
            throws Exception {
        LOGGER.info("inside getPublishedArticleDetails Method of DashboardServiceImpl");
        DashboardView dashboardView = null;
        ArticleData articleData = null;
        List<ArticleData> articleDataListforPublication = new ArrayList<ArticleData>();
        final List<ProductPersonRelations> productPersonRelationsList = dashboardDAO
                .getProductPersonRelations(userId);
        if (!StringUtils.isEmpty(productPersonRelationsList)) {
            LOGGER.info("ProductPersonRelations Data is Found");
            for (final ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                articleData = getPublicationArticles(productPersonRelations);
                articleDataListforPublication.add(articleData);
            }
            dashboardView = new DashboardView();
            dashboardView.setArticleData(articleDataListforPublication);
        }
        return dashboardView;
    }

    /**
     * Gets the publication articles.
     *
     * @param productPersonRelations
     *            the product person relations
     * @return the publication articles
     * @throws Exception
     *             the exception
     */
    private ArticleData getPublicationArticles(
            final ProductPersonRelations productPersonRelations)
            throws Exception {
        ArticleData articleData = null;
        if (!StringUtils.isEmpty(productPersonRelations)) {
            final Integer articleId = productPersonRelations.getProducts()
                    .getDhId();
            if (!StringUtils.isEmpty(articleId)
                    && "Article".equalsIgnoreCase(productPersonRelations
                            .getProducts().getDhTypeCd())) {
                articleData = getPublicationArticleStatus(articleId);
            }
        }
        return articleData;
    }

    /**
     * Gets the publication article status.
     *
     * @param articleId
     *            the article id
     * @return the publication article status
     * @throws Exception
     *             the exception
     */
    private ArticleData getPublicationArticleStatus(final Integer articleId)
            throws Exception {
        LOGGER.info("inside getPublicationArticleStatus Method of DashboardServiceImpl");
        ArticleData articleData = getPdhArticleData(articleId);
        PublicationDetails publication = new PublicationDetails();
        LOGGER.info("Publication Statuses Data is Found");
        publication.setPublicationStatus("Request OO");
        publication.setModifiedDate("2015-07-14T16:10:13Z");
        articleData.setPublication(publication);
        return articleData;
    }
}
