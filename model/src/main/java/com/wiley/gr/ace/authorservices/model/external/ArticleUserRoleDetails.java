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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class ArticleUserRoleDetails.
 *
 * @author virtusa version 1.0
 */
public class ArticleUserRoleDetails {

    /** The role code. */
    private String roleCode;

    /** The role name. */
    private String roleName;

    /**
     * Gets the role code.
     *
     * @return the roleCode
     */
    public final String getRoleCode() {
        return roleCode;
    }

    /**
     * Sets the role code.
     *
     * @param roleCode
     *            the roleCode to set
     */
    public final void setRoleCode(final String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * Gets the role name.
     *
     * @return the roleName
     */
    public final String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName
     *            the roleName to set
     */
    public final void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

}
