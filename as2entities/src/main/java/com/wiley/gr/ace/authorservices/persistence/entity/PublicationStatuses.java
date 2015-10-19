package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 19, 2015 4:16:00 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PublicationStatuses generated by hbm2java
 */
@Entity
@Table(name = "publication_statuses", catalog = "as2_app_db")
public class PublicationStatuses implements java.io.Serializable {

	private String publicationStatusCd;
	private String publicationStatusName;
	private Date createdDate;
	private UUID createdBy;
	private Date updatedDate;
	private UUID updatedBy;
	private Set<ProductPublicationStatuses> productPublicationStatuseses = new HashSet<ProductPublicationStatuses>(
			0);

	public PublicationStatuses() {
	}

	public PublicationStatuses(String publicationStatusCd) {
		this.publicationStatusCd = publicationStatusCd;
	}

	public PublicationStatuses(String publicationStatusCd,
			String publicationStatusName, Date createdDate, UUID createdBy,
			Date updatedDate, UUID updatedBy,
			Set<ProductPublicationStatuses> productPublicationStatuseses) {
		this.publicationStatusCd = publicationStatusCd;
		this.publicationStatusName = publicationStatusName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.productPublicationStatuseses = productPublicationStatuseses;
	}

	@Id
	@Column(name = "PUBLICATION_STATUS_CD", unique = true, nullable = false, length = 15)
	public String getPublicationStatusCd() {
		return this.publicationStatusCd;
	}

	public void setPublicationStatusCd(String publicationStatusCd) {
		this.publicationStatusCd = publicationStatusCd;
	}

	@Column(name = "PUBLICATION_STATUS_NAME", length = 250)
	public String getPublicationStatusName() {
		return this.publicationStatusName;
	}

	public void setPublicationStatusName(String publicationStatusName) {
		this.publicationStatusName = publicationStatusName;
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
	public UUID getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
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
	public UUID getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicationStatuses")
	public Set<ProductPublicationStatuses> getProductPublicationStatuseses() {
		return this.productPublicationStatuseses;
	}

	public void setProductPublicationStatuseses(
			Set<ProductPublicationStatuses> productPublicationStatuseses) {
		this.productPublicationStatuseses = productPublicationStatuseses;
	}

}
