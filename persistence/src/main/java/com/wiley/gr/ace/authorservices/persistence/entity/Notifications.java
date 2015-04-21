package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "NOTIFICATIONS")
public class Notifications implements java.io.Serializable {

	private Integer notificationId;
	private String notificationCategory;
	private Integer emailType;
	private String notificationDescription;
	private Integer intendedUserRole;
	private Serializable createdDate;
	private String createdBy;
	private Serializable updatedDate;
	private String updatedBy;

	public Notifications() {
	}

	public Notifications(Integer notificationId, Integer emailType,
			Integer intendedUserRole) {
		this.notificationId = notificationId;
		this.emailType = emailType;
		this.intendedUserRole = intendedUserRole;
	}

	public Notifications(Integer notificationId,
			String notificationCategory, Integer emailType,
			String notificationDescription, Integer intendedUserRole,
			Serializable createdDate, String createdBy,
			Serializable updatedDate, String updatedBy) {
		this.notificationId = notificationId;
		this.notificationCategory = notificationCategory;
		this.emailType = emailType;
		this.notificationDescription = notificationDescription;
		this.intendedUserRole = intendedUserRole;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "NOTIFICATION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	@Column(name = "NOTIFICATION_CATEGORY", length = 250)
	public String getNotificationCategory() {
		return this.notificationCategory;
	}

	public void setNotificationCategory(String notificationCategory) {
		this.notificationCategory = notificationCategory;
	}

	@Column(name = "EMAIL_TYPE", nullable = false, precision = 22, scale = 0)
	public Integer getEmailType() {
		return this.emailType;
	}

	public void setEmailType(Integer emailType) {
		this.emailType = emailType;
	}

	@Column(name = "NOTIFICATION_DESCRIPTION", length = 250)
	public String getNotificationDescription() {
		return this.notificationDescription;
	}

	public void setNotificationDescription(String notificationDescription) {
		this.notificationDescription = notificationDescription;
	}

	@Column(name = "INTENDED_USER_ROLE", nullable = false, precision = 22, scale = 0)
	public Integer getIntendedUserRole() {
		return this.intendedUserRole;
	}

	public void setIntendedUserRole(Integer intendedUserRole) {
		this.intendedUserRole = intendedUserRole;
	}

	@Column(name = "CREATED_DATE")
	public Serializable getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Serializable createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_DATE")
	public Serializable getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Serializable updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", length = 50)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
