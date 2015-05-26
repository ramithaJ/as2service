package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 2:39:51 PM by Hibernate Tools 3.4.0.CR1

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
 * UserReferenceData generated by hbm2java
 */
@Entity
@Table(name = "USER_REFERENCE_DATA")
public class UserReferenceData implements java.io.Serializable {

	private UserReferenceDataId id;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Users usersByUserId;
	private String orcidId;
	private Date createdDate;
	private Date updatedDate;

	public UserReferenceData() {
	}

	public UserReferenceData(UserReferenceDataId id, Users usersByUserId) {
		this.id = id;
		this.usersByUserId = usersByUserId;
	}

	public UserReferenceData(UserReferenceDataId id, Users usersByCreatedBy,
			Users usersByUpdatedBy, Users usersByUserId, String orcidId,
			Date createdDate, Date updatedDate) {
		this.id = id;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.usersByUserId = usersByUserId;
		this.orcidId = orcidId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "ecid", column = @Column(name = "ECID", nullable = false, length = 14)) })
	public UserReferenceDataId getId() {
		return this.id;
	}

	public void setId(UserReferenceDataId id) {
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
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public Users getUsersByUserId() {
		return this.usersByUserId;
	}

	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
	}

	@Column(name = "ORCID_ID", length = 20)
	public String getOrcidId() {
		return this.orcidId;
	}

	public void setOrcidId(String orcidId) {
		this.orcidId = orcidId;
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
