package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 6:09:14 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Permissions generated by hbm2java
 */
@Entity
@Table(name = "PERMISSIONS")
public class Permissions implements java.io.Serializable {

	private String permissionCd;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String permissionName;
	private String permissionGroup;
	private Date createdDate;
	private Date updatedDate;
	private Set<RolePermissions> rolePermissionses = new HashSet<RolePermissions>(
			0);
	private Set<AdditionalPermissions> additionalPermissionses = new HashSet<AdditionalPermissions>(
			0);

	public Permissions() {
	}

	public Permissions(String permissionCd) {
		this.permissionCd = permissionCd;
	}

	public Permissions(String permissionCd, Users usersByCreatedBy,
			Users usersByUpdatedBy, String permissionName,
			String permissionGroup, Date createdDate, Date updatedDate,
			Set<RolePermissions> rolePermissionses,
			Set<AdditionalPermissions> additionalPermissionses) {
		this.permissionCd = permissionCd;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.permissionName = permissionName;
		this.permissionGroup = permissionGroup;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.rolePermissionses = rolePermissionses;
		this.additionalPermissionses = additionalPermissionses;
	}

	@Id
	@Column(name = "PERMISSION_CD", unique = true, nullable = false, length = 25)
	public String getPermissionCd() {
		return this.permissionCd;
	}

	public void setPermissionCd(String permissionCd) {
		this.permissionCd = permissionCd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY")
	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATED_BY")
	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	@Column(name = "PERMISSION_NAME", length = 250)
	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Column(name = "PERMISSION_GROUP", length = 25)
	public String getPermissionGroup() {
		return this.permissionGroup;
	}

	public void setPermissionGroup(String permissionGroup) {
		this.permissionGroup = permissionGroup;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 7)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
	public Set<RolePermissions> getRolePermissionses() {
		return this.rolePermissionses;
	}

	public void setRolePermissionses(Set<RolePermissions> rolePermissionses) {
		this.rolePermissionses = rolePermissionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
	public Set<AdditionalPermissions> getAdditionalPermissionses() {
		return this.additionalPermissionses;
	}

	public void setAdditionalPermissionses(
			Set<AdditionalPermissions> additionalPermissionses) {
		this.additionalPermissionses = additionalPermissionses;
	}

}
