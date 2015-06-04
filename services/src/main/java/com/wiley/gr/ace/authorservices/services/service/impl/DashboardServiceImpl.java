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
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestion;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;

/**
 * @author virtusa
 *version 1.0
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
        LOGGER.info("inside getProfileMeter Method of DashboardServiceImpl");
        Dashboard dashBoard = new Dashboard();
        List<DashboardInfo> dashBoardInfoList;
        UserProfileResponse userProfileResponse = userProfileService
                .userProfileResponse(userId);
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

    private DashboardInfo getSecurityDetailsForUser(String emailId)
            throws Exception {
        LOGGER.info("inside getSecurityDetailsForUser Method of DashboardServiceImpl");
        SecuirtyQuestionDetails secuirtyQuestionDetails = userManagementService
                .getSecurityQuestionDetails(emailId);
        DashboardInfo dashboardInfo = new DashboardInfo();
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

                        dashboardInfo.setId("security"); // TODO: fetch the id
                                                         // from contant or
                                                         // properties
                        dashboardInfo
                                .setDashBoardInfoMessage("No Security Details");
                        break;
                    } else {
                        dashboardInfo = null;
                    }
                }
            }
        }
        return dashboardInfo;
    }

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

    private DashboardInfo getInterestsForUser(UserProfile userProfile) {
        LOGGER.info("inside getInterestsForUser Method of DashboardServiceImpl");
        List<Interests> userInterestsList = userProfile.getInterests();
        DashboardInfo dashboardInfo = new DashboardInfo();
        if (null != userInterestsList && userInterestsList.isEmpty()) {
            dashboardInfo.setId("my-interests");
            dashboardInfo
                    .setDashBoardInfoMessage("No Areas Of Expertizes(Interests) Details");
        } else {
            dashboardInfo = null;
        }
        return dashboardInfo;
    }

    private DashboardInfo getAffiliationsForUser(UserProfile userProfile) {
        LOGGER.info("inside getAffiliationsForUser Method of DashboardServiceImpl");
        List<Affiliation> userAffiliationsList = userProfile.getAffiliations();
        DashboardInfo dashboardInfo = new DashboardInfo();
        if (!StringUtils.isEmpty(userAffiliationsList) && userAffiliationsList.isEmpty()) {
            dashboardInfo.setId("affiliations");
            dashboardInfo.setDashBoardInfoMessage("No Affiliation Details");
        } else {
            dashboardInfo = null;
        }
        return dashboardInfo;
    }

    private DashboardInfo getSocietiesForUser(UserProfile userProfile) {
        LOGGER.info("inside getSocietiesForUser Method of DashboardServiceImpl");
        List<Society> societyList = userProfile.getSocieties();
        DashboardInfo dashboardInfo = new DashboardInfo();
        if (!StringUtils.isEmpty(societyList) && societyList.isEmpty()) {
            dashboardInfo.setId("societies");
            dashboardInfo.setDashBoardInfoMessage("No Society Details");
        } else {
            dashboardInfo = null;
        }
        return dashboardInfo;
    }

    private DashboardInfo getFundersListForUser(UserProfile userProfile) {
        LOGGER.info("inside getFundersListForUser Method of DashboardServiceImpl");
        List<ResearchFunder> researchFundersList = userProfile
                .getResearchFunders();
        DashboardInfo dashboardInfo = new DashboardInfo();
        if (!StringUtils.isEmpty(researchFundersList) && researchFundersList.isEmpty()) {
            dashboardInfo.setId("research-funder");
            dashboardInfo
                    .setDashBoardInfoMessage("No Research Funders Details");
        } else {
            dashboardInfo = null;
        }
        return dashboardInfo;
    }

    private DashboardInfo getRecoveryEmailAddr(User user) throws Exception {
        LOGGER.info("inside getRecoveryEmailAddr Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = new DashboardInfo();
        if (StringUtils.isEmpty(user.getRecoveryEmailAddress())) {
            dashboardInfo.setId("email");
            dashboardInfo
                    .setDashBoardInfoMessage("No Secondary Email(Recovery Email Addr)");
        } else {
            dashboardInfo = null;
        }
        return dashboardInfo;
    }

    private DashboardInfo getOrcidId(User user) {
        LOGGER.info("inside getOrcidId Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = new DashboardInfo();
        if (StringUtils.isEmpty(user.getOrcidID())) {
            dashboardInfo.setId("orcid");
            dashboardInfo.setDashBoardInfoMessage("No Orcid ID");
        } else {
            dashboardInfo = null;
        }
        return dashboardInfo;
    }
}