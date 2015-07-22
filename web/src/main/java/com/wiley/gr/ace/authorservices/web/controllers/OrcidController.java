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

package com.wiley.gr.ace.authorservices.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;

/**
 * The Class OrcidController.
 *
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("user/orcid")
public class OrcidController {

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrcidController.class);

    /** The orcid service. */
    @Autowired(required = true)
    private OrcidService orcidService;

    /**
     * orcidUrl From Props File.
     */
    @Value("${orcid.url}")
    private String orcidUrl;

    /**
     * orcidClientId From Props File.
     */
    @Value("${orcid-clientid}")
    private String orcidClientId;

    /**
     * orcidRedirectUrl From Props File.
     */
    @Value("${orcid-redirect.url}")
    private String orcidRedirectUrl;

    /** The no orcid url code. */
    @Value("${noOrcidURL.code}")
    private String noOrcidURLCode;

    /** The no orcid data code. */
    @Value("${noOrcidData.code}")
    private String noOrcidDataCode;

    /**
     * Gets the orcid url.
     *
     * @return the orcid url
     */
    @RequestMapping(value = "/url", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Service getOrcidURL() {
        final Service service = new Service();
        try {
            /**
             * Depending on the environment the ORCID URL changes
             */
            String url = "";
            url = "https://" + orcidUrl + "/oauth/authorize?client_id="
                    + orcidClientId
                    + "&response_type=code&scope=/authenticate&redirect_uri="
                    + orcidRedirectUrl;
            service.setStatus("SUCCESS");
            service.setPayload(url);

        } catch (final Exception e) {
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(noOrcidURLCode);
            error.setMessage("Error while fetching ORCID URL");
            service.setStatus("error");
            service.setError(error);
            throw new ASException("-2", "Error while fetching ORCID URL", e);
        }
        return service;
    }

    /**
     * Gets the orcid details.
     *
     * @param type
     *            the type
     * @param authorizationCode
     *            the authorization code
     * @return the orcid details
     */
    @RequestMapping(value = "/profile/{type}/{authorizationCode}", method = RequestMethod.GET)
    public final Service getOrcidDetails(@PathVariable final String type,
            @PathVariable final String authorizationCode) {
        Service service = new Service();
        User user = null;
        try {

            if (null != authorizationCode) {
                final OrcidAccessToken accessToken = orcidService
                        .getAccessToken(authorizationCode);
                if (null != accessToken) {
                    LOGGER.info("accessToken.getAccess_token() --->"
                            + accessToken.getAccessToken());
                    LOGGER.info("accessToken.getOrcid() ---> "
                            + accessToken.getOrcid());
                    if (null != type) {
                        user = orcidService.getBio(accessToken);
                        if ("userupdate".equalsIgnoreCase(type)) {
                            orcidService.getWork(accessToken, user);
                        }
                    }
                    service.setStatus("SUCCESS");
                    service.setPayload(user);
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
            LOGGER.error("Stack Trace-.", e);
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(noOrcidDataCode);
            error.setMessage("Error while fetching ORCID details");

            service.setStatus("error");
            service.setError(error);
            throw new ASException("-2", "Error while fetching ORCID details", e);
        }
        return service;
    }
}
