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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.DashBoard;
import com.wiley.gr.ace.authorservices.model.DashBoardInfo;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestion;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

/**
 * @author yugandhark
 *
 */
public class DashBoardServiceImpl implements DashBoardService {

    @Autowired(required = true)
    private CDMInterfaceService cdmIntefaceService;
    @Autowired(required = true)
    private ALMInterfaceService almIntefaceService;

    /**
     * @param userId
     *            to get the data from ExternalService
     * @return DashBoard
     */
    public DashBoard getProfileMeter(String userId) throws NullPointerException {
        DashBoard dashBoard = null;
        List<DashBoardInfo> dashBoardInfoList;
        LookUpProfile lookUpProfile = cdmIntefaceService.lookUpProfile(userId);
        UserProfile userProfile = lookUpProfile.getCustomerProfile();
        User user = userProfile.getCustomerDetails();
        dashBoardInfoList = checkingDashBoardInfo(userProfile, user);
        dashBoard = new DashBoard();
        if (null != dashBoardInfoList && dashBoardInfoList.isEmpty()) {
            dashBoard.setProfileMeterMessage("Profile Completed");
            dashBoard.setDashBoardInfo(dashBoardInfoList);
        } else {
            dashBoard.setProfileMeterMessage("");
            dashBoard.setDashBoardInfo(dashBoardInfoList);
        }
        return dashBoard;
    }

    private DashBoardInfo getSecurityDetailsForUser(String emailId,
            DashBoardInfo dashBoardInfo) throws NullPointerException {
        SecuirtyQuestionDetails secuirtyQuestionDetails = almIntefaceService
                .getSecurityQuestionDetails(emailId);
        if (!StringUtils.isEmpty(secuirtyQuestionDetails)) {
            SecurityQuestion securityQuestion = secuirtyQuestionDetails
                    .getSecurityQuestion();
            String[] question =securityQuestion
                    .getQuestion();
            if (question.length==0) {
                        dashBoardInfo = new DashBoardInfo();
                        dashBoardInfo.setId("security");
                        dashBoardInfo
                                .setDashBoardInfoMessage("No Security Details");
              
                    }
        }
        return dashBoardInfo;
    }

    private List<DashBoardInfo> checkingDashBoardInfo(UserProfile userProfile,
            User user) {
        DashBoardInfo dashBoardInfo = null;
        List<DashBoardInfo> dashBoardInfoList = new ArrayList<DashBoardInfo>();
        dashBoardInfo = getSecurityDetailsForUser(user.getPrimaryEmailAddr(),
                dashBoardInfo);
        if (null != dashBoardInfo) {
            dashBoardInfoList.add(dashBoardInfo);
        }
        dashBoardInfo = getRecoveryEmailAddr(user, dashBoardInfo);
        if (null != dashBoardInfo) {
            dashBoardInfoList.add(dashBoardInfo);
        }
        dashBoardInfo = getOrcidId(user, dashBoardInfo);
        if (null != dashBoardInfo) {
            dashBoardInfoList.add(dashBoardInfo);
        }
        dashBoardInfo = getInterestsForUser(userProfile, dashBoardInfo);
        if (null != dashBoardInfo) {
            dashBoardInfoList.add(dashBoardInfo);
        }
        dashBoardInfo = getAffiliationsForUser(userProfile, dashBoardInfo);
        if (null != dashBoardInfo) {
            dashBoardInfoList.add(dashBoardInfo);
        }
        dashBoardInfo = getSocietiesForUser(userProfile, dashBoardInfo);
        if (null != dashBoardInfo) {
            dashBoardInfoList.add(dashBoardInfo);
        }
        dashBoardInfo = getFundersListForUser(userProfile, dashBoardInfo);
        if (null != dashBoardInfo) {
            dashBoardInfoList.add(dashBoardInfo);
        }
        return dashBoardInfoList;
    }

    private DashBoardInfo getInterestsForUser(UserProfile userProfile,
            DashBoardInfo dashBoardInfo) {
        List<Interests> userInterestsList = userProfile.getInterests();
        if (null != userInterestsList && userInterestsList.isEmpty()) {
            dashBoardInfo = new DashBoardInfo();
            dashBoardInfo.setId("my-interests");
            dashBoardInfo
                    .setDashBoardInfoMessage("No Areas Of Expertizes(Interests) Details");
        }
        return dashBoardInfo;
    }

    private DashBoardInfo getAffiliationsForUser(UserProfile userProfile,
            DashBoardInfo dashBoardInfo) {
        List<Affiliation> userAffiliationsList = userProfile.getAffiliations();
        if (null != userAffiliationsList && userAffiliationsList.isEmpty()) {
            dashBoardInfo = new DashBoardInfo();
            dashBoardInfo.setId("affiliations");
            dashBoardInfo.setDashBoardInfoMessage("No Affiliation Details");
        }
        return dashBoardInfo;
    }

    private DashBoardInfo getSocietiesForUser(UserProfile userProfile,
            DashBoardInfo dashBoardInfo) {
        List<Society> societyList = userProfile.getSocieties();
        if (null != societyList && societyList.isEmpty()) {
            dashBoardInfo = new DashBoardInfo();
            dashBoardInfo.setId("societies");
            dashBoardInfo.setDashBoardInfoMessage("No Society Details");
        }
        return dashBoardInfo;
    }

    private DashBoardInfo getFundersListForUser(UserProfile userProfile,
            DashBoardInfo dashBoardInfo) {
        List<ResearchFunder> researchFundersList = userProfile
                .getResearchFunders();
        if (null != researchFundersList && researchFundersList.isEmpty()) {
            dashBoardInfo = new DashBoardInfo();
            dashBoardInfo.setId("research-funder");
            dashBoardInfo
                    .setDashBoardInfoMessage("No Research Funders Details");
        }
        return dashBoardInfo;
    }

    private DashBoardInfo getRecoveryEmailAddr(User user,
            DashBoardInfo dashBoardInfo) {
        if (StringUtils.isEmpty(user.getRecoveryEmailAddress())) {
            dashBoardInfo = new DashBoardInfo();
            dashBoardInfo.setId("email");
            dashBoardInfo
                    .setDashBoardInfoMessage("No Secondary Email(Recovery Email Addr)");
        }
        return dashBoardInfo;
    }

    private DashBoardInfo getOrcidId(User user, DashBoardInfo dashBoardInfo) {
        if (StringUtils.isEmpty(user.getOrcidID())) {
            dashBoardInfo = new DashBoardInfo();
            dashBoardInfo.setId("orcid");
            dashBoardInfo.setDashBoardInfoMessage("No Orcid ID");
        }
        return dashBoardInfo;
    }
}