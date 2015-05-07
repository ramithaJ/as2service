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
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author vkumark
 *
 */
@RestController
@RequestMapping("/user/update")
public class UpdateUserController {

	@Autowired(required = true)
	UpdateUserService updateUserService;

	/**
	 * @param orcidId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{orcidId}/{userId}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Service updateUserOrcidDetails(
			@PathVariable String orcidId, @PathVariable String userId) {

		User user = null;
		Service service = new Service();
		try {
			user = updateUserService.updateOrcidProfile(orcidId, userId);
			if (user != null) {
				service.setStatus("success");
				service.setPayload(user);
			} else {
				service.setStatus("failure");
				service.setPayload(user);
			}
		} catch (Exception e) {
			ErrorPOJO error = new ErrorPOJO();
			error.setCode(-100); // Need to set proper error code this one is
									// dummy
			error.setMessage("Error updating user details with ORCID details");

			service.setStatus("error");
			service.setPayload(user);
			service.setError(error);
			throw new ASException("-1",
					"Error updating user details with ORCID details", e);
		}
		return service;
	}

	/**
	 * @param orcidId
	 * @return
	 */
	@RequestMapping(value = "/orcid/{orcid}/{userId}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Service updateOrcidId(@PathVariable String orcidId,
			@PathVariable String userId) {

		Service service = new Service();
		String status = "";

		try {
			status = updateUserService.updateOrcidId(orcidId, userId);
			System.out.println("status @@@@@@@@@@ " + status);

			if (null != status && status.equalsIgnoreCase("success")) {
				service.setStatus("success");
				service.setPayload(status);
			} else {
				service.setStatus("failure");
				service.setPayload(status);
			}
		} catch (Exception e) {
			ErrorPOJO error = new ErrorPOJO();
			error.setCode(-101); // Need to set proper error code this one is
									// dummy
			error.setMessage("Error updating user ORCID ID");

			service.setStatus("error");
			service.setPayload(status);
			service.setError(error);
			throw new ASException("-2", "Error updating user user ORCID ID", e);
		}
		return service;
	}
}
