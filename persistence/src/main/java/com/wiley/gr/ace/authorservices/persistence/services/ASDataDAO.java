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
 * @author virtusa version 1.0
 */
public interface ASDataDAO {

    /**
     * This method gets the List of LookupValues from AS 2.0 DB.
     * 
     * @param keyName
     *            to Retrieve.
     * @return the List of Lookup Values.
     */
    List<LookupValues> getDropDown(String keyName);

    /**
     * This method gets the List of Roles of Admin from AS 2.0 DB.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the List of Roles.
     */
    List<Roles> getAdminRoles(String roleId);

    /**
     * This method gets the List of Roles of User from AS 2.0 DB.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the List of Roles.
     */
    List<Roles> getUserRoles(String roleId);

    /**
     * This method gets all the permissions from AS 2.0 DB.
     * 
     * @return the List of Permissions.
     */
    List<Permissions> getPermissions();

    /**
     * This method gets the Role Permissions Mappings for all roles from AS 2.0
     * DB.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the List of Role Permissions.
     */
    List<RolePermissions> getRolePermissionMappings(String roleId);

    /**
     * This method gets the count of Roles.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the count
     */
    int getCount(int roleId);

}
