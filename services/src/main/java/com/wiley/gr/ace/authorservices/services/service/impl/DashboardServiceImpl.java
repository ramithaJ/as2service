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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.ArticleData;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.CommunicationDetails;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardInfo;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.EmailCommunicationHistory;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.PaymentStatus;
import com.wiley.gr.ace.authorservices.model.ProductionStatus;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.Identifier;
import com.wiley.gr.ace.authorservices.model.external.License;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.ProductContributor;
import com.wiley.gr.ace.authorservices.model.external.ProductDates;
import com.wiley.gr.ace.authorservices.model.external.Production;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestion;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.Title;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
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

    /**
     * This method is used for get the Profile Information of User from external
     * service called UserProfileService by using userId and returning the
     * Dashboard. In this Dashboard Every Missed Information is set with id and
     * profileMeterMessage of DashboardInfo.If these method unable to call the
     * External Service it will throws an Exception.
     *
     * @param userId
     *            the user id
     * @return DashBoard
     * @throws Exception
     *             the exception
     */
    @Override
    public final Dashboard getProfileMeter(final String userId)
            throws Exception {
        LOGGER.info("inside getProfileMeter Method of DashboardServiceImpl");
        final Dashboard dashBoard = new Dashboard();
        List<DashboardInfo> dashBoardInfoList;
        final UserProfileResponse userProfileResponse = userProfileService
                .getUserProfileResponse(userId);
        final UserProfile userProfile = userProfileResponse
                .getCustomerProfile();
        dashBoardInfoList = checkingDashboardInfo(userProfile);
        if (StringUtils.isEmpty(dashBoardInfoList)) {
            dashBoard.setProfileMeterMessage("Profile Completed");
            dashBoard.setDashBoardInfo(dashBoardInfoList);
        } else {
            dashBoard.setDashBoardInfo(dashBoardInfoList);
        }
        return dashBoard;
    }

    /**
     * This method will call the External Service to get Security Details of
     * user by passing emailId.If Security Questions are empty then set to the
     * DashboardInfo otherwise not set.
     *
     * @param emailId
     *            the email id
     * @return DashboardInfo
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getSecurityDetailsForUser(final String emailId)
            throws Exception {
        LOGGER.info("inside getSecurityDetailsForUser Method of DashboardServiceImpl");
        final SecuirtyQuestionDetails secuirtyQuestionDetails = userManagementService
                .getSecurityQuestionDetails(emailId);
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(secuirtyQuestionDetails)) {
            final SecurityQuestions securityQuestions = secuirtyQuestionDetails
                    .getSecurityQuestions();
            final List<SecurityQuestion> securityQuestionList = securityQuestions
                    .getSecurityQuestion();
            if (!StringUtils.isEmpty(securityQuestionList)) {
                for (final SecurityQuestion securityQuestion : securityQuestionList) {
                    if (StringUtils.isEmpty(securityQuestion.getQuestion())
                            || StringUtils
                                    .isEmpty(securityQuestion.getAnswer())) {
                        dashboardInfo = new DashboardInfo();
                        dashboardInfo.setId("security");
                        dashboardInfo
                                .setDashBoardInfoMessage("No Security Details");
                        break;
                    }
                }
            }
        }
        return dashboardInfo;
    }

    /**
     * Checking dashboard info.
     *
     * @param userProfile
     *            the user profile
     * @return the list
     * @throws Exception
     *             the exception
     */
    private List<DashboardInfo> checkingDashboardInfo(
            final UserProfile userProfile) throws Exception {
        LOGGER.info("inside checkingDashBoardInfo Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        final List<DashboardInfo> dashboardInfoList = new ArrayList<DashboardInfo>();
        dashboardInfo = getSecurityDetailsForUser(userProfile
                .getCustomerDetails().getPrimaryEmailAddr());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getRecoveryEmailAddr(userProfile.getCustomerDetails());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getOrcidId(userProfile.getCustomerDetails());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getInterestsForUser(userProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getAffiliationsForUser(userProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getSocietiesForUser(userProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getFundersListForUser(userProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        return dashboardInfoList;
    }

    /**
     * This method get the AreaOfInterests for user from userProfile and checks
     * whether user is added Interests or not.If User is not added then it show
     * empty and set to dashboardInfo otherwise dashboardInfo null.
     *
     * @param userProfile
     *            the user profile
     * @return dashboardInfo
     */
    private DashboardInfo getInterestsForUser(final UserProfile userProfile) {
        LOGGER.info("inside getInterestsForUser Method of DashboardServiceImpl");
        final List<Interests> userInterestsList = userProfile.getInterests();
        DashboardInfo dashboardInfo = null;
        if (null != userInterestsList && userInterestsList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("my-interests");
            dashboardInfo
                    .setDashBoardInfoMessage("No Areas Of Expertizes(Interests) Details");
        }
        return dashboardInfo;
    }

    /**
     * This method get the Affiliations for user from userProfile and checks
     * whether user is added Affiliations or not.If User is not added then it
     * show empty and set to dashboardInfo otherwise dashboardInfo null.
     *
     * @param userProfile
     *            the user profile
     * @return dashboardInfo
     */
    private DashboardInfo getAffiliationsForUser(final UserProfile userProfile) {
        LOGGER.info("inside getAffiliationsForUser Method of DashboardServiceImpl");
        final List<Affiliation> userAffiliationsList = userProfile
                .getAffiliations();
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(userAffiliationsList)
                && userAffiliationsList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("affiliations");
            dashboardInfo.setDashBoardInfoMessage("No Affiliation Details");
        }
        return dashboardInfo;
    }

    /**
     * This method get the Societies for user from userProfile and checks
     * whether user is added Societies or not.If User is not added then it show
     * empty and set to dashboardInfo otherwise dashboardInfo null.
     *
     * @param userProfile
     *            the user profile
     * @return dashboardInfo
     */
    private DashboardInfo getSocietiesForUser(final UserProfile userProfile) {
        LOGGER.info("inside getSocietiesForUser Method of DashboardServiceImpl");
        final List<Society> societyList = userProfile.getSocieties();
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(societyList) && societyList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("societies");
            dashboardInfo.setDashBoardInfoMessage("No Society Details");
        }
        return dashboardInfo;
    }

    /**
     * This method get the Funders for user from userProfile and checks whether
     * user is added Funders or not.If User is not added then it show empty and
     * set to dashboardInfo otherwise dashboardInfo null.
     *
     * @param userProfile
     *            the user profile
     * @return dashboardInfo
     */
    private DashboardInfo getFundersListForUser(final UserProfile userProfile) {
        LOGGER.info("inside getFundersListForUser Method of DashboardServiceImpl");
        final List<ResearchFunder> researchFundersList = userProfile
                .getResearchFunders();
        DashboardInfo dashboardInfo = null;
        if (!StringUtils.isEmpty(researchFundersList)
                && researchFundersList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("research-funder");
            dashboardInfo
                    .setDashBoardInfoMessage("No Research Funders Details");
        }
        return dashboardInfo;
    }

    /**
     * This method get the RecoveryEmailAddr for user from user object and
     * checks whether user is added RecoveryEmailAddr or not.If User is not
     * added then it show empty and set to dashboardInfo otherwise dashboardInfo
     * null.
     *
     * @param user
     *            the user
     * @return dashboardInfo
     * @throws Exception
     *             the exception
     */
    private DashboardInfo getRecoveryEmailAddr(final User user)
            throws Exception {
        LOGGER.info("inside getRecoveryEmailAddr Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(user.getRecoveryEmailAddress())) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("email");
            dashboardInfo
                    .setDashBoardInfoMessage("No Secondary Email(Recovery Email Addr)");
        }
        return dashboardInfo;
    }

    /**
     * This method get the OrcidId for user from user object and checks whether
     * user is added OrcidId or not.If User is not added then it show empty and
     * set to dashboardInfo otherwise dashboardInfo null.
     *
     * @param user
     *            the user
     * @return dashboardInfo
     */
    private DashboardInfo getOrcidId(final User user) {
        LOGGER.info("inside getOrcidId Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(user.getOrcidID())) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("orcid");
            dashboardInfo.setDashBoardInfoMessage("No Orcid ID");
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
            String articleAuthorRole = null;
            Integer articleId;
            for (final ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                articleAuthorRole = productPersonRelations.getProductRoles()
                        .getProductRoleName();
                articleId = productPersonRelations.getProducts().getDhId();
                articleData = getPdhArticleData(articleId, articleAuthorRole);
                articleData.setLicenseStatus(getLicenseStatusForArticle(String
                        .valueOf(articleId)));
                articleData
                        .setOrderPaymentStatus(getOrderPaymentStatusForArticle(Integer
                                .parseInt(String.valueOf(articleId))));
                articleDataList.add(articleData);
            }
        }
        return articleDataList;
    }

    /**
     * Gets the pdh article data.
     *
     * @param dhId
     *            the dh id
     * @param articleUserRole
     *            the article user role
     * @return the pdh article data
     * @throws Exception
     *             the exception
     */
    private ArticleData getPdhArticleData(final Integer dhId,
            final String articleUserRole) throws Exception {
        PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) esbInterfaceService
                .getPdhLookupResponse(String.valueOf(dhId));
        ArticleData articleData = null;
        if (!StringUtils.isEmpty(pdhLookupArticle)) {
            articleData = new ArticleData();
            articleData.setArticleUserRole(articleUserRole);
            articleData
                    .setArticleDetails(parseArticleDetails(pdhLookupArticle));
        }
        return articleData;
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
            articleDetails.setArticleId(title.getTitleDhProdId());
            articleDetails.setArticleTitle(title.getTitleText());
            articleDetails = parseProductDates(pdhLookupArticle, articleDetails);
            articleDetails = parseAuthors(pdhLookupArticle, articleDetails);
            articleDetails.setArticleDOI(getArticleDoi(pdhLookupArticle,
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
            final ArticleDetails articleDetails) throws Exception{
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
            final ArticleDetails articleDetails) throws Exception{
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
     * Gets the article doi.
     *
     * @param pdhLookupArticle
     *            the pdh lookup article
     * @param articleDetails
     *            the article details
     * @return the article doi
     * @throws Exception
     *             the exception
     */
    private ArticleDetails getArticleDoi(
            final PdhLookupArticle pdhLookupArticle,
            final ArticleDetails articleDetails) throws Exception{
        List<Identifier> identifierList = pdhLookupArticle
                .getArticleProductEntities().getIdentifier();
        if (!StringUtils.isEmpty(identifierList)) {
            for (Identifier identifier : identifierList) {
                if ("DOI".equalsIgnoreCase(identifier.getDhTypeCd())) {
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
     * Gets the order payment status for article.
     *
     * @param articleId
     *            the article id
     * @return the order payment status for article
     * @throws Exception
     *             the exception
     */
    private PaymentStatus getOrderPaymentStatusForArticle(
            final Integer articleId) throws Exception {
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
            String articleAuthorRole = null;
            Integer articleId;
            for (final ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                articleAuthorRole = productPersonRelations.getProductRoles()
                        .getProductRoleName();
                articleId = productPersonRelations.getProducts().getDhId();
                articleData = getProductionDetailsForArticles(articleId,
                        articleAuthorRole);
                articleDataListForProduction.add(articleData);
            }
            dashboardView = new DashboardView();
            dashboardView.setArticleData(articleDataListForProduction);
        }
        return dashboardView;
    }

    /**
     * Gets the production details for articles.
     *
     * @param articleId
     *            the article id
     * @param articleAuthorRole
     *            the article author role
     * @return the production details for articles
     * @throws Exception
     *             the exception
     */
    private ArticleData getProductionDetailsForArticles(
            final Integer articleId, final String articleAuthorRole)
            throws Exception {
        LOGGER.info("inside getProductionDetailsForArticles Method of DashboardServiceImpl");
        ArticleData articleData = getPdhArticleData(articleId,
                articleAuthorRole);
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
            String articleAuthorRole = null;
            Integer articleId;
            for (final ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                articleAuthorRole = productPersonRelations.getProductRoles()
                        .getProductRoleName();
                articleId = productPersonRelations.getProducts().getDhId();
                articleData = getPublicationArticleStatus(articleId,
                        articleAuthorRole);
                articleDataListforPublication.add(articleData);
            }
            dashboardView = new DashboardView();
            dashboardView.setArticleData(articleDataListforPublication);
        }
        return dashboardView;
    }

    /**
     * Gets the publication article status.
     *
     * @param dhId
     *            the dh id
     * @param articleAuthorRole
     *            the article author role
     * @return the publication article status
     * @throws Exception
     *             the exception
     */
    private ArticleData getPublicationArticleStatus(final Integer dhId,
            final String articleAuthorRole) throws Exception {
        LOGGER.info("inside getPublicationArticleStatus Method of DashboardServiceImpl");
        ArticleData articleData = getPdhArticleData(dhId, articleAuthorRole);
        PublicationDetails publication = new PublicationDetails();
        LOGGER.info("Publication Statuses Data is Found");
        publication.setPublicationStatus("Request OO");
        publication.setModifiedDate("2015-07-14T16:10:13Z");
        articleData.setPublication(publication);
        return articleData;
    }
}
