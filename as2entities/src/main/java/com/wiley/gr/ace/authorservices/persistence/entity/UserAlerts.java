package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 28, 2015 6:59:29 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * UserAlerts generated by hbm2java
 */
public class UserAlerts implements java.io.Serializable {

	private UserAlertsId id;
	private Alerts alerts;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private UserProfile userProfile;
	private Character onScreenFlg;
	private Character emailFlg;
	private Date createdDate;
	private Date updatedDate;

	public UserAlerts() {
	}

	public UserAlerts(UserAlertsId id, Alerts alerts, UserProfile userProfile) {
		this.id = id;
		this.alerts = alerts;
		this.userProfile = userProfile;
	}

	public UserAlerts(UserAlertsId id, Alerts alerts, Users usersByCreatedBy,
			Users usersByUpdatedBy, UserProfile userProfile,
			Character onScreenFlg, Character emailFlg, Date createdDate,
			Date updatedDate) {
		this.id = id;
		this.alerts = alerts;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.userProfile = userProfile;
		this.onScreenFlg = onScreenFlg;
		this.emailFlg = emailFlg;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public UserAlertsId getId() {
		return this.id;
	}

	public void setId(UserAlertsId id) {
		this.id = id;
	}

	public Alerts getAlerts() {
		return this.alerts;
	}

	public void setAlerts(Alerts alerts) {
		this.alerts = alerts;
	}

	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Character getOnScreenFlg() {
		return this.onScreenFlg;
	}

	public void setOnScreenFlg(Character onScreenFlg) {
		this.onScreenFlg = onScreenFlg;
	}

	public Character getEmailFlg() {
		return this.emailFlg;
	}

	public void setEmailFlg(Character emailFlg) {
		this.emailFlg = emailFlg;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
