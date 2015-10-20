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
 * @author virtusa version1.0
 *
 */
public class Permissions {

    /**
     * This field holds the value of permissionCd
     */
    private String permissionCd;

    /**
     * This field holds the value of permissionName
     */
    private String permissionName;

    /**
     * @return the permissionCd
     */
    public String getPermissionCd() {
        return permissionCd;
    }

    /**
     * @param permissionCd
     *            the permissionCd to set
     */
    public void setPermissionCd(final String permissionCd) {
        this.permissionCd = permissionCd;
    }

    /**
     * @return the permissionName
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     *            the permissionName to set
     */
    public void setPermissionName(final String permissionName) {
        this.permissionName = permissionName;
    }

}
