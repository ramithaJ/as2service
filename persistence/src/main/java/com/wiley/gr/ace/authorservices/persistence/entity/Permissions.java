package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "PERMISSIONS")
public class Permissions implements java.io.Serializable {

	private BigDecimal permissionId;
	private String permissionName;
	private String levelOfPermission;
	private String permActiveNotes;
	private Serializable createdDate;
	private String createdBy;
	private String updatedBy;
	private Serializable updatedDate;
	private Set<AdditionalPermissions> additionalPermissionses = new HashSet<AdditionalPermissions>(
			0);
	private Set<Roles> roleses = new HashSet<Roles>(0);

	public Permissions() {
	}

	public Permissions(BigDecimal permissionId) {
		this.permissionId = permissionId;
	}

	public Permissions(BigDecimal permissionId, String permissionName,
			String levelOfPermission, String permActiveNotes,
			Serializable createdDate, String createdBy, String updatedBy,
			Serializable updatedDate,
			Set<AdditionalPermissions> additionalPermissionses,
			Set<Roles> roleses) {
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.levelOfPermission = levelOfPermission;
		this.permActiveNotes = permActiveNotes;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.additionalPermissionses = additionalPermissionses;
		this.roleses = roleses;
	}

	@Id
	@Column(name = "PERMISSION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(BigDecimal permissionId) {
		this.permissionId = permissionId;
	}

	@Column(name = "PERMISSION_NAME", length = 50)
	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Column(name = "LEVEL_OF_PERMISSION", length = 250)
	public String getLevelOfPermission() {
		return this.levelOfPermission;
	}

	public void setLevelOfPermission(String levelOfPermission) {
		this.levelOfPermission = levelOfPermission;
	}

	@Column(name = "PERM_ACTIVE_NOTES", length = 100)
	public String getPermActiveNotes() {
		return this.permActiveNotes;
	}

	public void setPermActiveNotes(String permActiveNotes) {
		this.permActiveNotes = permActiveNotes;
	}

	@Column(name = "CREATED_DATE")
	public Serializable getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Serializable createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
	public Set<AdditionalPermissions> getAdditionalPermissionses() {
		return this.additionalPermissionses;
	}

	public void setAdditionalPermissionses(
			Set<AdditionalPermissions> additionalPermissionses) {
		this.additionalPermissionses = additionalPermissionses;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissionses")
	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

}
