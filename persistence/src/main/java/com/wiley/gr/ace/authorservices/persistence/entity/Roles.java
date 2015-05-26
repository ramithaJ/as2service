package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 4:56:42 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Roles generated by hbm2java
 */
public class Roles implements java.io.Serializable {

	private Integer roleId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String roleName;
	private String description;
	private String roleType;
	private Date createdDate;
	private Date updatedDate;
	private Set<UserRoles> userRoleses = new HashSet<UserRoles>(0);
	private Set<RolePermissions> rolePermissionses = new HashSet<RolePermissions>(
			0);
	private Set<AdditionalPermissions> additionalPermissionses = new HashSet<AdditionalPermissions>(
			0);

	public Roles() {
	}

	public Roles(Integer roleId, String roleType) {
		this.roleId = roleId;
		this.roleType = roleType;
	}

	public Roles(Integer roleId, Users usersByCreatedBy,
			Users usersByUpdatedBy, String roleName, String description,
			String roleType, Date createdDate, Date updatedDate,
			Set<UserRoles> userRoleses, Set<RolePermissions> rolePermissionses,
			Set<AdditionalPermissions> additionalPermissionses) {
		this.roleId = roleId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.roleName = roleName;
		this.description = description;
		this.roleType = roleType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.userRoleses = userRoleses;
		this.rolePermissionses = rolePermissionses;
		this.additionalPermissionses = additionalPermissionses;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
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

	public Set<UserRoles> getUserRoleses() {
		return this.userRoleses;
	}

	public void setUserRoleses(Set<UserRoles> userRoleses) {
		this.userRoleses = userRoleses;
	}

	public Set<RolePermissions> getRolePermissionses() {
		return this.rolePermissionses;
	}

	public void setRolePermissionses(Set<RolePermissions> rolePermissionses) {
		this.rolePermissionses = rolePermissionses;
	}

	public Set<AdditionalPermissions> getAdditionalPermissionses() {
		return this.additionalPermissionses;
	}

	public void setAdditionalPermissionses(
			Set<AdditionalPermissions> additionalPermissionses) {
		this.additionalPermissionses = additionalPermissionses;
	}

}
