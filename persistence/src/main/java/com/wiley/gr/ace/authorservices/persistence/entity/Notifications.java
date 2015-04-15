package com.wiley.gr.ace.authorservices.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notifications {
	@Id
	@Column(name = "NOTIFICATION_ID")
	private Integer notificationId;
	@Column(name = "NOTIFICATION_CATEGORY")
	private String notificationCategory;
	@Column(name = "EMAIL_TYPE")
	private Integer emailType;
	@Column(name = "NOTIFICATION_DESCRIPTION")
	private String notificationDescription;
	@Column(name = "INTENDED_USER_ROLE")
	private Integer intendedUserRole;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@ManyToOne
	@JoinColumn(name="EMAIL_TYPE")
	private EmailType emailTypeVar;

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationCategory() {
		return notificationCategory;
	}

	public void setNotificationCategory(String notificationCategory) {
		this.notificationCategory = notificationCategory;
	}

	public Integer getEmailType() {
		return emailType;
	}

	public void setEmailType(Integer emailType) {
		this.emailType = emailType;
	}

	public String getNotificationDescription() {
		return notificationDescription;
	}

	public void setNotificationDescription(String notificationDescription) {
		this.notificationDescription = notificationDescription;
	}

	public Integer getIntendedUserRole() {
		return intendedUserRole;
	}

	public void setIntendedUserRole(Integer intendedUserRole) {
		this.intendedUserRole = intendedUserRole;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
