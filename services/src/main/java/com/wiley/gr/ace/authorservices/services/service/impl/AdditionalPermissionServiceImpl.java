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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.PermissionService;
import com.wiley.gr.ace.authorservices.model.AdditionalPermissionsResponse;
import com.wiley.gr.ace.authorservices.model.Permissions;
import com.wiley.gr.ace.authorservices.model.external.AdditionalPermissions;
import com.wiley.gr.ace.authorservices.model.external.AdditionalPermissionsRequest;
import com.wiley.gr.ace.authorservices.services.service.AdditionalPermissionService;

public class AdditionalPermissionServiceImpl implements
		AdditionalPermissionService {

	@Autowired(required = true)
    private PermissionService permissionService; 
	
	/**
	 * Method to get Get Additional Permissions.
	 */
	@Override
	public AdditionalPermissionsResponse getAdditionalPermissions(
			final String userId) {

		AdditionalPermissions AdditionalPermissions = permissionService.getAdditionalPermissions(userId);
		List<AdditionalPermissionsRequest> additionalPermissionsList = AdditionalPermissions
				.getPermissions();
		AdditionalPermissionsResponse additionalPermissionsResponse = new AdditionalPermissionsResponse();
		List<Permissions> permissionsList = new ArrayList<Permissions>();
		Permissions permissions = null;
		for (AdditionalPermissionsRequest additionalPermissionsRequest : additionalPermissionsList) {
			permissions = new Permissions();
			permissions.setPermissionCd(additionalPermissionsRequest
					.getPermissionCd());
			permissions.setPermissionName(additionalPermissionsRequest
					.getPermissionName());
			permissionsList.add(permissions);
		}
		additionalPermissionsResponse.setPermissions(permissionsList);
		return additionalPermissionsResponse;
	}

	/**
	 * Method to update Additional permissions.
	 */
	@Override
	public boolean updateAdditionalPermissions(
			final AdditionalPermissions additionalPermissions) {
		// TODO Auto-generated method stub
		return true;
	}

}
