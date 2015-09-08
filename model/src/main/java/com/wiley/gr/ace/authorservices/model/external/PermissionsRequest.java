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

package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * The Class PermissionsRequest.
 */
public class PermissionsRequest {
    
    /** The permission cd. */
    private String permissionCd;
    
    /** The permission name. */
    private String permissionName;
    
    /** The created on. */
    private String createdOn;
    
    /** The updated on. */
    private String updatedOn;
    
    /** The created by. */
    private String createdBy;
    
    /** The updated by. */
    private String updatedBy;
    
    /** The groups. */
    private List<String> groups;

    /**
     * Gets the permission cd.
     *
     * @return the permission cd
     */
    public String getPermissionCd() {
        return permissionCd;
    }

    /**
     * Sets the permission cd.
     *
     * @param permissionCd the new permission cd
     */
    public void setPermissionCd(final String permissionCd) {
        this.permissionCd = permissionCd;
    }

    /**
     * Gets the permission name.
     *
     * @return the permission name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * Sets the permission name.
     *
     * @param permissionName the new permission name
     */
    public void setPermissionName(final String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * Gets the created on.
     *
     * @return the created on
     */
    public String getCreatedOn() {
        return createdOn;
    }

    /**
     * Sets the created on.
     *
     * @param createdOn the new created on
     */
    public void setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * Gets the updated on.
     *
     * @return the updated on
     */
    public String getUpdatedOn() {
        return updatedOn;
    }

    /**
     * Sets the updated on.
     *
     * @param updatedOn the new updated on
     */
    public void setUpdatedOn(final String updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * Gets the created by.
     *
     * @return the created by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the created by.
     *
     * @param createdBy the new created by
     */
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the updated by.
     *
     * @return the updated by
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets the updated by.
     *
     * @param updatedBy the new updated by
     */
    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * Gets the groups.
     *
     * @return the groups
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Sets the groups.
     *
     * @param groups the new groups
     */
    public void setGroups(final List<String> groups) {
        this.groups = groups;
    }

}
