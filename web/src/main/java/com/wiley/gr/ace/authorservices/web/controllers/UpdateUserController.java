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

	/**
	 * @param orcidId
	 * @param userId
	 * @return
	 */
	@Autowired(required = true)
	UpdateUserService updateUserService;

	@RequestMapping(value = "/orcid/{orcidId}/{userId}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Service updateUserOrcidDetails(
			@PathVariable String orcidId, @PathVariable String userId) {
		User user = null;
		Service service = null;
		try {
			user = updateUserService.updateOrcidProfile(orcidId, userId);
		} catch (Exception e) {
			throw new ASException("-1",
					"Error updating user details with ORCID details", e);
		}
		if (user != null) {
			service = new Service();
			service.setStatus("success");
			service.setPayload(user);
		} else {
			service = new Service();
			service.setStatus("failure");
		}
		return service;
	}

}
