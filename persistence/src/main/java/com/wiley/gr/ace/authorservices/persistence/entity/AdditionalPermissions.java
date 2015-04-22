package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
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
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "ADDITIONAL_PERMISSIONS")
public class AdditionalPermissions implements java.io.Serializable {

	private AdditionalPermissionsId id;
	private Roles roles;
	private UserProfile userProfile;
	private Permissions permissions;
	private Character splPermissionFlg;
	private Date permEndDt;

	public AdditionalPermissions() {
	}

	public AdditionalPermissions(AdditionalPermissionsId id, Roles roles,
			UserProfile userProfile, Permissions permissions) {
		this.id = id;
		this.roles = roles;
		this.userProfile = userProfile;
		this.permissions = permissions;
	}

	public AdditionalPermissions(AdditionalPermissionsId id, Roles roles,
			UserProfile userProfile, Permissions permissions,
			Character splPermissionFlg, Date permEndDt) {
		this.id = id;
		this.roles = roles;
		this.userProfile = userProfile;
		this.permissions = permissions;
		this.splPermissionFlg = splPermissionFlg;
		this.permEndDt = permEndDt;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "articleId", column = @Column(name = "ARTICLE_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "permissionId", column = @Column(name = "PERMISSION_ID", nullable = false, precision = 22, scale = 0)) })
	public AdditionalPermissionsId getId() {
		return this.id;
	}

	public void setId(AdditionalPermissionsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERMISSION_ID", nullable = false, insertable = false, updatable = false)
	public Permissions getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}

	@Column(name = "SPL_PERMISSION_FLG", length = 1)
	public Character getSplPermissionFlg() {
		return this.splPermissionFlg;
	}

	public void setSplPermissionFlg(Character splPermissionFlg) {
		this.splPermissionFlg = splPermissionFlg;
	}

	@Column(name = "PERM_END_DT")
	public Date getPermEndDt() {
		return this.permEndDt;
	}

	public void setPermEndDt(Date permEndDt) {
		this.permEndDt = permEndDt;
	}

}
