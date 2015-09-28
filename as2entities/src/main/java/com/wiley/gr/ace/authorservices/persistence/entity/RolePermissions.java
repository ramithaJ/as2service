package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 28, 2015 6:59:29 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * RolePermissions generated by hbm2java
 */
public class RolePermissions implements java.io.Serializable {

	private RolePermissionsId id;
	private Roles roles;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Permissions permissions;
	private String roleLevelDataAccess;
	private Date createdDate;
	private Date updatedDate;

	public RolePermissions() {
	}

	public RolePermissions(RolePermissionsId id, Roles roles,
			Permissions permissions) {
		this.id = id;
		this.roles = roles;
		this.permissions = permissions;
	}

	public RolePermissions(RolePermissionsId id, Roles roles,
			Users usersByCreatedBy, Users usersByUpdatedBy,
			Permissions permissions, String roleLevelDataAccess,
			Date createdDate, Date updatedDate) {
		this.id = id;
		this.roles = roles;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.permissions = permissions;
		this.roleLevelDataAccess = roleLevelDataAccess;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public RolePermissionsId getId() {
		return this.id;
	}

	public void setId(RolePermissionsId id) {
		this.id = id;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	public Permissions getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

	public String getRoleLevelDataAccess() {
		return this.roleLevelDataAccess;
	}

	public void setRoleLevelDataAccess(String roleLevelDataAccess) {
		this.roleLevelDataAccess = roleLevelDataAccess;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
