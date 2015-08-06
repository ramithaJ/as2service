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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;

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

	/** The input parameter not found. */
	@Value("${inputParameterNotFound.message}")
	private String inputParameterNotFound;

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

		if (StringUtils.isEmpty(dhId) || StringUtils.isEmpty(userId)) {
			LOGGER.info("Input parameter DH_ID or UserID is null or empty");
			service.setStatus("FAILURE");
			service.setPayload(inputParameterNotFound);
			return service;
		}
		
		return service;
	}
}
