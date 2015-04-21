package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "ALERTS")
public class Alerts implements java.io.Serializable {

	private Integer alertId;
	private String alertName;
	private String description;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;

	public Alerts() {
	}

	public Alerts(Integer alertId) {
		this.alertId = alertId;
	}

	public Alerts(Integer alertId, String alertName, String description,
			Date createdDate, String createdBy,
			Date updatedDate, String updatedBy) {
		this.alertId = alertId;
		this.alertName = alertName;
		this.description = description;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "ALERT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getAlertId() {
		return this.alertId;
	}

	public void setAlertId(Integer alertId) {
		this.alertId = alertId;
	}

	@Column(name = "ALERT_NAME", length = 250)
	public String getAlertName() {
		return this.alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	@Column(name = "DESCRIPTION", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
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
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
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
