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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

/**
 * @author virtusa version1.0
 *
 */
@RestController
@RequestMapping("/article")
public class ArticleAssignmentController {

    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ArticleAssignmentController.class);
    
    /**
     * injected ArticleAssignmentService bean.
     */
    @Autowired(required = true)
    private ArticleAssignmentService articleAssignmentService;

    /**
     * the value of noDataFoundCode.
     */
    @Value("${noDataFound.code}")
    private int noDataFoundCode;

    /**
     * @param emailId
     *            - The Request value
     * @return service
     */
    @RequestMapping(value = "/confirm/display/{emailId}", method = RequestMethod.GET)
    public final Service getArticleInfo(
            @PathVariable("emailId") final String emailId) {
        Service service = new Service();
        ArticleInfoDetails articleInfoDetails = null;

        try {
            articleInfoDetails = articleAssignmentService
                    .getArticleInfo(emailId);
            if (!StringUtils.isEmpty(articleInfoDetails)) {
                service.setPayload(articleInfoDetails);
            }
        } catch (Exception e) {
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(noDataFoundCode);
            error.setMessage("Error Fetching ArticleInfo");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;

    }

    /**
     * @param articleAuthId
     *            - The Request value
     * @param userId
     *            - The Request value
     * @return service
     */
    @RequestMapping(value = "/confirm/confirmassociation", method = RequestMethod.PUT)
    public final Service confirmAssociation(
            @RequestBody final String articleAuthId,
            @RequestBody final String userId) {
        Service service = new Service();
        boolean confirmAssociation = false;
        try {
            confirmAssociation = articleAssignmentService.confirmAssociation(
                    articleAuthId, userId);
            if (confirmAssociation) {
                service.setPayload(confirmAssociation);
            } else {
                service.setStatus("FAILURE");
                service.setPayload(confirmAssociation);
            }
        } catch (Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(noDataFoundCode);
            error.setMessage("Error Fetching ArticleInfo");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;

    }
}
