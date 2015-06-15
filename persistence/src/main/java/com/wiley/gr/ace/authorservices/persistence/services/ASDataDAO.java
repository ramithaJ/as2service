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
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;

/**
 * @author virtusa
 *	version 1.0
 */
public interface ASDataDAO {
    
    /**
     * @return
     */
    List<LookupValues> getDropDown(String keyName);
    
    /**
     * @return
     */
    List<Roles> getAdminRoles(String roleId);
    
    /**
     * @return
     */
    List<Roles> getUserRoles(String roleId);
    
    /**
     * This method gets all the permissions in the system
     * 
     * @return
     */
    List<Permissions> getPermissions();
    
    /**
     * This method returns the permissions for all roles
     * 
     * @return
     */
    List<RolePermissions> getRolePermissionMappings(String roleId);
    
    int getCount(int roleId);
    
}
