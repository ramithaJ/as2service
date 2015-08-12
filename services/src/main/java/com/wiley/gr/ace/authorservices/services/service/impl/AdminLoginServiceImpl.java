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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.RolesService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.ASRolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.PermissionSection;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.RolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.UserPermissions;
import com.wiley.gr.ace.authorservices.model.external.PermissionData;
import com.wiley.gr.ace.authorservices.model.external.PermissionsRequest;
import com.wiley.gr.ace.authorservices.model.external.RoleRequest;
import com.wiley.gr.ace.authorservices.model.external.RolesData;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRoles;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRolesId;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
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

    /** The Roles Service. */
    @Autowired(required = true)
    private RolesService rolesService;

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
    public final Users getASUser(final String emailId) {
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
     * that id by calling external service.
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

        List<RolesData> rolesData = rolesService.getRoles();

        for (final RolesData roleData : rolesData) {

            final Role role = new Role();
            String roleIdString = roleData.getRoleId();
            role.setRoleId(roleIdString);
            role.setRoleName(roleData.getRoleName());
            role.setRoleDescription(roleData.getRoleDescription());
            if (roleData.getRoleType() != null
                    && AuthorServicesConstants.ROLE_TYPE_INTERNAL
                            .equalsIgnoreCase(roleData.getRoleType())) {
                role.setAdminRole(true);
            }
            rolesAndPermissions.getRolesList().add(role);

            List<PermissionData> permissionsDataList = roleData
                    .getPermissions();

            for (PermissionData permissionData : permissionsDataList) {

                if (permissionsMap.containsKey(roleIdString)) {
                    List<String> permissionsList = permissionsMap
                            .get(roleIdString);
                    if (permissionsList == null) {
                        permissionsList = new ArrayList<String>();
                        permissionsMap.put(roleIdString, permissionsList);
                    }
                    permissionsList.add(permissionData.getPermissionCd());

                } else {
                    List<String> permissionsList = new ArrayList<String>();
                    permissionsList.add(permissionData.getPermissionCd());
                    permissionsMap.put(roleIdString, permissionsList);
                }
            }
        }

        final List<PermissionData> permissionsDataList = rolesService
                .getPermissions();

        for (PermissionData permissionData : permissionsDataList) {

            UserPermissions permission = new UserPermissions();

            permission.setPermissionId(permissionData.getPermissionCd());
            permission.setPermissionName(permissionData.getPermissionName());

            if (permissionData.getGroups() != null
                    && !StringUtils.isEmpty(permissionData.getGroups())
                    && permissionData.getGroups().contains(
                            AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM)) {
                systemSection.getPermissionsList().add(permission);

            } else if (permissionData.getGroups() != null
                    && !StringUtils.isEmpty(permissionData.getGroups())
                    && permissionData.getGroups().contains(
                            AuthorServicesConstants.PERMISSION_LEVEL_ADMIN)) {
                adminSection.getPermissionsList().add(permission);

            } else if (permissionData.getGroups() != null
                    && !StringUtils.isEmpty(permissionData.getGroups())
                    && permissionData.getGroups().contains(
                            AuthorServicesConstants.PERMISSION_LEVEL_ARTICLE)) {
                articleSection.getPermissionsList().add(permission);
            }

        }

        final List<PermissionSection> permissionSectionsList = rolesAndPermissions
                .getSectionsList();
        permissionSectionsList.add(adminSection);
        permissionSectionsList.add(articleSection);
        permissionSectionsList.add(systemSection);

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
        List<Permissions> permissionsList = new ArrayList<Permissions>();
        Role role = rolesAndPermissions.getRole();
        String roleIdStr = "";

        for (Map.Entry<String, String[]> entry : rolesAndPermissions
                .getPermissionsMap().entrySet()) {
            for (String permissionId : entry.getValue()) {

                Permissions permissions = new Permissions();
                permissions.setPermissionCd(permissionId);
                permissionsList.add(permissions);
            }
        }

        if (permissionsList.isEmpty()) {
            throw new UserException("1111",
                    "Please select atleast one permission");
        }

        if ("0".equals(role.getRoleId())) {
            roleIdStr = getRoleId(role.getRoleName());
            if (roleIdStr.equals("0")) {
                RoleRequest roleRequest = new RoleRequest();
                roleRequest.setRoleName(role.getRoleName());
                roleRequest.setRoleDescription(role.getRoleDescription());
                roleRequest.setCreatedBy(rolesAndPermissions.getUserId());
                roleRequest.setUpdatedBy(rolesAndPermissions.getUserId());
                if (role.isAdminRole()) {
                    roleRequest.setRoleType("Internal");
                } else {
                    roleRequest.setRoleType("External");
                }
                rolesService.addRole(roleRequest);
                roleIdStr = getRoleId(role.getRoleName());
                System.out.println("roleIdStr obtained:::" + roleIdStr);
                System.out.println("Size of PermissionsList:::"
                        + permissionsList.size());

            } else {
                throw new UserException("2222",
                        "Role already exists with this name. Please Re-Enter");
            }
        } else {

            roleIdStr = role.getRoleId();
            RoleRequest roleRequest = new RoleRequest();
            roleRequest.setRoleName(role.getRoleName());
            roleRequest.setRoleDescription(role.getRoleDescription());
            rolesService.updateRole(roleRequest, roleIdStr);
        }

        List<PermissionsRequest> permissionsRequestList = new ArrayList<PermissionsRequest>();
        for (Permissions permissions : permissionsList) {
            System.out.println("Adding Permission:::"
                    + permissions.getPermissionCd());
            PermissionsRequest permissionsRequest = new PermissionsRequest();
            permissionsRequest.setPermissionCd(permissions.getPermissionCd());
            permissionsRequest.setPermissionName(permissions
                    .getPermissionName());
            permissionsRequest.setCreatedBy(rolesAndPermissions.getUserId());
            permissionsRequest.setUpdatedBy(rolesAndPermissions.getUserId());
            permissionsRequestList.add(permissionsRequest);
        }
        rolesService.updatePermissions(permissionsRequestList, roleIdStr);

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

    /**
     * Role name exists.
     *
     * @param roleName
     *            the role name
     * @return true, if successful
     */
    private String getRoleId(final String roleName) {

        String roleId = "0";

        List<RolesData> rolesDataList = rolesService.getRoles();

        for (RolesData rolesData : rolesDataList) {
            if (rolesData.getRoleName().equalsIgnoreCase(roleName.trim())) {
                roleId = rolesData.getRoleId();
            }
        }

        return roleId;
    }

}
