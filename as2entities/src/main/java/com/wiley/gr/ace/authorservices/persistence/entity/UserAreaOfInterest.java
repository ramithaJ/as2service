package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 18, 2015 11:29:00 AM by Hibernate Tools 4.0.0

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
 * UserAreaOfInterest generated by hbm2java
 */
@Entity
@Table(name = "USER_AREA_OF_INTEREST")
public class UserAreaOfInterest implements java.io.Serializable {

	private UserAreaOfInterestId id;
	private AreaOfInterest areaOfInterest;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private UserProfile userProfile;
	private Date createdDate;
	private Date updatedDate;

	public UserAreaOfInterest() {
	}

	public UserAreaOfInterest(UserAreaOfInterestId id,
			AreaOfInterest areaOfInterest, UserProfile userProfile) {
		this.id = id;
		this.areaOfInterest = areaOfInterest;
		this.userProfile = userProfile;
	}

	public UserAreaOfInterest(UserAreaOfInterestId id,
			AreaOfInterest areaOfInterest, Users usersByCreatedBy,
			Users usersByUpdatedBy, UserProfile userProfile, Date createdDate,
			Date updatedDate) {
		this.id = id;
		this.areaOfInterest = areaOfInterest;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.userProfile = userProfile;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "areaOfInterestCd", column = @Column(name = "AREA_OF_INTEREST_CD", nullable = false, length = 15)) })
	public UserAreaOfInterestId getId() {
		return this.id;
	}

	public void setId(UserAreaOfInterestId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AREA_OF_INTEREST_CD", nullable = false, insertable = false, updatable = false)
	public AreaOfInterest getAreaOfInterest() {
		return this.areaOfInterest;
	}

	public void setAreaOfInterest(AreaOfInterest areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
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
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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
