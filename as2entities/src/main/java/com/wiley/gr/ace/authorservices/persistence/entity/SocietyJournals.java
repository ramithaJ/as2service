package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 28, 2015 6:59:29 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * SocietyJournals generated by hbm2java
 */
public class SocietyJournals implements java.io.Serializable {

	private Long societyJournalId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Products products;
	private Societies societies;
	private Date createdDate;
	private Date updatedDate;

	public SocietyJournals() {
	}

	public SocietyJournals(Users usersByCreatedBy, Users usersByUpdatedBy,
			Products products, Societies societies, Date createdDate,
			Date updatedDate) {
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.products = products;
		this.societies = societies;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Long getSocietyJournalId() {
		return this.societyJournalId;
	}

	public void setSocietyJournalId(Long societyJournalId) {
		this.societyJournalId = societyJournalId;
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

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Societies getSocieties() {
		return this.societies;
	}

	public void setSocieties(Societies societies) {
		this.societies = societies;
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
