package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * @author SarmaKumarap
 *
 */
public class RolesData {
	
	private String roleId;
	
	private String  roleName;
	
	private String roleDescription;
	
	private String roleType;
	
	private List<PermissionData> permissions;
	
	private List<UserData> users;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public List<PermissionData> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionData> permissions) {
		this.permissions = permissions;
	}

	public List<UserData> getUsers() {
		return users;
	}

	public void setUsers(List<UserData> users) {
		this.users = users;
	}

}
