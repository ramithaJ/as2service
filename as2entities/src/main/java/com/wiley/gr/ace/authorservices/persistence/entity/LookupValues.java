package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 28, 2015 6:59:29 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * LookupValues generated by hbm2java
 */
public class LookupValues implements java.io.Serializable {

	private Long lookupId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String lookupKey;
	private String lookupName;
	private String lookupValue;
	private Date createdDate;
	private Date updatedDate;

	public LookupValues() {
	}

	public LookupValues(Users usersByCreatedBy, Users usersByUpdatedBy,
			String lookupKey, String lookupName, String lookupValue,
			Date createdDate, Date updatedDate) {
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.lookupKey = lookupKey;
		this.lookupName = lookupName;
		this.lookupValue = lookupValue;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Long getLookupId() {
		return this.lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	public String getLookupKey() {
		return this.lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	public String getLookupName() {
		return this.lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public String getLookupValue() {
		return this.lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
