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
     * Gets the section name.
     *
     * @return the section name
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * Sets the section name.
     *
     * @param sectionName
     *            the new section name
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * Gets the permissions list.
     *
     * @return the permissions list
     */
    public List<UserPermissions> getPermissionsList() {
        return permissionsList;
    }

    /**
     * Sets the permissions list.
     *
     * @param permissionsList
     *            the new permissions list
     */
    public void setPermissionsList(List<UserPermissions> permissionsList) {
        this.permissionsList = permissionsList;
    }

}
