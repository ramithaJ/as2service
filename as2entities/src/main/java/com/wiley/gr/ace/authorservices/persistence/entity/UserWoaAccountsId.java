package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 24, 2015 5:21:06 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserWoaAccountsId generated by hbm2java
 */
@Embeddable
public class UserWoaAccountsId implements java.io.Serializable {

	private long userId;
	private String woaInstitutionCd;

	public UserWoaAccountsId() {
	}

	public UserWoaAccountsId(long userId, String woaInstitutionCd) {
		this.userId = userId;
		this.woaInstitutionCd = woaInstitutionCd;
	}

	@Column(name = "USER_ID", nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "WOA_INSTITUTION_CD", nullable = false, length = 15)
	public String getWoaInstitutionCd() {
		return this.woaInstitutionCd;
	}

	public void setWoaInstitutionCd(String woaInstitutionCd) {
		this.woaInstitutionCd = woaInstitutionCd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserWoaAccountsId))
			return false;
		UserWoaAccountsId castOther = (UserWoaAccountsId) other;

		return (this.getUserId() == castOther.getUserId())
				&& ((this.getWoaInstitutionCd() == castOther
						.getWoaInstitutionCd()) || (this.getWoaInstitutionCd() != null
						&& castOther.getWoaInstitutionCd() != null && this
						.getWoaInstitutionCd().equals(
								castOther.getWoaInstitutionCd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getUserId();
		result = 37
				* result
				+ (getWoaInstitutionCd() == null ? 0 : this
						.getWoaInstitutionCd().hashCode());
		return result;
	}

}
