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
 * @author virtusa
 *	version 1.0
 */
public class UserPermissions {
    
    private String permissionId;
    
    private String permissionName;
    
    private boolean status = true;
    
    /**
     * @return
     */
    public String getPermissionId() {
        return permissionId;
    }
    
    /**
     * @param permissionId
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
    
    /**
     * @return
     */
    public String getPermissionName() {
        return permissionName;
    }
    
    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
    
    /**
     * @return
     */
    public boolean isStatus() {
        return status;
    }
    
    /**
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
