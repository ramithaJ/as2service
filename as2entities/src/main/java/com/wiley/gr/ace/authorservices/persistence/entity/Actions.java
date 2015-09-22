package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 22, 2015 4:46:21 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
	private String actionName;
	private String description;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;
	private Set<AuditDetails> auditDetailses = new HashSet<AuditDetails>(0);

	public Actions() {
	}

	public Actions(String actionCd) {
		this.actionCd = actionCd;
	}

	public Actions(String actionCd, String actionName, String description,
			Date createdDate, Long createdBy, Date updatedDate, Long updatedBy,
			Set<AuditDetails> auditDetailses) {
		this.actionCd = actionCd;
		this.actionName = actionName;
		this.description = description;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
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

	@Column(name = "CREATED_BY")
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actions")
	public Set<AuditDetails> getAuditDetailses() {
		return this.auditDetailses;
	}

	public void setAuditDetailses(Set<AuditDetails> auditDetailses) {
		this.auditDetailses = auditDetailses;
	}

}
