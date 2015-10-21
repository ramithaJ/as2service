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
 * @author virtusa version1.0
 *
 */
public class AdditionalPermissions {

    /**
     * This field holds the value of permissions
     */
    private List<AdditionalPermissionsRequest> permissions;

    /**
     * @return the permissions
     */
    public List<AdditionalPermissionsRequest> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions
     *            the permissions to set
     */
    public void setPermissions(
            final List<AdditionalPermissionsRequest> permissions) {
        this.permissions = permissions;
    }

}
