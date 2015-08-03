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

import com.wiley.gr.ace.authorservices.model.external.PermissionData;
import com.wiley.gr.ace.authorservices.model.external.PermissionsRequest;
import com.wiley.gr.ace.authorservices.model.external.RoleRequest;
import com.wiley.gr.ace.authorservices.model.external.RolesData;

/**
 * The Class RolesService.
 *
 * @author virtusa version 1.0
 */
public interface RolesService {
	
	/**
	 * This method calls the Roles and Permissions Shared Service to get the role data.
	 *
	 * @return the roles
	 */
	List<RolesData> getRoles();
	
	/**
	 * Gets the permissions.
	 *
	 * @return the permissions
	 */
	List<PermissionData> getPermissions();
	
	/**
	 * Adds the role.
	 *
	 * @param roleRequest the role request
	 */
	void addRole(RoleRequest roleRequest);
	
	/**
	 * Adds the permissions.
	 *
	 * @param permissionsRequest the permissions request
	 */
	void addPermissions(PermissionsRequest permissionsRequest);
	
	/**
	 * Update role.
	 *
	 * @param roleRequest the role request
	 * @param roleId the role id
	 */
	void updateRole(RoleRequest roleRequest, final String roleId);
	
	/**
	 * Update permissions.
	 *
	 * @param permissionsRequest the permissions request
	 * @param roleId the role id
	 */
	void updatePermissions(List<PermissionsRequest> permissionsRequestList, final String roleId);
	
	/**
	 * Gets the role permissions.
	 *
	 * @param roleId the role id
	 * @return the role permissions
	 */
	List<PermissionData> getRolePermissions(String roleId);
	
	/**
	 * Delete role permission.
	 *
	 * @param roleId the role id
	 * @param permissionCd the permission cd
	 */
	void deleteRolePermission(String roleId, String permissionCd);
	
}
