package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_PERMISSIONS")
public class RolePermissions {
	@Id
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name = "PERMISSION_ID")
	private Integer permissionId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

}
