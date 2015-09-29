package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 29, 2015 12:48:43 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductPublicationStatuses generated by hbm2java
 */
@Entity
@Table(name = "product_publication_statuses", catalog = "as2_app_db")
public class ProductPublicationStatuses implements java.io.Serializable {

	private Long productPubId;
	private long dhId;
	private String publicationStatusCd;
	private Date publicationStatusDate;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;

	public ProductPublicationStatuses() {
	}

	public ProductPublicationStatuses(long dhId) {
		this.dhId = dhId;
	}

	public ProductPublicationStatuses(long dhId, String publicationStatusCd,
			Date publicationStatusDate, Date createdDate, Long createdBy,
			Date updatedDate, Long updatedBy) {
		this.dhId = dhId;
		this.publicationStatusCd = publicationStatusCd;
		this.publicationStatusDate = publicationStatusDate;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRODUCT_PUB_ID", unique = true, nullable = false)
	public Long getProductPubId() {
		return this.productPubId;
	}

	public void setProductPubId(Long productPubId) {
		this.productPubId = productPubId;
	}

	@Column(name = "DH_ID", nullable = false)
	public long getDhId() {
		return this.dhId;
	}

	public void setDhId(long dhId) {
		this.dhId = dhId;
	}

	@Column(name = "PUBLICATION_STATUS_CD", length = 15)
	public String getPublicationStatusCd() {
		return this.publicationStatusCd;
	}

	public void setPublicationStatusCd(String publicationStatusCd) {
		this.publicationStatusCd = publicationStatusCd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLICATION_STATUS_DATE", length = 19)
	public Date getPublicationStatusDate() {
		return this.publicationStatusDate;
	}

	public void setPublicationStatusDate(Date publicationStatusDate) {
		this.publicationStatusDate = publicationStatusDate;
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

}
