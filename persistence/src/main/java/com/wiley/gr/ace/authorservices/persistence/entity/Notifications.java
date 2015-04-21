package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

	private BigDecimal notificationId;
	private String notificationCategory;
	private BigDecimal emailType;
	private String notificationDescription;
	private BigDecimal intendedUserRole;
	private Serializable createdDate;
	private String createdBy;
	private Serializable updatedDate;
	private String updatedBy;

	public Notifications() {
	}

	public Notifications(BigDecimal notificationId, BigDecimal emailType,
			BigDecimal intendedUserRole) {
		this.notificationId = notificationId;
		this.emailType = emailType;
		this.intendedUserRole = intendedUserRole;
	}

	public Notifications(BigDecimal notificationId,
			String notificationCategory, BigDecimal emailType,
			String notificationDescription, BigDecimal intendedUserRole,
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
	public BigDecimal getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(BigDecimal notificationId) {
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
	public BigDecimal getEmailType() {
		return this.emailType;
	}

	public void setEmailType(BigDecimal emailType) {
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
	public BigDecimal getIntendedUserRole() {
		return this.intendedUserRole;
	}

	public void setIntendedUserRole(BigDecimal intendedUserRole) {
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
