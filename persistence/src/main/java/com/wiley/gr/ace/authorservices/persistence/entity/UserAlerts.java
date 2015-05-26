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
 * UserAlerts generated by hbm2java
 */
@Entity
@Table(name = "USER_ALERTS")
public class UserAlerts implements java.io.Serializable {

	private UserAlertsId id;
	private Alerts alerts;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private AuthorProfile authorProfile;
	private Character onScreenFlg;
	private Character emailFlg;
	private Date createdDate;
	private Date updatedDate;

	public UserAlerts() {
	}

	public UserAlerts(UserAlertsId id, Alerts alerts,
			AuthorProfile authorProfile) {
		this.id = id;
		this.alerts = alerts;
		this.authorProfile = authorProfile;
	}

	public UserAlerts(UserAlertsId id, Alerts alerts, Users usersByCreatedBy,
			Users usersByUpdatedBy, AuthorProfile authorProfile,
			Character onScreenFlg, Character emailFlg, Date createdDate,
			Date updatedDate) {
		this.id = id;
		this.alerts = alerts;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.authorProfile = authorProfile;
		this.onScreenFlg = onScreenFlg;
		this.emailFlg = emailFlg;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "alertCd", column = @Column(name = "ALERT_CD", nullable = false, length = 15)) })
	public UserAlertsId getId() {
		return this.id;
	}

	public void setId(UserAlertsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALERT_CD", nullable = false, insertable = false, updatable = false)
	public Alerts getAlerts() {
		return this.alerts;
	}

	public void setAlerts(Alerts alerts) {
		this.alerts = alerts;
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
	public AuthorProfile getAuthorProfile() {
		return this.authorProfile;
	}

	public void setAuthorProfile(AuthorProfile authorProfile) {
		this.authorProfile = authorProfile;
	}

	@Column(name = "ON_SCREEN_FLG", length = 1)
	public Character getOnScreenFlg() {
		return this.onScreenFlg;
	}

	public void setOnScreenFlg(Character onScreenFlg) {
		this.onScreenFlg = onScreenFlg;
	}

	@Column(name = "EMAIL_FLG", length = 1)
	public Character getEmailFlg() {
		return this.emailFlg;
	}

	public void setEmailFlg(Character emailFlg) {
		this.emailFlg = emailFlg;
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
