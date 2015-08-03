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

// TODO: Auto-generated Javadoc
/**
 * The Class ASRolesAndPermissions.
 *
 * @author virtusa version 1.0
 */
public class ASRolesAndPermissions {

    
    /** The user id. */
    @NotNull
    private String userId;
    /** The role. */
    @NotNull
    private Role role = new Role();

    /** The permissions map. */
    @NotNull
    private Map<String, String[]> permissionsMap = new HashMap<String, String[]>();

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public final Role getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role
     *            the role to set
     */
    public final void setRole(final Role role) {
        this.role = role;
    }

    /**
     * Gets the permissions map.
     *
     * @return the permissionsMap
     */
    public final Map<String, String[]> getPermissionsMap() {
        return permissionsMap;
    }

    /**
     * Sets the permissions map.
     *
     * @param permissionsMap
     *            the permissionsMap to set
     */
    public final void setPermissionsMap(
            final Map<String, String[]> permissionsMap) {
        this.permissionsMap = permissionsMap;
    }

}
