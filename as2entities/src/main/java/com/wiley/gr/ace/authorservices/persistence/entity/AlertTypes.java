package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AlertTypes generated by hbm2java
 */
@Entity
@Table(name = "ALERT_TYPES")
public class AlertTypes implements java.io.Serializable {

	private String alertTypeCd;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String alertTypeName;
	private Date createdDate;
	private Date updatedDate;
	private Set<Alerts> alertses = new HashSet<Alerts>(0);

	public AlertTypes() {
	}

	public AlertTypes(String alertTypeCd) {
		this.alertTypeCd = alertTypeCd;
	}

	public AlertTypes(String alertTypeCd, Users usersByCreatedBy,
			Users usersByUpdatedBy, String alertTypeName, Date createdDate,
			Date updatedDate, Set<Alerts> alertses) {
		this.alertTypeCd = alertTypeCd;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.alertTypeName = alertTypeName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.alertses = alertses;
	}

	@Id
	@Column(name = "ALERT_TYPE_CD", unique = true, nullable = false, length = 15)
	public String getAlertTypeCd() {
		return this.alertTypeCd;
	}

	public void setAlertTypeCd(String alertTypeCd) {
		this.alertTypeCd = alertTypeCd;
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

	@Column(name = "ALERT_TYPE_NAME", length = 100)
	public String getAlertTypeName() {
		return this.alertTypeName;
	}

	public void setAlertTypeName(String alertTypeName) {
		this.alertTypeName = alertTypeName;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alertTypes")
	public Set<Alerts> getAlertses() {
		return this.alertses;
	}

	public void setAlertses(Set<Alerts> alertses) {
		this.alertses = alertses;
	}

}
