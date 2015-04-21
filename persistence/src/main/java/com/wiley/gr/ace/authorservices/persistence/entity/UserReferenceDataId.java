package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

 
/**
 * @author RAVISINHA
 *
 */
@Embeddable
public class UserReferenceDataId implements java.io.Serializable {

	private Integer userId;
	private String ecid;

	public UserReferenceDataId() {
	}

	public UserReferenceDataId(Integer userId, String ecid) {
		this.userId = userId;
		this.ecid = ecid;
	}

	@Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "ECID", nullable = false, length = 15)
	public String getEcid() {
		return this.ecid;
	}

	public void setEcid(String ecid) {
		this.ecid = ecid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserReferenceDataId))
			return false;
		UserReferenceDataId castOther = (UserReferenceDataId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getEcid() == castOther.getEcid()) || (this.getEcid() != null
						&& castOther.getEcid() != null && this.getEcid()
						.equals(castOther.getEcid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getEcid() == null ? 0 : this.getEcid().hashCode());
		return result;
	}

}
