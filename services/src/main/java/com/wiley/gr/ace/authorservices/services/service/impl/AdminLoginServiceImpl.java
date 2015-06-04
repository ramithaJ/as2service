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
 * @author virtusa version 1.0
 */
public class AdminLoginServiceImpl implements AdminLoginService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminLoginServiceImpl.class);

	@Autowired(required = true)
	UserLoginDao userlogindao;
	@Autowired(required = true)
	UserLoginServiceDAO userLoginServiceDAO;
	@Autowired(required = true)
	UserManagement almService;
	@Autowired(required = true)
	BPMInterfaceService bpmService;
	@Autowired(required = true)
	ASDataDAO asDataDAO;
	@Autowired(required = true)
	UserRolesDAO userRolesDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.admin.AdminLoginService#
	 * validateEmail(java.lang.String)
	 */

	@Override
	public boolean validateEmail(String emailId) {
		LOGGER.info("inside validateEmail Method");
		return userlogindao.validateEmail(emailId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.services.service.AdminLoginService#doLogin
	 * (java.lang.String)
	 */
	@Override
	public String doLogin(String emailId) {
		// Call external service for password validation
		LOGGER.info("inside doLogin Method");
		int userId = userLoginServiceDAO.getUserId(emailId);
		// userLoginServiceDAO.doLogin(userId);
		return userId + "";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.AdminLoginService#
	 * requestAdminAccess(java.lang.String)
	 */
	@Override
	public boolean requestAdminAccess(String emailId) {
		// TODO: Integrate with BPM Service
		LOGGER.info("inside requestAdminAccess Method");

		return bpmService.createTask();
	}

	@Override
	public RolesAndPermissions getRolesAndPermissions(String roleId) {

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
					AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.AdminLoginService#
	 * addOrUpdateUserRole
	 * (com.wiley.gr.ace.authorservices.model.RolesAndPermissions)
	 */
	@Override
	public void addOrUpdateUserRole(ASRolesAndPermissions rolesAndPermissions) {

		LOGGER.info("inside addOrUpdateUserRole Method");
		Roles roles = new Roles();
		List<Permissions> permissionsList = new ArrayList<Permissions>();

		userRolesDAO.checkRoleName(rolesAndPermissions.getRole().getRoleName());

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
			roles.setRoleId(Integer.parseInt(rolesAndPermissions.getRole()
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.services.service.AdminLoginService#findUser
	 * (java.lang.String)
	 */
	@Override
	public AdminUser findUser(String emailId) {
		LOGGER.info("inside findUser Method");
		return almService.findUser(emailId);
	}

	@Override
	public void createAdmin(AdminUser adminuser) {
		LOGGER.info("inside createAdmin Method");
		Users users = new Users();
		List<UserRoles> rolesList = new ArrayList<UserRoles>();

		for (String roleId : adminuser.getRolesList()) {
			UserRoles userRoles = new UserRoles();
			UserRolesId userRolesId = new UserRolesId();
			userRolesId.setRoleId(Integer.valueOf(roleId));
			userRoles.setId(userRolesId);
			rolesList.add(userRoles);
		}

		users.setPrimaryEmailAddr(adminuser.getEmailId());
		users.setFirstName(adminuser.getFirstName());
		users.setLastName(adminuser.getLastName());
		userlogindao.createAdminUser(users, rolesList);

	}

}
