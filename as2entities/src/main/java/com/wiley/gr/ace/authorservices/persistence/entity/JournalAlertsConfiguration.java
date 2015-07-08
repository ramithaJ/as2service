package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JournalAlertsConfiguration generated by hbm2java
 */
@Entity
@Table(name = "JOURNAL_ALERTS_CONFIGURATION")
public class JournalAlertsConfiguration implements java.io.Serializable {

	private Integer jouAlertId;
	private Alerts alerts;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Products products;
	private Character alertCdFlg;
	private Date createdDate;
	private Date updatedDate;

	public JournalAlertsConfiguration() {
	}

	public JournalAlertsConfiguration(Integer jouAlertId) {
		this.jouAlertId = jouAlertId;
	}

	public JournalAlertsConfiguration(Integer jouAlertId, Alerts alerts,
			Users usersByCreatedBy, Users usersByUpdatedBy, Products products,
			Character alertCdFlg, Date createdDate, Date updatedDate) {
		this.jouAlertId = jouAlertId;
		this.alerts = alerts;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.products = products;
		this.alertCdFlg = alertCdFlg;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "JOU_ALERT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getJouAlertId() {
		return this.jouAlertId;
	}

	public void setJouAlertId(Integer jouAlertId) {
		this.jouAlertId = jouAlertId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALERT_CD")
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
	@JoinColumn(name = "DH_ID")
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Column(name = "ALERT_CD_FLG", length = 1)
	public Character getAlertCdFlg() {
		return this.alertCdFlg;
	}

	public void setAlertCdFlg(Character alertCdFlg) {
		this.alertCdFlg = alertCdFlg;
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
