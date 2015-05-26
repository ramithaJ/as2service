package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 4:56:42 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * AdminDetails generated by hbm2java
 */
public class AdminDetails implements java.io.Serializable {

	private Integer adminUserId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Users usersByUserId;
	private Date createdDate;
	private Date updatedDate;

	public AdminDetails() {
	}

	public AdminDetails(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
	}

	public AdminDetails(Users usersByCreatedBy, Users usersByUpdatedBy,
			Users usersByUserId, Date createdDate, Date updatedDate) {
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.usersByUserId = usersByUserId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Integer getAdminUserId() {
		return this.adminUserId;
	}

	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
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

	public Users getUsersByUserId() {
		return this.usersByUserId;
	}

	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
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
