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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Alerts generated by hbm2java
 */
@Entity
@Table(name = "alerts", catalog = "as2_app_db")
public class Alerts implements java.io.Serializable {

	private String alertCd;
	private AlertTypes alertTypes;
	private String alertName;
	private String description;
	private Date createdDate;
	private UUID createdBy;
	private Date updatedDate;
	private UUID updatedBy;
	private Set<JournalAlertsConfiguration> journalAlertsConfigurations = new HashSet<JournalAlertsConfiguration>(
			0);

	public Alerts() {
	}

	public Alerts(String alertCd) {
		this.alertCd = alertCd;
	}

	public Alerts(String alertCd, AlertTypes alertTypes, String alertName,
			String description, Date createdDate, UUID createdBy,
			Date updatedDate, UUID updatedBy,
			Set<JournalAlertsConfiguration> journalAlertsConfigurations) {
		this.alertCd = alertCd;
		this.alertTypes = alertTypes;
		this.alertName = alertName;
		this.description = description;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.journalAlertsConfigurations = journalAlertsConfigurations;
	}

	@Id
	@Column(name = "ALERT_CD", unique = true, nullable = false, length = 15)
	public String getAlertCd() {
		return this.alertCd;
	}

	public void setAlertCd(String alertCd) {
		this.alertCd = alertCd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALERT_TYPE_CD")
	public AlertTypes getAlertTypes() {
		return this.alertTypes;
	}

	public void setAlertTypes(AlertTypes alertTypes) {
		this.alertTypes = alertTypes;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alerts")
	public Set<JournalAlertsConfiguration> getJournalAlertsConfigurations() {
		return this.journalAlertsConfigurations;
	}

	public void setJournalAlertsConfigurations(
			Set<JournalAlertsConfiguration> journalAlertsConfigurations) {
		this.journalAlertsConfigurations = journalAlertsConfigurations;
	}

}
