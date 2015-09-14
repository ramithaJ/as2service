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

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.LicenseException;
import com.wiley.gr.ace.authorservices.model.LicenseObject;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.TrackLicense;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.services.service.LicenseService;

/**
 * The Class LicenseController.
 *
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/license")
public class LicenseController {

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LicenseController.class);

    /** The license service. */
    @Autowired(required = true)
    private LicenseService licenseService;

    /**
     * Gets the license type.
     *
     * @param articleId
     *            the article id
     * @param licenseObject
     *            the license object
     * @return the license type
     */
    @RequestMapping(value = "/types/{articleId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Service getLicenseType(
            @PathVariable("articleId") final String articleId,
            @RequestBody final LicenseObject licenseObject) {
        Service service = new Service();
        if (!StringUtils.isEmpty(articleId)
                && !StringUtils.isEmpty(licenseObject)) {
            LOGGER.info("fetching license type choice for article with article id: "
                    + articleId);
            ArrayList<String> licenseTypesOptions = licenseService
                    .getLicenseChoice(articleId, licenseObject);
            if (!StringUtils.isEmpty(licenseTypesOptions)) {
                LOGGER.info("Fetched the available license types for the article");
                service.setPayload(licenseTypesOptions);
            } else {
                LOGGER.error("No license type is available for this article");
                throw new LicenseException(
                        "SIGN_LICENSE_AGREEMENT_OA_CTA_LICENSE_TYPE_NOT_RETRIVED_ERR_TEXT",
                        "Failed to retrieve license for this article");
            }
        }

        return service;
    }

    /**
     * Gets the license status.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the license status
     */
    @RequestMapping(value = "/status/{dhId}/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service getLicenseStatus(
            @PathVariable("dhId") final String dhId,
            @PathVariable("userId") final String userId) {
        Service service = new Service();
        TrackLicense licenseStatus = null;
        try {
            LOGGER.info("Getting License status ..");
            licenseStatus = licenseService.trackLicenseStatus(dhId, userId);
        } catch (Exception e) {
            LOGGER.error("Print Stack Trace " + e);
            throw new ASException("2301", "Error Fetching License Details");
        }
        LOGGER.debug("License status :: " + licenseStatus);
        service.setPayload(licenseStatus);
        return service;
    }

    /**
     * Initiate licence.
     *
     * @param articleId
     *            the article id
     * @return the service
     */
    @RequestMapping(value = "/initiate/{userId}/{articleId}/", method = RequestMethod.GET)
    public Service initiateLicence(@PathVariable("userId") final String userId,
            @PathVariable("articleId") final String articleId,
            @RequestParam("articleType") final String articleType) {
        Service service = new Service();
        service.setPayload(licenseService.initiateLicence(userId, articleId,
                articleType));
        return service;

    }

    /**
     * Gets the license text.
     *
     * @param licenseChoiceRequest
     *            the license choice request
     * @return the license text
     */
    @RequestMapping(value = "/licensetext/", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getLicenseText(
            @RequestBody final LicenseChoiceRequest licenseChoiceRequest) {
        return licenseService.getLicenseText(licenseChoiceRequest);

    }

    /**
     * Save license.
     *
     * @param licenseObject
     *            the license object
     * @param userId
     *            the user id
     * @param articleId
     *            the article id
     * @return the service
     */
    @RequestMapping(value = "/saveLicence/{userId}/{articleId}/", method = RequestMethod.POST)
    public Service saveLicense(@RequestBody final LicenseObject licenseObject,
            @PathVariable("userId") final String userId,
            @PathVariable("articleId") final String articleId) {

        Service service = new Service();
        service.setPayload(licenseService.saveLicenseLater(licenseObject,
                userId, articleId));
        return service;

    }

}
