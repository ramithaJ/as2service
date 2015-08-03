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

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.RolesService;
import com.wiley.gr.ace.authorservices.model.external.PermissionData;
import com.wiley.gr.ace.authorservices.model.external.PermissionsRequest;
import com.wiley.gr.ace.authorservices.model.external.RoleRequest;
import com.wiley.gr.ace.authorservices.model.external.RolesData;
import com.wiley.gr.ace.authorservices.model.external.Status;

/**
 * The Class RolesServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class RolesServiceImpl implements RolesService {
    
    /** The roles url. */
    @Value("${roles.url}")
    private String rolesUrl;
    
    /** The roles url. */
    @Value("${permissions.url}")
    private String permissionsUrl;

	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#getRoles()
	 */
	@Override
	public List<RolesData> getRoles() {
	    
	    RolesData[] rolesArray = (RolesData[]) RestServiceInvokerUtil.getServiceData(rolesUrl, RolesData[].class);
	    
	    return Arrays.asList(rolesArray);
	}

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#getPermissions()
     */
    @Override
    public List<PermissionData> getPermissions() {
        
        PermissionData[] permissionsArray = (PermissionData[])RestServiceInvokerUtil.getServiceData(permissionsUrl, PermissionData[].class);
        
        return Arrays.asList(permissionsArray);
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#addRole(com.wiley.gr.ace.authorservices.model.external.RoleRequest)
     */
    @Override
    public void addRole(final RoleRequest roleRequest) {
        
        RestServiceInvokerUtil.restServiceInvoker(rolesUrl, roleRequest, Status.class);
        
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#addPermissions(com.wiley.gr.ace.authorservices.model.external.PermissionsRequest)
     */
    @Override
    public void addPermissions(final PermissionsRequest permissionsRequest) {
        
        RestServiceInvokerUtil.restServiceInvoker(rolesUrl, permissionsRequest, Status.class);
        
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#updateRole(com.wiley.gr.ace.authorservices.model.external.RoleRequest, java.lang.String)
     */
    @Override
    public void updateRole(final RoleRequest roleRequest, final String roleId) {
        
        RestServiceInvokerUtil.putServiceData(rolesUrl+"/"+roleId, roleRequest);
        
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#updatePermissions(com.wiley.gr.ace.authorservices.model.external.PermissionsRequest, java.lang.String)
     */
    @Override
    public void updatePermissions(final List<PermissionsRequest> permissionsRequestList, final String roleId) {
        
        RestServiceInvokerUtil.putServiceData(rolesUrl+"/"+roleId+"/permissions", permissionsRequestList.toArray());
        
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#getRolePermissions(java.lang.String)
     */
    @Override
    public List<PermissionData> getRolePermissions(final String roleId) {
        
        PermissionData[] permissionsArray = (PermissionData[]) RestServiceInvokerUtil.getServiceData(rolesUrl, RolesData[].class);
        
        return Arrays.asList(permissionsArray);
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#deleteRolePermission(java.lang.String, java.lang.String)
     */
    @Override
    public void deleteRolePermission(final String roleId, final String permissionCd) {
        RestServiceInvokerUtil.deleteServiceData(rolesUrl+"/"+roleId+"/permissions"+permissionCd);
    }
    
}
