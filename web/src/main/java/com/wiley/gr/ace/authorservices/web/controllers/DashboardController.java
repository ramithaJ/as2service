/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
/**
 *
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.EmailCommunicationHistory;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This DashboardController is for view the Dashboard of Corresponding Author
 * and Co-Author.
 *
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    /**
     * logger configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DashboardController.class);

    @Autowired(required = true)
    private DashboardService dashboardService;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getProfileMeter.code}")
    private String getProfileMeterErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getProfileMeter.message}")
    private String getProfileMeterErrorMessage;

    /**
     * The get all author articles error code.
     */
    @Value("${DashboardController.getAllAuthorArticles.code}")
    private String getAllAuthorArticlesErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getAllAuthorArticles.message}")
    private String getAllAuthorArticlesErrorMessage;

    /**
     * The get action required error code.
     */
    @Value("${DashboardController.getActionRequired.code}")
    private String getActionRequiredErrorCode;

    /**
     * The get action required error message.
     */
    @Value("${DashboardController.getActionRequired.message}")
    private String getActionRequiredErrorMessage;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getEmailCommunicationHistory.code}")
    private String getEmailCommunicationHistoryErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getEmailCommunicationHistory.message}")
    private String getEmailCommunicationHistoryErrorMessage;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getProductionDetails.code}")
    private String getProductionDetailsErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getProductionDetails.message}")
    private String getProductionDetailsErrorMessage;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getPublishedArticleDetails.code}")
    private String getPublishedArticleDetailsErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${DashboardController.getPublishedArticleDetails.message}")
    private String getPublishedArticleDetailsErrorMessage;

    /**
     * The no data found.
     */
    @Value("${noDataFound.message}")
    private String noDataFound;

    @Value("${inputParameterNotFound.message}")
    private String inputParameterNotFound;

    /** The parameter not found constant. */
    private static final String PARAMETER_NOT_FOUND_MSG = "input Parameter userId is Not Found";

    /**
     * This method takes userId and return the Service.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/profilemeter/{userId}", method = RequestMethod.GET)
    public final Service getProfileMeter(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getProfileMeter method of DashboardController");
        final Service service = new Service();
        Dashboard dashboard = null;
        if (!StringUtils.isEmpty(userId)) {
            try {
                dashboard = dashboardService.getProfileMeter(userId);
                if (!StringUtils.isEmpty(dashboard)) {
                    LOGGER.info("Profile Meter Data is Found");
                    service.setPayload(dashboard);
                } else {
                    LOGGER.info("Profile Meter Data is Not Found");
                    service.setStatus(AuthorServicesConstants.SUCCESS);
                    service.setPayload(noDataFound);
                }
            } catch (final Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new UserException(getProfileMeterErrorCode,
                        getProfileMeterErrorMessage);
            }
        } else {
            LOGGER.info(PARAMETER_NOT_FOUND_MSG);
            service.setStatus(AuthorServicesConstants.FAILURE);
            service.setPayload(inputParameterNotFound);
        }
        return service;

    }

    /**
     * This method takes userId and return the Service.
     *
     * @param userId
     *            the user id
     * @return service
     */
    @RequestMapping(value = "/viewall/{userId}", method = RequestMethod.GET)
    public final Service getAllAuthorArticles(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getAllAuthorArticles method of DashboardController");
        final Service service = new Service();
        DashboardView dashboardView = null;
        if (!StringUtils.isEmpty(userId)) {
            LOGGER.info("input parameter userId is found to Get All the Author Article Details");
            try {
                dashboardView = dashboardService.getAllAuthorArticles(userId);
                setService(dashboardView, service);
            } catch (final Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new ASException(getActionRequiredErrorCode,
                        getActionRequiredErrorMessage);
            }
        } else {
            LOGGER.info(PARAMETER_NOT_FOUND_MSG);
            service.setStatus(AuthorServicesConstants.FAILURE);
            service.setPayload(inputParameterNotFound);
        }
        return service;
    }

    /**
     * This method takes userId and return the Service.
     *
     * @param userId
     *            the user id
     * @return service
     */
    @RequestMapping(value = "/action/{userId}", method = RequestMethod.GET)
    public final Service getActionRequired(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getActionRequired method of DashboardController");
        final Service service = new Service();
        DashboardView dashboardView = null;
        if (!StringUtils.isEmpty(userId)) {
            LOGGER.info("input parameter userId is found to Get All the Article status Details");
            try {
                dashboardView = dashboardService.actionRequired(userId);
                setService(dashboardView, service);
            } catch (final Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new ASException(getAllAuthorArticlesErrorCode,
                        getAllAuthorArticlesErrorMessage);
            }
        } else {
            LOGGER.info(PARAMETER_NOT_FOUND_MSG);
            service.setStatus(AuthorServicesConstants.FAILURE);
            service.setPayload(inputParameterNotFound);
        }
        return service;
    }

    /**
     * Gets the email communication history.
     *
     * @param userId
     *            the user id
     * @return the email communication history
     */
    @RequestMapping(value = "/communication/{userId}", method = RequestMethod.GET)
    public final Service getEmailCommunicationHistory(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getCommunicationHistory method of DashboardController");
        final Service service = new Service();
        EmailCommunicationHistory emailCommunicationHistory = null;
        if (!StringUtils.isEmpty(userId)) {
            LOGGER.info("input parameter userId is found to Get Email Communication History");
            try {
                emailCommunicationHistory = dashboardService
                        .getEmailCommunicationHistory(userId);
                if (!StringUtils.isEmpty(emailCommunicationHistory)) {
                    LOGGER.info(" Email Communication History is Found");
                    service.setStatus(AuthorServicesConstants.SUCCESS);
                    service.setPayload(emailCommunicationHistory);
                } else {
                    LOGGER.info(" Email Communication History Not Found");
                    service.setStatus(AuthorServicesConstants.SUCCESS);
                    service.setPayload(noDataFound);
                }
            } catch (final Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new ASException(getEmailCommunicationHistoryErrorCode,
                        getEmailCommunicationHistoryErrorMessage);
            }
        } else {
            LOGGER.info(PARAMETER_NOT_FOUND_MSG);
            service.setStatus(AuthorServicesConstants.FAILURE);
            service.setPayload(inputParameterNotFound);
        }
        return service;
    }

    /**
     * Gets the production details.
     *
     * @param userId
     *            the user id
     * @return the production details
     */
    @RequestMapping(value = "/production/{userId}", method = RequestMethod.GET)
    public final Service getProductionDetails(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getProductionDetails method of DashboardController");
        final Service service = new Service();
        DashboardView dashboardView = null;
        if (!StringUtils.isEmpty(userId)) {
            LOGGER.info("input parameter userId is found to Get Production Details of All Articles of An Author");
            try {
                dashboardView = dashboardService.getProductionDetails(userId);
                setService(dashboardView, service);
            } catch (final Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new ASException(getProductionDetailsErrorCode,
                        getProductionDetailsErrorMessage);
            }
        } else {
            LOGGER.info(PARAMETER_NOT_FOUND_MSG);
            service.setStatus(AuthorServicesConstants.FAILURE);
            service.setPayload(inputParameterNotFound);
        }
        return service;
    }

    /**
     * Gets the published article details.
     *
     * @param userId
     *            the user id
     * @return the published article details
     */
    @RequestMapping(value = "/published/{userId}", method = RequestMethod.GET)
    public final Service getPublishedArticleDetails(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getPublishedArticleDetails method of DashboardController");
        final Service service = new Service();
        DashboardView dashboardView = null;
        if (!StringUtils.isEmpty(userId)) {
            LOGGER.info("input parameter userId is found to Get Publication Details of All Articles of An Author");
            try {
                dashboardView = dashboardService
                        .getPublishedArticleDetails(userId);
                setService(dashboardView, service);
            } catch (final Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new ASException(getPublishedArticleDetailsErrorCode,
                        getPublishedArticleDetailsErrorMessage);
            }
        } else {
            LOGGER.info(PARAMETER_NOT_FOUND_MSG);
            service.setStatus(AuthorServicesConstants.FAILURE);
            service.setPayload(inputParameterNotFound);
        }
        return service;
    }

    /**
     * @param dashboardView
     * @param service
     * @return
     */
    private void setService(DashboardView dashboardView, Service service) {
        if (!StringUtils.isEmpty(dashboardView)) {
            LOGGER.info("Publication Details are Found");
            service.setStatus(AuthorServicesConstants.SUCCESS);
            service.setPayload(dashboardView);
        } else {
            LOGGER.info("Publication Details are Not Found");
            service.setStatus(AuthorServicesConstants.SUCCESS);
            service.setPayload(noDataFound);
        }
    }

}
