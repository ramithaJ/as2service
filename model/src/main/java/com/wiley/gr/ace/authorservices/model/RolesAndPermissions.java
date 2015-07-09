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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

/**
 * The Class RolesAndPermissions.
 *
 * @author virtusa version 1.0
 */
public class RolesAndPermissions {

    /** The roles list. */
    @NotNull
    private List<Role> rolesList = new ArrayList<Role>();

    /** The sections list. */
    private List<PermissionSection> sectionsList = new ArrayList<PermissionSection>();

    /** The permissions map. */
    @NotNull
    private Map<String, String[]> permissionsMap = new HashMap<String, String[]>();

    /**
     * Gets the roles list.
     *
     * @return the rolesList
     */
    public final List<Role> getRolesList() {
        return rolesList;
    }

    /**
     * Sets the roles list.
     *
     * @param rolesList
     *            the rolesList to set
     */
    public final void setRolesList(final List<Role> rolesList) {
        this.rolesList = rolesList;
    }

    /**
     * Gets the sections list.
     *
     * @return the sectionsList
     */
    public final List<PermissionSection> getSectionsList() {
        return sectionsList;
    }

    /**
     * Sets the sections list.
     *
     * @param sectionsList
     *            the sectionsList to set
     */
    public final void setSectionsList(final List<PermissionSection> sectionsList) {
        this.sectionsList = sectionsList;
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
