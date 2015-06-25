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
import com.wiley.gr.ace.authorservices.exception.ASException;
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
    public final String doLogin(final String emailId) {
        // Call external service for password validation
        LOGGER.info("inside doLogin Method");
        int userId = userLoginServiceDAO.getUserId(emailId);
        // userLoginServiceDAO.doLogin(userId);
        return userId + "";

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

        // if(roleId == null || roleId.equals("")) {

        List<Roles> daoRolesList = asDataDAO.getUserRoles(roleId);

        for (Roles daoRoles : daoRolesList) {

            Role role = new Role();
            role.setRoleId(daoRoles.getRoleId() + "");
            role.setRoleName(daoRoles.getRoleName());
            role.setRoleDescription(daoRoles.getDescription());
            if (daoRoles.getRoleType() != null
                    && daoRoles.getRoleType().equals(
                            AuthorServicesConstants.ROLE_TYPE_INTERNAL)) {
                role.setAdminRole(true);
            }
            rolesAndPermissions.getRolesList().add(role);
        }

        List<Permissions> daoPermissionsList = asDataDAO.getPermissions();

        for (Permissions daoPermissions : daoPermissionsList) {

            UserPermissions permission = new UserPermissions();

            permission.setPermissionId(daoPermissions.getPermissionCd() + "");
            permission.setPermissionName(daoPermissions.getPermissionName());

            if (daoPermissions.getPermissionGroup().equalsIgnoreCase(
                    AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM)
            /*
             * && daoPermissions.getPermType().equalsIgnoreCase(
             * AuthorServicesConstants.PERMISSION_TYPE_EXTERNAL)
             */) { // TODO
                systemSection.getPermissionsList().add(permission);

            } else if (daoPermissions.getPermissionGroup().equalsIgnoreCase(
                    AuthorServicesConstants.PERMISSION_LEVEL_ADMIN)
            /*
             * && daoPermissions.getPermType().equalsIgnoreCase(
             * AuthorServicesConstants.PERMISSION_TYPE_INTERNAL)
             */) { // TODO
                adminSection.getPermissionsList().add(permission);

            } else if (daoPermissions.getPermissionGroup().equalsIgnoreCase(
                    AuthorServicesConstants.PERMISSION_LEVEL_ARTICLE)) {
                articleSection.getPermissionsList().add(permission);
            }
        }

        rolesAndPermissions.getSectionsList().add(adminSection);
        rolesAndPermissions.getSectionsList().add(articleSection);
        rolesAndPermissions.getSectionsList().add(systemSection);

        List<RolePermissions> daoPermissionMappings = asDataDAO
                .getRolePermissionMappings(roleId);

        for (RolePermissions daoRolePermissions : daoPermissionMappings) {

            String roleIdString = daoRolePermissions.getId().getRoleId() + "";
            if (permissionsMap.containsKey(roleIdString)) {
                List<String> permissionsList = permissionsMap.get(roleIdString);
                if (permissionsList == null) {
                    permissionsList = new ArrayList<String>();
                    permissionsMap.put(roleIdString, permissionsList);
                }
                permissionsList.add(daoRolePermissions.getId()
                        .getPermissionCd() + "");

            } else {
                List<String> permissionsList = new ArrayList<String>();
                permissionsList.add(daoRolePermissions.getId()
                        .getPermissionCd() + "");
                permissionsMap.put(roleIdString, permissionsList);
            }

        }

        Map<String, String[]> returnMap = new HashMap<String, String[]>();

        for (Map.Entry<String, List<String>> entry : permissionsMap.entrySet()) {

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
        Roles roles = new Roles();
        List<Permissions> permissionsList = new ArrayList<Permissions>();
        Role role = rolesAndPermissions.getRole();
        if (role.getRoleId().equals("0")) {
            userRolesDAO.checkRoleName(role.getRoleName());
        }

        for (Map.Entry<String, String[]> entry : rolesAndPermissions
                .getPermissionsMap().entrySet()) {
            for (String permissionId : entry.getValue()) {

                Permissions permissions = new Permissions();
                permissions.setPermissionCd(permissionId);
                permissionsList.add(permissions);
            }

        }

        if (permissionsList.isEmpty()) {
            throw new ASException("1111",
                    "Please select atleast one permission");
        }
        if (rolesAndPermissions.getRole().getRoleId() != null
                && !rolesAndPermissions.getRole().getRoleId().trim()
                        .equals("0")) {
            roles.setRoleId(Integer.valueOf(rolesAndPermissions.getRole()
                    .getRoleId()));
        }
        roles.setDescription(rolesAndPermissions.getRole().getRoleDescription());
        roles.setRoleName(rolesAndPermissions.getRole().getRoleName());
        if (rolesAndPermissions.getRole().isAdminRole()) {
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
        Users users = new Users();
        List<UserRoles> rolesList = new ArrayList<UserRoles>();

        for (String roleId : adminuser.getRolesList()) {
            UserRoles userRoles = new UserRoles();
            UserRolesId userRolesId = new UserRolesId();
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
