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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.LicenseException;
import com.wiley.gr.ace.authorservices.model.LicenseObject;
import com.wiley.gr.ace.authorservices.model.LicenseStatus;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.LicenseService;

/**
 * @author virtusa version 1.0
 *
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
	public Service getLicenseType(@PathVariable("articleId") final String articleId,
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
	 * @param dhId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/status/{dhId}/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Service getLicenseStatus(
			@PathVariable("dhId") final String dhId,
			@PathVariable("userId") final String userId) {

		Service service = new Service();
		LOGGER.info("Getting License status ..");
		LicenseStatus licenseStatus = licenseService.getLicenseStatus(dhId,
				userId);
		LOGGER.debug("License status :: " + licenseStatus);
		return service;
	}
	
	@RequestMapping(value="/initiate/{articleId}/" ,method=RequestMethod.GET)
	public Service initiateLicence(@PathVariable("articleId") final String articleId){
	    Service service= new Service();
	   service.setPayload(licenseService.initiateLicence(articleId)); 
        return service;
	    
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value="/licensetext/" ,method=RequestMethod.POST ,produces=MediaType.TEXT_PLAIN_VALUE)
	public  String getLicenseText(@RequestBody final LicenseObject licenseObject){
        return licenseService.getLicenseText(licenseObject);
	    
	    
	}
}
