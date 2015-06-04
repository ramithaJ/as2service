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
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestion;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestions;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;

/**
 * @author yugandhark
 *
 */
public class DashboardServiceImpl implements DashboardService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DashboardServiceImpl.class);
    @Autowired(required = true)
    private UserProfiles userProfileService;
    @Autowired(required = true)
    private UserManagement userManagementService;

    /**
     * @param userId
     *            to get the data from ExternalService
     * @return DashBoard
     */
    public Dashboard getProfileMeter(String userId) throws Exception {
        LOGGER.info("inside getProfileMeter Method of DashBoardServiceImpl");
        Dashboard dashBoard = null;
        List<DashboardInfo> dashBoardInfoList;
        UserProfileResponse userProfileResponse = userProfileService
                .userProfileResponse(userId);
        UserProfile userProfile = userProfileResponse.getCustomerProfile();
        User user = userProfile.getCustomerDetails();
        dashBoardInfoList = checkingDashboardInfo(userProfile, user);
        dashBoard = new Dashboard();
        if (null != dashBoardInfoList && dashBoardInfoList.isEmpty()) {
            dashBoard.setProfileMeterMessage("Profile Completed");
            dashBoard.setDashBoardInfo(dashBoardInfoList);
        } else {
            dashBoard.setProfileMeterMessage("");
            dashBoard.setDashBoardInfo(dashBoardInfoList);
        }
        return dashBoard;
    }

    private DashboardInfo getSecurityDetailsForUser(String emailId,
            DashboardInfo dashboardInfo) throws NullPointerException {
        LOGGER.info("inside getSecurityDetailsForUser Method of DashBoardServiceImpl");
        SecuirtyQuestionDetails secuirtyQuestionDetails = userManagementService
                .getSecurityQuestionDetails(emailId);
        if (!StringUtils.isEmpty(secuirtyQuestionDetails)) {
            SecurityQuestions securityQuestions = secuirtyQuestionDetails
                    .getSecurityQuestions();
            List<SecurityQuestion> securityQuestionList = securityQuestions
                    .getSecurityQuestion();
            if (null != securityQuestionList) {
                for (SecurityQuestion securityQuestion : securityQuestionList) {
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

    private List<DashboardInfo> checkingDashboardInfo(UserProfile userProfile,
            User user) {
        LOGGER.info("inside checkingDashBoardInfo Method of DashBoardServiceImpl");
        DashboardInfo dashboardInfo = null;
        List<DashboardInfo> dashboardInfoList = new ArrayList<DashboardInfo>();
        dashboardInfo = getSecurityDetailsForUser(user.getPrimaryEmailAddr(),
                dashboardInfo);
        if (null != dashboardInfo) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getRecoveryEmailAddr(user, dashboardInfo);
        if (null != dashboardInfo) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getOrcidId(user, dashboardInfo);
        if (null != dashboardInfo) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getInterestsForUser(userProfile, dashboardInfo);
        if (null != dashboardInfo) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getAffiliationsForUser(userProfile, dashboardInfo);
        if (null != dashboardInfo) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getSocietiesForUser(userProfile, dashboardInfo);
        if (null != dashboardInfo) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getFundersListForUser(userProfile, dashboardInfo);
        if (null != dashboardInfo) {
            dashboardInfoList.add(dashboardInfo);
        }
        return dashboardInfoList;
    }

    private DashboardInfo getInterestsForUser(UserProfile userProfile,
            DashboardInfo dashBoardInfo) {
        LOGGER.info("inside getInterestsForUser Method of DashBoardServiceImpl");
        List<Interests> userInterestsList = userProfile.getInterests();
        if (null != userInterestsList && userInterestsList.isEmpty()) {
            dashBoardInfo = new DashboardInfo();
            dashBoardInfo.setId("my-interests");
            dashBoardInfo
                    .setDashBoardInfoMessage("No Areas Of Expertizes(Interests) Details");
        }
        return dashBoardInfo;
    }

    private DashboardInfo getAffiliationsForUser(UserProfile userProfile,
            DashboardInfo dashboardInfo) {
        LOGGER.info("inside getAffiliationsForUser Method of DashBoardServiceImpl");
        List<Affiliation> userAffiliationsList = userProfile.getAffiliations();
        if (null != userAffiliationsList && userAffiliationsList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("affiliations");
            dashboardInfo.setDashBoardInfoMessage("No Affiliation Details");
        }
        return dashboardInfo;
    }

    private DashboardInfo getSocietiesForUser(UserProfile userProfile,
            DashboardInfo dashboardInfo) {
        LOGGER.info("inside getSocietiesForUser Method of DashBoardServiceImpl");
        List<Society> societyList = userProfile.getSocieties();
        if (null != societyList && societyList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("societies");
            dashboardInfo.setDashBoardInfoMessage("No Society Details");
        }
        return dashboardInfo;
    }

    private DashboardInfo getFundersListForUser(UserProfile userProfile,
            DashboardInfo dashboardInfo) {
        LOGGER.info("inside getFundersListForUser Method of DashBoardServiceImpl");
        List<ResearchFunder> researchFundersList = userProfile
                .getResearchFunders();
        if (null != researchFundersList && researchFundersList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("research-funder");
            dashboardInfo
                    .setDashBoardInfoMessage("No Research Funders Details");
        }
        return dashboardInfo;
    }

    private DashboardInfo getRecoveryEmailAddr(User user,
            DashboardInfo dashboardInfo) {
        LOGGER.info("inside getRecoveryEmailAddr Method of DashBoardServiceImpl");
        if (StringUtils.isEmpty(user.getRecoveryEmailAddress())) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("email");
            dashboardInfo
                    .setDashBoardInfoMessage("No Secondary Email(Recovery Email Addr)");
        }
        return dashboardInfo;
    }

    private DashboardInfo getOrcidId(User user, DashboardInfo dashboardInfo) {
        LOGGER.info("inside getOrcidId Method of DashBoardServiceImpl");
        if (StringUtils.isEmpty(user.getOrcidID())) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("orcid");
            dashboardInfo.setDashBoardInfoMessage("No Orcid ID");
        }
        return dashboardInfo;
    }
}