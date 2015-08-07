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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.CommunicationDetails;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardInfo;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.EmailCommunicationHistory;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.OrderPaymentStatus;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.Production;
import com.wiley.gr.ace.authorservices.model.external.Publication;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestion;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.PublicationStatuses;
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

    /** The article acptd status. */
    @Value("${ARTICLE_ACCEPTED_STATUS_TEXT}")
    private String articleAcptdStatus;

    /** The acptd art pub online status. */
    @Value("${ACCEPTED_ARTICLE_PUBLISHED_ONLINE_STATUS_TEXT}")
    private String acptdArtPubOnlineStatus;

    /** The proofs out status. */
    @Value("${PROOFS_OUT_STATUS_TEXT}")
    private String proofsOutStatus;

    /** The proofs rcvd status. */
    @Value("${PROOFS_RCVD_STATUS_TEXT}")
    private String proofsRcvdStatus;

    /** The proofs corr rcvd status. */
    @Value("${PROOFS_CORRECTION_RCVD_STATUS_TEXT}")
    private String proofsCorrRcvdStatus;

    /** The early view status. */
    @Value("${EARLY_VIEW_STATUS_TEXT}")
    private String earlyViewStatus;

    /** The iss pub online status. */
    @Value("${ISSUE_PUBLISHED_ONLINE_STATUS_TEXT}")
    private String issPubOnlineStatus;

    /** The acptd art withdrawn status. */
    @Value("${ACCEPTED_ARTICLE_WITHDRAWN_STATUS_TEXT}")
    private String acptdArtWithdrawnStatus;

    /** The article proof rcvd status. */
    @Value("${ARTICLE_PROOF_RECEIVED_STATUS_TEXT}")
    private String articleProofRcvdStatus;

    /** The article proof approved status. */
    @Value("{ARTICLE_PROOF_APPROVED_STATUS_TEXT}")
    private String articleProofApprovedStatus;

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
        final List<ArticleData> articleDataList = new ArrayList<ArticleData>();
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
                articleData = getArticleDataDetails(articleId,
                        articleAuthorRole);
                articleDataList.add(articleData);
            }
        }
        return articleDataList;
    }

    /**
     * Gets the article data details.
     *
     * @param articleId
     *            the article id
     * @param articleUserRole
     *            the article user role
     * @return the article data details
     * @throws Exception
     *             the exception
     */
    private ArticleData getArticleDataDetails(final Integer articleId,
            final String articleUserRole) throws Exception {
        LOGGER.info("inside getArticleDataDetails Method of DashboardServiceImpl");
        final ArticleData articleData = esbInterfaceService
                .getAuthorArticle(articleId);
        if (!StringUtils.isEmpty(articleData)) {
            LOGGER.info("Article Data is Found");
            articleData.setArticleUserRole(articleUserRole);
            final String licenseStatus = esbInterfaceService.getLicenseStatus(
                    articleId).getLicenseStatus();
            if (!StringUtils.isEmpty(licenseStatus)) {
                LOGGER.info("License Status is Found");
                articleData.setLicenseStatus(licenseStatus);
            }
            articleData
                    .setOrderPaymentStatus(getOrderPaymentStatusForArticle(articleId));
        }
        return articleData;
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
    private OrderPaymentStatus getOrderPaymentStatusForArticle(
            final Integer articleId) throws Exception {
        LOGGER.info("inside getOrderPaymentStatusForArticle Method of DashboardServiceImpl");
        final OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus();
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
        final List<ArticleData> articleDataListForProduction = new ArrayList<ArticleData>();
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
                articleData = getProductionDetailsForArticles(
                        articleAuthorRole, articleId);
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
     * @param articleAuthorRole
     *            the article author role
     * @param articleId
     *            the article id
     * @return the production details for articles
     * @throws Exception
     *             the exception
     */
    private ArticleData getProductionDetailsForArticles(
            final String articleAuthorRole, final Integer articleId)
            throws Exception {
        LOGGER.info("inside getProductionDetailsForArticles Method of DashboardServiceImpl");
        final ArticleData articleData = esbInterfaceService
                .getAuthorArticle(articleId);
        if (!StringUtils.isEmpty(articleData)) {
            LOGGER.info("Article Data is Found");
            articleData.setArticleUserRole(articleAuthorRole);
            articleData.setProduction(getProductionDatesForArticles(articleId
                    .toString()));
        }
        return articleData;
    }

    /**
     * Gets the production dates for articles.
     *
     * @param articleId
     *            the article id
     * @return the production dates for articles
     * @throws Exception
     *             the exception
     */
    private Production getProductionDatesForArticles(final String articleId)
            throws Exception {
        final PdhLookupArticleResponse pdhLookupArticleResponse = esbInterfaceService
                .viewAssignedArticle(articleId);
        Production production = null;
        if (!StringUtils.isEmpty(pdhLookupArticleResponse)) {
            final SimpleDateFormat formatter = new SimpleDateFormat(
                    "dd-MMM-yyyy");
            final Map<Date, String> productionDatesStatus = new TreeMap<Date, String>();
            productionDatesStatus
                    .put(formatter.parse(pdhLookupArticleResponse
                            .getAcceptedDate()), articleAcptdStatus);
            productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
                    .getPublishedDate()), acptdArtPubOnlineStatus);
            productionDatesStatus
                    .put(formatter.parse(pdhLookupArticleResponse
                            .getProofOutDate()), proofsOutStatus);
            productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
                    .getProofReceivedDate()), proofsRcvdStatus);
            productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
                    .getAlertAssociateUnpagpubOnline()), earlyViewStatus);
            production = getProductionDateStatus(formatter,
                    pdhLookupArticleResponse, productionDatesStatus);
        }
        return production;
    }

    /**
     * Gets the production date status.
     *
     * @param formatter
     *            the formatter
     * @param pdhLookupArticleResponse
     *            the pdh lookup article response
     * @param productionDatesStatus
     *            the production dates status
     * @return the production date status
     * @throws Exception
     *             the exception
     */
    private Production getProductionDateStatus(
            final SimpleDateFormat formatter,
            final PdhLookupArticleResponse pdhLookupArticleResponse,
            final Map<Date, String> productionDatesStatus) throws Exception {
        productionDatesStatus
                .put(formatter.parse(pdhLookupArticleResponse
                        .getIssPubOnlineDate()), issPubOnlineStatus);
        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
                .getWithdrawnDateAfterAcceptance()), acptdArtWithdrawnStatus);
        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
                .getProofCorrectionsReceivedDate()), proofsCorrRcvdStatus);
        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
                .getRevisedProofReceivedDate()), articleProofRcvdStatus);
        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
                .getRevisedProofApprovedDate()), articleProofApprovedStatus);
        return getMostProductionDateStatus(productionDatesStatus);
    }

    /**
     * Gets the most production date status.
     *
     * @param productionDatesStatus
     *            the production dates status
     * @return the most production date status
     * @throws Exception
     *             the exception
     */
    private Production getMostProductionDateStatus(
            final Map<Date, String> productionDatesStatus) throws Exception {
        Date mostRecentProductionDate = null;
        String productionStatus = null;
        for (Map.Entry<Date, String> entry : productionDatesStatus.entrySet()) {
            mostRecentProductionDate = entry.getKey();
            productionStatus = productionDatesStatus
                    .get(mostRecentProductionDate);
        }
        Production production = new Production();
        production.setProductionStatusDate(mostRecentProductionDate.toString());
        production.setProductionStatus(productionStatus);
        return production;
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
        final List<ArticleData> articleDataListforPublication = new ArrayList<ArticleData>();
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
                articleData = getPublicationArticleStatus(articleAuthorRole,
                        articleId);
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
     * @param articleAuthorRole
     *            the article author role
     * @param dhId
     *            the dh id
     * @return the publication article status
     * @throws Exception
     *             the exception
     */
    private ArticleData getPublicationArticleStatus(
            final String articleAuthorRole, final Integer dhId)
            throws Exception {
        LOGGER.info("inside getPublicationArticleStatus Method of DashboardServiceImpl");
        final ArticleData articleData = esbInterfaceService
                .getAuthorArticle(dhId);
        if (!StringUtils.isEmpty(articleData)) {
            LOGGER.info("Article Data is Found");
            articleData.setArticleUserRole(articleAuthorRole);
            final Publication publication = new Publication();
            final PublicationStatuses publicationStatuses = dashboardDAO
                    .getPublishedArticleDetails(dhId).getPublicationStatuses();
            if (!StringUtils.isEmpty(publicationStatuses)) {
                LOGGER.info("Publication Statuses Data is Found");
                publication.setPublicationStatus(publicationStatuses
                        .getPublicationStatusName());
                publication.setModifiedDate(publicationStatuses
                        .getUpdatedDate().toString());
            }
            articleData.setPublication(publication);
        }
        return articleData;
    }
}
