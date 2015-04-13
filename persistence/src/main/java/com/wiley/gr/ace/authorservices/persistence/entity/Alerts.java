package com.wiley.gr.ace.authorservices.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALERTS")
public class Alerts {
	@Id
	@Column(name = "ALERT_ID")
	private Integer alertId;
	@Column(name = "ALERT_NAME")
	private String alertName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public Integer getAlertId() {
		return alertId;
	}

	public void setAlertId(Integer alertId) {
		this.alertId = alertId;
	}

	public String getAlertName() {
		return alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
