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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.ASRolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.PermissionSection;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.RolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.UserPermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRoles;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRolesId;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserRolesDAO;
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

    /** The user login service dao. */
    @Autowired(required = true)
    private UserLoginServiceDAO userLoginServiceDAO;

    /** The user management. */
    @Autowired(required = true)
    private UserManagement userManagement;

    /** The bpm service. */
    @Autowired(required = true)
    private BPMInterfaceService bpmService;

    /** The as data dao. */
    @Autowired(required = true)
    private ASDataDAO asDataDAO;

    /** The user roles dao. */
    @Autowired(required = true)
    private UserRolesDAO userRolesDAO;

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
     * This method will call take emailId as input and login in.
     *
     * @param emailId
     *            the email id
     * @return the string
     */
    @Override
    public final Users doLogin(final String emailId) {
        // Call external service for password validation
        LOGGER.info("inside doLogin Method");
        return userLoginServiceDAO.getUserId(emailId);

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
    public final boolean requestAdminAccess(final String emailId) {

        LOGGER.info("inside requestAdminAccess Method");

        return bpmService.createTask();
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
        final RolesAndPermissions rolesAndPermissions = new RolesAndPermissions();

        final Map<String, List<String>> permissionsMap = new HashMap<String, List<String>>();

        final PermissionSection systemSection = new PermissionSection();
        final PermissionSection articleSection = new PermissionSection();
        final PermissionSection adminSection = new PermissionSection();

        systemSection
                .setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM);
        articleSection
                .setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_ARTICLE);
        adminSection
                .setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_ADMIN);

        // if(roleId == null || roleId.equals("")) {

        final List<Roles> daoRolesList = asDataDAO.getUserRoles(roleId);

        for (final Roles daoRoles : daoRolesList) {

            final Role role = new Role();
            role.setRoleId(daoRoles.getRoleId() + "");
            role.setRoleName(daoRoles.getRoleName());
            role.setRoleDescription(daoRoles.getDescription());
            if (daoRoles.getRoleType() != null
                    && AuthorServicesConstants.ROLE_TYPE_INTERNAL
                            .equals(daoRoles.getRoleType())) {
                role.setAdminRole(true);
            }
            rolesAndPermissions.getRolesList().add(role);
        }

        final List<Permissions> daoPermissionsList = asDataDAO.getPermissions();

        for (final Permissions daoPermissions : daoPermissionsList) {

            final UserPermissions permission = new UserPermissions();

            permission.setPermissionId(daoPermissions.getPermissionCd() + "");
            permission.setPermissionName(daoPermissions.getPermissionName());

            /**
             * Temporary Commenting for fixing compilation issue as per new
             * entity generated
             */
            /*
             * if (daoPermissions.getPermissionGroup().equalsIgnoreCase(
             * AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM)
             * 
             * && daoPermissions.getPermType().equalsIgnoreCase(
             * AuthorServicesConstants.PERMISSION_TYPE_EXTERNAL) ) { // TODO
             * systemSection.getPermissionsList().add(permission);
             * 
             * } else if (daoPermissions.getPermissionGroup().equalsIgnoreCase(
             * AuthorServicesConstants.PERMISSION_LEVEL_ADMIN)
             * 
             * && daoPermissions.getPermType().equalsIgnoreCase(
             * AuthorServicesConstants.PERMISSION_TYPE_INTERNAL) ) { // TODO
             * adminSection.getPermissionsList().add(permission);
             * 
             * } else if (daoPermissions.getPermissionGroup().equalsIgnoreCase(
             * AuthorServicesConstants.PERMISSION_LEVEL_ARTICLE)) {
             * articleSection.getPermissionsList().add(permission); }
             */
        }

        final List<PermissionSection> permissionSectionsList = rolesAndPermissions
                .getSectionsList();
        permissionSectionsList.add(adminSection);
        permissionSectionsList.add(articleSection);
        permissionSectionsList.add(systemSection);

        final List<RolePermissions> daoPermissionMappings = asDataDAO
                .getRolePermissionMappings(roleId);

        for (final RolePermissions daoRolePermissions : daoPermissionMappings) {

            final String roleIdString = daoRolePermissions.getId().getRoleId()
                    + "";
            if (permissionsMap.containsKey(roleIdString)) {
                List<String> permissionsList = permissionsMap.get(roleIdString);
                if (permissionsList == null) {
                    permissionsList = new ArrayList<String>();
                    permissionsMap.put(roleIdString, permissionsList);
                }
                permissionsList.add(daoRolePermissions.getId()
                        .getPermissionCd() + "");

            } else {
                final List<String> permissionsList = new ArrayList<String>();
                permissionsList.add(daoRolePermissions.getId()
                        .getPermissionCd() + "");
                permissionsMap.put(roleIdString, permissionsList);
            }

        }

        final Map<String, String[]> returnMap = new HashMap<String, String[]>();

        for (final Map.Entry<String, List<String>> entry : permissionsMap
                .entrySet()) {

            returnMap.put(
                    entry.getKey(),
                    entry.getValue().toArray(
                            new String[entry.getValue().size()]));
        }
        rolesAndPermissions.setPermissionsMap(returnMap);
        // }
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
        final Roles roles = new Roles();
        final List<Permissions> permissionsList = new ArrayList<Permissions>();
        final Role role = rolesAndPermissions.getRole();
        if ("0".equals(role.getRoleId())) {
            userRolesDAO.checkRoleName(role.getRoleName());
        }

        for (final Map.Entry<String, String[]> entry : rolesAndPermissions
                .getPermissionsMap().entrySet()) {
            for (final String permissionId : entry.getValue()) {

                final Permissions permissions = new Permissions();
                permissions.setPermissionCd(permissionId);
                permissionsList.add(permissions);
            }

        }

        if (permissionsList.isEmpty()) {
            throw new UserException("1111",
                    "Please select atleast one permission");
        }
        final String roleId = role.getRoleId();
        if (roleId != null && !"0".trim().equals(roleId)) {
            roles.setRoleId(Integer.valueOf(roleId));
        }
        roles.setDescription(role.getRoleDescription());
        roles.setRoleName(role.getRoleName());
        if (role.isAdminRole()) {
            roles.setRoleType(AuthorServicesConstants.ROLE_TYPE_INTERNAL);
        } else {
            roles.setRoleType(AuthorServicesConstants.ROLE_TYPE_EXTERNAL);
        }

        userRolesDAO.addOrUpdateUserRoles(roles, permissionsList);

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
        /*
         * AdminUser adminUser = new AdminUser();
         * 
         * Users user=userlogindao.getUserDetails(emailId);
         * 
         * 
         * if(! StringUtils.isEmpty(user)) {
         * adminUser.setFirstName(user.getFirstName());
         * adminUser.setLastName(user.getLastName()); }else{
         * 
         * userManagement.findUser(emailId); } return adminUser;
         */

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
        final Users users = new Users();
        final List<UserRoles> rolesList = new ArrayList<UserRoles>();

        for (final String roleId : adminuser.getRolesList()) {
            final UserRoles userRoles = new UserRoles();
            final UserRolesId userRolesId = new UserRolesId();
            userRolesId.setRoleId(Integer.parseInt(roleId));
            userRoles.setId(userRolesId);
            rolesList.add(userRoles);
        }

        users.setPrimaryEmailAddr(adminuser.getEmailId());
        users.setFirstName(adminuser.getFirstName());
        users.setLastName(adminuser.getLastName());
        userlogindao.createAdminUser(users, rolesList);

    }

}
