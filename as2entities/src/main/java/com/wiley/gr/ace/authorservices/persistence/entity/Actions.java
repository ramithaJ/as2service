package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 24, 2015 5:21:06 PM by Hibernate Tools 4.0.0

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Actions generated by hbm2java
 */
@Entity
@Table(name = "actions", catalog = "as2_app_db")
public class Actions implements java.io.Serializable {

	private String actionCd;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String actionName;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private Set<AuditDetails> auditDetailses = new HashSet<AuditDetails>(0);

	public Actions() {
	}

	public Actions(String actionCd) {
		this.actionCd = actionCd;
	}

	public Actions(String actionCd, Users usersByCreatedBy,
			Users usersByUpdatedBy, String actionName, String description,
			Date createdDate, Date updatedDate, Set<AuditDetails> auditDetailses) {
		this.actionCd = actionCd;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.actionName = actionName;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.auditDetailses = auditDetailses;
	}

	@Id
	@Column(name = "ACTION_CD", unique = true, nullable = false, length = 15)
	public String getActionCd() {
		return this.actionCd;
	}

	public void setActionCd(String actionCd) {
		this.actionCd = actionCd;
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

	@Column(name = "ACTION_NAME", length = 50)
	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Column(name = "DESCRIPTION", length = 100)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actions")
	public Set<AuditDetails> getAuditDetailses() {
		return this.auditDetailses;
	}

	public void setAuditDetailses(Set<AuditDetails> auditDetailses) {
		this.auditDetailses = auditDetailses;
	}

}
