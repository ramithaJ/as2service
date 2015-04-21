package com.wiley.gr.ace.authorservices.persistence.entity;

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
@Table(name = "USER_REFERENCE_DATA")
public class UserReferenceData implements java.io.Serializable {

	private UserReferenceDataId id;
	private UserProfile userProfile;
	private String orcid;
	private String almid;

	public UserReferenceData() {
	}

	public UserReferenceData(UserReferenceDataId id, UserProfile userProfile) {
		this.id = id;
		this.userProfile = userProfile;
	}

	public UserReferenceData(UserReferenceDataId id, UserProfile userProfile,
			String orcid, String almid) {
		this.id = id;
		this.userProfile = userProfile;
		this.orcid = orcid;
		this.almid = almid;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "ecid", column = @Column(name = "ECID", nullable = false, length = 15)) })
	public UserReferenceDataId getId() {
		return this.id;
	}

	public void setId(UserReferenceDataId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "ORCID", length = 15)
	public String getOrcid() {
		return this.orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	@Column(name = "ALMID", length = 15)
	public String getAlmid() {
		return this.almid;
	}

	public void setAlmid(String almid) {
		this.almid = almid;
	}

}
