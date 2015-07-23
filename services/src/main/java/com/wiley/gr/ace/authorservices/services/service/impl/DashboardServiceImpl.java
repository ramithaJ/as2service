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
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardInfo;
import com.wiley.gr.ace.authorservices.model.external.Affiliation;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.Interest;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.external.Society;
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
        DashboardServiceImpl.LOGGER
                .info("inside getProfileMeter Method of DashboardServiceImpl");
        final Dashboard dashBoard = new Dashboard();
        List<DashboardInfo> dashBoardInfoList = null;
        final LookupCustomerProfile lookupCustomerProfile = userProfileService
                .getLookupCustomerProfile(userId);
        final CustomerProfile customerProfile = lookupCustomerProfile
                .getLookupCustomerProfileResponse().getCustomerProfile();
        dashBoardInfoList = checkingDashboardInfo(customerProfile);
        if (dashBoardInfoList.isEmpty()) {
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
        DashboardServiceImpl.LOGGER
                .info("inside getSecurityDetailsForUser Method of DashboardServiceImpl");
        final List<String> systemSecurityQuestionsList = userManagementService
                .getSecurityQuestionsList(emailId).getSystemSecurityQuestions()
                .getSecurityQuestionList();
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(systemSecurityQuestionsList)
                && systemSecurityQuestionsList.isEmpty()) {
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId("security");
            dashboardInfo.setDashBoardInfoMessage("No Security Details");
        }
        return dashboardInfo;
    }

    /**
     * This method will check the each and every profile meter information of
     * dashboardInfo is empty or not.If dashboardInfo object is empty then add
     * to the list of dashboardInfoList then return otherwise if not empty then
     * not added to the dashboardInfoList.
     *
     * @param customerProfile
     *            the user profile
     * @return the List of DashboardInfo
     * @throws Exception
     *             the exception
     */
    private List<DashboardInfo> checkingDashboardInfo(
            final CustomerProfile customerProfile) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside checkingDashBoardInfo Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        final List<DashboardInfo> dashboardInfoList = new ArrayList<DashboardInfo>();
        dashboardInfo = getSecurityDetailsForUser(customerProfile
                .getCustomerDetails().getPrimaryEmail());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getRecoveryEmailAddr(customerProfile
                .getCustomerDetails());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getOrcidId(customerProfile.getCustomerDetails());
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getInterestsForUser(customerProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getAffiliationsForUser(customerProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getSocietiesForUser(customerProfile);
        if (!StringUtils.isEmpty(dashboardInfo)) {
            dashboardInfoList.add(dashboardInfo);
        }
        dashboardInfo = getFundersListForUser(customerProfile);
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
    private DashboardInfo getInterestsForUser(
            final CustomerProfile customerProfile) {
        DashboardServiceImpl.LOGGER
                .info("inside getInterestsForUser Method of DashboardServiceImpl");
        final List<Interest> userInterestsList = customerProfile
                .getAreaOfInterest().getInterest();
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
    private DashboardInfo getAffiliationsForUser(
            final CustomerProfile customerProfile) {
        DashboardServiceImpl.LOGGER
                .info("inside getAffiliationsForUser Method of DashboardServiceImpl");
        final List<Affiliation> userAffiliationsList = customerProfile
                .getAffiliations().getAffiliation();
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
    private DashboardInfo getSocietiesForUser(
            final CustomerProfile customerProfile) {
        DashboardServiceImpl.LOGGER
                .info("inside getSocietiesForUser Method of DashboardServiceImpl");
        final List<Society> societyList = customerProfile.getSocietyList()
                .getSociety();
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
    private DashboardInfo getFundersListForUser(
            final CustomerProfile customerProfile) {
        DashboardServiceImpl.LOGGER
                .info("inside getFundersListForUser Method of DashboardServiceImpl");
        final List<ResearchFunder> researchFundersList = customerProfile
                .getResearchFunders().getResearchFunder();
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
    private DashboardInfo getRecoveryEmailAddr(
            final CustomerDetails customerDetails) throws Exception {
        DashboardServiceImpl.LOGGER
                .info("inside getRecoveryEmailAddr Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(customerDetails.getSecondaryEmail())) {
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
    private DashboardInfo getOrcidId(final CustomerDetails customerDetails) {
        DashboardServiceImpl.LOGGER
                .info("inside getOrcidId Method of DashboardServiceImpl");
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(customerDetails.getOrcId())) {
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
    public final DashboardView viewDashboard(final int userId) throws Exception {
        return esbInterfaceService.viewDashboard(userId);
    }
}
