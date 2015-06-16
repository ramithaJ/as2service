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
 * @author yugandhark
 */
public class ArticleUserRoleDetails {

    /** The role code. */
    private String roleCode;

    /** The role name. */
    private String roleName;

    /**
     * @return the roleCode
     */
    public final String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode
     *            the roleCode to set
     */
    public final void setRoleCode(final String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * @return the roleName
     */
    public final String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     *            the roleName to set
     */
    public final void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

}
