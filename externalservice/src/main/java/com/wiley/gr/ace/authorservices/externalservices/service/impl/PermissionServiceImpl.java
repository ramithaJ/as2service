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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.PermissionService;
import com.wiley.gr.ace.authorservices.model.external.AdditionalPermissions;

/**
 * @author virtusa version1.0
 *
 */
public class PermissionServiceImpl implements PermissionService {

	/**
	 * This field holds the value of additionalPermissionsurl
	 */
	@Value("${additionalPermissions.url}")
	private String additionalPermissionsurl;

	/**
	 * Method to get additional permissions.
	 */
	@Override
	public AdditionalPermissions getAdditionalPermissions(final String userId) {

		return (AdditionalPermissions) StubInvokerUtil.invokeJsonStub(
				additionalPermissionsurl, HttpMethod.POST,
				AdditionalPermissions.class);
	}

}
