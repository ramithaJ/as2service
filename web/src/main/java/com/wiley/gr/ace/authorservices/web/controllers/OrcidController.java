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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.exception.ASException;
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

    /** value from props file configured. */
    @Value("${OrcidController.getOrcidURL.code}")
    private String getOrcidURLErrorCode;

    /** value from props file configured. */
    @Value("${OrcidController.getOrcidURL.message}")
    private String getOrcidURLErrorMessage;

    /** value from props file configured. */
    @Value("${OrcidController.getOrcidDetails.code}")
    private String getOrcidDetailsErrorCode;

    /** value from props file configured. */
    @Value("${OrcidController.getOrcidDetails.message}")
    private String getOrcidDetailsErrorMessage;

    /** The get orcid id error code. */
    @Value("${OrcidController.getOrcidId.code}")
    private String getOrcidIdErrorCode;

    /** The get orcid id error message. */
    @Value("{OrcidController.getOrcidDetails.message}")
    private String getOrcidIdErrorMessage;

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
            StringBuilder url = new StringBuilder();
            url = url
                    .append("https://")
                    .append(orcidUrl)
                    .append("/oauth/authorize?client_id=")
                    .append(orcidClientId)
                    .append("&response_type=code&scope=/authenticate&redirect_uri=")
                    .append(orcidRedirectUrl);
            service.setStatus("SUCCESS");
            service.setPayload(url);

        } catch (final Exception e) {
            throw new ASException(getOrcidURLErrorCode,
                    getOrcidURLErrorMessage, e);
        }
        return service;
    }

    /**
     * Gets the orcid data.
     *
     * @param type
     *            the type
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the orcid data
     */
    @RequestMapping(value = "/authorization/{type}", method = RequestMethod.GET)
    public final void getOrcidData(@PathVariable("type") final String type,
            HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("inside getOrcidData() method of OrcidController ");
        Service service = new Service();
        User user = null;
        try {
            String authrizationCode = request.getParameter("code");
            LOGGER.info("authrizationCode------>" + authrizationCode);
            if (null != authrizationCode) {
                final OrcidAccessToken orcidAccessToken = orcidService
                        .getAccessToken(authrizationCode);
                if (null != orcidAccessToken) {
                    LOGGER.info("accessToken.getAccess_token() --->"
                            + orcidAccessToken.getAccessToken());
                    LOGGER.info("accessToken.getOrcid() ---> "
                            + orcidAccessToken.getOrcid());
                    if (null != type) {
                        user = orcidService.getBio(orcidAccessToken);
                        if ("userupdate".equalsIgnoreCase(type)) {
                            orcidService.getWork(orcidAccessToken, user);
                        }
                    }
                    service.setStatus("SUCCESS");
                    service.setPayload(user);
                    LOGGER.info("service.toString() --> "+ service.toString());
                    ObjectMapper objectMapper = new ObjectMapper();
                    String serviceStr = objectMapper.writeValueAsString(service);
                    LOGGER.info("serviceStr--> "+ serviceStr);
//                    response.addHeader("ORCIDINFO", serviceStr);
//                    response.setStatus(HttpStatus.SC_MOVED_PERMANENTLY);
                    response.sendRedirect("http://authorservicesdev.wiley.com/landing.html#register/orcid/"+serviceStr);
                                                           
                    
//                    request.setAttribute("ORCIDINFO", service);
//                    RequestDispatcher rd = request
//                            .getRequestDispatcher("http://authorservicesdev.wiley.com/landing.html#register/orcid");
//                    rd.forward(request, response);
                }
            }
        } catch (final Exception e) {
            LOGGER.error("Stack Trace-.", e);
            throw new ASException(getOrcidDetailsErrorCode,
                    getOrcidDetailsErrorMessage, e);
        }
        // return service;
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
            LOGGER.error("Stack Trace-.", e);
            throw new ASException(getOrcidDetailsErrorCode,
                    getOrcidDetailsErrorMessage, e);
        }
        return service;
    }

    /**
     * Gets the orcid id.
     *
     * @param participantId
     *            the participant id
     * @return the orcid id
     */
    @RequestMapping(value = "/{participantId}", method = RequestMethod.GET)
    public final Service getOrcidId(@PathVariable final String participantId) {
        Service service = new Service();
        if (!StringUtils.isEmpty(participantId))
            try {
                service.setPayload(orcidService.getOrcidId(participantId));
            } catch (final Exception e) {
                LOGGER.error("Stack Trace-.", e);
                throw new ASException(getOrcidIdErrorCode,
                        getOrcidIdErrorMessage, e);
            }
        return service;
    }

}
