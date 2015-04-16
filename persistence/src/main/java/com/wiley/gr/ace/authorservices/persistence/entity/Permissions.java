package com.wiley.gr.ace.authorservices.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSIONS")
public class Permissions {
	@Id
	@Column(name = "PERMISSION_ID")
	private Integer permissionId;
	@Column(name = "PERMISSION_NAME")
	private String permissionName;
	@Column(name = "LEVEL_OF_PERMISSION")
	private String levelOfPermission;
	@Column(name = "PERM_ACTIVE_NOTES")
	private String permActiveNotes;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getLevelOfPermission() {
		return levelOfPermission;
	}

	public void setLevelOfPermission(String levelOfPermission) {
		this.levelOfPermission = levelOfPermission;
	}

	public String getPermActiveNotes() {
		return permActiveNotes;
	}

	public void setPermActiveNotes(String permActiveNotes) {
		this.permActiveNotes = permActiveNotes;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
