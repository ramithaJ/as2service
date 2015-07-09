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
     * @return the permissionId
     */
    public final String getPermissionId() {
        return permissionId;
    }

    /**
     * Sets the permission id.
     *
     * @param permissionId
     *            the permissionId to set
     */
    public final void setPermissionId(final String permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * Gets the permission name.
     *
     * @return the permissionName
     */
    public final String getPermissionName() {
        return permissionName;
    }

    /**
     * Sets the permission name.
     *
     * @param permissionName
     *            the permissionName to set
     */
    public final void setPermissionName(final String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * Checks if is status.
     *
     * @return the status
     */
    public final boolean isStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the status to set
     */
    public final void setStatus(final boolean status) {
        this.status = status;
    }

}
