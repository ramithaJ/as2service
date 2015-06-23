package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 23, 2015 2:35:20 PM by Hibernate Tools 4.0.0

import java.util.Date;
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
 * PermissionGroups generated by hbm2java
 */
@Entity
@Table(name = "PERMISSION_GROUPS")
public class PermissionGroups implements java.io.Serializable {

	private PermissionGroupsId id;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Permissions permissions;
	private Date createdDate;
	private Date updatedDate;

	public PermissionGroups() {
	}

	public PermissionGroups(PermissionGroupsId id, Permissions permissions) {
		this.id = id;
		this.permissions = permissions;
	}

	public PermissionGroups(PermissionGroupsId id, Users usersByCreatedBy,
			Users usersByUpdatedBy, Permissions permissions, Date createdDate,
			Date updatedDate) {
		this.id = id;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.permissions = permissions;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "permissionCd", column = @Column(name = "PERMISSION_CD", nullable = false, length = 25)),
			@AttributeOverride(name = "permissionGroupCd", column = @Column(name = "PERMISSION_GROUP_CD", nullable = false, length = 25)) })
	public PermissionGroupsId getId() {
		return this.id;
	}

	public void setId(PermissionGroupsId id) {
		this.id = id;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERMISSION_CD", nullable = false, insertable = false, updatable = false)
	public Permissions getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
