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
import java.util.List;

/**
 * The Class PermissionSection.
 *
 * @author virtusa version 1.0
 */
public class PermissionSection {

    /** The section name. */
    private String sectionName;

    /** The permissions list. */
    private List<UserPermissions> permissionsList = new ArrayList<UserPermissions>();

    /**
     * @return the sectionName
     */
    public final String getSectionName() {
        return sectionName;
    }

    /**
     * @param sectionName
     *            the sectionName to set
     */
    public final void setSectionName(final String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * @return the permissionsList
     */
    public final List<UserPermissions> getPermissionsList() {
        return permissionsList;
    }

    /**
     * @param permissionsList
     *            the permissionsList to set
     */
    public final void setPermissionsList(final List<UserPermissions> permissionsList) {
        this.permissionsList = permissionsList;
    }

}
