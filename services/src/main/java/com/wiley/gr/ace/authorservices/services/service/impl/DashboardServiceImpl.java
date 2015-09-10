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

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
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
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.OrderPaymentStatus;
import com.wiley.gr.ace.authorservices.model.OrderStatus;
import com.wiley.gr.ace.authorservices.model.Production;
import com.wiley.gr.ace.authorservices.model.PublicationDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.TrackLicense;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.Identifier;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.OrderDataList;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournal;
import com.wiley.gr.ace.authorservices.model.external.ProductContributor;
import com.wiley.gr.ace.authorservices.model.external.ProductDates;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestion;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.Title;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.persistence.entity.CoauthorRequestsOoorders;
import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.DashboardDAO;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;
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

    /** The article assignment service. */
    @Autowired(required = true)
    private ArticleAssignmentService articleAssignmentService;

    /** The order onlinedao. */
    @Autowired(required = true)
    private OrderOnlineDAO orderOnlinedao;

    /** The license service. */
    @Autowired(required = true)
    private LicenseService licenseService;

    /** The article acptd status. */
    @Value("${ARTICLE_ACCEPTED}")
    private String articleAcptdStatus;

    /** The acptd art pub online status. */
    @Value("${ACCEPTED_ARTICLE_PUBLISHED}")
    private String acptdArtPubOnlineStatus;

    /** The proofs out status. */
    @Value("${PROOFS_OUT}")
    private String proofsOutStatus;

    /** The proofs rcvd status. */
    @Value("${PROOFS_RCVD}")
    private String proofsRcvdStatus;

    /** The proofs corr rcvd status. */
    @Value("${PROOFS_CORRECTION_RCVD}")
    private String proofsCorrRcvdStatus;

    /** The early view status. */
    @Value("${EARLY_VIEW}")
    private String earlyViewStatus;

    /** The article online open status. */
    @Value("${ARTICLE_ONLINE_OPEN}")
    private String articleOnlineOpenStatus;

    /** The iss pub online status. */
    @Value("${ISSUE_PUBLISHED_ONLINE}")
    private String issPubOnlineStatus;

    /** The acptd art withdrawn status. */
    @Value("${ACCEPTED_ARTICLE_WITHDRAWN}")
    private String acptdArtWithdrawnStatus;

    /** The article proof rcvd status. */
    @Value("${ARTICLE_PROOF_RECEIVED}")
    private String articleProofRcvdStatus;

    /** The article proof approved status. */
    @Value("${ARTICLE_PROOF_APPROVED}")
    private String articleProofApprovedStatus;

    /** The view full article action. */
    @Value("${VIEW_FULL_ARTICLE}")
    private String viewFullArticleAction;
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
//            articleData.setProduction(getProductionDetailsForArticles(articleData
//                    .getDhId()));
//            articleData.setPublicationDetails(getPublicationArticleStatus(
//                    articleData.getArticleUserRole(), articleData.getDhId())
//                    .getPublicationDetails());
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

    private Map<Integer,String> getAllArticlesForUser(final String userId){
        final List<ProductPersonRelations> productPersonRelationsList = dashboardDAO
                .getProductPersonRelations(userId);
        Map<Integer, String> articleMap=new HashMap<>();
        if (!StringUtils.isEmpty(productPersonRelationsList)) {
            for(ProductPersonRelations productPersonRelations:productPersonRelationsList){
                articleMap.put(productPersonRelations.getProducts().getDhId(), productPersonRelations.getProducts().getDhTypeCd());
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
        Map<Integer,String> articleDetailsMap=getAllArticlesForUser(userId);
        for (Map.Entry<Integer, String> articleInfo : articleDetailsMap.entrySet()) {
            Integer dhId=articleInfo.getKey();
            String dhTypeCode=articleDetailsMap.get(dhId);
            if (!StringUtils.isEmpty(dhId)
                    && "Article".equalsIgnoreCase(dhTypeCode)){
            HashMap<String, OrderStatus> orderStatusHashMap = orderStatusHasMap(userId);
                articleData = getArticleDataForUser(dhId,orderStatusHashMap, userId);
                articleDataList.add(articleData);
            }
        }
        return articleDataList;
    }

    
    private ArticleData getArticleDataForUser(
            final Integer articleId,final HashMap<String, OrderStatus> orderStatusHashMap,final String userId)
            throws Exception {
        ArticleData articleData = getPdhArticleData(articleId);
        TrackLicense trackLicense=licenseService
                .trackLicenseStatus(String.valueOf(articleId), userId);
        if(!StringUtils.isEmpty(trackLicense)){
                articleData.setTrackLicense(licenseService
                        .trackLicenseStatus(String.valueOf(articleId), userId));
        }
                articleData.setOrderPaymentStatus(getOrderPaymentStatusForArticle(orderStatusHashMap,articleId));
          
      
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
    private JournalDetails getJournalDetails() throws Exception {
        PdhLookupJournal pdhLookupJournal = (PdhLookupJournal) esbInterfaceService
                .getPdhLookupResponse("6839245");
        List<Title> titleList = pdhLookupJournal.getJournalProductEntities()
                .getTitle();
        JournalDetails journalDetails = null;
        if (!StringUtils.isEmpty(titleList)) {
            for (Title title : titleList) {
                if ("8118618".equals(title.getTitleDhId())) {
                    journalDetails = new JournalDetails();
                    journalDetails.setJournalTitle(title.getTitleText());
                }
            }
        }
        return journalDetails;
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
                            .getProdDtDateValue().toString());
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
     * Gets the order payment status for article.
     *
     * @param orderStatusHashMap
     *            the order status hash map
     * @param articleId
     *            the article id
     * @return the order payment status for article
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
        DashboardView dashboardView =new DashboardView();
        List<ArticleData> articleDataListForProduction = new ArrayList<ArticleData>();
        ArticleData articleDataForProduction = null;
        Map<Integer,String> articleDetailsMap=getAllArticlesForUser(userId);
        for (Map.Entry<Integer, String> articleInfo : articleDetailsMap.entrySet()) {
            Integer dhId=articleInfo.getKey();
            String dhTypeCode=articleDetailsMap.get(dhId);
            if (!StringUtils.isEmpty(dhId)
                    && "Article".equalsIgnoreCase(dhTypeCode)){
                articleDataForProduction =getProductionDetailsForArticles(dhId);
                articleDataListForProduction.add(articleDataForProduction);
            }
        }
        dashboardView.setArticleData(articleDataListForProduction);
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
    private ArticleData getProductionDetailsForArticles(final Integer dhId)
            throws Exception {
        LOGGER.info("inside getProductionDetailsForArticles Method of DashboardServiceImpl");
        PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) esbInterfaceService
                .getPdhLookupResponse(String.valueOf(dhId));
        ArticleData articleDataForProduction = null;
        if (!StringUtils.isEmpty(pdhLookupArticle)) {
            LOGGER.info("Article Data is Found");
            articleDataForProduction = new ArticleData();
            articleDataForProduction
                    .setArticleUserRole(getArticleAuthorRole(pdhLookupArticle));
            articleDataForProduction
                    .setArticleDetails(parseArticleDetails(pdhLookupArticle));
            articleDataForProduction.setJournal(getJournalDetails());
            articleDataForProduction.setProduction(parseDatesForProduction(pdhLookupArticle));
        }
        return articleDataForProduction;
    }

    private Production parseDatesForProduction(final PdhLookupArticle pdhLookupArticle) throws Exception{
        List<ProductDates> productDatesList=pdhLookupArticle.getArticleProductEntities().getProductDates();
        Map<Date, String> productionDatesStatus = new TreeMap<Date, String>();
        if(!StringUtils.isEmpty(productDatesList)){
            for(ProductDates productDates : productDatesList){
                productionDatesStatus.put(productDates.getProdDtDateValue(), productDates.getDhDateTypeCd());
            }
        }
        return getMostProductionDateStatus(productionDatesStatus);
    }
    
//    private Production getProductionDatesForArticles(final PdhLookupArticle pdhLookupArticle)
//            throws Exception {
//        LOGGER.info("inside getProductionDatesForArticles Method of DashboardServiceImpl");
//        final PdhLookupArticleResponse pdhLookupArticleResponse = esbInterfaceService
//                .viewAssignedArticle(articleId);
//        Production production = null;
//        if (!StringUtils.isEmpty(pdhLookupArticleResponse)) {
//            LOGGER.info("PDH Lookup Article Response data is Found");
//            final SimpleDateFormat formatter = new SimpleDateFormat(
//                    "dd-MMM-yyyy");
//            final Map<Date, String> productionDatesStatus = new TreeMap<Date, String>();
//            LOGGER.info("Getting the Production Dates and setting the Status From dotCMS ");
//            productionDatesStatus
//                    .put(formatter.parse(pdhLookupArticleResponse
//                            .getAcceptedDate()), articleAcptdStatus);
//            productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                    .getPublishedDate()), acptdArtPubOnlineStatus);
//            productionDatesStatus
//                    .put(formatter.parse(pdhLookupArticleResponse
//                            .getProofOutDate()), proofsOutStatus);
//            productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                    .getProofReceivedDate()), proofsRcvdStatus);
//            productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                    .getAlertAssociateUnpagpubOnline()), earlyViewStatus);
//            production = getProductionDateStatus(formatter,
//                    pdhLookupArticleResponse, productionDatesStatus);
//        }
//        return production;
//    }
//
//    /**
//     * Gets the production date status.
//     *
//     * @param formatter
//     *            the formatter
//     * @param pdhLookupArticleResponse
//     *            the pdh lookup article response
//     * @param productionDatesStatus
//     *            the production dates status
//     * @return the production date status
//     * @throws Exception
//     *             the exception
//     */
//    private Production getProductionDateStatus(
//            final SimpleDateFormat formatter,
//            final PdhLookupArticleResponse pdhLookupArticleResponse,
//            final Map<Date, String> productionDatesStatus) throws Exception {
//        LOGGER.info("inside getProductionDateStatus Method of DashboardServiceImpl");
//        LOGGER.info("Getting the Production Dates and setting the Status From dotCMS ");
//        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                .getArticleAcceptedInOO()), articleOnlineOpenStatus);
//        productionDatesStatus
//                .put(formatter.parse(pdhLookupArticleResponse
//                        .getIssPubOnlineDate()), issPubOnlineStatus);
//        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                .getWithdrawnDateAfterAcceptance()), acptdArtWithdrawnStatus);
//        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                .getProofCorrectionsReceivedDate()), proofsCorrRcvdStatus);
//        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                .getRevisedProofReceivedDate()), articleProofRcvdStatus);
//        productionDatesStatus.put(formatter.parse(pdhLookupArticleResponse
//                .getRevisedProofApprovedDate()), articleProofApprovedStatus);
//        return getMostProductionDateStatus(productionDatesStatus);
//    }

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
        if ("ART_ACC_DT".equals(productionStatus)) {
            production.setProductionStatus(articleAcptdStatus);
            production.setProductionStatusDate(mostRecentProductionDate.toString());
        } else if ("ART_PRFRCVD_DT".equals(productionStatus)) {
            production.setProductionStatus(articleProofRcvdStatus);
        }
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
        Map<Integer,String> articleDetailsMap=getAllArticlesForUser(userId);
        for (Map.Entry<Integer, String> articleInfo : articleDetailsMap.entrySet()) {
            Integer dhId=articleInfo.getKey();
            String dhTypeCode=articleDetailsMap.get(dhId);
            if (!StringUtils.isEmpty(dhId)
                    && "Article".equalsIgnoreCase(dhTypeCode)){
                publishedArticleData = getPublishedArticleDetails(dhId);
                articleDataListforPublication.add(publishedArticleData);
            }
            dashboardView = new DashboardView();
            dashboardView.setArticleData(articleDataListforPublication);
        }
        return dashboardView;
    }


    private ArticleData getPublishedArticleDetails(final Integer dhId) throws Exception{
        PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) esbInterfaceService
                .getPdhLookupResponse(String.valueOf(dhId));
        ArticleData publishedArticleData= new ArticleData();
        if (!StringUtils.isEmpty(pdhLookupArticle)) {
            LOGGER.info("Article Data is Found");
            publishedArticleData = new ArticleData();
            publishedArticleData
                    .setArticleUserRole(getArticleAuthorRole(pdhLookupArticle));
            publishedArticleData
                    .setArticleDetails(parseArticleDetails(pdhLookupArticle));
            publishedArticleData.setJournal(getJournalDetails());  
            publishedArticleData.setPublicationDetails(getPublicationArticleStatus(dhId));
        }
        return publishedArticleData;
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
    private PublicationDetails getPublicationArticleStatus(
            final Integer articleId) throws Exception {
        LOGGER.info("inside getPublicationArticleStatus Method of DashboardServiceImpl");
            PublicationDetails publicationDetails = articleAssignmentService
                    .viewAssignedArticle(String.valueOf(articleId)).getPublicationData();
            PublicationDetails publication=null;
            if (!StringUtils.isEmpty(publicationDetails)) {
                LOGGER.info("Publication Statuses Data is Found");
                publication=new PublicationDetails();
                publication.setPublicationStatus(publicationDetails
                        .getPublicationStatus());
                publication.setModifiedDate(publicationDetails
                        .getModifiedDate());
            }
        return publication;
    }
}
