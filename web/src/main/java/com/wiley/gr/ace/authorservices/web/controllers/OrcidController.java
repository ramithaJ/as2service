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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;

/**
 * @author vkumark
 *
 */
@RestController
@RequestMapping("/orcid")
public class OrcidController {

	@Autowired(required = true)
	OrcidService orcidService;

	/**
	 * @return ORCID URL
	 */
	@RequestMapping(value = "/url", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Service getOrcidURL() {
		Service service = new Service();

		try {
			/**
			 * Depending on the environment the ORCID URL changes
			 */
			String env = "DEV";// Need to fetch this from prop file
			String url = "";
			if (null != env) {
				url = "https://orcid.org/oauth/authorize?client_id=APP-7E4BRADG8DTVCY64&response_type=code&scope=/authenticate&redirect_uri=http://www.vinay.com:8080/orcid/index.jsp";
				service.setStatus("SUCCESS");
				service.setPayload(url);
			}
		} catch (Exception e) {
			ErrorPOJO error = new ErrorPOJO();
			error.setCode(-101); // Need to set proper error code this one is
									// dummy
			error.setMessage("Error while fetching ORCID URL");

			service.setStatus("error");
			service.setError(error);
			throw new ASException("-2", "Error while fetching ORCID URL", e);
		}
		return service;
	}

	/**
	 * @param authorizationCode
	 * @return
	 */
	@RequestMapping(value = "/orcidprofile/{authorizationCode}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Service getOrcidDetails(
			@PathVariable String authorizationCode) {
		Service service = new Service();
		try {
			if (null != authorizationCode) {
				OrcidAccessToken accessToken = orcidService
						.getAccessToken(authorizationCode);
				if (null != accessToken) {
System.out.println("accessToken.getAccess_token() --->"+accessToken.getAccess_token());
System.out.println("accessToken.getOrcid() ---> "+accessToken.getOrcid());
				}
			}
		} catch (Exception e) {
			ErrorPOJO error = new ErrorPOJO();
			error.setCode(-101); // Need to set proper error code this one is
									// dummy
			error.setMessage("Error while fetching ORCID details");

			service.setStatus("error");
			service.setError(error);
			throw new ASException("-2", "Error while fetching ORCID details", e);
		}
		return service;
	}
}
