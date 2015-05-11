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

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.model.PermissionSection;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.RolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.UserPermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;


/**
 * @author RAVISINHA
 *
 */
public class AdminLoginServiceImpl implements AdminLoginService {

	
	@Autowired(required=true)
	UserLoginDao userlogindao;
	@Autowired(required=true)
	ALMInterfaceService almService;
	@Autowired(required=true)
	BPMInterfaceService bpmService;
	@Autowired(required=true)
	ASDataDAO  asDataDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.admin.AdminLoginService#
	 * validateEmail(java.lang.String)
	 */
	
	@Override
	public boolean validateEmail(String emailId) {
		
		boolean status = false;

		status = userlogindao.validateEmail(emailId);

		if (status) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean doLogin(String emailId) {
		// Call external service for password validation

		
		return almService.authenticateAdminUser(emailId);

	}

	@Override
	public boolean requestAdminAccess(String emailId) {

	
		// TODO: Integrate with BPM Service
		return bpmService.createTask();
	}

	@Override
	public RolesAndPermissions getRolesAndPermissions(String roleId) {
		
		RolesAndPermissions rolesAndPermissions = new RolesAndPermissions();
		
		Map<String, StringBuffer> permissionsMap = new HashMap();
		
		PermissionSection systemSection = new PermissionSection();
		PermissionSection articleSection = new PermissionSection();
		PermissionSection adminSection = new PermissionSection();
		
		systemSection.setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM);
		articleSection.setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_ARTICLE);
		adminSection.setSectionName(AuthorServicesConstants.PERMISSION_LEVEL_ADMIN);
		
		if(roleId == null || roleId.equals("")) {
			
			List<Roles> daoRolesList = asDataDAO.getAdminRoles();
			
			for (Roles daoRoles : daoRolesList) {
				
				Role role = new Role();
				role.setRoleId(daoRoles.getRoleId()+"");
				role.setRoleName(daoRoles.getRoleName());
				rolesAndPermissions.getRolesList().add(role);
			}
			
			List<Permissions> daoPermissionsList = asDataDAO.getPermissions();
			
			for (Permissions daoPermissions : daoPermissionsList) {
				
				UserPermissions permission = new UserPermissions();
				
				permission.setPermissionId(daoPermissions.getPermissionId()+"");
				permission.setPermissionName(daoPermissions.getPermissionName());
				
				if(daoPermissions.getLevelOfPermission().equalsIgnoreCase(AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM)
						&& daoPermissions.getPermType().equalsIgnoreCase(AuthorServicesConstants.PERMISSION_TYPE_EXTERNAL)) {
					systemSection.getPermissionsList().add(permission);
				
				} else if(daoPermissions.getLevelOfPermission().equalsIgnoreCase(AuthorServicesConstants.PERMISSION_LEVEL_SYSTEM)
						&& daoPermissions.getPermType().equalsIgnoreCase(AuthorServicesConstants.PERMISSION_TYPE_INTERNAL)) {
					adminSection.getPermissionsList().add(permission);
				
				} else if(daoPermissions.getLevelOfPermission().equalsIgnoreCase(AuthorServicesConstants.PERMISSION_LEVEL_ARTICLE))  {
					articleSection.getPermissionsList().add(permission);
				}
			}
			
			rolesAndPermissions.getSectionsList().add(adminSection);
			rolesAndPermissions.getSectionsList().add(articleSection);
			rolesAndPermissions.getSectionsList().add(systemSection);
			
			List<RolePermissions> daoPermissionMappings = asDataDAO.getRolePermissionMappings();
			
			for (RolePermissions daoRolePermissions : daoPermissionMappings) {
				
				String roleIdString = daoRolePermissions.getId().getRoleId()+"";
				if(permissionsMap.containsKey(roleIdString)) {
					StringBuffer permissionsString = permissionsMap.get(roleIdString);
					if(permissionsString == null) {
						permissionsString = new StringBuffer();
						permissionsString.append(daoRolePermissions.getId().getPermissionId()+"");
					} else {
						permissionsString.append(", "+daoRolePermissions.getId().getPermissionId()+"");
					}
				} else {
					permissionsMap.put(roleIdString, new StringBuffer().append(daoRolePermissions.getId().getPermissionId()+""));
				}
				
			}
			rolesAndPermissions.setPermissionsMap(permissionsMap);
		}
		return rolesAndPermissions;
	}

}
