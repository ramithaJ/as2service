package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "ROLES")
public class Roles implements java.io.Serializable {

	private Integer roleId;
	private String roleName;
	private String createdBy;
	private Serializable createdDate;
	private String updatedBy;
	private Serializable updatedDate;
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);
	private Set<AdditionalPermissions> additionalPermissionses = new HashSet<AdditionalPermissions>(
			0);
	private Set<Permissions> permissionses = new HashSet<Permissions>(0);

	public Roles() {
	}

	public Roles(Integer roleId) {
		this.roleId = roleId;
	}

	public Roles(Integer roleId, String roleName, String createdBy,
			Serializable createdDate, String updatedBy,
			Serializable updatedDate, Set<UserProfile> userProfiles,
			Set<AdditionalPermissions> additionalPermissionses,
			Set<Permissions> permissionses) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.userProfiles = userProfiles;
		this.additionalPermissionses = additionalPermissionses;
		this.permissionses = permissionses;
	}

	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_NAME", length = 100)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "CREATED_BY", length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DATE")
	public Serializable getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Serializable createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY", length = 50)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE")
	public Serializable getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Serializable updatedDate) {
		this.updatedDate = updatedDate;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleses")
	public Set<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<AdditionalPermissions> getAdditionalPermissionses() {
		return this.additionalPermissionses;
	}

	public void setAdditionalPermissionses(
			Set<AdditionalPermissions> additionalPermissionses) {
		this.additionalPermissionses = additionalPermissionses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ROLE_PERMISSIONS", joinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "PERMISSION_ID", nullable = false, updatable = false) })
	public Set<Permissions> getPermissionses() {
		return this.permissionses;
	}

	public void setPermissionses(Set<Permissions> permissionses) {
		this.permissionses = permissionses;
	}

}
