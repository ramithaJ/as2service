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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.ArticleData;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.ArticleUserRoleDetails;
import com.wiley.gr.ace.authorservices.model.CommunicationDetails;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardInfo;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.EmailCommunicationHistory;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.OrderPaymentStatus;
import com.wiley.gr.ace.authorservices.model.OrderStatus;
import com.wiley.gr.ace.authorservices.model.PdhArticleData;
import com.wiley.gr.ace.authorservices.model.PdhJournalData;
import com.wiley.gr.ace.authorservices.model.Production;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.external.AffiliationData;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.InterestData;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.OrderDataList;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunderData;
import com.wiley.gr.ace.authorservices.model.external.SocietyData;
import com.wiley.gr.ace.authorservices.model.external.SystemSecurityQuestions;
import com.wiley.gr.ace.authorservices.persistence.entity.CoauthorRequestsOoorders;
import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.DashboardDAO;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;
import com.wiley.gr.ace.authorservices.services.service.LicenseService;
import com.wiley.gr.ace.authorservices.services.service.OrderStatusService;

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

    /** The order onlinedao. */
    @Autowired(required = true)
    private OrderOnlineDAO orderOnlinedao;

    /** The license service. */
    @Autowired(required = true)
    private LicenseService licenseService;

    /** The article acptd status. */
    @Value("${ARTICLE_ACCEPTED}")
    private String articleAcptdStatus;

    // /** The acptd art pub online status. */
    // @Value("${ACCEPTED_ARTICLE_PUBLISHED}")
    // private String acptdArtPubOnlineStatus;

    /** The proofs out status. */
    @Value("${PROOFS_OUT}")
    private String proofsOutStatus;

    /** The proofs rcvd status. */
    @Value("${PROOFS_RCVD}")
    private String proofsRcvdStatus;

    // /** The proofs corr rcvd status. */
    // @Value("${PROOFS_CORRECTION_RCVD}")
    // private String proofsCorrRcvdStatus;
    //
    // /** The early view status. */
    // @Value("${EARLY_VIEW}")
    // private String earlyViewStatus;
    //
    // /** The article online open status. */
    // @Value("${ARTICLE_ONLINE_OPEN}")
    // private String articleOnlineOpenStatus;
    //
    // /** The iss pub online status. */
    // @Value("${ISSUE_PUBLISHED_ONLINE}")
    // private String issPubOnlineStatus;
    //
    // /** The acptd art withdrawn status. */
    // @Value("${ACCEPTED_ARTICLE_WITHDRAWN}")
    // private String acptdArtWithdrawnStatus;
    //
    // /** The article proof rcvd status. */
    // @Value("${ARTICLE_PROOF_RECEIVED}")
    // private String articleProofRcvdStatus;
    //
    // /** The article proof approved status. */
    // @Value("${ARTICLE_PROOF_APPROVED}")
    // private String articleProofApprovedStatus;
    //
    // /** The view full article action. */
    // @Value("${VIEW_FULL_ARTICLE}")
    // private String viewFullArticleAction;
    /**
     * This field holds the value of submitOrderStatus.
     */
    @Value("${SUBMIT_ORDER}")
    private String submitOrderStatus;

    /**
     * This field holds the value of onlineOpenReqRcvd.
     */
    @Value("${ONLINE_OPEN_REQ_RCVD}")
    private String onlineOpenReqRcvd;

    /**
     * This field holds the value of orderservice.
     */
    @Autowired(required = true)
    private OrderService orderservice;

    /**
     * This field holds the value of orderStatus.
     */
    @Autowired(required = true)
    private OrderStatusService orderStatusService;

    /** The order service. */
    @Autowired(required = true)
    private OrderService orderService;

    /**
     * This method is used for get the Profile Information of User from external
     * service called UserProfileService by using userId and returning the
     * Dashboard. In this Dashboard Every Missed Information is set with id and
     * profileMeterMessage of DashboardInfo.If these method unable to call the
     * External Service it will throws an Exception.
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
        if (!StringUtils.isEmpty(userInterestsList)) {
            for (InterestData interestData : userInterestsList) {
                if (StringUtils.isEmpty(interestData)) {
                    LOGGER.info(" Interests List is Empty then No Interests on Dashboard");
                    dashboardInfo = new DashboardInfo();
                    dashboardInfo.setId(interestsId);
                    dashboardInfo.setDashBoardInfoMessage(interestsMessage);
                }
            }
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
        if (!StringUtils.isEmpty(userAffiliationsList)) {
            for (AffiliationData affiliationData : userAffiliationsList) {
                if (StringUtils.isEmpty(affiliationData.getStartDate())) {
                    LOGGER.info(" Affiliations List is Empty then No Affiliations on Dashboard");
                    dashboardInfo = new DashboardInfo();
                    dashboardInfo.setId(affiliationsId);
                    dashboardInfo.setDashBoardInfoMessage(affiliationsMessage);
                }
            }
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
        if (!StringUtils.isEmpty(societyList)) {
            for (SocietyData societyData : societyList) {
                if (StringUtils.isEmpty(societyData.getSocietyId())) {
                    LOGGER.info(" Society List is Empty then No Societies on Dashboard");
                    dashboardInfo = new DashboardInfo();
                    dashboardInfo.setId(societiesId);
                    dashboardInfo.setDashBoardInfoMessage(societiesMessage);
                }
            }
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
        if (!StringUtils.isEmpty(researchFundersList)) {
            for (ResearchFunderData researchFunderData : researchFundersList) {
                if (StringUtils.isEmpty(researchFunderData.getFunderID())) {
                    LOGGER.info(" Funders List is Empty then No Funders on Dashboard");
                    dashboardInfo = new DashboardInfo();
                    dashboardInfo.setId(researchFunderId);
                    dashboardInfo
                            .setDashBoardInfoMessage(researchFunderMessage);
                }
            }
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
     * Gets the all author articles.
     *
     * @param userId
     *            the user id
     * @return the all author articles
     * @throws Exception
     *             the exception
     */
    @Override
    public DashboardView getAllAuthorArticles(String userId) throws Exception {
        DashboardView dashboardView = new DashboardView();
        List<ArticleData> articleDataList = getArticleAuthorData(userId);
        List<ArticleData> viewAllArticles = new ArrayList<ArticleData>();
        for (ArticleData articleData : articleDataList) {
            articleData.setProduction(getProductionDetailsForArticles(
                    articleData.getDhId()).getProduction());
            articleData.setPublication(getPublishedArticleData(
                    articleData.getDhId()).getPublication());
            viewAllArticles.add(articleData);
        }
        dashboardView.setArticleData(viewAllArticles);
        return dashboardView;
    }

    /**
     * Action required.
     *
     * @param userId
     *            the user id
     * @return the dashboard view
     * @throws Exception
     *             the exception
     */
    @Override
    public final DashboardView actionRequired(final String userId)
            throws Exception {
        LOGGER.info("inside viewDashboard Method of DashboardServiceImpl");
        final DashboardView dashboardView = new DashboardView();
        dashboardView.setArticleData(getArticleAuthorData(userId));
        return dashboardView;
    }

    /**
     * Gets the all articles for user.
     *
     * @param userId
     *            the user id
     * @return the all articles for user
     */
    private Map<Integer, ArticleUserRoleDetails> getAllArticlesForUser(
            final String userId) {
        final List<ProductPersonRelations> productPersonRelationsList = dashboardDAO
                .getProductPersonRelations(userId);
        ArticleUserRoleDetails articleUserRoleDetails = null;
        Map<Integer, ArticleUserRoleDetails> articleMap = new HashMap<Integer, ArticleUserRoleDetails>();
        if (!StringUtils.isEmpty(productPersonRelationsList)) {
            for (ProductPersonRelations productPersonRelations : productPersonRelationsList) {
                articleUserRoleDetails = new ArticleUserRoleDetails();
                articleUserRoleDetails.setRoleCode(productPersonRelations
                        .getProducts().getDhTypeCd());
                articleUserRoleDetails.setRoleName(productPersonRelations
                        .getProductRoles().getProductRoleName());
                articleMap.put(productPersonRelations.getProducts().getDhId(),
                        articleUserRoleDetails);
            }
        }
        return articleMap;
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
        Map<Integer, ArticleUserRoleDetails> articleDetailsMap = getAllArticlesForUser(userId);
        for (Map.Entry<Integer, ArticleUserRoleDetails> articleInfo : articleDetailsMap
                .entrySet()) {
            Integer dhId = articleInfo.getKey();
            ArticleUserRoleDetails articleUserRoleDetails = articleDetailsMap
                    .get(dhId);
            if (!StringUtils.isEmpty(dhId)
                    && "Article".equalsIgnoreCase(articleUserRoleDetails
                            .getRoleCode())) {
                articleData = getArticleDataForUser(dhId, userId);
                articleData.setArticleUserRole(articleUserRoleDetails
                        .getRoleName());
                articleDataList.add(articleData);
            }
        }
        return articleDataList;
    }

    /**
     * Gets the article data for user.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the article data for user
     * @throws Exception
     *             the exception
     */
    private ArticleData getArticleDataForUser(final Integer dhId, String userId)
            throws Exception {
        PdhArticleData pdhArticleData = (PdhArticleData) esbInterfaceService
                .getPdhLookupResponse(String.valueOf(dhId));
        ArticleData articleData = null;
        if (!StringUtils.isEmpty(pdhArticleData)) {
            LOGGER.info("pdhLookupArticle Data is found");
            if ("Y".equalsIgnoreCase(pdhArticleData.getIsInvitedInAs())) {
                articleData = new ArticleData();
                articleData
                        .setArticleDetails(parseArticleDetails(pdhArticleData));
                articleData.setJournal(getJournalDetails(pdhArticleData
                        .getJournalDhId()));
                articleData.setTrackLicense(licenseService.trackLicenseStatus(
                        String.valueOf(dhId), userId));
                HashMap<String, OrderStatus> orderStatusHashMap = orderStatusHasMap(userId);
                articleData
                        .setOrderPaymentStatus(getOrderPaymentStatusForArticle(
                                orderStatusHashMap, dhId));
            }
        }
        return articleData;
    }

    /**
     * Gets the journal details.
     *
     * @param journalDhId
     *            the journal dh id
     * @return the journal details
     * @throws Exception
     *             the exception
     */
    private JournalDetails getJournalDetails(final String journalDhId)
            throws Exception {
        PdhJournalData pdhJournalData = (PdhJournalData) esbInterfaceService
                .getPdhLookupResponse(journalDhId);
        JournalDetails journalDetails = null;
        if (!StringUtils.isEmpty(pdhJournalData)) {
            journalDetails = new JournalDetails();
            journalDetails.setDhId(pdhJournalData.getDhId());
            journalDetails.setJournalId(pdhJournalData.geteJournalCode());
            journalDetails.setJournalTitle(pdhJournalData.getJournalTitle());
            journalDetails.setBannerImageLink(pdhJournalData
                    .getBannerImageLink());
            journalDetails
                    .setCoverImageLink(pdhJournalData.getCoverImageLink());
        }
        return journalDetails;
    }

    /**
     * Parses the article details.
     *
     * @param pdhArticleData
     *            the pdh article data
     * @return the article details
     * @throws Exception
     *             the exception
     */
    private ArticleDetails parseArticleDetails(
            final PdhArticleData pdhArticleData) throws Exception {
        ArticleDetails articleDetails = new ArticleDetails();
        articleDetails.setDhId(pdhArticleData.getDhId());
        articleDetails.setArticleId(pdhArticleData.getArticleId());
        articleDetails.setArticleTitle(pdhArticleData.getTitle());
        articleDetails.setArticleType(pdhArticleData.getArticleType());
        articleDetails.setAcceptanceDate(pdhArticleData.getAcceptedDate()
                .toString());
        articleDetails.setArticleAuthorName(pdhArticleData.getAuthorName());
        articleDetails.setArticleCoAuthors(pdhArticleData.getCoAuthors());
        articleDetails.setArticleDOI(pdhArticleData.getArticleDoi());
        return articleDetails;
    }

    /**
     * HashMap contains article Id's of saved orders and coAuthorRequestOOOrders
     * tables.
     * 
     * @param userId
     *            - the request value
     * @return hashMap
     */
    private HashMap<String, OrderStatus> orderStatusHasMap(final String userId) {

        // calling saved orders table
        List<SavedOrders> savedOrdersList = orderOnlinedao
                .getUserSavedOrders(userId);
        OrderStatus orderStatus = new OrderStatus();
        HashMap<String, OrderStatus> satusHashMap = new HashMap<String, OrderStatus>();

        if (null != savedOrdersList) {
            String[] statusArray = submitOrderStatus.split(":");
            orderStatus.setStatus(statusArray[0]);
            orderStatus.setActionsRequired(statusArray[1]);
            // order status HashMap
            for (SavedOrders savedOrders : savedOrdersList) {
                satusHashMap.put(
                        String.valueOf(savedOrders.getProducts().getDhId()),
                        orderStatus);
            }
        }
        // calling Co_Author Request OO Orders table
        List<CoauthorRequestsOoorders> coauthorRequestsOoordersList = orderOnlinedao
                .getcoAuthorReqOO(userId);

        if (null != coauthorRequestsOoordersList) {
            String[] orderStatusArray = onlineOpenReqRcvd.split(":");
            orderStatus.setStatus(orderStatusArray[0]);
            orderStatus.setActionsRequired(orderStatusArray[1]);
            for (CoauthorRequestsOoorders coauthorRequestsOoorders : coauthorRequestsOoordersList) {
                satusHashMap.put(String.valueOf(coauthorRequestsOoorders
                        .getProducts().getDhId()), orderStatus);
            }
        }

        // calling View All Orders external Service
        OrderDataList ordersData = orderservice.getAllOrders(userId);

        if (null != ordersData) {
            List<OrderData> orderDataList = ordersData.getOrderDatas();
            for (OrderData orderData : orderDataList) {
                // Taking the hashMap from orderStatusServiceImpl class
                HashMap<String, OrderStatus> orderStatusHashMap = orderStatusService
                        .getOrderStatusMap();
                if (orderStatusHashMap.containsKey(orderData
                        .getOrderStatusCode())) {
                    satusHashMap.put(orderData.getArticle().getDhId(),
                            orderStatusHashMap.get(orderData
                                    .getOrderStatusCode()));
                }
            }

        }
        System.err.println(satusHashMap.toString());
        return satusHashMap;
    }

    /**
     * Gets the license status for article.
     *
     * @param orderStatusHashMap
     *            the order status hash map
     * @param articleId
     *            the article id
     * @return the license status for article
     * @throws Exception
     *             the exception
     */
    private OrderPaymentStatus getOrderPaymentStatusForArticle(
            final HashMap<String, OrderStatus> orderStatusHashMap,
            final Integer articleId) throws Exception {
        // TODO: Order status
        LOGGER.info("inside getOrderPaymentStatusForArticle Method of DashboardServiceImpl");
        OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus();
        if (orderStatusHashMap.containsKey(String.valueOf(articleId))) {

            OrderStatus orderStatus = orderStatusHashMap.get(String
                    .valueOf(articleId));
            orderPaymentStatus.setOrderStatus(orderStatus.getStatus());
            String[] actionArray = orderStatus.getActionsRequired().split(",");
            List<String> availableActionsList = new ArrayList<String>();
            for (String action : actionArray) {
                if (!"None".equalsIgnoreCase(action)) {
                    availableActionsList.add(action);
                }
            }
            orderPaymentStatus.setAvailableActionsList(availableActionsList);
            // TODO: set date to additional param
            orderPaymentStatus.setAdditionalParam("");
            return orderPaymentStatus;
        }

        // calling get Quote external service
        // get Quote request object.
        QuoteRequest quoteRequest = new QuoteRequest();
        Article article = new Article();
        article.setArticleID(String.valueOf(articleId));
        article.setJournalElectronicISSN(""); // TODO
        article.setJournalPrintISSN(""); // TODO
        quoteRequest.setArticle(article);
        quoteRequest.setRequestCreatedTimestamp(""); // TODO
        quoteRequest.setRequestType(""); // TODO

        Quote quote = orderService.getQuote(quoteRequest);
        return openAccessStatus(quote);

        // String openAccessStatus = esbInterfaceService.getOpenAccessStatus(
        // articleId).getOpenAccessStatus();
        // if (!StringUtils.isEmpty(openAccessStatus)) {
        // LOGGER.info("Open Access Status is Found");
        // orderPaymentStatus.setOpenAccessStatus(openAccessStatus);
        // }
        // final String onlineOpenStatus = esbInterfaceService
        // .getOnlineOpenStatus(articleId).getOnlineOpenStatus();
        // if (!StringUtils.isEmpty(onlineOpenStatus)) {
        // LOGGER.info("Open Order Status is Found");
        // orderPaymentStatus.setOnlineOpenStatus(onlineOpenStatus);
        // }
        // return orderPaymentStatus;
    }

    /**
     * Open access status.
     *
     * @param quote
     *            the quote
     * @return the order payment status
     */
    private OrderPaymentStatus openAccessStatus(final Quote quote) {

        OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus();
        if ("AP".equalsIgnoreCase(quote.getQuoteType())
                && "APPROVED".equalsIgnoreCase(quote.getQuoteStatus())) {
            return setOAAvailableActions("MAKE_PAYMENT_STATUS_TEXT:PAYMENT_DUE_ACTION_TEXT");
        }
        if ("FI".equalsIgnoreCase(quote.getQuoteType())
                && "APPROVED".equalsIgnoreCase(quote.getQuoteStatus())) {
            return setOAAvailableActions("PAYMENT_COVERED_STATUS_TEXT:None");
        }
        if ("FI".equalsIgnoreCase(quote.getQuoteType())
                && "Denied".equalsIgnoreCase(quote.getQuoteStatus())) {
            return setOAAvailableActions("FUND_DENIED_STATUS_TEXT:CONTACT_WILEY_SUPPORT_ACTION_TEXT");
        }
        if ("Withdrawn".equalsIgnoreCase(quote.getQuoteStatus())) {
            return setOAAvailableActions("ARTICLE_WITHDRAWN_STATUS_TEXT:None");
        }
        return orderPaymentStatus;
    }

    /**
     * Sets the oa available actions.
     *
     * @param status
     *            the status
     * @return the order payment status
     */
    private OrderPaymentStatus setOAAvailableActions(final String status) {

        OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus();
        StringTokenizer stringTokenizer = new StringTokenizer(status, ":");
        orderPaymentStatus.setOrderType("OA");
        orderPaymentStatus.setOrderStatus(stringTokenizer.nextElement()
                .toString());
        String[] actionsArray = stringTokenizer.nextElement().toString()
                .split(",");
        List<String> availableActionsArray = new ArrayList<String>();
        for (String action : actionsArray) {
            if (!"None".equalsIgnoreCase(action)) {
                availableActionsArray.add(action);
            }
        }
        // TODO: we need to set date here
        orderPaymentStatus.setAdditionalParam("");
        orderPaymentStatus.setAvailableActionsList(availableActionsArray);
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
        DashboardView dashboardView = new DashboardView();
        List<ArticleData> articleDataListForProduction = new ArrayList<ArticleData>();
        ArticleData articleDataForProduction = null;
        Map<Integer, ArticleUserRoleDetails> articleDetailsMap = getAllArticlesForUser(userId);
        for (Map.Entry<Integer, ArticleUserRoleDetails> articleInfo : articleDetailsMap
                .entrySet()) {
            Integer dhId = articleInfo.getKey();
            ArticleUserRoleDetails articleUserRoleDetails = articleDetailsMap
                    .get(dhId);
            if (!StringUtils.isEmpty(dhId)
                    && "Article".equalsIgnoreCase(articleUserRoleDetails
                            .getRoleCode())) {
                articleDataForProduction = getProductionDetailsForArticles(String
                        .valueOf(dhId));
                articleDataForProduction
                        .setArticleUserRole(articleUserRoleDetails
                                .getRoleName());
                articleDataListForProduction.add(articleDataForProduction);
            }
        }
        dashboardView.setArticleData(articleDataListForProduction);
        return dashboardView;
    }

    /**
     * Gets the production details for articles.
     *
     * @param dhId
     *            the dh id
     * @return the production details for articles
     * @throws Exception
     *             the exception
     */
    private ArticleData getProductionDetailsForArticles(final String dhId)
            throws Exception {
        LOGGER.info("inside getProductionDetailsForArticles Method of DashboardServiceImpl");
        PdhArticleData pdhArticleData = (PdhArticleData) esbInterfaceService
                .getPdhLookupResponse(dhId);
        ArticleData articleDataForProduction = null;
        if (!StringUtils.isEmpty(pdhArticleData)) {
            LOGGER.info("Article Data is Found");
            if ("Y".equalsIgnoreCase(pdhArticleData.getIsInvitedInAs())) {
                articleDataForProduction = new ArticleData();
                articleDataForProduction
                        .setArticleDetails(parseArticleDetails(pdhArticleData));
                articleDataForProduction
                        .setJournal(getJournalDetails(pdhArticleData
                                .getJournalDhId()));
                articleDataForProduction
                        .setProduction(parseDatesForProduction(pdhArticleData));
            }
        }
        return articleDataForProduction;
    }

    /**
     * Parses the dates for production.
     *
     * @param pdhArticleData
     *            the pdh article data
     * @return the production
     * @throws Exception
     *             the exception
     */
    private Production parseDatesForProduction(
            final PdhArticleData pdhArticleData) throws Exception {
        Map<Date, String> productionDatesStatus = new TreeMap<Date, String>();
        productionDatesStatus.put(pdhArticleData.getAcceptedDate(),
                articleAcptdStatus);
        productionDatesStatus.put(pdhArticleData.getProofRcvdDate(),
                proofsRcvdStatus);
        productionDatesStatus.put(pdhArticleData.getProofOutDate(),
                proofsOutStatus);
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
        LOGGER.info("inside getProductionDateStatus Method of DashboardServiceImpl");
        for (Map.Entry<Date, String> entry : productionDatesStatus.entrySet()) {
            mostRecentProductionDate = entry.getKey();
            productionStatus = productionDatesStatus
                    .get(mostRecentProductionDate);
        }
        return trackingProductionStatusActions(mostRecentProductionDate,
                productionStatus);
    }

    /**
     * Tracking production status actions.
     *
     * @param mostRecentProductionDate
     *            the most recent production date
     * @param productionStatus
     *            the production status
     * @return the production
     */
    private Production trackingProductionStatusActions(
            final Date mostRecentProductionDate, final String productionStatus) {
        Production production = new Production();
        LOGGER.info("Getting Most Recent Date Among All Production Stages Dates and Setting Production Status,Actions");
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
        ArticleData publishedArticleData = null;
        List<ArticleData> articleDataListforPublication = new ArrayList<ArticleData>();
        Map<Integer, ArticleUserRoleDetails> articleDetailsMap = getAllArticlesForUser(userId);
        for (Map.Entry<Integer, ArticleUserRoleDetails> articleInfo : articleDetailsMap
                .entrySet()) {
            Integer dhId = articleInfo.getKey();
            ArticleUserRoleDetails articleUserRoleDetails = articleDetailsMap
                    .get(dhId);
            if (!StringUtils.isEmpty(dhId)
                    && "Article".equalsIgnoreCase(articleUserRoleDetails
                            .getRoleCode())) {
                publishedArticleData = getPublishedArticleData(String
                        .valueOf(dhId));
                publishedArticleData.setArticleUserRole(articleUserRoleDetails
                        .getRoleName());
                articleDataListforPublication.add(publishedArticleData);
            }
            dashboardView = new DashboardView();
            dashboardView.setArticleData(articleDataListforPublication);
        }
        return dashboardView;
    }

    /**
     * Gets the published article data.
     *
     * @param dhId
     *            the dh id
     * @return the published article data
     * @throws Exception
     *             the exception
     */
    private ArticleData getPublishedArticleData(final String dhId)
            throws Exception {
        PdhArticleData pdhArticleData = (PdhArticleData) esbInterfaceService
                .getPdhLookupResponse(dhId);
        ArticleData publishedArticleData = null;
        if (!StringUtils.isEmpty(pdhArticleData)) {
            LOGGER.info("Article Data is Found");
            if ("Y".equalsIgnoreCase(pdhArticleData.getIsInvitedInAs())) {
                publishedArticleData = new ArticleData();
                publishedArticleData
                        .setArticleDetails(parseArticleDetails(pdhArticleData));
                publishedArticleData
                        .setJournal(getJournalDetails(pdhArticleData
                                .getJournalDhId()));
                publishedArticleData
                        .setPublication(getPublicationArticleStatus());
            }
        }
        return publishedArticleData;
    }

    /**
     * Gets the publication article status.
     *
     * @return the publication article status
     * @throws Exception
     *             the exception
     */
    private PublicationDetails getPublicationArticleStatus() throws Exception {
        LOGGER.info("inside getPublicationArticleStatus Method of DashboardServiceImpl");
        PublicationDetails publication = new PublicationDetails();
        if (!StringUtils.isEmpty(publication)) {
            LOGGER.info("Publication Statuses Data is Found");
            publication.setModifiedDate("2015-08-28T14:06:31Z");
            publication.setPublicationStatus("Make OO");
        }
        return publication;
    }
}
