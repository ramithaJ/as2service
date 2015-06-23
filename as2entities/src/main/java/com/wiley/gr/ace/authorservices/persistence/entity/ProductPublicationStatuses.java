package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 23, 2015 2:35:20 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProductPublicationStatuses generated by hbm2java
 */
@Entity
@Table(name = "PRODUCT_PUBLICATION_STATUSES")
public class ProductPublicationStatuses implements java.io.Serializable {

	private Integer productPubId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Products products;
	private PublicationStatuses publicationStatuses;
	private Date publicationStatusDate;
	private Date createdDate;
	private Date updatedDate;

	public ProductPublicationStatuses() {
	}

	public ProductPublicationStatuses(Integer productPubId, Products products) {
		this.productPubId = productPubId;
		this.products = products;
	}

	public ProductPublicationStatuses(Integer productPubId,
			Users usersByCreatedBy, Users usersByUpdatedBy, Products products,
			PublicationStatuses publicationStatuses,
			Date publicationStatusDate, Date createdDate, Date updatedDate) {
		this.productPubId = productPubId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.products = products;
		this.publicationStatuses = publicationStatuses;
		this.publicationStatusDate = publicationStatusDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "PRODUCT_PUB_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getProductPubId() {
		return this.productPubId;
	}

	public void setProductPubId(Integer productPubId) {
		this.productPubId = productPubId;
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
	@JoinColumn(name = "DH_ID", nullable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PUBLICATION_STATUS_CD")
	public PublicationStatuses getPublicationStatuses() {
		return this.publicationStatuses;
	}

	public void setPublicationStatuses(PublicationStatuses publicationStatuses) {
		this.publicationStatuses = publicationStatuses;
	}

	@Column(name = "PUBLICATION_STATUS_DATE")
	public Date getPublicationStatusDate() {
		return this.publicationStatusDate;
	}

	public void setPublicationStatusDate(Date publicationStatusDate) {
		this.publicationStatusDate = publicationStatusDate;
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
