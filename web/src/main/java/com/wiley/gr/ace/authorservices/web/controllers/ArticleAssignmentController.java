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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

/**
 * @author yugandhark
 *
 */
@RestController
@RequestMapping("/article")
public class ArticleAssignmentController {

    @Autowired(required = true)
    ArticleAssignmentService articleAssignmentService;

    /**
     * @param emailId
     * @return
     */
    @RequestMapping(value = "/confirm/display/{emailId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final @ResponseBody Service getArticleInfo(
            @PathVariable("emailId") final String emailId) {
        Service service = new Service();
        ArticleInfoDetails articleInfoDetails = null;

        try {
            articleInfoDetails = articleAssignmentService
                    .getArticleInfo(emailId);
            if (!StringUtils.isEmpty(articleInfoDetails)) {
                service.setStatus("SUCCESS");
                service.setPayload(articleInfoDetails);
            }
        } catch (Exception e) {
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(205);
            error.setMessage("Error Fetching ArticleInfo");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;

    }

    /**
     * @param articleAuthId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/confirm/confirmassociation", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public final @ResponseBody Service confirmAssociation(
            @RequestBody String articleAuthId, @RequestBody String userId) {
        Service service = new Service();
        boolean confirmAssociation = false;
        try {
            confirmAssociation = articleAssignmentService.confirmAssociation(
                    articleAuthId, userId);
            if (confirmAssociation) {
                service.setStatus("SUCCESS");
                service.setPayload(confirmAssociation);
            } else {
                service.setStatus("FAILURE");
                service.setPayload(confirmAssociation);
            }
        } catch (Exception e) {
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(205);
            error.setMessage("Error Fetching ArticleInfo");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;

    }
}
