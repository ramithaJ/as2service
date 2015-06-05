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
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.DashboardService;

/**
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DashboardController.class);
    /** The Auto Wired for DashBoard Service . */
    @Autowired(required = true)
    private DashboardService dashboardService;

    @RequestMapping(value = "/profilemeter/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service getProfileMeter(
            @PathVariable("userId") String userId) {
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
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(-101);
            error.setMessage("Error fetching profile meter");
            service.setStatus("ERROR");
            service.setPayload(dashboard);
            service.setError(error);
            throw new ASException("-2", "Error fetching profile meter", e);
        }
        return service;

    }
}
