package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserRolesId generated by hbm2java
 */
@Embeddable
public class UserRolesId implements java.io.Serializable {

	private int userId;
	private int roleId;

	public UserRolesId() {
	}

	public UserRolesId(int userId, int roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	@Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "ROLE_ID", nullable = false, precision = 22, scale = 0)
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRolesId))
			return false;
		UserRolesId castOther = (UserRolesId) other;

		return (this.getUserId() == castOther.getUserId())
				&& (this.getRoleId() == castOther.getRoleId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getRoleId();
		return result;
	}

}
