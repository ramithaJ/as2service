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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * The Class UpdateUserController.
 *
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/user/update")
public class UpdateUserController {

    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UpdateUserController.class);
    /**
     * getting bean of update user service.
     */
    @Autowired(required = true)
    private UpdateUserService updateUserService;

    /** The no orcid update code. */
    @Value("${noOrcidUpdate.code}")
    private String noOrcidUpdateCode;

    /**
     * Update orcid id.
     *
     * @param orcidId
     *            - The request value
     * @param userId
     *            - The request value
     * @param emailId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/orcid/{orcidId}/{userId}", method = RequestMethod.POST)
    public final Service updateOrcidId(@PathVariable final String orcidId,
            @PathVariable final String userId, @RequestBody final String emailId) {
        final Service service = new Service();
        try {
            service.setPayload(updateUserService.updateOrcidId(emailId,
                    orcidId, userId));
        } catch (final Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            final ErrorPOJO error = new ErrorPOJO();
            error.setCode(noOrcidUpdateCode);
            error.setMessage("Error updating user ORCID ID");
            service.setStatus("error");
            service.setPayload(service);
            service.setError(error);
            throw new ASException("-2", "Error updating user user ORCID ID", e);
        }
        return service;
    }
}
