package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 6:09:14 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RolePermissions generated by hbm2java
 */
@Entity
@Table(name = "ROLE_PERMISSIONS")
public class RolePermissions implements java.io.Serializable {

	private RolePermissionsId id;
	private Roles roles;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Permissions permissions;

	public RolePermissions() {
	}

	public RolePermissions(RolePermissionsId id) {
		this.id = id;
	}

	public RolePermissions(RolePermissionsId id, Roles roles,
			Users usersByCreatedBy, Users usersByUpdatedBy,
			Permissions permissions) {
		this.id = id;
		this.roles = roles;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.permissions = permissions;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "permissionCd", column = @Column(name = "PERMISSION_CD", length = 25)),
			@AttributeOverride(name = "roleLevelDataAccess", column = @Column(name = "ROLE_LEVEL_DATA_ACCESS", length = 500)),
			@AttributeOverride(name = "createdDate", column = @Column(name = "CREATED_DATE")),
			@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY", precision = 22, scale = 0)),
			@AttributeOverride(name = "updatedDate", column = @Column(name = "UPDATED_DATE")),
			@AttributeOverride(name = "updatedBy", column = @Column(name = "UPDATED_BY", precision = 22, scale = 0)) })
	public RolePermissionsId getId() {
		return this.id;
	}

	public void setId(RolePermissionsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", insertable = false, updatable = false)
	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATED_BY", insertable = false, updatable = false)
	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERMISSION_CD", insertable = false, updatable = false)
	public Permissions getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

}
