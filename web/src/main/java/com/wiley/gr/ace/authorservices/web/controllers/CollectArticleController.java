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
 ******************************************************************************/
package com.wiley.gr.ace.authorservices.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.CollectArticle;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.CollectArticleService;

/**
 * The Class CollectArticleController.
 * 
 * * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/v1")
public class CollectArticleController {

    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CollectArticleController.class);

    /** The get collect article error code. */
    @Value("${CollectArticleController.getCollectArticle.code}")
    private String getCollectArticleErrorCode;

    /** The get collect article error message. */
    @Value("${CollectArticleController.getCollectArticle.message}")
    private String getCollectArticleErrorMessage;

    /** The get collect article error codes. */
    @Value("${CollectArticleController.getCollectArticleError.code}")
    private String getCollectArticleErrorCodes;

    /** The get collect article error messages. */
    @Value("${CollectArticleController.getCollectArticleError.message}")
    private String getCollectArticleErrorMessages;

    /** The collect article service. */
    @Autowired(required = true)
    private CollectArticleService collectArticleService;

    /**
     * Gets the collect article.
     *
     * @return the collect article
     */
    @RequestMapping(value = "/article/ownership", method = RequestMethod.GET)
    public final Service getCollectArticle() {
        LOGGER.info("inside getCollectArticle method of CollectArticleController");
        Service service = new Service();

        try {
            CollectArticle collectArticle = collectArticleService
                    .getCollectArticleObj();
            if (!StringUtils.isEmpty(collectArticle)) {
                service.setStatus("SUCCESS");
                service.setPayload(collectArticle);
            } else {
                final ErrorPOJO error = new ErrorPOJO();
                error.setCode(getCollectArticleErrorCode);
                error.setMessage(getCollectArticleErrorMessage);
                service.setStatus("FAILURE");
                service.setError(error);

            }
        } catch (final Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            final ErrorPOJO error = new ErrorPOJO();
            error.setCode(getCollectArticleErrorCodes);
            error.setMessage(getCollectArticleErrorMessages);
            service.setStatus("ERROR");
            service.setError(error);
        }
        return service;
    }

}
