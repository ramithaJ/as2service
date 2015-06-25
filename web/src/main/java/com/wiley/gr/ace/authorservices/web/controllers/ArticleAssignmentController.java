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

import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.ConfirmArticleData;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

/**
 * The Class ArticleAssignmentController.
 *
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/article")
public class ArticleAssignmentController {

    /**
     * injected ArticleAssignmentService bean.
     */
    @Autowired(required = true)
    ArticleAssignmentService articleAssignmentService;

    /**
     * Gets the article info.
     *
     * @param emailId
     *            the email id
     * @return service
     */
    @RequestMapping(value = "/confirm/display/{emailId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final @ResponseBody Service getArticleInfo(
            @PathVariable("emailId") final String emailId) {
        final Service service = new Service();
        ArticleInfoDetails articleInfoDetails = null;

        try {
            articleInfoDetails = articleAssignmentService
                    .getArticleInfo(emailId);
            if (!StringUtils.isEmpty(articleInfoDetails)) {
                service.setStatus("SUCCESS");
                service.setPayload(articleInfoDetails);
            }
        } catch (final Exception e) {
            final ErrorPOJO error = new ErrorPOJO();
            error.setCode(205);
            error.setMessage("Error Fetching ArticleInfo");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;

    }

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return service
     */
    @RequestMapping(value = "/confirm/association", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public final @ResponseBody Service associationConfirmation(
            @RequestBody final AssociationConfirmation associationConfirmation) {
        final Service service = new Service();
        boolean isAssociationconfirmed = false;
        try {
            isAssociationconfirmed = articleAssignmentService
                    .associationConfirmation(associationConfirmation);
            if (isAssociationconfirmed) {
                service.setStatus("SUCCESS");
                service.setPayload(isAssociationconfirmed);
            } else {
                service.setStatus("FAILURE");
                service.setPayload(isAssociationconfirmed);
            }
        } catch (final Exception e) {
            final ErrorPOJO error = new ErrorPOJO();
            error.setCode(205);
            error.setMessage("Error Fetching Association Confirmation");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;

    }

    /**
     * Gets the confirmation article data.
     *
     * @param emailId
     *            the email id
     * @return the confirmation article data
     */
    @RequestMapping(value = "/confirmation/{emailId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final @ResponseBody Service getConfirmationArticleData(
            @PathVariable("emailId") final String emailId) {
        final Service service = new Service();
        ConfirmArticleData confirmArticleData = null;

        try {
            confirmArticleData = articleAssignmentService
                    .getArticleConfirmationData(emailId);
            if (!StringUtils.isEmpty(confirmArticleData)) {
                service.setStatus("SUCCESS");
                service.setPayload(confirmArticleData);
            }
        } catch (final Exception e) {
            final ErrorPOJO error = new ErrorPOJO();
            error.setCode(205);
            error.setMessage("Error Fetching Confrim Article Data");
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;

    }
}
