package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 18, 2015 11:29:00 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * LookupValues generated by hbm2java
 */
@Entity
@Table(name = "LOOKUP_VALUES")
public class LookupValues implements java.io.Serializable {

	private Integer lookupId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String lookupKey;
	private String lookupName;
	private String lookupValue;
	private Date createdDate;
	private Date updatedDate;

	public LookupValues() {
	}

	public LookupValues(Integer lookupId) {
		this.lookupId = lookupId;
	}

	public LookupValues(Integer lookupId, Users usersByCreatedBy,
			Users usersByUpdatedBy, String lookupKey, String lookupName,
			String lookupValue, Date createdDate, Date updatedDate) {
		this.lookupId = lookupId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.lookupKey = lookupKey;
		this.lookupName = lookupName;
		this.lookupValue = lookupValue;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "LOOKUP_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getLookupId() {
		return this.lookupId;
	}

	public void setLookupId(Integer lookupId) {
		this.lookupId = lookupId;
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

	@Column(name = "LOOKUP_KEY", length = 50)
	public String getLookupKey() {
		return this.lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	@Column(name = "LOOKUP_NAME", length = 250)
	public String getLookupName() {
		return this.lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	@Column(name = "LOOKUP_VALUE", length = 1000)
	public String getLookupValue() {
		return this.lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
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
