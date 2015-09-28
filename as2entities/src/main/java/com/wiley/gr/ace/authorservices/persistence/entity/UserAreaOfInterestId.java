package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 28, 2015 6:59:29 PM by Hibernate Tools 4.0.0

/**
 * UserAreaOfInterestId generated by hbm2java
 */
public class UserAreaOfInterestId implements java.io.Serializable {

	private long userId;
	private String areaOfInterestCd;

	public UserAreaOfInterestId() {
	}

	public UserAreaOfInterestId(long userId, String areaOfInterestCd) {
		this.userId = userId;
		this.areaOfInterestCd = areaOfInterestCd;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAreaOfInterestCd() {
		return this.areaOfInterestCd;
	}

	public void setAreaOfInterestCd(String areaOfInterestCd) {
		this.areaOfInterestCd = areaOfInterestCd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserAreaOfInterestId))
			return false;
		UserAreaOfInterestId castOther = (UserAreaOfInterestId) other;

		return (this.getUserId() == castOther.getUserId())
				&& ((this.getAreaOfInterestCd() == castOther
						.getAreaOfInterestCd()) || (this.getAreaOfInterestCd() != null
						&& castOther.getAreaOfInterestCd() != null && this
						.getAreaOfInterestCd().equals(
								castOther.getAreaOfInterestCd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getUserId();
		result = 37
				* result
				+ (getAreaOfInterestCd() == null ? 0 : this
						.getAreaOfInterestCd().hashCode());
		return result;
	}

}
