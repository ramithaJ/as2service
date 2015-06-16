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

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

/**
 * The Class ASRolesAndPermissions.
 *
 * @author virtusa version 1.0
 */
public class ASRolesAndPermissions {

    /** The role. */
    @NotNull
    private Role role = new Role();

    /** The permissions map. */
    @NotNull
    private Map<String, String[]> permissionsMap = new HashMap<String, String[]>();

    /**
     * Gets the role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role
     *            the new role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets the permissions map.
     *
     * @return the permissions map
     */
    public Map<String, String[]> getPermissionsMap() {
        return permissionsMap;
    }

    /**
     * Sets the permissions map.
     *
     * @param permissionsMap
     *            the permissions map
     */
    public void setPermissionsMap(Map<String, String[]> permissionsMap) {
        this.permissionsMap = permissionsMap;
    }

}
