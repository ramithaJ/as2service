package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 24, 2015 5:21:06 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LockedAccountDetails generated by hbm2java
 */
@Entity
@Table(name = "locked_account_details", catalog = "as2_app_db")
public class LockedAccountDetails implements java.io.Serializable {

	private String userId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Long invalidLoginCount;
	private Date lockedTime;
	private String appKey;
	private Date loginAttemptTime;
	private Date createdDate;
	private Date updatedDate;

	public LockedAccountDetails() {
	}

	public LockedAccountDetails(String userId) {
		this.userId = userId;
	}

	public LockedAccountDetails(String userId, Users usersByCreatedBy,
			Users usersByUpdatedBy, Long invalidLoginCount, Date lockedTime,
			String appKey, Date loginAttemptTime, Date createdDate,
			Date updatedDate) {
		this.userId = userId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.invalidLoginCount = invalidLoginCount;
		this.lockedTime = lockedTime;
		this.appKey = appKey;
		this.loginAttemptTime = loginAttemptTime;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	@Column(name = "INVALID_LOGIN_COUNT")
	public Long getInvalidLoginCount() {
		return this.invalidLoginCount;
	}

	public void setInvalidLoginCount(Long invalidLoginCount) {
		this.invalidLoginCount = invalidLoginCount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOCKED_TIME", length = 19)
	public Date getLockedTime() {
		return this.lockedTime;
	}

	public void setLockedTime(Date lockedTime) {
		this.lockedTime = lockedTime;
	}

	@Column(name = "APP_KEY")
	public String getAppKey() {
		return this.appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_ATTEMPT_TIME", length = 19)
	public Date getLoginAttemptTime() {
		return this.loginAttemptTime;
	}

	public void setLoginAttemptTime(Date loginAttemptTime) {
		this.loginAttemptTime = loginAttemptTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
