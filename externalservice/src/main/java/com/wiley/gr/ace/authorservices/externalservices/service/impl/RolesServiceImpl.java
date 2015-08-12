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

    /**
     * call Roles service of shared services
     * 
     * @return roles data list
     */
    @Override
    public final List<RolesData> getRoles() {

        RolesData[] rolesArray = (RolesData[]) RestServiceInvokerUtil
                .getServiceData(rolesUrl, RolesData[].class);

        return Arrays.asList(rolesArray);
    }

    /**
     * call Roles service of shared services for getting permissions
     * 
     * @return permissions data list
     */
    @Override
    public final List<PermissionData> getPermissions() {

        PermissionData[] permissionsArray = (PermissionData[]) RestServiceInvokerUtil
                .getServiceData(permissionsUrl, PermissionData[].class);

        return Arrays.asList(permissionsArray);
    }

    /**
     * call Roles service of shared services for adding roles..
     * 
     * @param roleRequest
     * */
    @Override
    public final void addRole(final RoleRequest roleRequest) {

        RestServiceInvokerUtil.restServiceInvoker(rolesUrl, roleRequest,
                Status.class);

    }

    /**
     * call Roles service of shared services for adding permissions
     * 
     * @param permissionsRequest
     * */
    @Override
    public final void addPermissions(final PermissionsRequest permissionsRequest) {

        RestServiceInvokerUtil.restServiceInvoker(rolesUrl, permissionsRequest,
                Status.class);

    }

    /**
     * call Roles service of shared services for updating roles
     * 
     * @param roleRequest
     * @param roleId
     * 
     * */
    @Override
    public final void updateRole(final RoleRequest roleRequest,
            final String roleId) {

        RestServiceInvokerUtil.putServiceData(rolesUrl + "/" + roleId,
                roleRequest);

    }

    /**
     * call Roles service of shared services for updating permissions
     * 
     * @param permissionsRequestList
     * @param roleId
     * */
    @Override
    public final void updatePermissions(
            final List<PermissionsRequest> permissionsRequestList,
            final String roleId) {

        RestServiceInvokerUtil.putServiceData(rolesUrl + "/" + roleId
                + "/permissions", permissionsRequestList.toArray());

    }

    /**
     * call Roles service of shared services
     * 
     * @param roleId
     * @return permissions data list
     * 
     * */
    @Override
    public final List<PermissionData> getRolePermissions(final String roleId) {

        PermissionData[] permissionsArray = (PermissionData[]) RestServiceInvokerUtil
                .getServiceData(rolesUrl, RolesData[].class);

        return Arrays.asList(permissionsArray);
    }

    /**
     * call Roles service of shared services for deleting roles and permissions
     * 
     * @param roleId
     * @param permissionCd
     * */
    @Override
    public final void deleteRolePermission(final String roleId,
            final String permissionCd) {
        RestServiceInvokerUtil.deleteServiceData(rolesUrl + "/" + roleId
                + "/permissions" + permissionCd);
    }

}
