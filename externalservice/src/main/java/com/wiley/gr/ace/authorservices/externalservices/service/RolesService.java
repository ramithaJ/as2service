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
package com.wiley.gr.ace.authorservices.externalservices.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.external.RolesData;

/**
 * The Class RolesService.
 *
 * @author virtusa version 1.0
 */
public interface RolesService {
	
	/**
	 * This method calls the Roles and Permissions Shared Service to get the role data
	 * 
	 * @return
	 */
	List<RolesData> getRoles();
	
	/**
	 * This method returns the admin related roles
	 * 
	 * @return
	 */
	List<Role> getAdminRoles();

}
