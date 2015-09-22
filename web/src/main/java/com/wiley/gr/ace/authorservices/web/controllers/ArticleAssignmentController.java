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

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.ViewAssignedArticle;
import com.wiley.gr.ace.authorservices.model.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

/**
 * The Class ArticleAssignmentController.
 *
 * @author virtusa version 1.0
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

    /** The get article info error code. */
    @Value("${ArticleAssignmentController.getArticleInfo.code}")
    private String getArticleInfoErrorCode;

    /** The get article info error message. */
    @Value("${ArticleAssignmentController.getArticleInfo.message}")
    private String getArticleInfoErrorMessage;

    /** The association confirmation error code. */
    @Value("${ArticleAssignmentController.associationConfirmation.code}")
    private String associationConfirmationErrorCode;

    /** The association confirmation message. */
    @Value("${ArticleAssignmentController.associationConfirmation.message}")
    private String associationConfirmationErrorMessage;

    /** The no data found. */
    @Value("${noDataFound.message}")
    private String noDataFound;

    /** The input parameter not found. */
    @Value("${inputParameterNotFound.message}")
    private String inputParameterNotFound;

    /**
     * Gets the article info.
     *
     * @param articleId
     *            the article id
     * @return the article info
     */
    @RequestMapping(value = "/confirm/display/{emailId}", method = RequestMethod.GET)
    public final Service getArticleInfo(
            @PathVariable("emailId") final String emailId) {
        LOGGER.info("inside getArticleInfo method of ArticleAssignmentController");
        final Service service = new Service();
        ArticleInfoDetails articleInfoDetails = null;
        if (!StringUtils.isEmpty(emailId)) {
            LOGGER.info("input parameter articleId is found to Get Article Info");
            try {
                articleInfoDetails = articleAssignmentService
                        .getArticleInfoDetails(emailId);
                if (!StringUtils.isEmpty(articleInfoDetails)) {
                    LOGGER.info("Article Info Details Found");
                    service.setStatus("SUCCESS");
                    service.setPayload(articleInfoDetails);
                } else {
                    LOGGER.info("Article Info Details Not Found");
                    service.setStatus("SUCCESS");
                    service.setPayload(noDataFound);
                }
            } catch (final Exception e) {
                LOGGER.error("Print Stack Trace- ", e);
                throw new ASException(getArticleInfoErrorCode,
                        getArticleInfoErrorMessage);
            }
        } else {
            LOGGER.info("input Parameter emailId is Not Found");
            service.setStatus("FAILURE");
            service.setPayload(inputParameterNotFound);
        }
        return service;

    }

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation - The Request value
     * @return service
     */
    @RequestMapping(value = "/confirm/association", method = RequestMethod.PUT)
    public final Service associationConfirmation(
            @RequestBody final AssociationConfirmation associationConfirmation) {
        LOGGER.info("inside associationConfirmation method of ArticleAssignmentController");
        final Service service = new Service();
        if (!StringUtils.isEmpty(associationConfirmation)) {
            LOGGER.info("input parameter associationConfirmation is found to Confirm the Association");
            boolean isAssociationconfirmed = false;
            try {
                isAssociationconfirmed = articleAssignmentService
                        .associationConfirmation(associationConfirmation);
                if (isAssociationconfirmed) {
                    LOGGER.info(" Article Association is Confirmed");
                    service.setStatus("SUCCESS");
                    service.setPayload(isAssociationconfirmed);
                } else {
                    LOGGER.info(" Article Association is Not Confirmed");
                    service.setStatus("FAILURE");
                    service.setPayload(isAssociationconfirmed);
                }
            } catch (final Exception e) {
                LOGGER.error("Print Stack Trace- ", e);
                throw new ASException(associationConfirmationErrorCode,
                        associationConfirmationErrorMessage);
            }
        } else {
            LOGGER.info("input Parameters are Not Found");
            service.setStatus("FAILURE");
            service.setPayload(inputParameterNotFound);
        }
        return service;

    }

    /**
     * Gets the confirmation article data.
     *
     * @param articleId
     *            the article id
     * @return the confirmation article data
     */
    @RequestMapping(value = "/view/{articleId}", method = RequestMethod.GET)
    public final Service viewAssignedArticle(
            @PathVariable("articleId") final String articleId) {
        LOGGER.info("inside viewAssignedArticle method of ArticleAssignmentController");
        final Service service = new Service();
        ViewAssignedArticle viewAssignedArticle = null;
        if (!StringUtils.isEmpty(articleId)) {
            LOGGER.info("input parameter articleId is found to Get View Assigned Article");
            try {
                viewAssignedArticle = articleAssignmentService
                        .viewAssignedArticle(articleId);
                if (!StringUtils.isEmpty(viewAssignedArticle)) {
                    LOGGER.info(" View Assigned Article Data Found");
                    service.setStatus("SUCCESS");
                    service.setPayload(viewAssignedArticle);
                } else {
                    LOGGER.info(" View Assigned Article Data Not Found");
                    service.setStatus("SUCCESS");
                    service.setPayload(noDataFound);
                }
            } catch (final Exception e) {
                LOGGER.error("Print Stack Trace- ", e);
                throw new ASException("viewAssignedArticleErrorCode",
                        "viewAssignedArticleErrorMessage"); // create mapping
                                                            // from properties
                                                            // :MERGE
            }
        } else {
            LOGGER.info("input Parameter emailId is Not Found");
            service.setStatus("FAILURE");
            service.setPayload(inputParameterNotFound);
        }
        return service;

    }
}
