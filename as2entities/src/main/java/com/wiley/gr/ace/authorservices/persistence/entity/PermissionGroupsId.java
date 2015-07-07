package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 7, 2015 5:39:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PermissionGroupsId generated by hbm2java
 */
@Embeddable
public class PermissionGroupsId implements java.io.Serializable {

	private String permissionCd;
	private String permissionGroupCd;

	public PermissionGroupsId() {
	}

	public PermissionGroupsId(String permissionCd, String permissionGroupCd) {
		this.permissionCd = permissionCd;
		this.permissionGroupCd = permissionGroupCd;
	}

	@Column(name = "PERMISSION_CD", nullable = false, length = 25)
	public String getPermissionCd() {
		return this.permissionCd;
	}

	public void setPermissionCd(String permissionCd) {
		this.permissionCd = permissionCd;
	}

	@Column(name = "PERMISSION_GROUP_CD", nullable = false, length = 25)
	public String getPermissionGroupCd() {
		return this.permissionGroupCd;
	}

	public void setPermissionGroupCd(String permissionGroupCd) {
		this.permissionGroupCd = permissionGroupCd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PermissionGroupsId))
			return false;
		PermissionGroupsId castOther = (PermissionGroupsId) other;

		return ((this.getPermissionCd() == castOther.getPermissionCd()) || (this
				.getPermissionCd() != null
				&& castOther.getPermissionCd() != null && this
				.getPermissionCd().equals(castOther.getPermissionCd())))
				&& ((this.getPermissionGroupCd() == castOther
						.getPermissionGroupCd()) || (this
						.getPermissionGroupCd() != null
						&& castOther.getPermissionGroupCd() != null && this
						.getPermissionGroupCd().equals(
								castOther.getPermissionGroupCd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPermissionCd() == null ? 0 : this.getPermissionCd()
						.hashCode());
		result = 37
				* result
				+ (getPermissionGroupCd() == null ? 0 : this
						.getPermissionGroupCd().hashCode());
		return result;
	}

}
