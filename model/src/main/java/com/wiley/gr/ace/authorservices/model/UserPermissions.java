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
 * The Class UserPermissions.
 *
 * @author virtusa version 1.0
 */
public class UserPermissions {

    /** The permission id. */
    private String permissionId;

    /** The permission name. */
    private String permissionName;

    /** The status. */
    private boolean status = true;

    /**
     * Gets the permission id.
     *
     * @return the permission id
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * Sets the permission id.
     *
     * @param permissionId
     *            the new permission id
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
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
     * @param permissionName
     *            the new permission name
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * Checks if is status.
     *
     * @return true, if is status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
