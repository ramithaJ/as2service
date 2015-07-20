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
package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.RolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.ASRolesAndPermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;

/**
 * The Interface AdminLoginService.
 *
 * @author virtusa version 1.0
 */
public interface AdminLoginService {

    /**
     * This method validates if emailId exists in the AS 2.0 database.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    boolean validateEmail(String emailId);

    /**
     * This method updates the lastLoginTime in the AS 2.0 database.
     *
     * @param emailId
     *            the email id
     * @return the string
     */
    Users doLogin(String emailId);

    /**
     * This method requests for a wiley user to get Admin Access.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    boolean requestAdminAccess(String emailId);

    /**
     * This method gets the list of all roles, the sections and permissions List
     * and the role and permissions mappings.
     *
     * @param roleId
     *            the role id
     * @return the roles and permissions
     */
    RolesAndPermissions getRolesAndPermissions(String roleId);

    /**
     * This method is used to add or update user roles and permissions.
     *
     * @param rolesAndPermissions
     *            the roles and permissions
     */
    void addOrUpdateUserRole(ASRolesAndPermissions rolesAndPermissions);

    /**
     * This service calls the active directory to get the wiley user details.
     *
     * @param emailId
     *            the email id
     * @return the admin user
     */
    AdminUser findUser(String emailId);

    /**
     * This method is used to create admin user.
     *
     * @param adminuser
     *            the adminuser
     */
    void createAdmin(AdminUser adminuser);

}
