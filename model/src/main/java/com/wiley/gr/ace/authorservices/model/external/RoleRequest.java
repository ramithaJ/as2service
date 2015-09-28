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

/**
 * The Class RoleRequest.
 */
public class RoleRequest {
    
    /** The role id. */
    private String roleId;
    
    /** The role name. */
    private String roleName;
    
    /** The role description. */
    private String roleDescription;
    
    /** The role type. */
    private String roleType;
    
    /** The created by. */
    private String createdBy;
    
    /** The updated by. */
    private String updatedBy;

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(final String roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName the new role name
     */
    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets the role description.
     *
     * @return the role description
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * Sets the role description.
     *
     * @param roleDescription the new role description
     */
    public void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * Gets the role type.
     *
     * @return the role type
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets the role type.
     *
     * @param roleType the new role type
     */
    public void setRoleType(final String roleType) {
        this.roleType = roleType;
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
    
    

}
