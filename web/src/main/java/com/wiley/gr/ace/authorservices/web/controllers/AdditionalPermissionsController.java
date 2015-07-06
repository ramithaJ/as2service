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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.AdditionalPermissions;
import com.wiley.gr.ace.authorservices.services.service.AdditionalPermissionService;

/**
 * @author virtusa version1.0
 *
 */
@RestController
@RequestMapping("/v1")
public class AdditionalPermissionsController {

	/**
	 * This field holds the value of additionalPermissionService
	 */
	@Autowired(required = true)
    private AdditionalPermissionService additionalPermissionService;
	
	/**
	 * @param userId
	 * @return service
	 */
	@RequestMapping(value = "/asdata/additionalPermissions/{userId}/", method = RequestMethod.GET)
	public Service getAdditionalPermissions(@PathVariable("userId") final String userId) {
		
		Service service = new Service();
		service.setPayload(additionalPermissionService.getAdditionalPermissions(userId));
		return service;
	}
	
	/**
	 * @param additionalPermissions
	 * @return service
	 */
	@RequestMapping(value = "/additionalpermissions/request/", method = RequestMethod.POST)
	public Service updateAdditionalPermissions(@RequestBody @Valid final AdditionalPermissions additionalPermissions) {
		
		Service service = new Service();
		additionalPermissionService.updateAdditionalPermissions(additionalPermissions);
		return service;
	}
}
