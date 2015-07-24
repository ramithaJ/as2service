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

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardInfo;
import com.wiley.gr.ace.authorservices.model.external.AffiliationData;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.Interest;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.external.Society;
import com.wiley.gr.ace.authorservices.model.external.SystemSecurityQuestions;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;

/**
 * The Class DashboardServiceImpl.
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
        if (!StringUtils.isEmpty(emailId)) {
            LOGGER.info(" EmailId is Found to Check Secuirty Questions");
            SystemSecurityQuestions systemSecurityQuestions = userManagementService
                    .userSecurityQuestions(emailId)
                    .getSystemSecurityQuestions();
            dashboardInfo = securityQuestionsChecking(systemSecurityQuestions);
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
        DashboardInfo dashboardInfo = null;
        if (StringUtils.isEmpty(systemSecurityQuestions)) {
            LOGGER.info("No user Found with EmailId then No Security Questions on Dashboard");
            dashboardInfo = new DashboardInfo();
            dashboardInfo.setId(securityId);
            dashboardInfo.setDashBoardInfoMessage(securityMessage);
        } else {
            List<String> systemSecurityQuestionsList = systemSecurityQuestions
                    .getSecurityQuestionList();
            if (!StringUtils.isEmpty(systemSecurityQuestionsList)
                    && systemSecurityQuestionsList.isEmpty()) {
                LOGGER.info("Secuirty Questions List is Empty then No Security Questions on Dashboard");
                dashboardInfo = new DashboardInfo();
                dashboardInfo.setId(securityId);
                dashboardInfo.setDashBoardInfoMessage(securityMessage);
            }
        }
        return dashboardInfo;
    }

    /**
     * Gets the interests for user.
     *
     * @param customerProfile
     *            the customer profile
     * @return the interests for user
     */
    private DashboardInfo getInterestsForUser(
            final CustomerProfile customerProfile) {
        DashboardServiceImpl.LOGGER
                .info("inside getInterestsForUser Method of DashboardServiceImpl");
        final List<Interest> userInterestsList = customerProfile
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
     */
    private DashboardInfo getAffiliationsForUser(
            final CustomerProfile customerProfile) {
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
     */
    private DashboardInfo getSocietiesForUser(
            final CustomerProfile customerProfile) {
        DashboardServiceImpl.LOGGER
                .info("inside getSocietiesForUser Method of DashboardServiceImpl");
        final List<Society> societyList = customerProfile.getSocietyList()
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
            LOGGER.info(" If EmailId Not Found then No Orcid Id on Dashboard");
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
     */
    private DashboardInfo getOrcidId(final CustomerDetails customerDetails) {
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
    public final DashboardView viewDashboard(final int userId) throws Exception {
        return esbInterfaceService.viewDashboard(userId);
    }
}
