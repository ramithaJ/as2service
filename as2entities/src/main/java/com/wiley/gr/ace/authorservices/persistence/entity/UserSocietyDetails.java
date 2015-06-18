package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 18, 2015 11:29:00 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserSocietyDetails generated by hbm2java
 */
@Entity
@Table(name = "USER_SOCIETY_DETAILS")
public class UserSocietyDetails implements java.io.Serializable {

	private Integer userSocietyId;
	private Societies societies;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private UserProfile userProfile;
	private String membershipNo;
	private String promoCode;
	private Date startDt;
	private Date endDt;
	private Date createdDate;
	private Date updatedDate;

	public UserSocietyDetails() {
	}

	public UserSocietyDetails(Integer userSocietyId, Societies societies) {
		this.userSocietyId = userSocietyId;
		this.societies = societies;
	}

	public UserSocietyDetails(Integer userSocietyId, Societies societies,
			Users usersByCreatedBy, Users usersByUpdatedBy,
			UserProfile userProfile, String membershipNo, String promoCode,
			Date startDt, Date endDt, Date createdDate, Date updatedDate) {
		this.userSocietyId = userSocietyId;
		this.societies = societies;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.userProfile = userProfile;
		this.membershipNo = membershipNo;
		this.promoCode = promoCode;
		this.startDt = startDt;
		this.endDt = endDt;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "USER_SOCIETY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getUserSocietyId() {
		return this.userSocietyId;
	}

	public void setUserSocietyId(Integer userSocietyId) {
		this.userSocietyId = userSocietyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOCIETY_ID", nullable = false)
	public Societies getSocieties() {
		return this.societies;
	}

	public void setSocieties(Societies societies) {
		this.societies = societies;
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
	@JoinColumn(name = "USER_ID")
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "MEMBERSHIP_NO", length = 50)
	public String getMembershipNo() {
		return this.membershipNo;
	}

	public void setMembershipNo(String membershipNo) {
		this.membershipNo = membershipNo;
	}

	@Column(name = "PROMO_CODE", length = 50)
	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	@Column(name = "START_DT")
	public Date getStartDt() {
		return this.startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	@Column(name = "END_DT")
	public Date getEndDt() {
		return this.endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
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
