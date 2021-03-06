package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 19, 2015 4:16:00 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AlertTypes generated by hbm2java
 */
@Entity
@Table(name = "alert_types", catalog = "as2_app_db")
public class AlertTypes implements java.io.Serializable {

	private String alertTypeCd;
	private String alertTypeName;
	private Date createdDate;
	private UUID createdBy;
	private Date updatedDate;
	private UUID updatedBy;
	private Set<Alerts> alertses = new HashSet<Alerts>(0);

	public AlertTypes() {
	}

	public AlertTypes(String alertTypeCd) {
		this.alertTypeCd = alertTypeCd;
	}

	public AlertTypes(String alertTypeCd, String alertTypeName,
			Date createdDate, UUID createdBy, Date updatedDate, UUID updatedBy,
			Set<Alerts> alertses) {
		this.alertTypeCd = alertTypeCd;
		this.alertTypeName = alertTypeName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
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

	@Column(name = "ALERT_TYPE_NAME", length = 100)
	public String getAlertTypeName() {
		return this.alertTypeName;
	}

	public void setAlertTypeName(String alertTypeName) {
		this.alertTypeName = alertTypeName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY")
	public UUID getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY")
	public UUID getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alertTypes")
	public Set<Alerts> getAlertses() {
		return this.alertses;
	}

	public void setAlertses(Set<Alerts> alertses) {
		this.alertses = alertses;
	}

}
