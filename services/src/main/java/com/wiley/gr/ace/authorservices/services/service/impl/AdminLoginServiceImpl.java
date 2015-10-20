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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.ASRolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.PermissionSection;
import com.wiley.gr.ace.authorservices.model.RolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.external.TaskServiceRequest;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

/**
 * The Class AdminLoginServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class AdminLoginServiceImpl implements AdminLoginService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AdminLoginServiceImpl.class);

    /** The userlogindao. */
    @Autowired(required = true)
    private UserLoginDao userlogindao;

    /** The user management. */
    @Autowired(required = true)
    private UserManagement userManagement;

    /** The user roles dao. */
    @Autowired(required = true)
    private TaskService taskService;

    /**
     * This method will call take emailId as input and takes and validate
     * against db.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    @Override
    public final boolean validateEmail(final String emailId) {
        LOGGER.info("inside validateEmail Method");
        return userlogindao.validateEmail(emailId);
    }

    /**
     * This method will call take emailId and call external service to create
     * task.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    @Override
    public final String requestAdminAccess(final List<String> accessId,
            final String emailId) {

        LOGGER.info("inside requestAdminAccess Method");
        final String userId = emailId.substring(0, emailId.indexOf('@'));
        LOGGER.info("#userId" + userId);
        TaskServiceRequest taskServiceRequest = new TaskServiceRequest();
        taskServiceRequest.setRequestorEmail(emailId);
        taskServiceRequest.setJustifications(accessId);
        taskServiceRequest.setRequestorId("john");
        LOGGER.info("#userId" + taskServiceRequest.toString());
        String status = taskService.invokeTaskService(taskServiceRequest,
                "skpalli");
        return status;
    }

    /**
     * This method will call take roleId and gets all the permissions based on
     * that id by calling dao.
     *
     * @param roleId
     *            the role id
     * @return the roles and permissions
     */
    @Override
    public final RolesAndPermissions getRolesAndPermissions(final String roleId) {

        LOGGER.info("inside getRolesAndPermissions Method");
        RolesAndPermissions rolesAndPermissions = new RolesAndPermissions();

        Map<String, List<String>> permissionsMap = new HashMap<String, List<String>>();

        PermissionSection systemSection = new PermissionSection();
        PermissionSection articleSection = new PermissionSection();
        PermissionSection adminSection = new PermissionSection();

        systemSection
                .setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM);
        articleSection
                .setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_ARTICLE);
        adminSection
                .setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_ADMIN);

        rolesAndPermissions.getSectionsList().add(adminSection);
        rolesAndPermissions.getSectionsList().add(articleSection);
        rolesAndPermissions.getSectionsList().add(systemSection);

        Map<String, String[]> returnMap = new HashMap<String, String[]>();

        for (Map.Entry<String, List<String>> entry : permissionsMap.entrySet()) {

            returnMap.put(
                    entry.getKey(),
                    entry.getValue().toArray(
                            new String[entry.getValue().size()]));
        }
        rolesAndPermissions.setPermissionsMap(returnMap);

        return rolesAndPermissions;
    }

    /**
     * This method will call take rolesAndPermissions json and do addorupdate by
     * calling dao.
     *
     * @param rolesAndPermissions
     *            the roles and permissions
     */
    @Override
    public final void addOrUpdateUserRole(
            final ASRolesAndPermissions rolesAndPermissions) {

        LOGGER.info("inside addOrUpdateUserRole Method");

    }

    /**
     * This method will call take emailId and find user is existing or not.
     *
     * @param emailId
     *            the email id
     * @return the admin user
     */
    @Override
    public final AdminUser findUser(final String emailId) {
        LOGGER.info("inside findUser Method");
        return userManagement.findUser(emailId);
    }

    /**
     * This method will take adminuser as in input and passes the data to dao
     * for creating admin.
     *
     * @param adminuser
     *            the adminuser
     */
    @Override
    public final void createAdmin(final AdminUser adminuser) {
        LOGGER.info("inside createAdmin Method");

    }

}
