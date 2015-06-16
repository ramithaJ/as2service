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

package com.wiley.gr.ace.authorservices.model;

/**
 * The Class RolePermissionMapping.
 *
 * @author virtusa version 1.0
 */
public class RolePermissionMapping {

    /** The role id. */
    private String roleId;

    /** The permissions list. */
    private StringBuffer permissionsList;

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    /**
     * @return
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId
     *            the new role id
     */
    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the permissions list.
     *
     * @return the permissions list
     */
    public StringBuffer getPermissionsList() {
        return permissionsList;
    }

    /**
     * Sets the permissions list.
     *
     * @param permissionsList
     *            the new permissions list
     */
    public void setPermissionsList(StringBuffer permissionsList) {
        this.permissionsList = permissionsList;
    }

}
