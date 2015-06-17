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
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardInfo;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.OrderPaymentStatus;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestion;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;

/**
 * This DashboardServiceImpl is for providing service for viewing the Dashboard
 * of Corresponding Author and Co-Author.
 * 
 * @author virtusa version 1.0
 */
public class DashboardServiceImpl implements DashboardService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DashboardServiceImpl.class);
	@Autowired(required = true)
	private UserProfiles userProfileService;
	@Autowired(required = true)
	private UserManagement userManagementService;
	@Autowired(required = true)
	private ESBInterfaceService esbInterfaceService;

	/**
	 * This method is used for get the Profile Information of User from external
	 * service called UserProfileService by using userId and returning the
	 * Dashboard. In this Dashboard Every Missed Information is set with id and
	 * profileMeterMessage of DashboardInfo.If these method unable to call the
	 * External Service it will throws an Exception.
	 * 
	 * @param userId
	 * @return DashBoard
	 * @throws Exception
	 */
	public Dashboard getProfileMeter(String userId) throws Exception {
		LOGGER.info("inside getProfileMeter Method of DashboardServiceImpl");
		Dashboard dashBoard = new Dashboard();
		List<DashboardInfo> dashBoardInfoList;
		UserProfileResponse userProfileResponse = userProfileService
				.getUserProfileResponse(userId);
		UserProfile userProfile = userProfileResponse.getCustomerProfile();
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
	 * @return DashboardInfo
	 * @throws Exception
	 */
	private DashboardInfo getSecurityDetailsForUser(String emailId)
			throws Exception {
		LOGGER.info("inside getSecurityDetailsForUser Method of DashboardServiceImpl");
		SecuirtyQuestionDetails secuirtyQuestionDetails = userManagementService
				.getSecurityQuestionDetails(emailId);
		DashboardInfo dashboardInfo = null;
		if (!StringUtils.isEmpty(secuirtyQuestionDetails)) {
			SecurityQuestions securityQuestions = secuirtyQuestionDetails
					.getSecurityQuestions();
			List<SecurityQuestion> securityQuestionList = securityQuestions
					.getSecurityQuestion();
			if (!StringUtils.isEmpty(securityQuestionList)) {
				for (SecurityQuestion securityQuestion : securityQuestionList) {
					if (StringUtils.isEmpty(securityQuestion.getQuestion())
							|| StringUtils
									.isEmpty(securityQuestion.getAnswer())) {
						dashboardInfo = new DashboardInfo();
						dashboardInfo.setId("security"); // TODO: fetch the id
															// from contant or
															// properties
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
	 * This method will check the each and every profile meter information of
	 * dashboardInfo is empty or not.If dashboardInfo object is empty then add
	 * to the list of dashboardInfoList then return otherwise if not empty then
	 * not added to the dashboardInfoList
	 * 
	 * @param userProfile
	 * @return List<DashboardInfo>
	 * @throws Exception
	 */
	private List<DashboardInfo> checkingDashboardInfo(UserProfile userProfile)
			throws Exception {
		LOGGER.info("inside checkingDashBoardInfo Method of DashboardServiceImpl");
		DashboardInfo dashboardInfo = null;
		List<DashboardInfo> dashboardInfoList = new ArrayList<DashboardInfo>();
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
	 * @return dashboardInfo
	 */
	private DashboardInfo getInterestsForUser(UserProfile userProfile) {
		LOGGER.info("inside getInterestsForUser Method of DashboardServiceImpl");
		List<Interests> userInterestsList = userProfile.getInterests();
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
	 * @return dashboardInfo
	 */
	private DashboardInfo getAffiliationsForUser(UserProfile userProfile) {
		LOGGER.info("inside getAffiliationsForUser Method of DashboardServiceImpl");
		List<Affiliation> userAffiliationsList = userProfile.getAffiliations();
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
	 * @return dashboardInfo
	 */
	private DashboardInfo getSocietiesForUser(UserProfile userProfile) {
		LOGGER.info("inside getSocietiesForUser Method of DashboardServiceImpl");
		List<Society> societyList = userProfile.getSocieties();
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
	 * @return dashboardInfo
	 */
	private DashboardInfo getFundersListForUser(UserProfile userProfile) {
		LOGGER.info("inside getFundersListForUser Method of DashboardServiceImpl");
		List<ResearchFunder> researchFundersList = userProfile
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
	 * @return dashboardInfo
	 */
	private DashboardInfo getRecoveryEmailAddr(User user) throws Exception {
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
	 * @return dashboardInfo
	 */
	private DashboardInfo getOrcidId(User user) {
		LOGGER.info("inside getOrcidId Method of DashboardServiceImpl");
		DashboardInfo dashboardInfo = null;
		if (StringUtils.isEmpty(user.getOrcidID())) {
			dashboardInfo = new DashboardInfo();
			dashboardInfo.setId("orcid");
			dashboardInfo.setDashBoardInfoMessage("No Orcid ID");
		}
		return dashboardInfo;
	}

	@Override
	public DashboardView viewDashboard(String userId) throws Exception {
		DashboardView dashboardView = new DashboardView();
		List<ArticleData> articleDataList=getArticleDataDetails(userId);
		System.err.println(articleDataList.get(0).getLicenseStatus());
		dashboardView.setArticleData(getArticleDataDetails(userId));
		dashboardView.setCommunicationDetails(esbInterfaceService
				.getCommunicationDetails(userId));
		dashboardView.setArticleCitationRecord(esbInterfaceService
				.getArticleCitationReadRecords(userId)
				.getArticleCitationRecord());
		dashboardView.setArticleReadRecord(esbInterfaceService
				.getArticleCitationReadRecords(userId).getArticleReadRecord());
		return dashboardView;
	}

	private List<ArticleData> getArticleDataDetails(String userId)
			throws Exception {
		List<ArticleData> articleDataList = esbInterfaceService
				.getAllAuthorArticles(userId);
		if (!StringUtils.isEmpty(articleDataList)) {
			for (ArticleData articleData : articleDataList) {
				articleData.setLicenseStatus(esbInterfaceService
						.getLicenseStatus(
								articleData.getArticleDetails().getArticleId())
						.getLicenseStatus());
				articleData
						.setOrderPaymentStatus(getOrderPaymentStatusForArticle(articleData
								.getArticleDetails().getArticleId()));
				articleData.setProductionStatus(esbInterfaceService
						.getProductionStatus(
								articleData.getArticleDetails().getArticleId())
						.getProductionStatus());
				articleDataList.add(articleData);
			}
		}
		return articleDataList;
	}

	private OrderPaymentStatus getOrderPaymentStatusForArticle(Integer articleId)
			throws Exception {
		OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus();
		orderPaymentStatus.setOpenAccessStatus(esbInterfaceService
				.getOpenAccessStatus(articleId).getOpenAccessStatus());
		orderPaymentStatus.setOnlineOpenStatus(esbInterfaceService
				.getOnlineOpenStatus(articleId).getOnlineOpenStatus());
		return orderPaymentStatus;
	}

}