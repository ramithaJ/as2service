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
 * @author sarmakumarap
 */
public class RolePermissionMapping {
    
    private String roleId;
    
    private StringBuffer permissionsList;
    
    /**
     * @return
     */
    /**
     * @return
     */
    public String getRoleId() {
        return roleId;
    }
    
    /**
     * @param roleId
     */
    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    /**
     * @return
     */
    public StringBuffer getPermissionsList() {
        return permissionsList;
    }
    
    /**
     * @param permissionsList
     */
    public void setPermissionsList(StringBuffer permissionsList) {
        this.permissionsList = permissionsList;
    }
    
}
