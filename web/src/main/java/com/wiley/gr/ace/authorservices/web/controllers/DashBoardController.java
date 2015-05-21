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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.DashBoard;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

/**
 * @author Virtusa
 *
 */
@RestController
@RequestMapping("/dashboard")
public class DashBoardController {

    /** The Auto Wired for DashBoard Service . */
    @Autowired(required = true)
    private DashBoardService dashBoardService;

    @RequestMapping(value = "/profilemeter/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service getProfileMeter(
            @PathVariable("userId") String userId) {

        Service service = new Service();
        DashBoard dashBoard = null;

        try {
            dashBoard = dashBoardService.getProfileMeter(userId);
            if (!StringUtils.isEmpty(dashBoard)) {
                if (dashBoard.getDashBoardInfo().isEmpty())
                    service.setStatus("SUCCESS");
                service.setPayload(dashBoard);
            } else {
                service.setStatus("SUCCESS");
                service.setPayload(dashBoard);
            }
        } catch (Exception e) {
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(-101);
            error.setMessage("Error fetching profile meter");
            service.setStatus("ERROR");
            service.setPayload(dashBoard);
            service.setError(error);
            throw new ASException("-2", "Error fetching profile meter", e);
        }
        return service;

    }
}
