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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;

/**
 * This DashboardController is for view the Dashboard of Corresponding Author
 * and Co-Author.
 * 
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DashboardController.class);
    /** value from props file configured. */
    @Value("${DashboardController.getProfileMeter.code}")
    private int getProfileMetererrorcode;
    /** value from props file configured. */
    @Value("${DashboardController.getProfileMeter.message}")
    private String getProfileMetererrormessage;
    /** The Auto Wired for DashBoard Service . */
    @Autowired(required = true)
    private DashboardService dashboardService;

    /**
     * This method takes userId and return the Service.
     *
     * @param userId
     *            the user id
     * @return service
     */
    @RequestMapping(value = "/profilemeter/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final @ResponseBody Service getProfileMeter(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getProfileMeter method of DashboardController");
        Service service = new Service();
        Dashboard dashboard = null;

        try {
            dashboard = dashboardService.getProfileMeter(userId);
            if (!StringUtils.isEmpty(dashboard)) {
                service.setStatus("SUCCESS");
                service.setPayload(dashboard);
            }
        } catch (Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(getProfileMetererrorcode);
            error.setMessage(getProfileMetererrormessage);
            service.setStatus("ERROR");
            service.setError(error);
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
    @RequestMapping(value = "/view/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final @ResponseBody Service getAllAuthorArticles(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside viewallauthorarticles method of DashboardController");
        Service service = new Service();
        DashboardView dashboardView = null;
        try {
            dashboardView = dashboardService.viewDashboard(userId);
            if (!StringUtils.isEmpty(dashboardView)) {
                service.setStatus("SUCCESS");
                service.setPayload(dashboardView);
            }
        } catch (Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(201);
            error.setMessage("Error Fetching To View All Author Articles");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;
    }
}