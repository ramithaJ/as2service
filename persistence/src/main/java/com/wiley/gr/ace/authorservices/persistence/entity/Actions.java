package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 2:39:51 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Actions generated by hbm2java
 */
@Entity
@Table(name = "ACTIONS")
public class Actions implements java.io.Serializable {

	private String actionCd;
	private String actionName;
	private String description;
	private Date createdDate;
	private Integer createdBy;
	private Date updatedDate;
	private Integer updatedBy;

	public Actions() {
	}

	public Actions(String actionCd) {
		this.actionCd = actionCd;
	}

	public Actions(String actionCd, String actionName, String description,
			Date createdDate, Integer createdBy, Date updatedDate,
			Integer updatedBy) {
		this.actionCd = actionCd;
		this.actionName = actionName;
		this.description = description;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
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

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", precision = 22, scale = 0)
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", precision = 22, scale = 0)
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

}
